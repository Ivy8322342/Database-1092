//connection_sql

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection_sql 
{
 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
 static final String DB_URL = "jdbc:mysql://localhost:3306/company?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
 static final String USER = "ivy";
 static final String PASS = "ab8322342";
 
 
 
 
// =========================
 public static Connection getConnection() 
 {
  Connection conn = null;
  
  try 
  {
   conn =  DriverManager.getConnection(DB_URL, USER, PASS);
   System.out.println("mysql Connection Success");
  } 
  catch (SQLException e)
  {
   e.printStackTrace();
  }
  
  return conn;
 } 
 
 
 
//=========================
 
 public static void main (String [] args) {
	 
	  getConnection() ;
	 

//  try 
//  {
// Connection  conn =  DriverManager.getConnection(DB_URL, USER, PASS);
//   System.out.println("mysql Connection Success");
//   Statement statement = conn.createStatement();
//
//   try (ResultSet resultSet = statement.executeQuery("SELECT * FROM city limit 10")) {
//	   while (resultSet.next()) {
//	   System.out.println(resultSet.getString("Name") + " " + resultSet.getString("CountryCode") + " " + resultSet.getString("District"));
//	   }
//	   }
//	
//  } catch (SQLException ex) {
//	// handle any errors
//	System.out.println("SQLException: " + ex.getMessage());
//	System.out.println("SQLState: " + ex.getSQLState());
//	System.out.println("VendorError: " + ex.getErrorCode());
//	}
 }
}