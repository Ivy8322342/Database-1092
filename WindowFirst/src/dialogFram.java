import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dialogFram {

	JFrame diaframe;
	JPanel No;
	QRcode QR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialogFram window = new dialogFram();
					window.diaframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public dialogFram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		diaframe = new JFrame();
		diaframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		diaframe.setBounds(100, 100, 450, 300);
//		diaframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
//				QR =new QRcode();
//				QR.QRframe.dispose();
				
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
}
