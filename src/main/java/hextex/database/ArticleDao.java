package hextex.database;


import hextex.references.Article;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ArticleDao implements Dao<Article, Integer> {
  private Database database;

  public ArticleDao (Database database) {
    this.database = database;
  }

  public void insertArticle(String reference, String title, String author, String journal,
                          int volume, String pages, int year) throws SQLException {
    Connection connection = database.getConnection();
    Statement stmt = connection.createStatement();

    String kysely = "INSERT INTO Article (reference, title, author, journal, volume, pages, year) VALUES"
            + "('" + reference + "', '"  + title + "', '" + author + "', '"
                + journal + "', '" + volume + "', '" + pages + "', '" + year + "');";

    stmt.execute(kysely);
    connection.close();
  }

  @Override
    public List<Article> findAll() throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Article;");

        ResultSet rs = stmt.executeQuery();
        List<Article> articles = new ArrayList<>();
        while (rs.next()) {
            String ref = rs.getString("reference");
            String title = rs.getString("title");
            String author = rs.getString("author");
            String journal = rs.getString("journal");
            Integer volume = rs.getInt("volume");
            String pages = rs.getString("pages");
            Integer year = rs.getInt("year");

            Article a = new Article(ref, title, author, journal, volume, pages, year);
            articles.add(a);
        }

        rs.close();
        stmt.close();
        connection.close();

        return articles;
    }
}
