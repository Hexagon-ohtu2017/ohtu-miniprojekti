package hextex;
import hextex.io.ConsoleIO;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:tietokanta.db");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Book");

        ConsoleIO io = new ConsoleIO();
        String name = io.readLine("Give book's name");
        System.out.println("Book's name is " + name);
        int pages = io.readInt("How many pages does the book have?");
        System.out.println("Book has " + pages + " pages");
    }
}
