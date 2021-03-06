import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.UIManager;

public class Search {
 Prebuy prebuy;
 JFrame frame;
 Search_Back searchback;
 JComboBox areaComboBox = new JComboBox();
 JLabel quanLabel_1 = new JLabel("\u5546\u54C1\u5269\u9918\u6578\u91CF\uFF1A");
 JLabel quanLabel_2 = new JLabel("\u5546\u54C1\u5269\u9918\u6578\u91CF\uFF1A");
 JLabel quanLabel_2_1 = new JLabel("\u5546\u54C1\u5269\u9918\u6578\u91CF\uFF1A");
 JLabel numLabel_1 = new JLabel("_");
 JLabel branchLabel_1 = new JLabel("");
 JLabel numLabel_3 = new JLabel("_");
 JLabel branchLabel_2 = new JLabel("");
 JLabel branchLabel_3 = new JLabel("");
 JLabel numLabel_2 = new JLabel("_");
 JPanel searchPanel_2 = new JPanel();
 JLabel Wornlabel_1 = new JLabel("");
 JLabel Wornlabel_2 = new JLabel("");
 JLabel Wornlabel_3 = new JLabel("");
 JLabel PageLabel = new JLabel("\u9801\u6578");
 ArrayList<String>Aldis1=new ArrayList<String>();
 ArrayList<String>Aldis2=new ArrayList<String>();
 ArrayList<String>Aldis3=new ArrayList<String>();
 private int page;
 //因為是由商品出發，來選擇妳要去取貨的店家
 int Product_ID;
 String Cid;


 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Search window = new Search(1,"ivy20468");
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
 public Search(int Product_ID,String cid,Prebuy prebuy) throws SQLException {
	 this .Product_ID=Product_ID;
	 this.prebuy=prebuy;
	 this.Cid=cid;
  initialize();
 }

