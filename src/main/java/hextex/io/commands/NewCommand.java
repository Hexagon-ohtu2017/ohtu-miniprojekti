package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.io.Shortcut;
import hextex.service.KeyMaker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewCommand implements Command {

    private IO io;
    private InMemoryReferenceDao dao;
    private HashMap<String, Command> commands = new HashMap<String, Command>();
    private KeyMaker keyMaker;
    private Shortcut shortcut;

    public NewCommand(IO io, InMemoryReferenceDao dao, KeyMaker keyMaker) {
        this.io = io;
        this.dao = dao;
        this.keyMaker = keyMaker;

        commands.put("book", new CreateBookCommand(dao, io, keyMaker));
        commands.put("article", new CreateArticleCommand(dao, io, keyMaker));
        commands.put("inproceedings", new CreateInproceedingsCommand(dao, io, keyMaker));
        ArrayList<String> list = new ArrayList();
        list.add("book");
        list.add("article");
        list.add("inproceedings");
        list.add("back");
        this.shortcut = new Shortcut(list);
    }

    @Override
    public void run() {
        io.print("Create a new reference!");
        String print = io.readLine("Select type : [book] [article] [inproceedings] or return: [back]");
        List<String> matchingCommands = shortcut.returnCommands(print);

//        io.print(matchingCommands.toString());
        if (matchingCommands.isEmpty()) {
            io.print("Command not found.");
        } else if (matchingCommands.size() > 1) {
            StringBuilder sb = new StringBuilder();
            for (String s : matchingCommands) {
                sb.append(s).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            io.print("Please type more, found the following matches: " + sb.toString());
            run();
        } else if (commands.containsKey(matchingCommands.get(0))) {
            commands.get(matchingCommands.get(0)).run();
        } else if (!matchingCommands.get(0).equals("back")) {
            run();
        }
    }

}
