package hextex.database;


import hextex.references.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class BookDao implements Dao<Book, Integer> {
  private Database database;

  public BookDao(Database database) {
    this.database = database;
  }

  public void insertBook(String reference, String title, String author, int year, String publisher) throws SQLException {
    Connection connection = database.getConnection();
    Statement stmt = connection.createStatement();

    String kysely = "INSERT INTO Book (reference, title, author, year, publisher) VALUES ("
                + "'" + reference + "', '"  + title + "', '" + author + "', '"
                + year + "', '" + publisher + "');";

    stmt.execute(kysely);
    connection.close();
  }

  @Override
    public List<Book> findAll() throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Book;");

        ResultSet rs = stmt.executeQuery();
        List<Book> books = new ArrayList<>();
        while (rs.next()) {
            String reference = rs.getString("reference");
            String title = rs.getString("title");
            String author = rs.getString("author");
            Integer year = rs.getInt("year");
            String publisher = rs.getString("publisher");

            Book b = new Book(reference, title, author, year, publisher);
            books.add(b);
        }

        rs.close();
        stmt.close();
        connection.close();

        return books;
    }

}
