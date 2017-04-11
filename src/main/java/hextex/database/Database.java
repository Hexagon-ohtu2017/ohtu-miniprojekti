package hextex.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;

import hextex.references.*;

public class Database {

  private String databaseAddress;
  private BookDao bookDao;
  private ArticleDao articleDao;
  private InproceedingDao inproceedingDao;

  public Database() throws SQLException {
    this.databaseAddress = "jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    init();
    this.bookDao = new BookDao(this);
    this.articleDao = new ArticleDao(this);
    this.inproceedingDao = new InproceedingDao(this);
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
        /*
        lista.add("CREATE TABLE Book (reference varchar(100), title varchar(100),"+
          " author varchar(100), year int, publisher varchar(100));");
        lista.add("CREATE TABLE Article (reference varchar(100), title varchar(100), "+
            "author varchar(100), journal varchar(100), " +
            "volume int, pages varchar(50), year int);");
        lista.add("CREATE TABLE Inproceeding (reference varchar(100), " +
        "title varchar(100), author varchar(100), booktitle varchar(100), year int);");
        */
        return lista;
    }

    public Connection getConnection() throws SQLException {
      Connection c = null;
        try {
          c = DriverManager.getConnection(databaseAddress, "root", "hexagonista");
        } catch (Throwable t) {
          System.out.println("Error: " + t.getMessage());
          t.printStackTrace();
        }
        return c;
    }

    public BookDao getBookDao() {
      return this.bookDao;
    }

    public ArticleDao getArticleDao() {
      return this.articleDao;
    }

    public InproceedingDao getInproceedingDao() {
      return this.inproceedingDao;
    }

    public List<Reference> findAllReferences() throws SQLException {
        ArrayList<Reference> references = new ArrayList();
        references.addAll(this.bookDao.findAll());
        references.addAll(this.articleDao.findAll());
        references.addAll(this.inproceedingDao.findAll());
        return references;
    }

}
