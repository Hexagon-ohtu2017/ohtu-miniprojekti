/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.io;

import hextex.references.Article;
import hextex.references.Book;
import hextex.references.Inproceeding;
import hextex.references.Reference;
import java.io.IOException;

/**
 *
 * @author tuletule
 */
public class ConsoleInterface {

    public static void run() throws IOException {
        ConsoleIO io = new ConsoleIO();
        while (true) {
            System.out.println("Welcome to the mainmenu of HexTexBibtexGenerator 1.0 !");
            String command = io.readLine("Commands: [new] , [help] , [quit]");
            if (command.equals("new")) {
                System.out.println("Create a new reference!");
                Reference reference = createNewReference(io);
                while (true) {
                    command = io.readLine("Commands: [new] , [bibtex] , [help], [back]");
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
                                System.out.println("type back if you want to return to main menu");
                            }
                            if (command.equals("new")) {
                                break;
                            }
                           
                        }

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

            if (command.equals("help")) {
                System.out.println("type new if you want to generate new reference");
                System.out.println("type quit if you want to quit program");
            }

            if (command.equals("quit")) {
                System.out.println("Thank you, come again ;)");
                break;
            }
        }

        //System.out.println(Integer.class.isInstance(5));
    }

    public static Book createBook(ConsoleIO io) {
        String author = io.readLine("Book's author(s) (format: 'Last, First and Last, First and...'):");
        String title = io.readLine("Book's title:");
        int year = io.readInt("Year of publishing:");
        String publisher = io.readLine("Publisher:");
        String referenceName = io.readLine("Please give a name for the reference:");

        return new Book(referenceName, author, title, year, publisher);
    }

    public static Article createArticle(ConsoleIO io) {
        String author = io.readLine("Article's author(s) (format: 'Last, First and Last, First and...'):");
        String title = io.readLine("Article's title:");
        String journal = io.readLine("Article's journal:");
        int volume = io.readInt("Article's volume:");
        String page = io.readLine("Article's pages:");
        int year = io.readInt("Year of publishing:");
        String referenceName = io.readLine("Please give a name for the reference:");

        return new Article(referenceName, author, title, journal, volume, page, year);

    }

    public static Inproceeding createInproceeding(ConsoleIO io) {
        String author = io.readLine("Inproceeding's author(s) (format: 'Last, First and Last, First and...'):");
        String title = io.readLine("Inproceeding's title:");
        String bookTitle = io.readLine("Inproceeding's book's title:");
        int year = io.readInt("Year of publishing:");
        String referenceName = io.readLine("Please give a name for the reference:");
        return new Inproceeding(referenceName, author, title, bookTitle, year);
    }

    public static Reference createNewReference(ConsoleIO io) {
        Reference reference;
        while (true) {
            String command = io.readLine("Select type : [book] [article] [inproceeding]");
            if (command.equals("book")) {
                reference = createBook(io);
                break;
            }
            if (command.equals("article")) {
                reference = createArticle(io);
                break;
            }
            if (command.equals("inproceeding")) {
                reference = createInproceeding(io);
                break;
            }
        }
        System.out.println("Reference was succesfully created!");
        return reference;
    }

}
