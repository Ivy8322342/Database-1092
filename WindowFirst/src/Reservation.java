
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Reservation
 {
  private String customerID;
  private JButton ReservationBtn;
 

  public Reservation ()throws SQLException
  {
   ReservationBtn();
 //  CancelFinishPanel();
 
  }
  
 
  public ArrayList<String> ReservationBtn() throws SQLException
  {    ArrayList<String> List = new ArrayList<String>();
   ReservationBtn = new JButton("我要預約");
   
   class ReservationBtnListener implements ActionListener 
   {
    String PName = null;
    Integer quantity = null;

	public void actionPerformed(ActionEvent event) 
    {
     ReservationBtn = new JButton("我要預約");
     boolean flag = false;
     Connection conn = null;
    
     try 
       {
        conn  = connection_sql.getConnection();
        PreparedStatement stat = conn.prepareStatement("SELECT Product_Name, Quantity FROM PREBUY PRODUCT WHERE Customer_ID = ? AND PRODUCT.PRODUCT_ID = PREBUY.PRODUCT_ID");
        stat.setString(1, customerID);
        
        
        ResultSet result = stat.executeQuery();
        
        
        
        if(result != null) 
        {
         flag = true;
         
         if (result.next()) 
         {
        	 String PName = result.getString("Product_Name");
        	 Integer quantity = result.getInt("Quantity");
        	
         }
         String result1 = "" + PName + ";" + quantity;
			System.out.println("result+" + result1);
			List.add(result1);
         
         
         
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
   return List;
   
  }
  
//	// find Branch_Name and Quantity_Left
//	public ArrayList<String> findBQ(String area, int ProductID) throws SQLException {
//		this.pid = ProductID;
//		boolean flag = false;
//		Connection conn = null;
//		ArrayList<String> Al = new ArrayList<String>();
//
//		try {
//			conn = connection_sql.getConnection();
//			PreparedStatement stat = conn.prepareStatement("SELECT Branch_Name,Quantity_Left ,PRODUCT.Product_Name "
//					+ "FROM BRANCH,Inventory,Product WHERE Branch.Location LIKE ? "
//					+ "AND Branch.Branch_No=Inventory.Branch_No" + " AND Inventory.Product_ID= ?"
//					+ " AND PRODUCT.Product_ID=Inventory.Product_ID");
//			stat.setString(1, "%" + area + "%");
//			stat.setInt(2, ProductID);
//			ResultSet result = stat.executeQuery();
//			while (result.next()) {
//				int Quantity = result.getInt("Quantity_Left");
//				String BName = result.getString("Branch_Name");
//				String PName = result.getString("Product_Name");
//				String info = "" + BName + ";" + Quantity;
//				System.out.println("info+" + info);
//				Al.add(info);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception ee) {
//			ee.printStackTrace();
//		}
//
//		finally {
//			conn.close();
//		}
//		return Al;
//
//	}

//  public void finish() 
//	{
//
//	     boolean flag = false;
//	     Connection conn = null;
//	     try 
//	     {
//		    conn  = connection_sql.getConnection();
//		    PreparedStatement stat = conn.prepareStatement("SELECT Finish_Or_Not FROM APPOINTMENTPICKUP WHERE Customer_ID = ?");
//		    stat.setString(1, customerID);
//		        
//		        
//		    ResultSet result = stat.executeQuery();
//		        
//		        
//		        
//		    if(result != null) 
//		    {
//		    	flag = true;
//		    	
//		    if (result.getInt("Finish_Or_Not")==1) 
//		    {
//		    		
//		    	
//		   	////刪掉那個預約取貨的panel
//		    
//		    	
//		    	
//		    }	
//		         
//		         
//		         
//		     }
//		     } 
//	     catch (SQLException e) 
//	     {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		       
//		       finally 
//		       {
//		    	
//		       }
//		       
//		      
//		     
//		       }
//  public void CancelFinishPanel() throws SQLException
//  {   
//   ReservationBtn = new JButton("我要預約");
//   
//   class ReservationBtnListener implements ActionListener 
//   {
//    public void actionPerformed(ActionEvent event) 
//    {
//     ReservationBtn = new JButton("我要預約");
//     boolean flag = false;
//     Connection conn = null;
//     try 
//       {
//        conn  = connection_sql.getConnection();
//        PreparedStatement stat = conn.prepareStatement("SELECT Product_ID, Quantity FROM PREBUY WHERE Customer_ID = ?");
//        stat.setString(1, customerID);
//        
//        
//        ResultSet result = stat.executeQuery();
//        
//        
//        
//        if(result != null) 
//        {
//         flag = true;
//         
//         if (result.next()) 
//         {
//             
//             System.out.println(result.getInt("Quantity"));
//         }
//         
//         
//         
//        }
//       } catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//       
//       finally 
//       {
//        try {
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//       }
//       
//      
//     
//       }
//   }
//   ActionListener listener = new ReservationBtnListener();
//   ReservationBtn.addActionListener(listener);
//   ReservationBtn.setSize(30, 30);
//   
//   
//  }
  public static void main(String[] args) throws SQLException {
		 
	  Reservation b=new Reservation();
	  b.ReservationBtn();
//	  b.CancelFinishPanel();
		 
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
