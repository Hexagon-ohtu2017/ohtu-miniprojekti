package hextex;

import hextex.io.ConsoleIO;
import hextex.database.Database;

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


        Database database = new Database("jdbc:sqlite:test.db");

        ConsoleIO io = new ConsoleIO();
        String name = io.readLine("Give book's name");
        System.out.println("Book's name is " + name);
        int pages = io.readInt("How many pages does the book have?");
        System.out.println("Book has " + pages + " pages");
    }
}
