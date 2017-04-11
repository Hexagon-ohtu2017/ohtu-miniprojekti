package hextex.database;


import hextex.references.Inproceeding;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class InproceedingDao implements Dao<Inproceeding, Integer> {
  private Database database;

  public InproceedingDao(Database database) {
    this.database = database;
  }

  public void insertInproceeding(String reference, String title, String author, String booktitle,
                          int year) throws SQLException {
    Connection connection = database.getConnection();
    Statement stmt = connection.createStatement();

    String kysely = "INSERT INTO Inproceeding (reference, title, author, booktitle, year) VALUES ('"
                + reference + "', '"  + title + "', '" + author + "', '"
                + booktitle + "', '" + year + "')";

    stmt.execute(kysely);
    connection.close();
  }

  @Override
    public List<Inproceeding> findAll() throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Inproceeding;");

        ResultSet rs = stmt.executeQuery();
        List<Inproceeding> procs = new ArrayList<>();
        while (rs.next()) {
            String ref = rs.getString("reference");
            String title = rs.getString("title");
            String author = rs.getString("author");
            String booktitle = rs.getString("booktitle");
            Integer year = rs.getInt("year");

            Inproceeding ip = new Inproceeding(ref, title, author, booktitle, year);
            procs.add(ip);
        }

        rs.close();
        stmt.close();
        connection.close();

        return procs;
    }
}
