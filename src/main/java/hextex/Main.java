package hextex;

import hextex.io.ConsoleIO;
import hextex.io.ConsoleInterface;
import hextex.io.StubIO;
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
      //  ConsoleInterface.run();

    }
}