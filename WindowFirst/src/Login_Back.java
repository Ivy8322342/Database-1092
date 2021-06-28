import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Login_Back {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Login_Back  Lback=new Login_Back();
		Lback.Account();
	}

	public ArrayList<String> Account() throws SQLException{
		ArrayList<String> account=new ArrayList<String>();
		Connection conn=null;
		ResultSet result=null;
		
		try {
			conn=connection_sql.getConnection();
			PreparedStatement stat=conn.prepareStatement("SELECT CUSTOMER.Customer_ID,CUSTOMER.Password "
					+ "FROM CUSTOMER");
			result=stat.executeQuery();
			while(result.next()) {
			String id=result.getString("Customer_ID");
			String passw=result.getString("Password");
			String info=id+","+passw;
			account.add(info);
			System.out.println(info);
					
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return account;
	}
	
	
}
