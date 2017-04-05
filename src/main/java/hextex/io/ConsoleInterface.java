/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hextex.io;

import hextex.references.Book;
import java.io.IOException;

/**
 *
 * @author tuletule
 */
public class ConsoleInterface {

    public static void run() throws IOException {
        ConsoleIO io = new ConsoleIO();

        System.out.println(Integer.class.isInstance(5));

        String author = io.readLine("Book's author(s) (format: 'Last, First and Last, First and...'):");
        String title = io.readLine("Book's title:");
        int year = io.readInt("Year of publishing:");
        String publisher = io.readLine("Publisher:");
        String referenceName = io.readLine("Please give a name for the reference:");

        Book book = new Book(referenceName, author, title, year, publisher);

        String fileName = io.readLine("Please give a name of the BibTeX file you wish to be created");

        WriteBibTeX.writeFile(fileName, book);
    }
}
