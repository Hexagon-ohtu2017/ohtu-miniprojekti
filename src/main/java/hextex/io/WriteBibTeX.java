package hextex.io;

import hextex.references.Book;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author tuletule
 */
public class WriteBibTeX {

    public static void writeFile(String nameOfFile, List<Book> books) throws IOException {

        try (FileWriter pr = new FileWriter(nameOfFile)) {
            for (Book book : books) {
                pr.write(book.getBibtexName() + "\n");
            }
        }
    }
}