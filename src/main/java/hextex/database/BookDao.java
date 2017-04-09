package hextex.database;


import hextex.references.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;

public class BookDao implements Dao<Book, Integer> {
  private Database database;

  public BookDao(Database database) {
    this.database = database;
  }

  public void insertBook(String title, String author, int year, String publisher) throws Exception {
    Connection connection = database.getConnection();
    Statement stmt = connection.createStatement();

    String kysely = "INSERT INTO Book (title, author, year, publisher) VALUES ("
                + title + ", '" + author + "', '"
                + year + "', '" + publisher + "')";

    stmt.execute(kysely);
    connection.close();
  }
}
