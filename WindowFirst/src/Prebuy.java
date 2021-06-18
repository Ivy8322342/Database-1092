
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Prebuy {

	JFrame frame;
 private int page;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Prebuy window = new Prebuy();
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
 public Prebuy() {
  initialize();
 }

 /**
  * Initialize the contents of the frame.
  */
 private void initialize() {
  page = 1;
  frame = new JFrame();
  frame.getContentPane().setBackground(new Color(250,245,172,98));
  frame.getContentPane().setLayout(null);
  
  JLabel buyLabel = new JLabel("\u9810\u8CB7\u6E05\u55AE");
  buyLabel.setForeground(Color.WHITE);
  buyLabel.setFont(new Font("華康中特圓體(P)", Font.BOLD, 30));
  buyLabel.setBounds(157, 10, 173, 30);
  frame.getContentPane().add(buyLabel);

  JPanel topPanel = new JPanel();
  topPanel.setBounds(0, 0, 436, 50);
  topPanel.setBackground(new Color(153,107,31));
  topPanel.setForeground(Color.BLACK);
  frame.getContentPane().add(topPanel);
  
  
  JPanel buyPanel_1 = new JPanel();
  buyPanel_1.setBounds(34, 74, 365, 150);
  frame.getContentPane().add(buyPanel_1);
  buyPanel_1.setLayout(null);
  
  JPanel imgPanel_1 = new JPanel();
  imgPanel_1.setBounds(17, 17, 116, 116);
  buyPanel_1.add(imgPanel_1);
  
  JLabel titleLabel_1 = new JLabel("\u7FA9\u7F8E\u7121\u7CD6\u8C46\u6F3F");
  titleLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  titleLabel_1.setBounds(155, 10, 154, 32);
  buyPanel_1.add(titleLabel_1);
  
  JLabel sizeLabel_1 = new JLabel("\u898F\u683C\uFF1A");
  sizeLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
  sizeLabel_1.setBounds(155, 45, 54, 26);
  buyPanel_1.add(sizeLabel_1);
  
  JLabel quanLabel_1 = new JLabel("\u9810\u8CB7\u6578\u91CF\uFF1A");
  quanLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
  quanLabel_1.setBounds(155, 75, 90, 26);
  buyPanel_1.add(quanLabel_1);
  
  JLabel deadlineLabel_1 = new JLabel("\u5230\u671F\u65E5\uFF1A");
  deadlineLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
  deadlineLabel_1.setBounds(155, 105, 72, 26);
  buyPanel_1.add(deadlineLabel_1);
  
  JLabel dateLabel_1 = new JLabel("2021/06/21");
  dateLabel_1.setBounds(227, 110, 128, 17);
  buyPanel_1.add(dateLabel_1);
  dateLabel_1.setFont(new Font("華康中特圓體(P)", Font.BOLD, 16));
  
  JLabel numLabel_1 = new JLabel("5");
  numLabel_1.setFont(new Font("華康中特圓體(P)", Font.BOLD, 16));
  numLabel_1.setBounds(246, 80, 31, 17);
  buyPanel_1.add(numLabel_1);
  
  JLabel capaLabel_1 = new JLabel("400ml");
  capaLabel_1.setFont(new Font("華康中特圓體(P)", Font.BOLD, 16));
  capaLabel_1.setBounds(210, 45, 78, 26);
  buyPanel_1.add(capaLabel_1);
  
  JPanel buyPanel_2 = new JPanel();
  buyPanel_2.setBounds(34, 249, 365, 150);
  frame.getContentPane().add(buyPanel_2);
  buyPanel_2.setLayout(null);
  
  JPanel imgPanel_2 = new JPanel();
  imgPanel_2.setBounds(17, 17, 116, 116);
  buyPanel_2.add(imgPanel_2);
  
  JLabel titleLabel_2 = new JLabel("\u8336\u8449\u86CB");
  titleLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  titleLabel_2.setBounds(155, 10, 154, 32);
  buyPanel_2.add(titleLabel_2);
  
  JLabel sizeLabel_2 = new JLabel("\u898F\u683C\uFF1A");
  sizeLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
  sizeLabel_2.setBounds(155, 45, 54, 26);
  buyPanel_2.add(sizeLabel_2);
  
  JLabel quanLabel_2 = new JLabel("\u9810\u8CB7\u6578\u91CF\uFF1A");
  quanLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
  quanLabel_2.setBounds(155, 75, 90, 26);
  buyPanel_2.add(quanLabel_2);
  
  JLabel deadlineLabel_2 = new JLabel("\u5230\u671F\u65E5\uFF1A");
  deadlineLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
  deadlineLabel_2.setBounds(155, 105, 72, 26);
  buyPanel_2.add(deadlineLabel_2);
  
  JLabel dateLabel_2 = new JLabel("2021/06/21");
  dateLabel_2.setFont(new Font("華康中特圓體(P)", Font.BOLD, 16));
  dateLabel_2.setBounds(227, 110, 128, 17);
  buyPanel_2.add(dateLabel_2);
  
  JLabel numLabel_2 = new JLabel("3");
  numLabel_2.setFont(new Font("華康中特圓體(P)", Font.BOLD, 16));
  numLabel_2.setBounds(246, 80, 31, 17);
  buyPanel_2.add(numLabel_2);
  
  JLabel capaLabel_2 = new JLabel("1\u9846");
  capaLabel_2.setFont(new Font("華康中特圓體(P)", Font.BOLD, 16));
  capaLabel_2.setBounds(210, 45, 78, 26);
  buyPanel_2.add(capaLabel_2);
  
  JButton nextButton = new JButton("\u4E0B\u4E00\u9801");
  nextButton.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 20));
  nextButton.setBounds(173, 421, 98, 25);
  
  JButton lastButton = new JButton("上一頁");
  lastButton.setBounds(0, 0, 98, 25);
  lastButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   }
  });
  lastButton.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 20));
  JPanel prePanel = new JPanel();
  prePanel.setBounds(80, 421, 98, 25);
  prePanel.setLayout(null);
  prePanel.add(lastButton);
  prePanel.setVisible(false);
  
  nextButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    page ++;
    prePanel.setVisible(true);
    nextButton.setBounds(258, 421, 98, 25);
    System.out.println(page);
   }
  });
  
  frame.setBounds(100, 100, 450, 550);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  JPanel FooterPanel = new JPanel();
	FooterPanel.setBounds(0, 430, 436, 81);
	FooterPanel.setBackground(new Color(153,107,31));
	 frame.add(FooterPanel);
	FooterPanel.setLayout(null);
	
	JLabel TimeLabel=new JLabel("");
	TimeLabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			ReserveFrame rwindow = new ReserveFrame();
			rwindow.reserveframe.setVisible(true);
			 frame.setVisible(false);
			
		}
		
	});
	
	TimeLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/time.png")));
	TimeLabel.setBounds(33, 10, 68, 61);
	FooterPanel.add(TimeLabel);
	
	JLabel SearchLabel = new JLabel("New label");
	SearchLabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Search swindow=new Search();
			swindow.frame.setVisible(true);
			 frame.setVisible(false);
		}
	});
	SearchLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/search.png")));
	SearchLabel.setBounds(234, 10, 68, 61);
	FooterPanel.add(SearchLabel);
	
	JLabel AccountLabel = new JLabel("New label");
	AccountLabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			demo_window window = new demo_window();
			window.Accountframe.setVisible(true);
			 frame.setVisible(false);
			
		}
		
	});
	AccountLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/account2.png")));
	AccountLabel.setBounds(336, 10, 68, 61);
	FooterPanel.add(AccountLabel);
	
	JLabel BagLabel = new JLabel("New label");
	BagLabel.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			Prebuy pwindow=new Prebuy();
			pwindow.frame.setVisible(true);
			 frame.setVisible(false);
		}
	});
	BagLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/bag1.png")));
	BagLabel.setBounds(132, 10, 68, 61);
	FooterPanel.add(BagLabel);

	GridBagConstraints gc;
	JLabel label = new JLabel("Label 2");
	label.setIcon(new ImageIcon(Search.class.getResource("/img/我.jpg")));
	label.setLocation(86, -232);
	label.setBackground(Color.CYAN);
	label.setSize(326, 274);
	label.setForeground(Color.BLACK);
  
 }

}