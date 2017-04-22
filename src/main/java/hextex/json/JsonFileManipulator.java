package hextex.json;

import com.google.gson.Gson;
import hextex.references.Book;
import hextex.references.Reference;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonFileManipulator {

    static String FILENAME = "jsonfile.json";
    static Gson gson = new Gson();

    public static void writeJSON(List<Reference> references) throws IOException {
        List<Reference> oldRefs = readJSON();
        oldRefs.addAll(references);
        try (FileWriter fw = new FileWriter(FILENAME)) {
            for (Reference reference : oldRefs) {
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
