package hextex.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class Database {

  private String databaseAddress;

  public Database() throws Exception {
    this.databaseAddress = "jdbc:mysql://localhost:3306/mysql";
    init();
  }

  public void init() {
        List<String> lauseet = null;
        lauseet = sqliteLauseet();

        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();

            for (String lause : lauseet) {
                System.out.println("Running command >> " + lause);
                st.executeUpdate(lause);
            }

        } catch (Throwable t) {
            System.out.println("Error >> " + t.getMessage());
        }
    }

  private List<String> sqliteLauseet() {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("DROP TABLE Book;");
        lista.add("CREATE TABLE Book (id INTEGER PRIMARY KEY, title varchar(100)"+
          "author varchar(100), year INT, publisher varchar(100));");

        return lista;
    }

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        return DriverManager.getConnection(databaseAddress, "root", "");
    }

}
