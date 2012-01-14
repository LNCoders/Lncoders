package fxmlexample;

import java.sql.*;

public class DatabaseConnect {

  public static void main(String args[]) {
    Connection con = null;

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      con = DriverManager.getConnection("jdbc:mysql:///fitness",
        "root", "UB0Ud02W");

      if(!con.isClosed())
        System.out.println("Successfully connected to " +
          "MySQL server using TCP/IP...");

    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    } finally {
      try {
        if(con != null)
          con.close();
      } catch(SQLException e) {}
    }
  }

 

    public ResultSet executeQuery(String SQL) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}