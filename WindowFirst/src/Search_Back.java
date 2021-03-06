//Search

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Search_Back 
{String pn;
 int pid;
	public static void main(String []args) throws SQLException {
		Search_Back search=new Search_Back();
		search.ProductName(3);
//		search.findBQ("北投區",1);
		for(String a:search.findBQ("北投區",1)){
			System.out.println(a);
		}
		
	}
	//用縣市找到區
public ArrayList<String> findZone(String city) throws SQLException{
	ArrayList<String> zone=new ArrayList<String>();
	Connection conn=null;
	
	try {
		conn=connection_sql.getConnection();
		PreparedStatement stat=conn.prepareStatement("SELECT DISTINCT SUBSTR(Branch.Location,4,3) AS area FROM Branch"
				+ " WHERE Branch.Location LIKE ? ");
		stat.setString(1,"%"+city+"%");
		ResultSet result=stat.executeQuery();
		while(result.next()) {
			String s=result.getString("area");
			System.out.println(s);
			zone.add(s);
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		conn.close();
		
	}
	return zone;
}
	
	
	
	
	
	
	
	
	//find Branch_Name and Quantity_Left
 public ArrayList<String> findBQ(String area,int ProductID) throws SQLException
 {this.pid=ProductID;
  boolean flag = false;
  Connection conn = null;
  ArrayList<String>Al=new ArrayList<String>();
  
  try 
  {
   conn = connection_sql.getConnection();
   PreparedStatement stat = conn.prepareStatement("SELECT Branch_Name,Quantity_Left ,PRODUCT.Product_Name "
   		+ "FROM BRANCH,Inventory,Product WHERE Branch.Location LIKE ? "
   		+ "AND Branch.Branch_No=Inventory.Branch_No"
   		+ " AND Inventory.Product_ID= ?"
   		+ " AND PRODUCT.Product_ID=Inventory.Product_ID");
   stat.setString(1,"%"+area+"%");
   stat.setInt(2,ProductID);
   ResultSet result = stat.executeQuery();
   while(result.next()) {
	   int Quantity=result.getInt("Quantity_Left");
	   String BName=result.getString("Branch_Name");
	   String PName=result.getString("Product_Name");
	   String info="" +BName+";"+Quantity;
	   System.out.println("info+"+info);
	   Al.add(info);
   }
   
   
  
  }catch(SQLException e) {
	  e.printStackTrace();
  }
  catch(Exception ee) {
	  ee.printStackTrace();
  }
  
  finally 
  {
   conn.close();
  }
  return Al;
  
 }
 
 public String ProductName(int pid) throws SQLException
 {
  Connection conn = null;
  ResultSet result = null;
  
  try 
  {
   conn = connection_sql.getConnection();
   PreparedStatement stat = conn.prepareStatement("SELECT * FROM PRODUCT WHERE product.product_id = ?");
   stat.setInt(1, pid);
   result = stat.executeQuery();
   while (result.next()) {
   pn=result.getString("Product_Name");
   }}catch(SQLException e) {
	   
   }
  
  
  finally 
  {
   conn.close();
  }
  System.out.println(pn);
  return pn;
 }
 //享用QR_
 public ResultSet displaySpecificItem(String pname, String bname) throws SQLException
 {
  Connection conn = null;
  ResultSet result = null;
  
  try 
  {
   conn = connection_sql.getConnection();
   PreparedStatement stat = conn.prepareStatement("SELECT Branch.Branch_Name,"
   		+ " INVENTORY.Quantity_Left FROM INVENTORY, PRODUCT, BRANCH WHERE PRODUCT.Product_Name = ? AND BRANCH.Branch_Name = ? AND PRODUCT.Product_ID = INVENTORY.Product_ID AND BRANCH.Branch_No = INVENTORY.Branch_No");
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