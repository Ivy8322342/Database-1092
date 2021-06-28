import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class demo_window {

	JFrame Accountframe;
	private JTextField account;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo_window window = new demo_window();
					window.Accountframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public demo_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//border round
		 AbstractBorder brdrLeft = new TextBubbleBorder(Color.BLACK,2,16,0);
		
		Accountframe = new JFrame();
		Accountframe.setBounds(100, 100, 450, 550);
		Accountframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Accountframe.getContentPane().setLayout(null);
		
		JPanel NavPanel = new JPanel();
		NavPanel.setBackground(new Color(153,107 ,31));
		NavPanel.setBounds(0, 0, 436, 54);
		Accountframe.getContentPane().add(NavPanel);
		NavPanel.setLayout(null);
		
		JLabel pageLabel = new JLabel("\u6703\u54E1\u5C08\u5340");
		pageLabel.setBounds(158, 10, 106, 35);
		pageLabel.setForeground(new Color(255, 255, 255));
		NavPanel.add(pageLabel);
		pageLabel.setBackground(new Color(153, 107, 31));
		pageLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(250, 245,172,98));
		MainPanel.setBounds(0, 52, 436, 461);
		Accountframe.getContentPane().add(MainPanel);
		MainPanel.setLayout(null);
		
		JLabel UserImg = new JLabel("New label");
		UserImg.setIcon(new ImageIcon(demo_window.class.getResource("/img/Leo.png")));
		UserImg.setBounds(160, 22, 99, 100);
		MainPanel.add(UserImg);
		
		JPanel FooterPanel = new JPanel();
		FooterPanel.setBackground(new Color(153,107 ,31));
		FooterPanel.setBounds(0, 380, 436, 81);
		MainPanel.add(FooterPanel);
		FooterPanel.setLayout(null);
		
		JLabel TimeLabel = new JLabel("New label");
		TimeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//show QRcode
//				QRcode codeframe=new QRcode();
//				codeframe.QRframe.setVisible(true);
//				Accountframe.setVisible(false);
				ReserveFrame reframe=new ReserveFrame();
				reframe.reserveframe.setVisible(true);
				Accountframe.setVisible(false);
				
			}
		});
		TimeLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/time.png")));
		TimeLabel.setBounds(33, 10, 68, 61);
		FooterPanel.add(TimeLabel);
		
		JLabel SearchLabel = new JLabel("New label");
		SearchLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Search swindow=new  Search();
				swindow.frame.setVisible(true);
				Accountframe.setVisible(false);
			}
		});
		SearchLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/search.png")));
		SearchLabel.setBounds(234, 10, 68, 61);
		FooterPanel.add(SearchLabel);
		
		JLabel AccountLabel = new JLabel("New label");
		AccountLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/account2.png")));
		AccountLabel.setBounds(336, 10, 68, 61);
		FooterPanel.add(AccountLabel);
		
		JLabel BagLabel = new JLabel("New label");
		BagLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Prebuy pwindow=new Prebuy();
				pwindow.frame.setVisible(true);
				Accountframe.setVisible(false);
			}
		});
		BagLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/bag1.png")));
		BagLabel.setBounds(132, 10, 68, 61);
		FooterPanel.add(BagLabel);
		
		JPanel BlackPanel = new JPanel();
		BlackPanel.setBackground(SystemColor.desktop);
		BlackPanel.setBounds(0, 0, 436, 65);
		MainPanel.add(BlackPanel);
		
		JLabel UserName = new JLabel("\u963F\u6C81");
		UserName.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		UserName.setBounds(190, 127, 51, 39);
		MainPanel.add(UserName);
		
		JLabel AccountL = new JLabel("\u5E33\u865F");
		AccountLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				demo_window window = new demo_window();
				window.Accountframe.setVisible(true);
				Accountframe.setVisible(false);
				
			}
			
		});
		AccountL.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		AccountL.setBackground(Color.BLACK);
		AccountL.setBounds(79, 198, 46, 28);
		MainPanel.add(AccountL);
		
		JPanel Line = new JPanel();
		Line.setBackground(Color.BLACK);
		Line.setBounds(160, 165, 106, 2);
		MainPanel.add(Line);
		
		JLabel PasswordL = new JLabel("\u5BC6\u78BC");
		PasswordL.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		PasswordL.setBounds(78, 257, 46, 28);
		MainPanel.add(PasswordL);
		
		account = new JTextField();
		account.setFont(new Font("新細明體", Font.PLAIN, 18));
		account.setText("12345678");
		account.setBounds(134, 201, 172, 28);
		MainPanel.add(account);
		account.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("新細明體", Font.PLAIN, 18));
		password.setText("ab3333333");
		password.setBounds(134, 259, 172, 28);
		MainPanel.add(password);
		password.setColumns(10);
		
		JPanel EditInfPanel = new JPanel();
		EditInfPanel.setBackground(SystemColor.desktop);
		EditInfPanel.setBounds(122, 309, 184, 49);
		MainPanel.add(EditInfPanel);
		EditInfPanel.setLayout(null);
		EditInfPanel.setBorder(brdrLeft);
		
		JLabel EditInfLabel = new JLabel("編輯會員資訊");
		EditInfLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		EditInfLabel.setForeground(SystemColor.window);
		EditInfLabel.setBounds(30, 10, 132, 29);
		EditInfPanel.add(EditInfLabel);
	}
}
