import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreBuy_Back //prebuy «áºÝ
{
 
 public ResultSet displayPrebuy(String cID, String name) throws SQLException
 {
  Connection conn = null;
  ResultSet result = null;
  
  try 
  {
   conn = connection_sql.getConnection();
   PreparedStatement stat = conn.prepareStatement("SELECT PRODUCT.Product_Name, PREBUY.Quantity, PREBUY.ExpiredDate FROM PREBUY, PRODUCT WHERE PREBUY.Customer_ID = ? AND PRODUCT.Product_ID = PREBUY.Product_ID");
   stat.setString(1, cID);
   stat.setString(2, name);
   result = stat.executeQuery();
  }
  
  finally 
  {
   conn.close();
  }
  
  return result;
 }
 
}