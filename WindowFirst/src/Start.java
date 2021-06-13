import java.awt.EventQueue;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

public class Start {

 private JFrame frame;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Start window = new Start();
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
 public Start() {
  initialize();
 }

 /**
  * Initialize the contents of the frame.
  */
 private void initialize() {
  frame = new JFrame();
  frame.getContentPane().setBackground(new Color(250, 245, 172,98));
  frame.setBounds(100, 100, 450, 550);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.getContentPane().setLayout(null);
  
  JLabel waitLabel = new JLabel("\u8ACB\u7A0D\u5F8C \u52A0\u8F09\u4E2D...");
  waitLabel.setForeground(SystemColor.desktop);
  waitLabel.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 22));
  waitLabel.setBounds(136, 334, 163, 36);
  frame.getContentPane().add(waitLabel);
  
  Icon LogoIcon=new ImageIcon(Start.class.getResource("/img/logo.png"));
  Icon gifIcon =new ImageIcon(demo_window.class.getResource("/img/load.gif"));
  
//  Icon gifIcon = new ImageIcon(ClassLoader.getSystemResource("/img/load.gif"));
  JLabel LogoLabel=new JLabel(LogoIcon);
  JLabel gifLabel = new JLabel(gifIcon);
  JPanel LogoPanel=new JPanel();
  LogoPanel.setBounds(110,80,220,140);
  LogoPanel.add(LogoLabel);
  frame.getContentPane().add(LogoPanel);
  LogoPanel.setBackground(new Color(250, 245,172,98));
  JPanel gifPanel = new JPanel();
  gifPanel.setBackground(new Color(250, 245,172,0));
  gifPanel.setBounds(183, 230, 60, 70);
  gifPanel.add(gifLabel);
  frame.getContentPane().add(gifPanel);
  //timer
  Timer timer=new Timer();
  TimerTask timetask = new TimerTask() { @Override public void run() { 
	  Login loginWindow=new Login();
	  loginWindow.frame.setVisible(true);
	  frame.setVisible(false);
	  
  } };
  timer.schedule(timetask,3000);	

  
 }
}