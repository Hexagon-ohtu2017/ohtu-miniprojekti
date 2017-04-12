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

  private BookDao bookDao;
  private ArticleDao articleDao;
  private InproceedingDao inproceedingDao;

   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://127.0.0.1/whoah?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

   static final String USER = "root";
   static final String PASS = "hexagonista";

  public Database() throws SQLException {
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
            //String sql = "USE mysql";
            //st.executeUpdate(sql);

            for (String lause : lauseet) {
                System.out.println("Running command >> " + lause);
                st.executeUpdate(lause);
            }
            st.close();

        } catch (Throwable t) {
            System.out.println("Error >> " + t.getMessage());
        }

    }

  private List<String> sqliteLauseet() {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("CREATE TABLE Book (reference varchar(100), title varchar(100),"+
          " author varchar(100), year int, publisher varchar(100));");
        lista.add("CREATE TABLE Article (reference varchar(100), title varchar(100), "+
            "author varchar(100), journal varchar(100), " +
            "volume int, pages varchar(50), year int);");
        lista.add("CREATE TABLE Inproceeding (reference varchar(100), " +
        "title varchar(100), author varchar(100), booktitle varchar(100), year int);");

        return lista;
    }

    public Connection getConnection() throws SQLException {
      Connection c = null;
        try {
          Class.forName("com.mysql.jdbc.Driver");
          com.mysql.jdbc.jdbc2.optional.MysqlDataSource ds
        = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
          ds.setServerName("127.0.0.1");
          ds.setPortNumber(3306);
          ds.setDatabaseName("bibdb");
          ds.setUser("root");
          ds.setPassword("hexagonista");

          c = ds.getConnection();
          //c = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
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
