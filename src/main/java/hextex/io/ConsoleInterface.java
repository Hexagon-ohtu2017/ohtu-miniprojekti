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
        Reference reference = createNewReference(io);
      
        //System.out.println(Integer.class.isInstance(5));



        //String fileName = io.readLine("Please give a name of the BibTeX file you wish to be created");

        //WriteBibTeX.writeFile(fileName, book);
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
        
        return new Article(referenceName,author,title,journal,volume,page,year);
        
    }
    
    public static Inproceeding createInproceeding(ConsoleIO io) {
        String author = io.readLine("Inproceeding's author(s) (format: 'Last, First and Last, First and...'):");
        String title = io.readLine("Inproceeding's title:");
        String bookTitle = io.readLine("Inproceeding's book's title:");
        int year = io.readInt("Year of publishing:");
        String referenceName = io.readLine("Please give a name for the reference:");
        return new Inproceeding(referenceName,author,title,bookTitle,year);
    }
    
    public static Reference createNewReference(ConsoleIO io) {
        while(true) {
            String command = io.readLine("Commands: [book] [article] [inproceeding]");
            if (command.equals("book")) {
                return createBook(io);
            }
            if (command.equals("article")) {
                return createArticle(io);
            }
            if (command.equals("inproceeding")) {
                return createInproceeding(io);
            }
        }
    }
}
