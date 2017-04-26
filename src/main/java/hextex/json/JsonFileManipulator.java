package hextex.json;

import com.google.gson.Gson;
import hextex.references.Article;
import hextex.references.Book;
import hextex.references.Inproceedings;
import hextex.references.Reference;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonFileManipulator {

    static String FILENAME = "references.json";
    static Gson gson = new Gson();

    public static void writeJSON(List<Reference> references, String filename) throws IOException {

        try (FileWriter fw = new FileWriter(filename)) {
            for (Reference reference : references) {
                String s = gson.toJson(reference);
//                System.out.println(s);
                fw.append(s);
                fw.append("\n");
            }
        }
    }

    public static void writeJSON(List<Reference> references) throws IOException {
        writeJSON(references, FILENAME);
    }
    
    public static List<Reference> readJSON(String filename) throws FileNotFoundException {
        FileReader fr = new FileReader(filename);

        Scanner sc = new Scanner(fr);
        ArrayList<Request> reqs = new ArrayList<>();

        while (sc.hasNextLine()) {
            String jsonString = sc.nextLine();
            if (!jsonString.isEmpty()) {
                Request rq = gson.fromJson(jsonString, Request.class);
                reqs.add(rq);
            }
        }

        // Move this somewhere else!
        ArrayList<Reference> refs = new ArrayList();

        for (Request req : reqs) {
            if (req.getType().equals("Book")) {
                Book b = new Book(req);
                refs.add(b);
            }
            if (req.getType().equals("Article")) {
                Article a = new Article(req);
                refs.add(a);
            }
            if (req.getType().equals("Inproceedings")) {
                Inproceedings i = new Inproceedings(req);
                refs.add(i);
            }
        }

        return refs;
    }

    public static List<Reference> readJSON() throws FileNotFoundException {
        return readJSON(FILENAME);
    }
}
