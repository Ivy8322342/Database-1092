import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Point;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.util.ArrayList;
//ArrayList load Goodpanels
//panelUpper
//panelLower
//nextPage()
//BackPage()
//int page=>page 1 get arrayList(0),(1);page 2 get arrayList(2),(3) that is get arraylist(page-1 to page+2)
//max page if 0 =>page1;else  arrsize/2+1
//show all goods at beginning if Arraylist.size() <=2,


public class ReserveFrame {
    
	ArrayList<JPanel> GoodArray=new ArrayList<JPanel>();
	JFrame reserveframe;
	JFrame diaframe;
	JPanel No;
	JFrame QRframe;
	 dialogFram dwindow;
	
	
	public void add() {
	GoodArray.add(new GoodP().getGoodP());
	}
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReserveFrame window = new ReserveFrame();
					window.reserveframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReserveFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		reserveframe = new JFrame();
		reserveframe.setBounds(100, 100, 450, 550);
		reserveframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reserveframe.getContentPane().setLayout(null);
	
		
		JPanel NavPanel = new JPanel();
		NavPanel.setBackground(new Color(0, 0, 153));
		NavPanel.setBounds(0, 0, 436, 54);
		reserveframe.getContentPane().add(NavPanel);
		
		//add pageLabel
		JLabel pageLabel=new JLabel("\u9810\u7D04\u53D6\u8CA8\u6E05\u55AE");
		pageLabel.setBounds(158,10,106,35);
		pageLabel.setForeground(new Color(255,255,255));
		NavPanel.add(pageLabel);
		pageLabel.setBackground(new Color(255,255,255));
		pageLabel.setFont(new Font("微軟正黑體",Font.BOLD,26));
		
		
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(255, 255, 255));
		MainPanel.setBounds(0, 52, 436, 461);
		reserveframe.getContentPane().add(MainPanel);
		MainPanel.setLayout(null);
		
		JPanel FooterPanel = new JPanel();
		FooterPanel.setBounds(0, 380, 436, 81);
		FooterPanel.setBackground(new Color(224, 255, 255));
		MainPanel.add(FooterPanel);
		FooterPanel.setLayout(null);
		
		JLabel TimeLabel=new JLabel("");
		TimeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReserveFrame rwindow = new ReserveFrame();
				rwindow.reserveframe.setVisible(true);
				reserveframe.setVisible(false);
				
			}
			
		});
		
		TimeLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/time.png")));
		TimeLabel.setBounds(33, 10, 68, 61);
		FooterPanel.add(TimeLabel);
		
		JLabel SearchLabel = new JLabel("New label");
		SearchLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchFrame swindow=new SearchFrame();
				swindow.searchframe.setVisible(true);
				reserveframe.setVisible(false);
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
				reserveframe.setVisible(false);
				
			}
			
		});
		AccountLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/account2.png")));
		AccountLabel.setBounds(336, 10, 68, 61);
		FooterPanel.add(AccountLabel);
		
		JLabel BagLabel = new JLabel("New label");
		BagLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PackageFrame pwindow=new PackageFrame();
				pwindow.packageframe.setVisible(true);
				reserveframe.setVisible(false);
			}
		});
		BagLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/bag1.png")));
		BagLabel.setBounds(132, 10, 68, 61);
		FooterPanel.add(BagLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 436, 376);
		MainPanel.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(229, 336, 106, 28);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(0, 0, 0));
		panel_2_1.setBounds(84, 336, 106, 28);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		
		
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setAutoscrolls(true);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 1, 414, 325);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		//add to Spanel
		JPanel eee=addUpperGood();
		panel_3.add(eee);
		JPanel LLL=addLowerGood();
		panel_3.add(LLL);

		
	
	}
	
	public  JPanel addUpperGood() {
//		JPanel jp=new JPanel();
		JPanel upperPanel = new JPanel();
//		panel_1.setBackground(new Color(255, 255, 204));
		upperPanel.setBackground(new Color(255, 255, 204));
		upperPanel.setBounds(10, 10, 394, 143);
		
		upperPanel.setLayout(null);
		
		JLabel IconLabel = new JLabel("New label");
		IconLabel.setIcon(new ImageIcon(ReserveFrame.class.getResource("/img/bag1.png")));
		IconLabel.setBounds(10, 10, 146, 123);
		upperPanel.add(IconLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\u54C1\u540D: ");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(166, 25, 46, 15);
		upperPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u9580\u5E02:");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_3.setBounds(166, 49, 82, 15);
		upperPanel.add(lblNewLabel_3);
		
		JLabel GoodsLabel = new JLabel("\u4E2D\u71B1\u7F8E\u5F0F");
		GoodsLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		GoodsLabel.setBounds(258, 25, 95, 15);
		upperPanel.add(GoodsLabel);
		
		JLabel Storelabel = new JLabel("\u653F\u5927");
		Storelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Storelabel.setBounds(258, 49, 95, 15);
		upperPanel.add(Storelabel);
		
		JLabel lblNewLabel_3_2 = new JLabel("\u5269\u9918\u6642\u9593:");
		lblNewLabel_3_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(166, 77, 82, 15);
		upperPanel.add(lblNewLabel_3_2);
		
		JLabel TimeLeftLabel = new JLabel("600");
		TimeLeftLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		TimeLeftLabel.setBounds(258, 77, 95, 15);
		upperPanel.add(TimeLeftLabel);
		//Timer start!
		Timer timer=new Timer();
		BackOff off=new BackOff();
        TimerTask  task = new TimerTask (){
         public void run() {
        	 off.sety();
        	 if(off.gety()>0) {
        			
        	      TimeLeftLabel.setText(""+off.gety()+" s");
        		 }else {
        		 timer.cancel();}
           }
        };
		timer.schedule(task,1000L,1000L);

		QRcode QRwindow1 = new QRcode();
		
		
		
		
		JPanel ShowQR = new JPanel();
		ShowQR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				QRwindow1.QRframe.setVisible(true);
//				reserveframe.setVisible(false);
			}
		});
		ShowQR.setBackground(new Color(204, 255, 255));
		ShowQR.setBounds(144, 106, 89, 27);
		upperPanel.add(ShowQR);
		ShowQR.setLayout(null);

		JLabel lblNewLabel = new JLabel("QR Code");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 6, 69, 15);
		ShowQR.add(lblNewLabel);
		
		JPanel CancleReserve = new JPanel();
		CancleReserve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				initialize1();
			}
		});
		CancleReserve.setBackground(new Color(255, 153, 255));
		CancleReserve.setBounds(251, 106, 89, 27);
		upperPanel.add(CancleReserve);
		CancleReserve.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\u53D6\u6D88\u9810\u7D04");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_4.setBounds(11, 6, 69, 15);
		CancleReserve.add(lblNewLabel_4);
		
		return upperPanel;
	}
	public  JPanel addLowerGood() {
//		JPanel jp=new JPanel();
		JPanel LowerPanel = new JPanel();
//		panel_1.setBackground(new Color(255, 255, 204));
		LowerPanel.setBackground(new Color(255, 255, 204));
		LowerPanel.setBounds(10, 172, 394, 143);
		
		LowerPanel.setLayout(null);
		
		JLabel IconLabel = new JLabel("New label");
		IconLabel.setIcon(new ImageIcon(ReserveFrame.class.getResource("/img/bag1.png")));
		IconLabel.setBounds(10, 10, 146, 123);
		LowerPanel.add(IconLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\u54C1\u540D: ");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(166, 25, 46, 15);
		LowerPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u9580\u5E02:");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_3.setBounds(166, 49, 82, 15);
		LowerPanel.add(lblNewLabel_3);
		
		JLabel GoodsLabel = new JLabel("\u4E2D\u71B1\u7F8E\u5F0F");
		GoodsLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		GoodsLabel.setBounds(258, 25, 95, 15);
		LowerPanel.add(GoodsLabel);
		
		JLabel Storelabel = new JLabel("\u653F\u5927");
		Storelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Storelabel.setBounds(258, 49, 95, 15);
		LowerPanel.add(Storelabel);
		
		JLabel lblNewLabel_3_2 = new JLabel("\u5269\u9918\u6642\u9593:");
		lblNewLabel_3_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(166, 77, 82, 15);
		LowerPanel.add(lblNewLabel_3_2);
		
		JLabel TimeLeftLabel = new JLabel("600");
		TimeLeftLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		TimeLeftLabel.setBounds(258, 77, 95, 15);
		LowerPanel.add(TimeLeftLabel);
		Timer timer=new Timer();
		BackOff off=new BackOff();
        TimerTask  task = new TimerTask (){
         public void run() {
        	 off.sety();
        	 if(off.gety()>0) {
        			
        	      TimeLeftLabel.setText(""+off.gety()+" s");
        		 }else {
        		 timer.cancel();}
           }
        };
		timer.schedule(task,1000L,1000L);
		
		JPanel ShowQR = new JPanel();
		

		QRcode QRwindow2 = new QRcode();
		
		ShowQR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				QRwindow2.QRframe.setVisible(true);
//				reserveframe.setVisible(false);
			}
		});
		ShowQR.setBackground(new Color(204, 255, 255));
		ShowQR.setBounds(144, 106, 89, 27);
		LowerPanel.add(ShowQR);
		ShowQR.setLayout(null);

		JLabel lblNewLabel = new JLabel("QR Code");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 6, 69, 15);
		ShowQR.add(lblNewLabel);
		
		JPanel CancleReserve = new JPanel();
		CancleReserve.setBackground(new Color(255, 153, 255));
		CancleReserve.setBounds(251, 106, 89, 27);
		LowerPanel.add(CancleReserve);
		CancleReserve.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\u53D6\u6D88\u9810\u7D04");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_4.setBounds(11, 6, 69, 15);
		CancleReserve.add(lblNewLabel_4);
		
		return LowerPanel;
	}
	
