package fxmlexample;

import java.awt.event.ActionListener;
import java.sql.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import java.sql.*;
import java.lang.System;

public class FXMLExampleController {

//DB Connection
  /*
     * public static void main(String args[]) { Connection con = null;
     *
     * try { Class.forName("com.mysql.jdbc.Driver").newInstance(); con =
     * DriverManager.getConnection("jdbc:mysql:///fitness", "root", "UB0Ud02W");
     *
     * if(!con.isClosed()) System.out.println("Successfully connected to " +
     * "MySQL server using TCP/IP...");
     *
     * } catch(Exception e) { System.err.println("Exception: " +
     * e.getMessage()); } finally { try { if(con != null) con.close(); }
     * catch(SQLException e) {} } }
     */
    public ResultSet executeQuery(String SQL) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @FXML
    private Label buttonStatusText;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws SQLException {

        /*
         * try {
         *
         *
         * Class.forName("com.mysql.jdbc.Driver").newInstance(); db =
         * (DatabaseConnect)
         * DriverManager.getConnection("jdbc:mysql:///squirrel", "root",
         * "UB0Ud02W");
         *
         * /*
         * if (!db.isClosed()) { System.out.println("Successfully connected to "
         * + "MySQL server using TCP/IP..."); }
         *
         * } catch (Exception e) { System.err.println("Exception: " +
         * e.getMessage()); } finally { try { if (db != null) { db.close(); }
         */


        ResultSet rs = null;
        //int updateQuery = 0;
        Statement statement = null;
        DatabaseConnect db = DatabaseConnect.main(String args[]);
        statement = db.createStatement();

        String QueryString = "SELECT * from suppliments";
        rs = db.executeQuery(QueryString);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "\n");
        }
        rs.close();
        statement.close();



        buttonStatusText.setText(
                "PRESSED");

    }

    @FXML
    protected void handlePasswordFieldAction(ActionEvent event) {
        buttonStatusText.setText("Enter key pressed");
    }
}
/*
 * public void database(){ try{ ResultSet rs = null;
 *
 * int updateQuery = 0; Statement statement = null; DatabaseConnect db = new
 * DatabaseConnect(); statement = db.createStatement();
 *
 * String QueryString = "CREATE TABLE user_master1(User_Id INTEGER NOT "+"NULL
 * AUTO_INCREMENT, User_Name VARCHAR(25), UserId VARCHAR(20) "+ ", User_Pwd
 * VARCHAR(15), primary key(User_Id))"; updateQuery =
 * statement.executeUpdate(QueryString); if (updateQuery != 0) {
 * System.out.println("table is created successfully and " + updateQuery + " row
 * is inserted."); } QueryString = "SELECT * from user_master1"; rs =
 * statement.executeQuery(QueryString); while (rs.next()) {
 * System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
 * rs.getString(3) + " "+rs.getString(4)+"\n"); } rs.close(); statement.close();
 *
 *
 * }
 * catch(Exception ex){ System.out.println("Unable to secure databse
 * connection."); }
 *
 * }
 *
 * }
 *
 */
