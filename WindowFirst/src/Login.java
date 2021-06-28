import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login {

 Login_Back back=new Login_Back();
 demo_window demo;
  JFrame frame;
  JLabel ErrorLabel = new JLabel("");
 private JTextField accTextField;
 private JTextField passTextField;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Login window = new Login();
     window.frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the application.
  */
 public Login() {
  initialize();
 }

 /**
  * Initialize the contents of the frame.
  */
 private void initialize() {
  frame = new JFrame();
  frame.getContentPane().setBackground(new Color(250,245,172,98));
  frame.getContentPane().setLayout(null);
  
  accTextField = new JTextField();
  accTextField.setBounds(103, 198, 287, 40);
  frame.getContentPane().add(accTextField);
  accTextField.setColumns(10);
  
  JLabel accLabel = new JLabel("\u5E33\u865F");
  accLabel.setBounds(32, 204, 57, 29);
  accLabel.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  frame.getContentPane().add(accLabel);
  
  JLabel passLabel = new JLabel("\u5BC6\u78BC");
  passLabel.setBounds(32, 268, 57, 29);
  passLabel.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  frame.getContentPane().add(passLabel);
  
  passTextField = new JTextField();
  passTextField.setBounds(103, 262, 287, 40);
  passTextField.setForeground(Color.BLACK);
  passTextField.setColumns(10);
  frame.getContentPane().add(passTextField);
  
  JButton logButton = new JButton("\u767B\u5165");
  logButton.setBounds(123, 327, 194, 40);
  logButton.setContentAreaFilled(false);
  logButton.setOpaque(true);
  logButton.setBackground(new Color(0,0,0));
  logButton.setForeground(new Color(255, 255, 255));
  logButton.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  frame.getContentPane().add(logButton);
  logButton.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		  String acc=accTextField.getText();
		  String passw=passTextField.getText();
		  System.out.println("帳號:"+acc+"密碼:"+passw);
		  if(acc.matches("\\S+")&&passw.matches("\\S+")) {
		  try {
			CheckUser(acc,passw);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  accTextField.setText("");
		  passTextField.setText("");
		  }else {
			  ErrorLabel.setText("別鬧，請確實填寫帳密!!");
			  accTextField.setText("");
			  passTextField.setText("");
		  }
	  }


  });
  
  JPanel topPanel = new JPanel();
  topPanel.setBounds(0, 0, 436, 40);
  topPanel.setBackground(new Color(153,107,31));
  topPanel.setForeground(Color.BLACK);
  frame.getContentPane().add(topPanel);
  
  JPanel panel = new JPanel();
  panel.setBounds(0, 40, 436, 119);
  frame.getContentPane().add(panel);
  panel.setLayout(null);
  panel.setBackground(new Color(250,245,172));
  
  
  ErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
  ErrorLabel.setForeground(new Color(220, 20, 60));
  ErrorLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
  ErrorLabel.setBounds(87, 57, 267, 77);
  panel.add(ErrorLabel);
  
  JLabel titleLabel = new JLabel("\u767B\u5165");
  titleLabel.setBounds(43, 29, 70, 40);
  panel.add(titleLabel);
  titleLabel.setFont(new Font("華康中特圓體(P)", Font.BOLD, 32));
  
  logButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    
   }
  });
  
  frame.setBounds(100, 100, 450, 550);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  
 }
 
 public void CheckUser(String User,String Passw) throws SQLException {
	 ArrayList<String> arr= back.Account();
	 for(int i=0;i<arr.size();i++) {
		 String[]s=arr.get(i).split(",");
		 System.out.println(s[0]+";"+s[1]);
		 if(User.equals(s[0])&&Passw.equals(s[1])){
			 System.out.println("Successed!!");
			 Prebuy prebuy=new Prebuy(User);
			 prebuy.frame.setVisible(true);
			 ErrorLabel.setText("");
//			 ErrorLabel.setText("登入成功!!");
//			 this.frame.dispose();
			 return;
		 }
	 }ErrorLabel.setText("登入失敗，請重新登入。");
 }
}