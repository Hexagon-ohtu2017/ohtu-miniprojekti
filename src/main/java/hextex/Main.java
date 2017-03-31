package hextex;
import hextex.io.WriteBibTeX;
import hextex.references.Author;
import hextex.references.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        System.out.println("JEE TÄÄ TOIMII!!");
//        ConsoleIO io = new ConsoleIO();
//        String name = io.readLine("Give book's name");
//        System.out.println("Book's name is " + name);
//        int pages = io.readInt("How many pages book have?");
//        System.out.println("Book has " + pages + " pages");

        String name = "Martin09";       
        String title = "Clean Code: A Handbook of Agile Software Craftsmanship";
        int year = 2008;
        String publisher = "Prentice Hall";

        Book book = new Book(name, "Martin, Robert", title, year, publisher);
        List<Book> lib = new ArrayList<>();
        lib.add(book);
        WriteBibTeX.writeFile("asd.txt", lib);
    }
}
