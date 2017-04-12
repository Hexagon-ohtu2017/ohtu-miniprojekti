package hextex.database;

import java.sql.*;
import java.util.List;

public interface Dao<T, K> {
  List<T> findAll() throws SQLException;

}