package hextex.io;

import hextex.inmemory.InMemoryReferenceDao;
import hextex.references.Article;
import hextex.references.Book;
import hextex.references.Inproceedings;
import hextex.references.Reference;
import hextex.service.KeyMaker;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ConsoleInterface {

    private InMemoryReferenceDao dao;
    private IO io;
    private KeyMaker keyMaker;

    public ConsoleInterface(IO io) {
        this.io = io;
        this.dao = new InMemoryReferenceDao();
        this.keyMaker = new KeyMaker(dao);
    }

    public void run() throws IOException {
        while (true) {
            System.out.println("Welcome to the mainmenu of HexTexBibtexGenerator 1.0 !");
            String command = io.readLine("Commands: [new] , [list] , [delete] , [help] , [quit]");
            if (command.equals("new")) {
                System.out.println("Create a new reference!");
                Reference reference = createNewReference(io);
                dao.add(reference);
                while (true) {
                    command = io.readLine("Commands: [new] , [bibtex] , [list], [delete], [help], [back]");
                    if (command.equals("new")) {
                        System.out.println("Create a new reference!");
                        Reference ref = createNewReference(io);
                        dao.add(ref);
                    }

                    if (command.equals("bibtex")) {
                        String fileName = io.readLine("Please give a name of the BibTeX file you wish to be created");
                        WriteBibTeX.writeFile(fileName, reference);
                        while (true) {
                            command = io.readLine("Commands: [new] , [help] , [back]");
                            if (command.equals("back")) {
                                break;
                            }
                            if (command.equals("help")) {
                                System.out.println("type new if you want to create new reference");
                                System.out.println("type list if you want to list all your references");
                                System.out.println("type back if you want to return to main menu");
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
                        System.out.println("reference deleted");
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
                System.out.println("Thank you, come again ;)");
                break;
            }
        }

        //System.out.println(Integer.class.isInstance(5));
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
            String command = io.readLine("Select type : [book] [article] [inproceedings]");
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
        }
        System.out.println("Reference was succesfully created!");
        return reference;
    }

    public void printAllReferences() {
        List<Reference> references = this.dao.listAll();
        System.out.println("References: ");
        for (Reference ref : references) {
            System.out.println("\t" + ref.getEasyName() + "\n");
        }
    }
}
