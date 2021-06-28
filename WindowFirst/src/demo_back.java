import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class demo_back {
	String Cid;
	String passw;
	String Name;
	
	ArrayList<String> CusInfo=new ArrayList<String>();
	demo_back(String cid){
		this.Cid=cid;
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
 demo_back demo=new demo_back("ivy20468");
 demo.CustomerInfo();
 demo.edit("ivy204", "1123","vul","ÃÆ");
	}
	public String CustomerInfo() throws SQLException{
		
		Connection conn=null;
		ResultSet result=null;
		String info="";
		
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
			this.Cid=id;
			this.Name=LN+fN;
			this.passw=passw;
		    info=id+","+passw+","+LN+","+fN;
			
			System.out.println(info);
					
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return info;
	}
	public void edit(String Newid,String NewPassw,String NewLn,String NewFn) throws SQLException {
		String info=CustomerInfo();
		System.out.println(info);
		String[] s=info.split(",");
		String oldcid=Cid;
		String oldpass=passw;
		String oldLn=s[2];
		String oldFn=s[3];
		System.out.println("oldid="+oldcid+"\noldpass="+oldpass+"oldName="+oldLn+oldFn+"/////////////");
		Connection conn=null;
		ResultSet result=null;
		
		
		try {
			conn=connection_sql.getConnection();
			PreparedStatement stat1=conn.prepareStatement("UPDATE CUSTOMER "
					+ "SET Customer_ID=? "
					+ "WHERE Password=? "
					+ "AND Customer_ID=?");
			
			PreparedStatement stat2=conn.prepareStatement("UPDATE CUSTOMER "
					+ "SET Password=? "
					+ "WHERE Password=?"
					+ "AND Customer_ID=?");
			
			PreparedStatement stat3=conn.prepareStatement("UPDATE CUSTOMER "
					+ "SET LastName=? "
					+ "WHERE Password=? "
					+ "AND Customer_ID=?");
			PreparedStatement stat4=conn.prepareStatement("UPDATE CUSTOMER "
					+ "SET FirstName=? "
					+ "WHERE Password=? "
					+ "AND Customer_ID=?");
			stat1.setString(1, Newid);
			stat1.setString(2, oldpass);
			stat1.setString(3, oldcid);
			
			stat2.setString(1,NewPassw);
			stat2.setString(2, oldpass);
			stat2.setString(3, oldcid);
			
			stat3.setString(1, NewLn);
			stat3.setString(2, oldpass);
			stat3.setString(3, oldcid);
			
			stat4.setString(1, NewFn);
			stat4.setString(2, oldpass);
			stat4.setString(3, oldcid);
			stat1.executeUpdate();
			stat2.executeUpdate();
			stat3.executeUpdate();
			stat4.executeUpdate();
			
			
			System.out.println("­×§ï¦¨¥\!!");
			String newcid=Newid;
			this.Cid=newcid;
			String[] s1=CustomerInfo().split(",");
			
			String newpass=s1[1];
			String newName=s1[2]+s1[3];
			
			this.passw=newpass;
			this.Name=newName;
			System.out.println("newid="+newcid+"\n newpass="+newpass+"\n newName="+newName+"/////////////");		
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		
		
	}

}
