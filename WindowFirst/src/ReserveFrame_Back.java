import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


 public class ReserveFrame_Back 
 {
  private String customerID;
  private JButton ReservationBtn;
 
 
  public  ReserveFrame_Back () throws SQLException
  {
   ReservationBtn();
 
  }
  
 
  public void ReservationBtn() throws SQLException
  {   
   ReservationBtn = new JButton("我要預約");
   
   class ReservationBtnListener implements ActionListener 
   {
    public void actionPerformed(ActionEvent event) 
    {
     ReservationBtn = new JButton("我要預約");
     boolean flag = false;
     Connection conn = null;
     try 
       {
        conn  = connection_sql.getConnection();
        PreparedStatement stat = conn.prepareStatement("SELECT Product_ID, Quantity FROM PREBUY WHERE Customer_ID = ?");
        stat.setString(1, customerID);
        ResultSet result = stat.executeQuery();
        
        if(result != null) 
        {
         flag = true;
         
         if (result.next()) {
             
             System.out.println(result.getInt("Quantity"));
         }
         
         
         
        }
       } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
       finally 
       {
        try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
       
      
     
       }
   }
   ActionListener listener = new ReservationBtnListener();
   ReservationBtn.addActionListener(listener);
   ReservationBtn.setSize(30, 30);
   
   
  }
  public static void main(String[] args) throws SQLException {
		 
	  ReserveFrame_Back b=new ReserveFrame_Back ();
	  b.ReservationBtn();
		 
  }
  
  
 }

 
// public Customer findPerson(String customerID) {
//  
//  
//   
//   stat.setString(1, id);
//   
//   if (r.next()) {
//    int current = r.getInt("current");
//    int lv = r.getInt("Level");
//    int shell = r.getInt("Shells");
//    int feed = r.getInt("Feed");
//    int xp = r.getInt("Experience");
//    int ts = r.getInt("TimeStamp");
//    Person p = new Person(id, current, lv, shell, feed, xp, ts);
//    return p;
//   }
//   return null;
  
// }