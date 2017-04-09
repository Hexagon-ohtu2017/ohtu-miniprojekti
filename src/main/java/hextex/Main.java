package hextex;

import hextex.io.ConsoleInterface;
import hextex.database.Database;
import java.io.IOException;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {
        Database d = new Database();
        ConsoleInterface.run();


    }
}
