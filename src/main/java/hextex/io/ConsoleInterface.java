package hextex.io;

import hextex.inmemory.InMemoryReferenceDao;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleInterface {

    private InMemoryReferenceDao dao;
    private IO io;
    private KeyMaker keyMaker;

    public ConsoleInterface(IO io) {
        this.io = io;
        this.manipulator = new JsonFileManipulator();
        this.dao = new InMemoryReferenceDao();
        try {
            for (Reference ref : JsonFileManipulator.readJSON()) {
                dao.add(ref);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsoleInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.keyMaker = new KeyMaker(dao);
    }

    public void mainmenu() {
        MainMenu menu = new MainMenu(io);
        menu.run();
    }

    public void run() throws IOException {
        while (true) {
            io.print("Welcome to the mainmenu of HexTexBibtexGenerator 1.0 !");
            String command = io.readLine("Commands: [new] , [list] , [delete] , [help] , [quit]");
            if (command.equals("new")) {
                io.print("Create a new reference!");
                Reference reference = createNewReference(io);
                dao.add(reference);
                while (true) {
                    command = io.readLine("Commands: [new] , [bibtex] , [list], [delete], [help], [back]");
                    if (command.equals("new")) {
                        io.print("Create a new reference!");
                        Reference ref = createNewReference(io);
                        dao.add(ref);
                    }

                    if (command.equals("bibtex")) {
                        String fileName = io.readLine("Please give a name of the BibTeX file you wish to be created");

                        if (dao.getReferences().isEmpty()) {
                            io.print("There are no references!");
                        }

                        for (Reference r : dao.getReferences()) {
                            WriteBibTeX.writeFile(fileName, r);
                        }

                        while (true) {
                            command = io.readLine("Commands: [new] , [help] , [back]");
                            if (command.equals("back")) {
                                break;
                            }
                            if (command.equals("help")) {
                                io.print("type new if you want to create new reference");
                                io.print("type list if you want to list all your references");
                                io.print("type back if you want to return to main menu");
                            }
                            if (command.equals("new")) {
                                break;
                            }
                        }

                    }

                    if (command.equals("list")) {
                        this.printAllReferences();
                    }

                    if (command.equals("delete")) {
                        String keyToBeRemoved = io.readLine("Reference key (format: 'DoeDoe2000'):");
                        dao.delete(keyToBeRemoved);
                        io.print("reference deleted");
                    }

                    if (command.equals("help")) {
                        System.out.println("type new to create new reference");
                        System.out.println("type bibtex to create bibtex file for reference you created");
                        System.out.println("type back if you want to return to main menu");
                    }

                    if (command.equals("back")) {
                        break;
                    }

                }

            }

            if (command.equals("list")) {
                this.printAllReferences();
            }

            if (command.equals("delete")) {
                String keyToBeRemoved = io.readLine("Reference key (format: 'DoeDoe2000'):");
                dao.delete(keyToBeRemoved);
                System.out.println("reference deleted");
            }
            if (command.equals("help")) {
                System.out.println("type new if you want to generate new reference");
                System.out.println("type delete if you want to delete a reference");
                System.out.println("type list if you want to list all references");
                System.out.println("type quit if you want to quit program");
            }

            if (command.equals("quit")) {
                String c = io.readLine("Save first? [y/n]");
//                while (true) {
//                if (c.equals("y")) {
//                    JsonFileManipulator.writeJSON(this.dao.getReferences());
//                    break;
//                }
//                if (c.equals("n")) {
//                    break;
//                }
//            }
                JsonFileManipulator.writeJSON(this.dao.getReferences());
                io.print("Thank you, come again ;)");
                break;
            }
        }
    }

    public Book createBook(IO io) {
        String author = io.readAuthors("Book's author(s) (format: 'Lastname Firstname, Lastname Firstname...'):");
        String title = io.readLine("Book's title:");
        int year = io.readInt("Year of publishing:");
        String publisher = io.readLine("Publisher:");
        String key = keyMaker.generateKey(author, year);
        return new Book(author, title, year, publisher, key);
    }

    public Article createArticle(IO io) {
        String author = io.readAuthors("Article's author(s) (format: 'Lastname Firstname, Lastname Firstname...'):");
        String title = io.readLine("Article's title:");
        String journal = io.readLine("Article's journal:");
        int volume = io.readInt("Article's volume:");
        String page = io.readLine("Article's pages:");
        int year = io.readInt("Year of publishing:");
        String key = keyMaker.generateKey(author, year);
        return new Article(author, title, journal, volume, page, year, key);

    }

    public Inproceedings createInproceeding(IO io) {
        String author = io.readAuthors("Inproceeding's author(s) (format: 'Lastname Firstname, Lastname Firstname...'):");
        String title = io.readLine("Inproceeding's title:");
        String bookTitle = io.readLine("Inproceedings' book's title:");
        int year = io.readInt("Year of publishing:");
        String key = keyMaker.generateKey(author, year);
        return new Inproceedings(author, title, bookTitle, year, key);
    }

    public Reference createNewReference(IO io) {
        Reference reference;
        while (true) {
            String command = io.readLine("Select type : [book] [article] [inproceedings] or return: [back]");
            if (command.equals("book")) {
                reference = createBook(io);
                break;
            }
            if (command.equals("article")) {
                reference = createArticle(io);
                break;
            }
            if (command.equals("inproceedings")) {
                reference = createInproceeding(io);
                break;
            }
            if (command.equals("back")) {
                return null;
            }
        }
        io.print("Reference was succesfully created!");

        return reference;
    }

    public void printAllReferences() {
        List<Reference> references = this.dao.listAll();
//        try {
//            references.addAll(JsonFileManipulator.readJSON());
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ConsoleInterface.class.getName()).log(Level.SEVERE, null, ex);
//        }
        io.print("References:");
        for (Reference ref : references) {
            io.print("\t" + ref.getEasyName());
        }
    }
}
