package hextex.io;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.io.commands.BibtexCommand;
import hextex.io.commands.Command;
import hextex.io.commands.DeleteCommand;
import hextex.io.commands.HelpCommand;
import hextex.io.commands.ListCommand;
import hextex.io.commands.NewCommand;
import hextex.json.JsonFileManipulator;
import hextex.references.Article;
import hextex.references.Book;
import hextex.references.Inproceedings;
import hextex.references.Reference;
import hextex.service.KeyMaker;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleInterface {

    private InMemoryReferenceDao dao;
    private IO io;
    private KeyMaker keyMaker;
    private HashMap<String, Command> commands = new HashMap<>();

    public ConsoleInterface(IO io) {
        this.io = io;
        this.dao = new InMemoryReferenceDao();
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
        commands.put("delete", new DeleteCommand(io, dao));
        commands.put("bibtex", new BibtexCommand(io, dao));
        commands.put("help", new HelpCommand());
    }

    public void mainmenu() {
        MainMenu menu = new MainMenu(io);
        menu.run();
    }

    public void run() throws IOException {
        while (true) {
            io.print("Welcome to the mainmenu of HexTexBibtexGenerator 1.0 !");
            String command = io.readLine("Commands: [new] , [bibtex] , [list] , [delete] , [help] , [quit]");
            

            if (command.equals("quit")) {
                askForSaving();
                break;
            }
            
            if (commands.containsKey(command)) {
                commands.get(command).run();
            } else {
                System.out.println("Command not found.");
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