 /**
  * Initialize the contents of the frame.
 * @throws SQLException 
  */
 private void initialize() throws SQLException {
	 System.out.println("UpArrl size 在search ini="+prebuy.UpArrl.size());
//prebuy=new Prebuy(Cid);
prebuy.frame.setVisible(false);
  page = 1;
  searchback=new Search_Back();
  frame = new JFrame();
  
  ShowPName();
  frame.getContentPane().setBackground(new Color(250,245,172,88));
  frame.getContentPane().setLayout(null);
  
  JPanel topPanel = new JPanel();
  topPanel.setBounds(0, 0, 436, 50);
  topPanel.setBackground(new Color(153,107,31));
  topPanel.setForeground(Color.BLACK);
  frame.getContentPane().add(topPanel);
  topPanel.setLayout(null);
  
  JLabel searchLabel = new JLabel("\u67E5\u8A62");
  searchLabel.setBounds(184, 10, 161, 30);
  topPanel.add(searchLabel);
  searchLabel.setForeground(Color.WHITE);
  searchLabel.setFont(new Font("華康中特圓體(P)", Font.BOLD, 30));
  
//  JPanel bottomPanel = new JPanel();
//  bottomPanel.setForeground(Color.BLACK);
//  bottomPanel.setBackground(SystemColor.textHighlight);
//  bottomPanel.setBounds(0, 454, 436, 59);
//  frame.getContentPane().add(bottomPanel);
  
  JPanel searchPanel_3 = new JPanel();
  searchPanel_3.addMouseListener(new MouseAdapter() {
  	@Override
  	public void mouseClicked(MouseEvent e) {
  		if(branchLabel_3.getText().length()>=2&&!numLabel_3.getText().trim().equals("0")) {
  		try {
			if(prebuy.findRepeatOrder(Cid, Product_ID, branchLabel_3.getText())==false) {
				 System.out.println("UpArrl size searchP3 on click  ini="+prebuy.UpArrl.size());
			JFrame f=new JFrame();
			JDialog d=new JDialog(f,"即將預約取貨",true);
			d.setBounds(170, 222, 315, 200);
			 d.getContentPane().setLayout(null);  
			 JButton b = new JButton ("是的!!");  
			 b.setBounds(102,100, 85, 23);
			 b.addActionListener ( new ActionListener()  
			    {  
			        public void actionPerformed( ActionEvent e )  
			        {  
			            d.setVisible(false); 
			            //生城goodP的最小要素
			           System.out.println("goodp要素:"+Cid+","+Product_ID+","+branchLabel_3.getText());
			            
			            try {
							String info=prebuy.prebuy_b.findGoodPCom(Cid, Product_ID, branchLabel_3.getText());
							prebuy.Arrl.add(info);
							String[]s=info.split(",");
							String pN=s[0];
							int Q=Integer.parseInt(s[1]);
							String pic=s[2];
							String BN=s[3];
							if(prebuy.Arrl.size()==1) {
								JPanel upP=new GoodP(pN, BN, pic, Q,prebuy).getGoodP();
								prebuy.resF.Uppanel.add(upP);
								upP.setVisible(true);
							}else if(prebuy.Arrl.size()==2) {
								JPanel downP=new GoodP(pN, BN, pic, Q,prebuy).getGoodP();
								prebuy.resF.Downpanel.add(downP);
								downP.setVisible(true);
							}else {
								System.out.println("超過預約上限");
							}
						
							System.out.println("prebuy.Arrl size:"+prebuy.Arrl.size());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			            
			        }  
			    });  
			JLabel st= new JLabel ("要預約取貨嗎?");
			st.setBounds(80,46,269,46);
			 d.getContentPane().add(st);  
			    d.getContentPane().add(b);
			    b.setVisible(true);
//	        d.setSize(300,300);    
			    d.setVisible(true);  
			}else {
				Wornlabel_3.setText("重複預約");
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
				        public void run() {
				        	Wornlabel_3.setText("");
				        }
				}, 1000);
				
			}
		} catch (HeadlessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  		}
  	}
  });
  searchPanel_3.setBounds(36, 346, 365, 59);
  frame.getContentPane().add(searchPanel_3);
  searchPanel_3.setLayout(null);
  
  
  quanLabel_2_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  quanLabel_2_1.setBounds(21, 16, 168, 27);
  searchPanel_3.add(quanLabel_2_1);
  
//  JLabel numLabel_3 = new JLabel("3");
  numLabel_3.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  numLabel_3.setBounds(199, 16, 81, 26);
  searchPanel_3.add(numLabel_3);
  searchPanel_2.addMouseListener(new MouseAdapter() {
  	@Override
	public void mouseClicked(MouseEvent e) {
  		if(branchLabel_2.getText().length()>=2&&!numLabel_2.getText().trim().equals("0")) {
  		try {
			if(prebuy.findRepeatOrder(Cid, Product_ID, branchLabel_2.getText())==false) {
			JFrame f=new JFrame();
			JDialog d=new JDialog(f,"即將預約取貨",true);
			d.setBounds(170, 222, 315, 200);
			 d.getContentPane().setLayout(null);  
			 JButton b = new JButton ("是的!!");  
			 b.setBounds(102,100, 85, 23);
			 b.addActionListener ( new ActionListener()  
			    {  
			        public void actionPerformed( ActionEvent e )  
			        {  
			            d.setVisible(false); 
			            //生城goodP的最小要素
			           System.out.println("goodp要素:"+Cid+","+Product_ID+","+branchLabel_2.getText());
			            
			            try {
							String info=prebuy.prebuy_b.findGoodPCom(Cid, Product_ID, branchLabel_2.getText());
							prebuy.Arrl.add(info);
							String[]s=info.split(",");
							String pN=s[0];
							int Q=Integer.parseInt(s[1]);
							String pic=s[2];
							String BN=s[3];
							if(prebuy.Arrl.size()==1) {
								JPanel upP=new GoodP(pN, BN, pic, Q,prebuy).getGoodP();
								prebuy.resF.Uppanel.add(upP);
								upP.setVisible(true);
							}else if(prebuy.Arrl.size()==2) {
								JPanel downP=new GoodP(pN, BN, pic, Q,prebuy).getGoodP();
								prebuy.resF.Downpanel.add(downP);
								downP.setVisible(true);
							}else {
								System.out.println("超過預約上限");
							}
						
							System.out.println("prebuy.Arrl size:"+prebuy.Arrl.size());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			            
			        }  
			    });  
			JLabel st= new JLabel ("要預約取貨嗎?");
			st.setBounds(80,46,269,46);
			 d.getContentPane().add(st);  
			    d.getContentPane().add(b);
			    b.setVisible(true);
//	        d.setSize(300,300);    
			    d.setVisible(true);  
			}else {
				Wornlabel_2.setText("重複預約");
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
				        public void run() {
				        	Wornlabel_2.setText("");
				        }
				}, 1000);
				
			}
		} catch (HeadlessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  		}
  	}
  });
  
//  JPanel searchPanel_2 = new JPanel();
  searchPanel_2.setBounds(36, 247, 365, 59);
  frame.getContentPane().add(searchPanel_2);
  searchPanel_2.setLayout(null);
  
  
  quanLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  quanLabel_2.setBounds(21, 16, 168, 27);
  searchPanel_2.add(quanLabel_2);
  
//  JLabel numLabel_2 = new JLabel("3");
  numLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  numLabel_2.setBounds(199, 16, 66, 26);
  searchPanel_2.add(numLabel_2);
  
  
  String CityArray[]= {"請選擇","台北市","新北市","宜蘭縣","桃園市","新竹市","基隆市"};
  JComboBox cityComboBox = new JComboBox(CityArray);
  cityComboBox.setBounds(92, 60, 120, 42);
  cityComboBox.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  cityComboBox.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		  String CityString=(String)cityComboBox.getSelectedItem();
		  clearBQLabel();
			 try {System.out.println(CityString);
			 if(!CityString.equalsIgnoreCase("請選擇")) {
				setZoneCB(searchback.findZone(CityString));
			 }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  
	  }
  });
  frame.getContentPane().add(cityComboBox);
  
  JLabel cityLabel = new JLabel("\u7E23\u5E02\uFF1A");
  cityLabel.setBounds(24, 68, 72, 26);
  cityLabel.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 22));
  frame.getContentPane().add(cityLabel);
  
  JLabel areaLabel = new JLabel("\u5730\u5340\uFF1A");
  areaLabel.setBounds(228, 69, 72, 26);
  areaLabel.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 22));
  frame.getContentPane().add(areaLabel);
  
  
  
  
  areaComboBox.setBounds(293, 60, 120, 42);
  areaComboBox.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  areaComboBox.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		  page=1;
		  String area=(String)areaComboBox.getSelectedItem();
		  clearALs();
		  clearBQLabel();
		  LabelDistribute(area);
		  PageLabel.setText("p "+page+"");
		 
	  }
  });
  frame.getContentPane().add(areaComboBox);
  
  JPanel searchPanel_1 = new JPanel();
  searchPanel_1.addMouseListener(new MouseAdapter() {
  	@Override
  	public void mouseClicked(MouseEvent e) {
  		 System.out.println("UpArrl size searchP1 on click  ini="+prebuy.UpArrl.size());
		
  		if(branchLabel_1.getText().length()>=2&&!numLabel_1.getText().trim().equals("0")) {
  		try {
			if(prebuy.findRepeatOrder(Cid, Product_ID, branchLabel_1.getText())==false) {
			JFrame f=new JFrame();
			JDialog d=new JDialog(f,"即將預約取貨",true);
			d.setBounds(170, 222, 315, 200);
			 d.getContentPane().setLayout(null);  
			 JButton b = new JButton ("是的!!");  
			 b.setBounds(102,100, 85, 23);
			 b.addActionListener ( new ActionListener()  
			    {  
			        public void actionPerformed( ActionEvent e )  
			        {  
			            d.setVisible(false); 
			            //生城goodP的最小要素
			           System.out.println("goodp要素:"+Cid+","+Product_ID+","+branchLabel_1.getText());
			            
			            try {
							String info=prebuy.prebuy_b.findGoodPCom(Cid, Product_ID, branchLabel_1.getText());
							prebuy.Arrl.add(info);
							String[]s=info.split(",");
							String pN=s[0];
							int Q=Integer.parseInt(s[1]);
							String pic=s[2];
							String BN=s[3];
							if(prebuy.Arrl.size()==1) {
								JPanel upP=new GoodP(pN, BN, pic, Q,prebuy).getGoodP();
								prebuy.resF.Uppanel.add(upP);
								upP.setVisible(true);
							}else if(prebuy.Arrl.size()==2) {
								JPanel downP=new GoodP(pN, BN, pic, Q,prebuy).getGoodP();
								prebuy.resF.Downpanel.add(downP);
								downP.setVisible(true);
							}else {
								System.out.println("超過預約上限");
							}
						
							System.out.println("prebuy.Arrl size:"+prebuy.Arrl.size());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			            
			        }  
			    });  
			JLabel st= new JLabel ("要預約取貨嗎?");
			st.setBounds(80,46,269,46);
			 d.getContentPane().add(st);  
			    d.getContentPane().add(b);
			    b.setVisible(true);
//	        d.setSize(300,300);    
			    d.setVisible(true);  
			}else {
				Wornlabel_1.setText("重複預約");
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
				        public void run() {
				        	Wornlabel_1.setText("");
				        }
				}, 1000);
				
			}
		} catch (HeadlessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  		}
  	}
  });
  searchPanel_1.setBounds(36, 142, 365, 59);
  frame.getContentPane().add(searchPanel_1);
  searchPanel_1.setLayout(null);
  
 
  quanLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  quanLabel_1.setBounds(21, 16, 168, 27);
  searchPanel_1.add(quanLabel_1);
  
 // 
  numLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 24));
  numLabel_1.setBounds(199, 16, 69, 26);
  searchPanel_1.add(numLabel_1);
  
  
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
			prebuy.resF.reserveframe.setVisible(true);
			 frame.setVisible(false);
			
		}
		
	});
	
	TimeLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/time.png")));
	TimeLabel.setBounds(33, 10, 68, 61);
	FooterPanel.add(TimeLabel);
	
	JLabel SearchLabel = new JLabel("New label");
	SearchLabel.setBackground(UIManager.getColor("Button.focus"));
	SearchLabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
