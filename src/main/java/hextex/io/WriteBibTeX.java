package hextex.io;

import hextex.references.Book;
import hextex.references.Reference;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author tuletule
 */
public class WriteBibTeX {

    public static void writeFile(String nameOfFile, List<Reference> references) throws IOException {

        try (FileWriter pr = new FileWriter(nameOfFile, true)) {
            for (Reference reference : references) {
                pr.write(reference.getBibtexName() + "\n");
            }
        }
    }

    public static void writeFile(String nameOfFile, Reference reference) throws IOException {

        try (FileWriter pr = new FileWriter(nameOfFile, true)) {
            pr.write(reference.getBibtexName() + "\n");
        }
    }
}
