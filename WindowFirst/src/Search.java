import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Search {

 JFrame frame;
 private int page;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Search window = new Search();
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
 public Search() {
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
  
  JLabel searchLabel = new JLabel("\u67E5\u8A62");
  searchLabel.setBounds(188, 10, 161, 30);
  searchLabel.setForeground(Color.WHITE);
  searchLabel.setFont(new Font("華康中特圓體(P)", Font.BOLD, 30));
  frame.getContentPane().add(searchLabel);
  
  JPanel topPanel = new JPanel();
  topPanel.setBounds(0, 0, 436, 50);
  topPanel.setBackground(new Color(153,107,31));
  topPanel.setForeground(Color.BLACK);
  frame.getContentPane().add(topPanel);
  
//  JPanel bottomPanel = new JPanel();
//  bottomPanel.setForeground(Color.BLACK);
//  bottomPanel.setBackground(SystemColor.textHighlight);
//  bottomPanel.setBounds(0, 454, 436, 59);
//  frame.getContentPane().add(bottomPanel);
  
  JPanel searchPanel_3 = new JPanel();
  searchPanel_3.setBounds(36, 346, 365, 59);
  frame.getContentPane().add(searchPanel_3);
  searchPanel_3.setLayout(null);
  
  JLabel quanLabel_2_1 = new JLabel("\u5546\u54C1\u5269\u9918\u6578\u91CF\uFF1A");
  quanLabel_2_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  quanLabel_2_1.setBounds(21, 16, 168, 27);
  searchPanel_3.add(quanLabel_2_1);
  
  JLabel numLabel_3 = new JLabel("3");
  numLabel_3.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  numLabel_3.setBounds(199, 16, 40, 26);
  searchPanel_3.add(numLabel_3);
  
  JLabel branchLabel_2 = new JLabel("XX\u5E97");
  branchLabel_2.setBounds(36, 217, 54, 20);
  branchLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 20));
  frame.getContentPane().add(branchLabel_2);
  
  JLabel branchLabel_3 = new JLabel("XX\u5E97");
  branchLabel_3.setBounds(36, 316, 54, 20);
  branchLabel_3.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 20));
  frame.getContentPane().add(branchLabel_3);
  
  JPanel searchPanel_2 = new JPanel();
  searchPanel_2.setBounds(36, 247, 365, 59);
  frame.getContentPane().add(searchPanel_2);
  searchPanel_2.setLayout(null);
  
  JLabel quanLabel_2 = new JLabel("\u5546\u54C1\u5269\u9918\u6578\u91CF\uFF1A");
  quanLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  quanLabel_2.setBounds(21, 16, 168, 27);
  searchPanel_2.add(quanLabel_2);
  
  JLabel numLabel_2 = new JLabel("3");
  numLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  numLabel_2.setBounds(199, 16, 40, 26);
  searchPanel_2.add(numLabel_2);
  
  JComboBox cityComboBox = new JComboBox();
  cityComboBox.setBounds(92, 60, 120, 42);
  cityComboBox.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  frame.getContentPane().add(cityComboBox);
  
  JLabel cityLabel = new JLabel("\u7E23\u5E02\uFF1A");
  cityLabel.setBounds(24, 68, 72, 26);
  cityLabel.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 22));
  frame.getContentPane().add(cityLabel);
  
  JLabel areaLabel = new JLabel("\u5730\u5340\uFF1A");
  areaLabel.setBounds(228, 69, 72, 26);
  areaLabel.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 22));
  frame.getContentPane().add(areaLabel);
  
  JComboBox areaComboBox = new JComboBox();
  areaComboBox.setBounds(293, 60, 120, 42);
  areaComboBox.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  frame.getContentPane().add(areaComboBox);
  
  JPanel searchPanel_1 = new JPanel();
  searchPanel_1.setBounds(36, 142, 365, 59);
  frame.getContentPane().add(searchPanel_1);
  searchPanel_1.setLayout(null);
  
  JLabel quanLabel_1 = new JLabel("\u5546\u54C1\u5269\u9918\u6578\u91CF\uFF1A");
  quanLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  quanLabel_1.setBounds(21, 16, 168, 27);
  searchPanel_1.add(quanLabel_1);
  
  JLabel numLabel_1 = new JLabel("3");
  numLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  numLabel_1.setBounds(199, 16, 40, 26);
  searchPanel_1.add(numLabel_1);
  
  JLabel branchLabel_1 = new JLabel("XX\u5E97");
  branchLabel_1.setBounds(36, 112, 54, 20);
  branchLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 20));
  frame.getContentPane().add(branchLabel_1);
  
  
  frame.setBounds(100, 100, 450, 550);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  JPanel FooterPanel = new JPanel();
  FooterPanel.setBounds(0, 433, 436, 81);
	FooterPanel.setBackground(new Color(153,107 ,31));
	 frame.getContentPane().add(FooterPanel);
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
	
	JButton lastButton = new JButton("上一頁");
	lastButton.setBounds(83, 405, 98, 25);
	frame.getContentPane().add(lastButton);
	lastButton.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
	 }
	});
	lastButton.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 20));
	
	JButton nextButton = new JButton("\u4E0B\u4E00\u9801");
	nextButton.setBounds(251, 405, 98, 25);
	frame.getContentPane().add(nextButton);
	nextButton.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 20));
	
	nextButton.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
	  page ++;
	
	  System.out.println(page);
	 }
	});

	GridBagConstraints gc;
	JLabel label = new JLabel("Label 2");
	label.setIcon(new ImageIcon(Search.class.getResource("/img/me1.jpg")));
	label.setLocation(86, -232);
	label.setBackground(Color.CYAN);
	label.setSize(326, 274);
	label.setForeground(Color.BLACK);
	
}
 }
