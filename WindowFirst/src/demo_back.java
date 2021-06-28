import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class demo_back {
	String Cid;
	demo_back(String cid){
		this.Cid=cid;
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
 demo_back demo=new demo_back("ivy20468");
 demo.CustomerInfo();
	}
	public ArrayList<String> CustomerInfo() throws SQLException{
		ArrayList<String> CusInfo=new ArrayList<String>();
		Connection conn=null;
		ResultSet result=null;
		
		try {
			conn=connection_sql.getConnection();
			PreparedStatement stat=conn.prepareStatement("SELECT CUSTOMER.Customer_ID,CUSTOMER.Password"
					+ ",CUSTOMER.FirstName,LastName "
					+ "FROM CUSTOMER"
					+ " WHERE Customer_ID=?");
			stat.setString(1, this.Cid);
			result=stat.executeQuery();
			while(result.next()) {
			String id=result.getString("Customer_ID");
			String passw=result.getString("Password");
			String fN=result.getString("FirstName");
			String LN=result.getString("LastName");
			String info=id+","+passw+","+LN+fN;
			CusInfo.add(info);
			System.out.println(info);
					
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return CusInfo;
	}

}
