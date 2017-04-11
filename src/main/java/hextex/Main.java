package hextex;

import hextex.io.ConsoleInterface;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, SQLException {
        ConsoleInterface ci = new ConsoleInterface();
        ci.run();
      //  ConsoleInterface.run();

    }
}