//			Search swindow=new Search();
//			swindow.frame.setVisible(true);
//			 frame.setVisible(false);
		}
	});
	SearchLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/Atsearch.png")));
	SearchLabel.setBounds(234, 10, 68, 61);
	FooterPanel.add(SearchLabel);
	
	JLabel AccountLabel = new JLabel("New label");
	AccountLabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			demo_window window;
			try {
				window = new demo_window(Cid,prebuy);
				window.Accountframe.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 frame.setVisible(false);
			
		}
		
	});
	AccountLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/account2.png")));
	AccountLabel.setBounds(336, 10, 68, 61);
	FooterPanel.add(AccountLabel);
	
	JLabel BagLabel = new JLabel("New label");
	BagLabel.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			prebuy.frame.setVisible(true);
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
		 ShowlastP();
		 System.out.println("第"+page+"頁");
	 }
	});
	lastButton.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 20));
	
	JButton nextButton = new JButton("\u4E0B\u4E00\u9801");
	nextButton.setBounds(251, 405, 98, 25);
	frame.getContentPane().add(nextButton);
	nextButton.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 20));
	
	JPanel panel = new JPanel();
	panel.setForeground(Color.WHITE);
	panel.setBorder(null);
	panel.setBackground(new Color(250,245,172));
	panel.setBounds(0, 99, 436, 42);
	frame.getContentPane().add(panel);
	panel.setLayout(null);
	branchLabel_1.setBounds(36, 0, 142, 40);
	panel.add(branchLabel_1);
	branchLabel_1.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 20));
	
	
	Wornlabel_1.setForeground(new Color(255, 0, 0));
	Wornlabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	Wornlabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
	Wornlabel_1.setBounds(164, 10, 262, 30);
	panel.add(Wornlabel_1);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBorder(null);
	panel_1.setBackground(new Color(250,245,172));
	panel_1.setBounds(0, 205, 436, 42);
	frame.getContentPane().add(panel_1);
	panel_1.setLayout(null);
	branchLabel_2.setBounds(32, 0, 127, 36);
	panel_1.add(branchLabel_2);
	branchLabel_2.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 20));
	
	
	Wornlabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	Wornlabel_2.setForeground(Color.RED);
	Wornlabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
	Wornlabel_2.setBounds(164, 6, 262, 30);
	panel_1.add(Wornlabel_2);
	
	JPanel panel_2 = new JPanel();
	panel_2.setBackground(new Color(250,245,172));
	panel_2.setBounds(0, 304, 436, 42);
	frame.getContentPane().add(panel_2);
	panel_2.setLayout(null);
	branchLabel_3.setBounds(33, 0, 145, 42);
	panel_2.add(branchLabel_3);
	branchLabel_3.setFont(new Font("華康中特圓體(P)", Font.PLAIN, 20));
	
	
	Wornlabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	Wornlabel_3.setForeground(Color.RED);
	Wornlabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
	Wornlabel_3.setBounds(174, 12, 262, 30);
	panel_2.add(Wornlabel_3);
	
	JPanel panel_3 = new JPanel();
	panel_3.setBounds(188, 405, 61, 25);
	frame.getContentPane().add(panel_3);
	panel_3.setLayout(null);
	
	
	PageLabel.setHorizontalAlignment(SwingConstants.CENTER);
	PageLabel.setBounds(0, 0, 61, 25);
	panel_3.add(PageLabel);
	
	nextButton.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
		 ShownextP();
	
	  System.out.println("第"+page+"頁");
	 }
	});

	GridBagConstraints gc;
	JLabel label = new JLabel("Label 2");
	label.setIcon(new ImageIcon(Search.class.getResource("/img/我.jpg")));
	label.setLocation(86, -232);
	label.setBackground(Color.CYAN);
	label.setSize(326, 274);
	label.setForeground(Color.BLACK);}
	

 
 public void setZoneCB(ArrayList<String>arrL){
	 arrL.add(0,"區域");
	 Object[] arr= arrL.toArray();
	  areaComboBox.setModel(new DefaultComboBoxModel(arr));
	  areaComboBox.setSelectedItem(0);
 }
 //把每個分店分配給3個Labels，然後呈現第一頁
 public void LabelDistribute(String area) {
	 try { ArrayList<String> info=searchback.findBQ(area,Product_ID);
	 System.out.println(info.size());
	if (info.size()>0){ for(int i=0;i<info.size();i++) {
		 switch ((i+1)%3) {
		 case 1:Aldis1.add(info.get(i));
			 break;
		 case 2:Aldis2.add(info.get(i));
			 break;
		 case 0:Aldis3.add(info.get(i));
			 break;
		 }
	 }
	 if(Aldis3.size()>0){
	 setLabels(Aldis1.get(0),branchLabel_1,numLabel_1);
	 setLabels(Aldis2.get(0),branchLabel_2,numLabel_2);
	 setLabels(Aldis3.get(0),branchLabel_3,numLabel_3);
	 }else if(Aldis2.size()>0) {
		 setLabels(Aldis1.get(0),branchLabel_1,numLabel_1);
		 setLabels(Aldis2.get(0),branchLabel_2,numLabel_2);
	 }else if(Aldis1.size()>0) {
		 setLabels(Aldis1.get(0),branchLabel_1,numLabel_1);
	 }
	}
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
 
 public void clearALs() {
	 Aldis1.clear();
	 Aldis2.clear();
	 Aldis3.clear();
	 
	 System.out.println("Clear the ArrayLists!!");
 }
 public void clearBQLabel() {
	 numLabel_1.setText("");
	 numLabel_2.setText("");
	 numLabel_3.setText("");
	 branchLabel_1.setText("");
	 branchLabel_2.setText("");
	 branchLabel_3.setText("");
	 
	 System.out.println("Clear Branch and Quantity_Left Labels!1");
 }
 public void setLabels(String info,JLabel bLabel,JLabel nLabel) {
	String[] s=info.split(";");
	bLabel.setText(s[0]);
	nLabel.setText(s[1]);
 }
 public void ShownextP() {
	
	 if(Aldis1.size()>page&&Aldis2.size()>page&&Aldis3.size()>page) {
		 clearBQLabel();
		 page++;
		 setLabels(Aldis1.get(page-1),branchLabel_1,numLabel_1);
		 setLabels(Aldis2.get(page-1),branchLabel_2,numLabel_2);
		 setLabels(Aldis3.get(page-1),branchLabel_3,numLabel_3);
		 PageLabel.setText("p "+page+"");
	 }else if(Aldis1.size()>page&&Aldis2.size()>page) {
		 clearBQLabel();
		 page++;
		 setLabels(Aldis1.get(page-1),branchLabel_1,numLabel_1);
		 setLabels(Aldis2.get(page-1),branchLabel_2,numLabel_2);
		 PageLabel.setText("p "+page+"");
	 }else if(Aldis1.size()>page) {
		 clearBQLabel();
		 page++;
		 setLabels(Aldis1.get(page-1),branchLabel_1,numLabel_1);
		 PageLabel.setText("p "+page+"");
	 }else {
		 System.out.println("這是最後一頁");
	 }
 }
 public void ShowlastP() {
	
	 if(page-1<=0) {
		 System.out.println("first page!!");
	 }else { clearBQLabel();
		 page--;
		 setLabels(Aldis1.get(page-1),branchLabel_1,numLabel_1);
		 setLabels(Aldis2.get(page-1),branchLabel_2,numLabel_2);
		 setLabels(Aldis3.get(page-1),branchLabel_3,numLabel_3);
		 PageLabel.setText("p "+page+"");
	 }
 }
 public void ShowPName() throws SQLException{
	String pname= searchback.ProductName(Product_ID);
//	quanLabel_1.setText(pname+"剩餘數量:");
//	quanLabel_2.setText(pname+"剩餘數量:");
//	quanLabel_2_1.setText(pname+"剩餘數量:");
	frame.setTitle(pname);
 }
 
 
 }
