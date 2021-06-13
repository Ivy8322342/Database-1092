//connection_sql

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection_sql 
{
 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
 static final String DB_URL = "jdbc:mysql://localhost:3306/company?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
 static final String USER = "haru";
 static final String PASS = "DEFsoul1994";
 
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
}