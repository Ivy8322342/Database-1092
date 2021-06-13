//Search

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search_Back 
{
 public boolean findBranch(String name) throws SQLException
 {
  boolean flag = false;
  Connection conn = null;
  
  try 
  {
   conn = connection_sql.getConnection();
   PreparedStatement stat = conn.prepareStatement("SELECT Branch_No, Branch_Name, Location FROM BRANCH WHERE Branch_Name = ?");
   stat.setString(1, name);
   ResultSet result = stat.executeQuery();
   
   if(result != null) 
   {
    flag = true;
   }
  }
  
  finally 
  {
   conn.close();
  }
  
  return flag;
 }
 
 public ResultSet displayStorage(String name) throws SQLException
 {
  Connection conn = null;
  ResultSet result = null;
  
  try 
  {
   conn = connection_sql.getConnection();
   PreparedStatement stat = conn.prepareStatement("SELECT PRODUCT.Product_Name, BRANCH.Branch_Name, INVENTORY.Quantity_Left FROM INVENTORY, PRODUCT, BRANCH WHERE BRANCH.Branch_Name = ? AND PRODUCT.Product_ID = INVENTORY.Product_ID AND BRANCH.Branch_No = INVENTORY.Branch_No");
   stat.setString(1, name);
   result = stat.executeQuery();
  }
  
  finally 
  {
   conn.close();
  }
  
  return result;
 }
 
 public ResultSet displaySpecificItem(String pname, String bname) throws SQLException
 {
  Connection conn = null;
  ResultSet result = null;
  
  try 
  {
   conn = connection_sql.getConnection();
   PreparedStatement stat = conn.prepareStatement("SELECT PRODUCT.Product_Name, BRANCH.Branch_Name, INVENTORY.Quantity_Left FROM INVENTORY, PRODUCT, BRANCH WHERE PRODUCT.Product_Name = ? AND BRANCH.Branch_Name = ? AND PRODUCT.Product_ID = INVENTORY.Product_ID AND BRANCH.Branch_No = INVENTORY.Branch_No");
   stat.setString(1, pname);
   stat.setString(2, bname);
   result = stat.executeQuery();
  }
  
  finally 
  {
   conn.close();
  }
  
  return result;
 }
}