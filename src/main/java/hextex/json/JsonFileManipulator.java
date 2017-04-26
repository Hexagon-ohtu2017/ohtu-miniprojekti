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

    public static void writeJSON(List<Reference> references) throws IOException {
//        List<Reference> oldRefs = readJSON();
//        oldRefs.addAll(references);
        try (FileWriter fw = new FileWriter(FILENAME)) {
            for (Reference reference : references) {
                String s = gson.toJson(reference);
                System.out.println(s);
                fw.append(s);
                fw.append("\n");
            }
        }
    }

    public static List<Reference> readJSON() throws FileNotFoundException {
        FileReader fr = new FileReader(FILENAME);

        Scanner sc = new Scanner(fr);
        ArrayList<Request> reqs = new ArrayList<>();

        while (sc.hasNextLine()) {
            String jsonString = sc.nextLine();
            Request rq = gson.fromJson(jsonString, Request.class);
            reqs.add(rq);
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

    public class Wrapper {

        public String singleAuthor;
        public String title;
        public int year;
        public String publisher;
        private String key;
        private String lel;

    }

}