//	 void initialize1() {
//			diaframe = new JFrame();
//			diaframe.setVisible(true);
//			diaframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//			diaframe.setBounds(100, 100, 450, 300);
////			diaframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//			diaframe.getContentPane().setLayout(null);
//			
//			JPanel panel = new JPanel();
//			panel.setBackground(Color.WHITE);
//			panel.setBounds(0, 0, 436, 263);
//			diaframe.getContentPane().add(panel);
//			panel.setLayout(null);
//			
//			JLabel Label = new JLabel("\u78BA\u5B9A\u8981\u53D6\u6D88\u9810\u7D04\u55CE?");
//			Label.setFont(new Font("微軟正黑體", Font.BOLD, 26));
//			Label.setBounds(99, 51, 230, 62);
//			panel.add(Label);
//			
//			JLabel Label_1 = new JLabel("\u73FE\u5728\u9084\u5728\u5012\u6578\u8A08\u6642\u5594!");
//			Label_1.setFont(new Font("微軟正黑體", Font.BOLD, 26));
//			Label_1.setBounds(99, 86, 281, 62);
//			panel.add(Label_1);
//			
//			JPanel Yes = new JPanel();
//			Yes.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					diaframe.dispose();
////					QR =new QRcode();
////					ReserveFrame reframe=new ReserveFrame();
////					reframe.reserveframe.setVisible(true);
////					QRwindow2.dispose();
//					
//				}
//			});
//			Yes.setForeground(new Color(0, 0, 0));
//			Yes.setBackground(new Color(255, 20, 147));
//			Yes.setBounds(74, 174, 126, 51);
//			panel.add(Yes);
//			Yes.setLayout(null);
//			
//			JLabel lblNewLabel = new JLabel("\u78BA\u5B9A");
//			lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
//			lblNewLabel.setBounds(34, 6, 80, 41);
//			Yes.add(lblNewLabel);
//			
//			 No = new JPanel();
//			No.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					diaframe.dispose();
//				}
//			});
//			No.setForeground(Color.BLACK);
//			No.setBackground(new Color(153, 255, 255));
//			No.setBounds(234, 174, 126, 51);
//			panel.add(No);
//			No.setLayout(null);
//			
//			JLabel lblNewLabel_1 = new JLabel("\u8FD4\u56DE");
//			lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
//			lblNewLabel_1.setBounds(36, 6, 80, 41);
//			No.add(lblNewLabel_1);
//		}
//		
	
	
}
