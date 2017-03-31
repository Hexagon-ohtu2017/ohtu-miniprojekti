package hextex.database;

import hextex.database.Dao;
import hextex.references.Book;
import java.sql.*;
import java.util.*;


public class BookDao implements Dao<Book, Integer> {
  public Database database;

  public BookDao(Database database) {
    this.database = database;
  }

  /* @Override
  public Book findOne(Integer key) throws SQLException {
    Connection connection = database.getConnection();
    PreparedStatement stmt = connection.PreparedStatement("SELECT * FROM Book WHERE ID = ?");

    stmt.setObject(1, key);

    ResultSet rs = stmt.executeQuery();
    boolean hasOne = rs.next();

    if (!hasOne) {
        return null;
    }

    Integer id = rs.getInt("id");
    String nameOfReference = rs.getString("nameOfRef");
    String title = rs.getString("title");
    String author = rs.getString("author");
    Integer year = rs.getInt("year");
    String publisher = rs.getString("publisher");

    Book book = new Book(nameOfRef, author, title, year, publisher);

    rs.close();
    stmt.close();
    connection.close();

    return book;
  } */

  public void addOne(String nameOfRef, String author, String title,
    Integer year, String publisher) throws Exception {
       Connection connection = database.getConnection();
       Statement stmt = connection.createStatement();

       String query = "INSERT INTO Book (nameOfRef, author, title, year, publisher) VALUES ('" + nameOfRef
        + ", " + author + ", " + title + ", " + year + ", " + year + "')";
       stmt.execute(query);
       connection.close();

   }



}
