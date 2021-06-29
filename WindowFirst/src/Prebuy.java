import java.util.ArrayList;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;

public class Prebuy {
	ArrayList<String>Arrl;
	ArrayList<GoodP>UpArrl;
	ArrayList<GoodP>DownArrl;
	reserveF resF;
	demo_window window;
	 Search search1;
	 Search  search2;
	JFrame frame;
 private int page;
 private boolean uptrue=false;
 private boolean downtrue=false;
 String cid;
 PreBuy_Back prebuy_b;
 JPanel imgPanel_1 = new JPanel();
 JLabel titleLabel_1 = new JLabel("");
 JLabel dateLabel_1 = new JLabel("");
 JLabel capaLabel_1 = new JLabel("");
 JLabel numLabel_1 = new JLabel("");
 JPanel imgPanel_2 = new JPanel();
 JLabel titleLabel_2 = new JLabel("");
 JLabel dateLabel_2 = new JLabel("");
 JLabel numLabel_2 = new JLabel("");
 JLabel capaLabel_2 = new JLabel("");
 JLabel imgLabel_1 = new JLabel("");
 JLabel imgLabel_2 = new JLabel("");
 JLabel lblNewLabel = new JLabel("\u9801\u6578");
 JPanel buyPanel_1 = new JPanel();
 JPanel buyPanel_2 = new JPanel();
 ArrayList<String>upArrl=new ArrayList<String>();
 ArrayList<String>downArrl=new ArrayList <String>();
 // cid 要不要從Login get?之後再改好了
 
 
 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Prebuy window = new Prebuy("ivy204");
     window.frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the application.
 * @throws SQLException 
  */
 public Prebuy(String cid) throws SQLException {
	 this.cid=cid;
	 Arrl=new ArrayList<String>();
	 UpArrl=new ArrayList<GoodP>();
	 DownArrl=new ArrayList<GoodP>();
	 prebuy_b=new PreBuy_Back(cid);
  initialize();
 }

