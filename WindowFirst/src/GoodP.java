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

public class GoodP extends JPanel {

	JPanel Good;
	Timer timer;
	QRcode QRobj;
	String Pic;
	String StoreName;
	String QRcode;//因為QRcode 跟商品ID 一樣
	String GoodName;
	JFrame diaframe;
	JPanel No;
	int Quantity;
	 dialogFram dwindow;
	 
	 public GoodP(String GoodName,String StoreName,String Pic,String QRcode,int Quantity){
		 this.Pic=Pic;
		this.QRcode=QRcode;
		this.GoodName=GoodName;
		this.StoreName=StoreName;
		this.Quantity=Quantity;

	 }
	 //完成取貨
	public void finish() {
		
	}
	//加入的是第 th 個，因此在加入前ArrayList的長度是 th-1
	
	

	
	
	public JPanel getGoodP() {
		
		Good=new JPanel(); 
		Good.setBackground(new Color(255, 255, 204));
		
//		if(th%2==1) {
	Good.setBounds(14, 10, 394, 143);
//		else {
//			Good.setBounds(14, 172, 394, 143);
//		}
		
		Good.setLayout(null);
		
		JLabel IconLabel = new JLabel("");
		IconLabel.setIcon(new ImageIcon(ReserveFrame.class.getResource("img/"+Pic)));
		IconLabel.setBounds(10, 10, 134, 123);
		Good.add(IconLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\u54C1\u540D: ");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(166, 25, 46, 15);
		Good.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u9580\u5E02:");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_3.setBounds(166, 49, 82, 15);
		Good.add(lblNewLabel_3);
		
		JLabel GoodsLabel = new JLabel(""+GoodName);
		GoodsLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		GoodsLabel.setBounds(258, 25, 126, 15);
		Good.add(GoodsLabel);
		
		JLabel Storelabel = new JLabel(""+StoreName);
		Storelabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Storelabel.setBounds(258, 49, 126, 15);
		Good.add(Storelabel);
		
		JLabel lblNewLabel_3_2 = new JLabel("\u5269\u9918\u6642\u9593:");
		lblNewLabel_3_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_3_2.setBounds(166, 77, 82, 15);
		Good.add(lblNewLabel_3_2);
		
		JLabel TimeLeftLabel = new JLabel("600");
		TimeLeftLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		TimeLeftLabel.setBounds(258, 77, 95, 15);
		Good.add(TimeLeftLabel);
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

		 QRobj = new QRcode(StoreName,Quantity,QRcode);
		
		
		
		
		JPanel ShowQR = new JPanel();
		ShowQR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				QRobj.QRframe.setVisible(true);
//				reserveframe.setVisible(false);
			}
		});
		ShowQR.setBackground(new Color(204, 255, 255));
		ShowQR.setBounds(144, 106, 89, 27);
		Good.add(ShowQR);
		ShowQR.setLayout(null);

		JLabel lblNewLabel = new JLabel("QR Code");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 6, 69, 15);
		ShowQR.add(lblNewLabel);
		
		JPanel CancleReserve = new JPanel();
		CancleReserve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				initialize1();
			}
		});
		CancleReserve.setBackground(new Color(255, 153, 255));
		CancleReserve.setBounds(251, 106, 89, 27);
		Good.add(CancleReserve);
		CancleReserve.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\u53D6\u6D88\u9810\u7D04");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_4.setBounds(11, 6, 69, 15);
		CancleReserve.add(lblNewLabel_4);
		
		
		
		return Good;
		
	}
	 void initialize1() {
			diaframe = new JFrame();
			diaframe.setVisible(true);
			diaframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			diaframe.setBounds(100, 100, 450, 300);
//			diaframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			diaframe.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 436, 263);
			diaframe.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel Label = new JLabel("\u78BA\u5B9A\u8981\u53D6\u6D88\u9810\u7D04\u55CE?");
			Label.setFont(new Font("微軟正黑體", Font.BOLD, 26));
			Label.setBounds(99, 51, 230, 62);
			panel.add(Label);
			
			JLabel Label_1 = new JLabel("\u73FE\u5728\u9084\u5728\u5012\u6578\u8A08\u6642\u5594!");
			Label_1.setFont(new Font("微軟正黑體", Font.BOLD, 26));
			Label_1.setBounds(99, 86, 281, 62);
			panel.add(Label_1);
			
			JPanel Yes = new JPanel();
			Yes.addMouseListener(new MouseAdapter() {
				@Override
				
				public void mouseClicked(MouseEvent e) {
					diaframe.dispose();
					Good.setVisible(false);
				
				
					
				}
			});
			Yes.setForeground(new Color(0, 0, 0));
			Yes.setBackground(new Color(255, 20, 147));
			Yes.setBounds(74, 174, 126, 51);
			panel.add(Yes);
			Yes.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("\u78BA\u5B9A");
			lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
			lblNewLabel.setBounds(34, 6, 80, 41);
			Yes.add(lblNewLabel);
			
			 No = new JPanel();
			No.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					diaframe.dispose();
				}
			});
			No.setForeground(Color.BLACK);
			No.setBackground(new Color(153, 255, 255));
			No.setBounds(234, 174, 126, 51);
			panel.add(No);
			No.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("\u8FD4\u56DE");
			lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
			lblNewLabel_1.setBounds(36, 6, 80, 41);
			No.add(lblNewLabel_1);
		}
		
	public void disposeP(){
		this.Good.setVisible(false);
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoodP gg=new GoodP("豆漿","政大","鮪魚飯糰.jpg","11111",8);
		JPanel p=gg.getGoodP();
		gg.setBounds(14, 10, 394, 143);
JFrame j=new JFrame();

j.setVisible(true);
j.getContentPane().setLayout(null);
j.getContentPane().add(p);

	}

}
