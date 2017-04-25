package hextex;

import hextex.io.ConsoleIO;
import hextex.io.ConsoleInterface;
//<<<<<<< HEAD what is this?
import hextex.io.StubIO;
//======= what is this?
import hextex.json.JsonFileManipulator;
import hextex.references.Book;
//>>>>>>> 81e5504eff5789b8cbc10d38144e5867dd4d56d6 what is this?
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, SQLException {
        //List<String> input = new ArrayList<>();
        //StubIO stub = new StubIO(null);
        ConsoleInterface ci = new ConsoleInterface(new ConsoleIO());
        ci.run();



//        String author = "Teeeea the Tester";
//        String title = "Testing the Tester";
//        int year = 2017;
//        String publisher = "Princeton University Press";
//        String key = "Tes2017";
//        Book b = new Book(author, title, year, publisher, key);
//        List lib = new ArrayList();
//        lib.add(b);
//        lib.add(b);
//
//        author = "eeele";
//        title = "saddsadsa";
//        year = 666;
//        publisher = "assdasa";
//
//        b = new Book(author, title, year, publisher, "JII");
//        lib.add(b);
//        JsonFileManipulator.writeJSON(lib);
//        JsonFileManipulator.readJSON();
    }
}