 /**
  * Initialize the contents of the frame.
 * @throws SQLException 
  */
 private void initialize() throws SQLException {
  resF=new reserveF(this);
  resF.reserveframe.setVisible(false);
  page = 1;
  frame = new JFrame();
  frame.getContentPane().setBackground(new Color(250,245,172,98));
  frame.getContentPane().setLayout(null);
  
  JLabel buyLabel = new JLabel("\u9810\u8CB7\u6E05\u55AE");
  buyLabel.setBounds(157, 10, 173, 30);
  buyLabel.setForeground(Color.WHITE);
  buyLabel.setFont(new Font("華康中特圓體(P)", Font.BOLD, 30));
  frame.getContentPane().add(buyLabel);

  JPanel topPanel = new JPanel();
  topPanel.setBounds(0, 0, 436, 50);
  topPanel.setBackground(new Color(153,107,31));
  topPanel.setForeground(Color.BLACK);
  frame.getContentPane().add(topPanel);
  
  
 
  buyPanel_1.addMouseListener(new MouseAdapter() {
  	@Override
  	public void mouseClicked(MouseEvent e) {
  		if(uptrue==false) {
  		uptrue=true;
  		downtrue=false;
  		buyPanel_1.setBackground(new Color(250,245,172));
  		buyPanel_2.setBackground(new Color(240,240,240));
  		System.out.println("choose UpPanel!, give up DownPanel!");
  		
  		}else if(uptrue==true) {
  			uptrue=false;
  	  		downtrue=false;
  	  	buyPanel_1.setBackground(new Color(240,240,240));
  	  System.out.println("Give up UpPanel!, give up DownPanel!");
  	  	
  		}
  	   
  	}
  });
  buyPanel_1.setBounds(34, 74, 365, 150);
  frame.getContentPane().add(buyPanel_1);
  buyPanel_1.setLayout(null);

  
  
  imgPanel_1.setBounds(17, 17, 116, 116);
  buyPanel_1.add(imgPanel_1);
  imgPanel_1.setLayout(null);
  
 
  imgLabel_1.setBounds(0, 0, 116, 116);
  imgPanel_1.add(imgLabel_1);
  
  
  
  

  
 
  titleLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  titleLabel_1.setBounds(155, 10, 154, 32);
  buyPanel_1.add(titleLabel_1);
  
  JLabel sizeLabel_1 = new JLabel("\u985E\u5225\uFF1A");
  sizeLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
  sizeLabel_1.setBounds(155, 45, 72, 26);
  buyPanel_1.add(sizeLabel_1);
  
  JLabel quanLabel_1 = new JLabel("\u9810\u8CB7\u6578\u91CF\uFF1A");
  quanLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
  quanLabel_1.setBounds(155, 75, 105, 26);
  buyPanel_1.add(quanLabel_1);
  
  JLabel deadlineLabel_1 = new JLabel("\u5230\u671F\u65E5\uFF1A");
  deadlineLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
  deadlineLabel_1.setBounds(155, 105, 83, 26);
  buyPanel_1.add(deadlineLabel_1);
  
  
  dateLabel_1.setBounds(237, 111, 128, 17);
  buyPanel_1.add(dateLabel_1);
  dateLabel_1.setFont(new Font("華康中特圓體(P)", Font.BOLD, 16));
  
 
  numLabel_1.setFont(new Font("華康中特圓體(P)", Font.BOLD, 16));
  numLabel_1.setBounds(270, 81, 39, 17);
  buyPanel_1.add(numLabel_1);
  
 
  capaLabel_1.setFont(new Font("華康中特圓體(P)", Font.BOLD, 16));
  capaLabel_1.setBounds(244, 46, 78, 26);
  buyPanel_1.add(capaLabel_1);
  
 /////////////////////////////////////////////////buyPanel_2/////////////////////////////////////////
  buyPanel_2.addMouseListener(new MouseAdapter() {
  	@Override
	public void mouseClicked(MouseEvent e) {
  		if(downtrue==false) {
  		downtrue=true;
  		uptrue=false;
  		buyPanel_1.setBackground(new Color(240,240,240));
  		buyPanel_2.setBackground(new Color(250,245,172));
  		System.out.println("choose DownPanel!, give up UpPanel!");
  		}else if(downtrue==true) {
  			downtrue=false;
  	  		uptrue=false;
  	  	buyPanel_2.setBackground(new Color(240,240,240));
  	  System.out.println("Give up DownPanel!, give up UpPanel!");
  		}
  	   
  	}
  });
  buyPanel_2.setBounds(34, 249, 365, 150);
  frame.getContentPane().add(buyPanel_2);
  buyPanel_2.setLayout(null);
 
  ////////////////////////////////////////

  imgPanel_2.setBounds(17, 17, 116, 116);
  buyPanel_2.add(imgPanel_2);
  imgPanel_2.setLayout(null);
  
  
  imgLabel_2.setBounds(0, 0, 116, 116);
  imgPanel_2.add(imgLabel_2);
  
  titleLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  titleLabel_2.setBounds(155, 10, 154, 32);
  buyPanel_2.add(titleLabel_2);
  
  JLabel sizeLabel_2 = new JLabel("\u985E\u5225\uFF1A");
  sizeLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
  sizeLabel_2.setBounds(155, 45, 72, 26);
  buyPanel_2.add(sizeLabel_2);
  
  JLabel quanLabel_2 = new JLabel("\u9810\u8CB7\u6578\u91CF\uFF1A");
  quanLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
  quanLabel_2.setBounds(155, 75, 101, 26);
  buyPanel_2.add(quanLabel_2);
  
  JLabel deadlineLabel_2 = new JLabel("\u5230\u671F\u65E5\uFF1A");
  deadlineLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 18));
  deadlineLabel_2.setBounds(155, 105, 85, 26);
  buyPanel_2.add(deadlineLabel_2);
  
  
  dateLabel_2.setFont(new Font("華康中特圓體(P)", Font.BOLD, 16));
  dateLabel_2.setBounds(250, 111, 128, 17);
  buyPanel_2.add(dateLabel_2);
  

  numLabel_2.setFont(new Font("華康中特圓體(P)", Font.BOLD, 16));
  numLabel_2.setBounds(250, 81, 47, 17);
  buyPanel_2.add(numLabel_2);
  

  capaLabel_2.setFont(new Font("華康中特圓體(P)", Font.BOLD, 16));
  capaLabel_2.setBounds(237, 45, 78, 26);
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
	 frame.getContentPane().add(FooterPanel);
	FooterPanel.setLayout(null);
	
	JLabel TimeLabel=new JLabel("");
	TimeLabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			 resF.reserveframe.setVisible(true);
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
			if(uptrue==true) {
				try {
					upnewSearch();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				buyPanel_1.setBackground(new Color(240,240,240));
			}else if(downtrue==true) {
				try {
					downnewSearch();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				buyPanel_2.setBackground(new Color(240,240,240));
			}else {System.out.println("請選擇商品以查詢分店存貨");
				JFrame f=new JFrame();
				JDialog d=new JDialog(f,"小提示",true);
				d.setBounds(170, 222, 315, 200);
				 d.getContentPane().setLayout(null);  
				 JButton b = new JButton ("了解!!");  
				 b.setBounds(102,100, 85, 23);
				 b.addActionListener ( new ActionListener()  
			        {  
			            public void actionPerformed( ActionEvent e )  
			            {  
			                d.setVisible(false);  
			            }  
			        });  
				JLabel st= new JLabel ("先選擇品項才能查詢喔~");
				st.setBounds(80,46,269,46);
				 d.getContentPane().add(st);  
			        d.getContentPane().add(b);
			        b.setVisible(true);
//			        d.setSize(300,300);    
			        d.setVisible(true);  
				 
			}uptrue=false;
			downtrue=false;
			
		}
	});
	SearchLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/search.png")));
	SearchLabel.setBounds(234, 10, 68, 61);
	FooterPanel.add(SearchLabel);
	
	JLabel AccountLabel = new JLabel("New label");
	AccountLabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
				try{newdemo();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			window.Accountframe.setVisible(true);
			 frame.setVisible(false);
			
		}
		
	});
	AccountLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/account2.png")));
	AccountLabel.setBounds(336, 10, 68, 61);
	FooterPanel.add(AccountLabel);
	
	JLabel BagLabel = new JLabel("New label");
