package hextex;

import hextex.io.ConsoleIO;
import hextex.io.ConsoleInterface;
import hextex.io.WriteBibTeX;
import hextex.references.Book;
import java.io.IOException;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        ConsoleInterface.run();
        
        /*
        String name = "Martin09";       
        String title = "Clean Code: A Handbook of Agile Software Craftsmanship";
        int year = 2008;
        String publisher = "Prentice Hall";

        Book book = new Book(name, "Martin, Robert", title, year, publisher);
        List<Book> lib = new ArrayList<>();
        lib.add(book);
        WriteBibTeX.writeFile("asd.txt", lib);
         */
    }
}
