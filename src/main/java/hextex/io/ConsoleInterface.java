package hextex.io;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.commands.BibtexCommand;
import hextex.io.commands.Command;
import hextex.io.commands.DeleteCommand;
import hextex.io.commands.RemoveFilterCommand;
import hextex.io.commands.FilterCommand;
import hextex.io.commands.HelpCommand;
import hextex.io.commands.ListCommand;
import hextex.io.commands.FindCommand;
import hextex.io.commands.NewCommand;
import hextex.json.JsonFileManipulator;
import hextex.matcher.QueryBuilder;
import hextex.references.Reference;
import hextex.service.KeyMaker;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleInterface {

    private InMemoryReferenceDao dao;
    private IO io;
    private QueryBuilder qb;
    private ArrayList<String> filters;
    private Shortcut shortcut;
    private final KeyMaker keyMaker;
    private HashMap<String, Command> commands = new HashMap<>();

    public ConsoleInterface(IO io) {
        this.io = io;
        this.dao = new InMemoryReferenceDao();
        this.qb = new QueryBuilder();
        this.filters = new ArrayList();
        try {
            for (Reference ref : JsonFileManipulator.readJSON()) {
                dao.add(ref);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsoleInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.keyMaker = new KeyMaker(dao);

        commands.put("new", new NewCommand(io, dao, keyMaker));
        commands.put("list", new ListCommand(dao, io));
        commands.put("find", new FindCommand(dao, io));
        commands.put("delete", new DeleteCommand(io, dao));
        commands.put("bibtex", new BibtexCommand(io, dao));
        commands.put("help", new HelpCommand(io));
        commands.put("add filter", new FilterCommand(io, dao, qb, filters));
        commands.put("remove filter", new RemoveFilterCommand(io, dao, qb, filters));
        ArrayList<String> mainmenu = new ArrayList();
        mainmenu.add("new");
        mainmenu.add("bibtex");
        mainmenu.add("list");
        mainmenu.add("find");
        mainmenu.add("delete");
        mainmenu.add("help");
        mainmenu.add("quit");
        mainmenu.add("add filter");
        mainmenu.add("remove filter");

        this.shortcut = new Shortcut(mainmenu);
    }

    public void mainmenu() {
        MainMenu menu = new MainMenu(io);
        menu.run();
    }

    public void run() throws IOException {
        while (true) {
            io.print("Welcome to the mainmenu of HexTexBibtexGenerator 1.0 !");
            String command = io.readLine("Commands: [new] , [bibtex] , [list] , [add filter], [remove filter], [delete] , [help] , [quit]");
            List<String> matchingCommands = shortcut.returnCommands(command);

            if (matchingCommands.isEmpty()) {
                io.print("Command not found.");
            } else if (matchingCommands.size() == 1) {
                if (matchingCommands.get(0).equals("quit")) {
                    askForSaving();
                    break;
                }
                this.commands.get(matchingCommands.get(0)).run();
            } else {
                StringBuilder sb = new StringBuilder();
                for (String s : matchingCommands) {
                    sb.append(s).append(", ");
                }
                sb.delete(sb.length() - 2, sb.length());
                io.print("Please type more, found the following matches: " + sb.toString());
            }
        }
    }

    private void askForSaving() throws IOException {
        String c = io.readLine("Save first? (enter 'n' to NOT save)");
        if (!c.equals("n")) {
            JsonFileManipulator.writeJSON(this.dao.getReferences());
        }
        io.print("Thank you, come again ;)");
    }
}
