import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreBuy_Back //prebuy «áºÝ
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
	   
	   ///////////////§ìÂÎ¥Î
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
 
 public static void main(String[]args) throws SQLException {
	 PreBuy_Back pre=new PreBuy_Back("ivy2046");
	 
	 pre.displayPrebuyStr();
 }
 
}