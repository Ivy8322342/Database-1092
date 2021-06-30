import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreBuy_Back //prebuy 後端
{	String CustomerID;
	
 PreBuy_Back(String CustomerID){
	 this.CustomerID=CustomerID;
 }
 //use customer to find prebuy
 public ArrayList<String> displayPrebuyStr() throws SQLException
 {ArrayList<String> infoArrl=new ArrayList<String>();
  Connection conn = null;
  ResultSet result = null;
  
  try 
  {
   conn = connection_sql.getConnection();
   PreparedStatement stat = conn.prepareStatement("SELECT PRODUCT.Product_Name, PRODUCT.Product_type,PREBUY.Quantity, PREBUY.ExpiredDate,"
   		+ "PRODUCT.Picture,"
   		+ " PREBUY.product_ID"
   		+ " FROM  PRODUCT RIGHT JOIN PREBUY "
   		+ "ON  PRODUCT.Product_ID = PREBUY.Product_ID "
   		+ "WHERE PREBUY.Customer_ID = ? "
   		+ " Order by PRODUCT.Product_ID");
   stat.setString(1, CustomerID);
 
   result = stat.executeQuery();
   while(result.next()) {
	   String PName=result.getString("Product_Name");
	   String PType=result.getString("PRODUCT.Product_type");
	   int Quantity=result.getInt("PREBUY.Quantity");
	   String ExDate=result.getString("PREBUY.ExpiredDate");
	   int Product_ID=result.getInt("PREBUY.product_ID");
	   String pic=result.getString("picture");
	   
	   String info= PName+","+PType+","+Quantity+","+ExDate+","+"/img/"+pic+","+Product_ID;
	   
	   ///////////////抓蟲用
	   System.out.println("--------------------\n"+info);
	   ////////////////////////////
	   infoArrl.add(info);
   }
   //////////////////////
   System.out.println("=======================\n");
  }
  
  finally 
  {
   conn.close();
  }
  
  return infoArrl;
 }
 
 //find GoodP 要素:product id, cid,branch name,quantity,pic
 public String findGoodPCom(String cid,int pid,String bN) throws SQLException {
	 String Info="";
	 Connection conn = null;
	  ResultSet result = null;
	  
	  try 
	  {
	   conn = connection_sql.getConnection();
	   PreparedStatement stat = conn.prepareStatement("SELECT Product.product_name,Product.Picture,prebuy.quantity "
	   		+ "from product,prebuy "
	   		+ "where prebuy.Product_id=product.product_id"
	   		+ " And product.product_ID=?"
	   		+ " And customer_id=?");
	   stat.setInt(1,pid);
	   stat.setString(2, cid);
	 
	   result = stat.executeQuery();
	   while(result.next()) {
		   String PName=result.getString("Product_Name");
		   int Quantity=result.getInt("PREBUY.Quantity");
		   String pic=result.getString("picture");
		   
		   Info= PName+","+Quantity+","+"/img/"+pic+","+bN;
		   
		   ///////////////抓蟲用
		   System.out.println("goodpcom--------------------\n"+Info);
		   ////////////////////////////
		 
	   }
	   //////////////////////
	   System.out.println("=======================\n");
	  }
	  
	  finally 
	  {
	   conn.close();
	  }
	  
	 
	 
	 return Info;
	 
 }
 public void removeBranchGoodNum(int num,String BN,String PN ) throws SQLException {
	 Connection conn = null;
	  ResultSet result = null;
	  
	  try 
	  {
	   conn = connection_sql.getConnection();
	   
	   int pid=findpid(PN);
	   int BNo=findBno(BN);
	   
	   
	   PreparedStatement stat2 = conn.prepareStatement("UPDATE inventory "
	   		+ "SET inventory.Quantity_left= inventory.Quantity_left-?"
	   		+ " where inventory.Branch_No=?"
	   		+ " And inventory.product_ID=?"
	   		);
	   stat2.setInt(1,num);
	   stat2.setInt(2, BNo);
	   stat2.setInt(3,pid);
	 
	   stat2.executeUpdate();
	   while(result.next()) {
		   String PName=result.getString("Product_Name");
		   int Quantity=result.getInt("PREBUY.Quantity");
		   String pic=result.getString("picture");
		   
		 
		   
		   ///////////////抓蟲用
		   System.out.println("現在有 "+Quantity+"個 pid="+pid+",品名="+PN+",存貨在branch_no="+BNo+", 店名:"+BN);
		   ////////////////////////////
		 
	   }
	   //////////////////////
	   System.out.println("=======================\n");
	  }
	  
	  finally 
	  {
	   conn.close();
	  }
	  
	 
 }
 public int findBno(String BName) throws SQLException {
	 Connection conn = null;
	  ResultSet result = null;
	  int Bno=0;
	  try 
	  {
	   conn = connection_sql.getConnection();
	   PreparedStatement stat = conn.prepareStatement("SELECT Branch_No "
	   		+ "from Branch "
	   		+ "where Branch_Name=?"
	   		);
	   stat.setString(1,BName);
	   
	   result = stat.executeQuery();
	   while(result.next()) {
		  Bno=result.getInt("branch_No");
		  
		   String Info= "Get branch_No="+Bno;
		   
		   ///////////////抓蟲用
		   System.out.println(Info);
		   ////////////////////////////
		 
	   }
	   //////////////////////
	
	  }
	  
	  finally 
	  {
	   conn.close();
	  }
	  
	 return Bno;
	 
	 
 }
 public int findpid(String PName) throws SQLException {
	 Connection conn = null;
	  ResultSet result = null;
	  int pid=0;
	  try 
	  {
	   conn = connection_sql.getConnection();
	   PreparedStatement stat = conn.prepareStatement("SELECT Product.product_id "
	   		+ "from product "
	   		+ "where product.product_Name=?"
	   		);
	   stat.setString(1,PName);
	  
	 
	   result = stat.executeQuery();
	   while(result.next()) {
		  pid=result.getInt("Product.priduct_id");
		   
		 
		   
		  
		 
	   }
	  
	  }
	  
	  finally 
	  {
	   conn.close();
	  }
	  
	 return pid;
	 
 }
 
 
 
 
 
 
 
 
 public static void main(String[]args) throws SQLException {
	 PreBuy_Back pre=new PreBuy_Back("ivy1");
	 
	 pre.findGoodPCom("ivy1",4,"aa");
 }
 
}