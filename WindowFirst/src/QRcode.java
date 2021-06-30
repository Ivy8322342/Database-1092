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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class QRcode {
	int Quantity;
	String QRcode;
	JFrame QRframe;
	String StoreName;
	GoodP goodp;
	
	/**
	 * @wbp.nonvisual location=509,365
	 */
	private final JPanel BackPanel = new JPanel();
	private JTextField TaketextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QRcode window = new QRcode("政興",11,"義美全糖豆漿.png,new GoodP()");
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
	public QRcode(String StoreName,int Quantity,String QRcode,GoodP goodp) {
		this.StoreName=StoreName;
		this.Quantity=Quantity;
		this.QRcode=QRcode;
		this.goodp=goodp;
		
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
		
		JPanel ShowPanel = new JPanel();
		ShowPanel.setBounds(62, 22, 300, 265);
		ShowPanel.setBackground(new Color(255, 235, 205));
		MainPanel.add(ShowPanel);
		ShowPanel.setLayout(null);
		
		JLabel QRLabel = new JLabel("");
		QRLabel.setIcon(new ImageIcon(QRcode.class.getResource("/img/"+"義美全糖豆漿.png")));
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
		        	 if(off.gety()>=0) {
		        			
		        	      R_BackOffLabel.setText(""+off.gety()+" s");
		        		 }else {
		        		 timer.cancel();
		        		 QRframe.dispose();
		        		 goodp.disposeP();}
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
		lblNewLabel.setBounds(129, 296, 80, 23);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		MainPanel.add(lblNewLabel);
		
		JLabel Quantity_Label = new JLabel("");
		Quantity_Label.setBounds(241, 297, 58, 23);
		Quantity_Label.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		Quantity_Label.setText(""+Quantity);
		MainPanel.add(Quantity_Label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 82, 45));
		panel.setBounds(0, 396, 436, 65);
		MainPanel.add(panel);
		panel.setLayout(null);
		
		JButton finishButton = new JButton("完成取貨");
		finishButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		finishButton.setBounds(316, 10, 110, 45);
		panel.add(finishButton);
		
		TaketextField = new JTextField();
		TaketextField.setBounds(177, 10, 117, 45);
		panel.add(TaketextField);
		TaketextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(165, 42, 42));
		panel_1.setForeground(new Color(240, 248, 255));
		panel_1.setBounds(10, 10, 158, 45);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("輸入取貨數量:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 0, 148, 45);
		panel_1.add(lblNewLabel_1);
		
		
		
		
	}
}
