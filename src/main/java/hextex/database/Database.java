package hextex.database;

import java.net.URI;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Database {

    private String databaseAddress;

    public Database(String databaseAddress) throws ClassNotFoundException {
        this.databaseAddress = databaseAddress;

        init();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }

    public void init() {
      List<String> statements = sqliteStatements();

      try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();

            for (String statement : statements) {
                System.out.println("Running command >> " + statement);
                st.executeUpdate(statement);
            }

        } catch (Throwable t) {
            System.out.println("Error >> " + t.getMessage());
        }

    }


    private List<String> sqliteStatements() {
        ArrayList<String> statements = new ArrayList<>();


        statements.add("CREATE TABLE BOOK (id INTEGER PRIMARY KEY, title varchar(100));");
        



        return statements;
    }
  }
