package hextex.io.commands;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.IO;
import hextex.io.Shortcut;
import hextex.io.WriteBibTeX;
import hextex.references.Article;
import hextex.references.Book;
import hextex.references.Inproceedings;
import hextex.references.Reference;
import hextex.service.KeyMaker;
import java.util.ArrayList;
import java.util.HashMap;

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
        String command = shortcut.retunCommand(print);
        if (command.equals("back")) {
            return;
        }

        if (commands.containsKey(command)) {
            commands.get(command).run();
        }
    }

}
