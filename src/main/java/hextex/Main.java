package hextex;

import hextex.io.ConsoleIO;
import hextex.io.ConsoleInterface;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, SQLException {
        ConsoleInterface ci = new ConsoleInterface(new ConsoleIO());
        ci.run();
      //  ConsoleInterface.run();

    }
}