//	BagLabel.addMouseListener(new MouseAdapter() {
//		public void mouseClicked(MouseEvent e) {
//			Prebuy pwindow = null;
//			try {
//				pwindow = new Prebuy();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			pwindow.frame.setVisible(true);
//			 frame.setVisible(false);
//		}
//	});
	BagLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/Atbag1.png")));
	BagLabel.setBounds(132, 10, 68, 61);
	FooterPanel.add(BagLabel);
	
	JButton LastButton = new JButton("\u4E0A\u4E00\u9801");
	LastButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
	LastButton.setBounds(55, 397, 120, 37);
	frame.getContentPane().add(LastButton);
	LastButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent atg1) {
		lastP();
		}
	});
	
	JButton NextButton = new JButton("\u4E0B\u4E00\u9801");
	NextButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
	NextButton.setBounds(255, 397, 120, 37);
	frame.getContentPane().add(NextButton);
	NextButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			nextP();
		}
		
	});
	
	JPanel PagePanel = new JPanel();
	PagePanel.setBounds(173, 397, 83, 37);
	frame.getContentPane().add(PagePanel);
	PagePanel.setLayout(null);
	
	
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(0, 0, 83, 37);
	PagePanel.add(lblNewLabel);

	GridBagConstraints gc;
	JLabel label = new JLabel("Label 2");
	label.setIcon(new ImageIcon(Search.class.getResource("/img/我.jpg")));
	label.setLocation(86, -232);
	label.setBackground(Color.CYAN);
	label.setSize(326, 274);
	label.setForeground(Color.BLACK);
	distriTowarr();
  
 }
 public void distriTowarr() throws SQLException {
	 ArrayList<String>temArrayList=prebuy_b.displayPrebuyStr();
	 //切完字串來分給兩個ArrayLists
	 for(int i=0;i<temArrayList.size();i++) {
		if(i%2==0) {
			upArrl.add(temArrayList.get(i));
			////////to be deleted
			System.out.println("up Size="+upArrl.size());
		}else if(i%2==1) {
			downArrl.add(temArrayList.get(i));
	////////to be deleted
				System.out.println("down Size="+downArrl.size());
		}else {
			
		}

	 }showupP(1);
	 showupP(2);

 }
 
 public void showupP(int t ) {
	 page=1;
	 if(t==1) {
		if(upArrl.size()>0) {
			String[] s=upArrl.get(0).split(",");
			titleLabel_1.setText(s[0]);
			capaLabel_1.setText(s[1]);
			numLabel_1.setText(s[2]);
			dateLabel_1.setText(s[3]);
			imgLabel_1.setIcon(new ImageIcon(demo_window.class.getResource(s[4])));
		}
		 
	 }else if(t==2) {
		 if(downArrl.size()>0) {
				String[] s=downArrl.get(0).split(",");
				titleLabel_2.setText(s[0]);
				capaLabel_2.setText(s[1]);
				numLabel_2.setText(s[2]);
				dateLabel_2.setText(s[3]);
				imgLabel_2.setIcon(new ImageIcon(demo_window.class.getResource(s[4])));
			}
		 
	 }else {
		 
	 }lblNewLabel.setText(page+"");
 }
 
 public void nextP() {
	 if(page+1>upArrl.size()) {
		 System.out.println("last page");
		 System.out.println("page:"+page);
	 }else {clearP();
		 
		 if(downArrl.size()>page&&upArrl.size()>page) {
			 page++;
			 String[] s=upArrl.get(page-1).split(",");
				titleLabel_1.setText(s[0]);
				capaLabel_1.setText(s[1]);
				numLabel_1.setText(s[2]);
				dateLabel_1.setText(s[3]);
				imgLabel_1.setIcon(new ImageIcon(demo_window.class.getResource(s[4])));
				
				String[]sd=downArrl.get(page-1).split(",");
				titleLabel_2.setText(sd[0]);
				capaLabel_2.setText(sd[1]);
				numLabel_2.setText(sd[2]);
				dateLabel_2.setText(sd[3]);
				imgLabel_2.setIcon(new ImageIcon(demo_window.class.getResource(sd[4])));
				lblNewLabel.setText(page+"");
				
		 }else if(upArrl.size()>page) {
			 page++;
			 String[] s=upArrl.get(page-1).split(",");
				titleLabel_1.setText(s[0]);
				capaLabel_1.setText(s[1]);
				numLabel_1.setText(s[2]);
				dateLabel_1.setText(s[3]);
				imgLabel_1.setIcon(new ImageIcon(demo_window.class.getResource(s[4])));
				lblNewLabel.setText(page+"");
				
		 }
		 
	 }
 }
 
 public void lastP() {
	 if(page-1<1) {
		 System.out.println("first page");
	 }else {page--;
	 clearP();
	 String[] s=upArrl.get(page-1).split(",");
		titleLabel_1.setText(s[0]);
		capaLabel_1.setText(s[1]);
		numLabel_1.setText(s[2]);
		dateLabel_1.setText(s[3]);
		imgLabel_1.setIcon(new ImageIcon(demo_window.class.getResource(s[4])));
		
		String[]sd=downArrl.get(page-1).split(",");
		titleLabel_2.setText(sd[0]);
		capaLabel_2.setText(sd[1]);
		numLabel_2.setText(sd[2]);
		dateLabel_2.setText(sd[3]);
		imgLabel_2.setIcon(new ImageIcon(demo_window.class.getResource(sd[4])));
		lblNewLabel.setText(page+"");
		
		 
	 }
	 
 }
 public void clearP() {
	 titleLabel_1.setText("");
		capaLabel_1.setText("");
		numLabel_1.setText("");
		dateLabel_1.setText("");
		imgLabel_1.setIcon(new ImageIcon(demo_window.class.getResource("")));
		
		 titleLabel_2.setText("");
			capaLabel_2.setText("");
			numLabel_2.setText("");
			dateLabel_2.setText("");
			imgLabel_2.setIcon(new ImageIcon(demo_window.class.getResource("")));
 }
 
 public void upnewSearch() throws SQLException {
   int Product_ID=Integer.parseInt(upArrl.get(page-1).split(",")[5]);
   search1=new Search(Product_ID,cid,this);
   search1.frame.setVisible(true);
   this.frame.dispose();
   System.out.println("pID="+Product_ID);

 }
 public void downnewSearch() throws SQLException {
	 if(downArrl.size()>=page) {
	   int Product_ID=Integer.parseInt(downArrl.get(page-1).split(",")[5]);
	   search2=new Search(Product_ID,cid,this);
	   search2.frame.setVisible(true);
	   this.frame.dispose();
	   System.out.println("pID="+Product_ID);
	 }
	 }
 public void newdemo() throws SQLException {
	 window = new demo_window(cid,this);
 }
 public boolean findRepeatOrder(String Cid,int Pid,String Nb) throws SQLException {
	 boolean flag=false;
	 String cpinfo=this.prebuy_b.findGoodPCom(Cid,Pid,Nb);
	 for(String info:Arrl) {
		 if(cpinfo.equals(info)) {
			 flag=true;
			 return flag;
		 }
	 }
	 
	 return flag;
 }
 
 
 
 
}