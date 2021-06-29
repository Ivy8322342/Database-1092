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
 
 
 
 
 
 
 
 
 public static void main(String[]args) throws SQLException {
	 PreBuy_Back pre=new PreBuy_Back("ivy1");
	 
	 pre.findGoodPCom("ivy1",4,"aa");
 }
 
}