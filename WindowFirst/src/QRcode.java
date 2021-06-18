import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

public class QRcode {
	int Quantity;
	String QRcode;
	JFrame QRframe;
	String StoreName;
	
	/**
	 * @wbp.nonvisual location=509,365
	 */
	private final JPanel BackPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QRcode window = new QRcode("政興",11,"義美全糖豆漿.png");
					window.QRframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QRcode(String StoreName,int Quantity,String QRcode) {
		this.StoreName=StoreName;
		this.Quantity=Quantity;
		this.QRcode=QRcode;
		
		initialize();
	}
	//dia
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BackPanel.setLayout(null);
		BackPanel.setBorder(UIManager.getBorder("RadioButton.border"));
		BackPanel.setBackground(Color.CYAN);
		
		JLabel BackLabel = new JLabel("返回清單");
		BackLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		BackLabel.setBounds(15, 13, 75, 15);
		BackPanel.add(BackLabel);
		QRframe = new JFrame();
		QRframe.setBounds(100, 100, 450, 550);
		QRframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		QRframe.getContentPane().setLayout(null);
		
		JPanel NavPanel = new JPanel();
		NavPanel.setBackground(new Color(153,107,31));
		NavPanel.setBounds(0, 0, 436, 54);
		QRframe.getContentPane().add(NavPanel);
		
		JLabel pageLabel = new JLabel("掃碼取貨");
		pageLabel.setForeground(Color.WHITE);
		pageLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		pageLabel.setBackground(Color.WHITE);
		NavPanel.add(pageLabel);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(255, 255, 255));
		MainPanel.setBounds(0, 52, 436, 461);
		QRframe.getContentPane().add(MainPanel);
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
				ReserveFrame reframe=new ReserveFrame();
				reframe.reserveframe.setVisible(true);
				QRframe.setVisible(false);
				
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
				QRframe.setVisible(false);
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
				QRframe.setVisible(false);
				
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
				QRframe.setVisible(false);
			}
		});
		BagLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/bag1.png")));
		BagLabel.setBounds(132, 10, 68, 61);
		FooterPanel.add(BagLabel);
		
		JPanel ShowPanel = new JPanel();
		ShowPanel.setBounds(62, 22, 300, 265);
		ShowPanel.setBackground(new Color(255, 235, 205));
		MainPanel.add(ShowPanel);
		ShowPanel.setLayout(null);
		
		JLabel QRLabel = new JLabel("");
		QRLabel.setIcon(new ImageIcon(QRcode.class.getResource("/img/"+QRcode)));
		QRLabel.setBounds(75, 10, 167, 148);
		ShowPanel.add(QRLabel);
		
		JLabel R_CodeLabel = new JLabel(""+StoreName);
		R_CodeLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		R_CodeLabel.setBounds(167, 214, 75, 15);
		ShowPanel.add(R_CodeLabel);
		
		
		
		
		JLabel R_BackOffLabel = new JLabel("600");
		R_BackOffLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		R_BackOffLabel.setBounds(167, 243, 65, 15);
		ShowPanel.add(R_BackOffLabel);
		//Timer start!
				Timer timer=new Timer();
				BackOff off=new BackOff();
		        TimerTask  task = new TimerTask (){
		         public void run() {
		        	 off.sety();
		        	 if(off.gety()>0) {
		        			
		        	      R_BackOffLabel.setText(""+off.gety()+" s");
		        		 }else {
		        		 timer.cancel();}
		           }
		        };
				timer.schedule(task,1000L,1000L);
		
		
		//RandomCode generator
		RandomCode coder=new RandomCode();
		JLabel R_BranchLabel = new JLabel(coder.randomNum(8));
		R_BranchLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		R_BranchLabel.setBounds(167, 183, 85, 15);
		ShowPanel.add(R_BranchLabel);
		
		JLabel L_BranckhLabel = new JLabel("取貨代碼:");
		L_BranckhLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		L_BranckhLabel.setBounds(64, 183, 75, 15);
		ShowPanel.add(L_BranckhLabel);
		
		JLabel L_CodeLabel = new JLabel("門市:");
		L_CodeLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		L_CodeLabel.setBounds(75, 214, 65, 15);
		ShowPanel.add(L_CodeLabel);
		
		JLabel L_BackOffLabel = new JLabel("剩餘時間:");
		L_BackOffLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		L_BackOffLabel.setBounds(64, 243, 75, 15);
		ShowPanel.add(L_BackOffLabel);
		
		JPanel CanclePanel = new JPanel();
		CanclePanel.setBounds(154, 329, 101, 41);
		//Add actionListener
		CanclePanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//show optional dialoge
				QRframe.setVisible(false);
			
			}
		});
		CanclePanel.setBorder(UIManager.getBorder("RadioButton.border"));
		CanclePanel.setBackground(new Color(153, 107, 31));
		MainPanel.add(CanclePanel);
		CanclePanel.setLayout(null);
		
		JLabel CancleLabel = new JLabel("返回");
		CancleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		CancleLabel.setForeground(Color.WHITE);
		CancleLabel.setBounds(28, 13, 75, 15);
		CanclePanel.add(CancleLabel);
		
		JLabel lblNewLabel = new JLabel("剩餘數量:");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel.setBounds(129, 296, 80, 23);
		MainPanel.add(lblNewLabel);
		
		JLabel Quantity_Label = new JLabel("");
		Quantity_Label.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		Quantity_Label.setBounds(241, 297, 58, 23);
		Quantity_Label.setText(""+Quantity);
		MainPanel.add(Quantity_Label);
		
		FooterPanel.setVisible(false);
		
		
		
		
	}
}
