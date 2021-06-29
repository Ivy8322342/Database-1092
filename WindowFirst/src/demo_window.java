import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.SwingConstants;

public class demo_window {
	Prebuy prebuy;
	String Cid;
	String Name;
	String password;
    int countclick;
	JFrame Accountframe;
	 JTextField accountT;
	 JTextField passwordT;
	demo_back Dback;
	 JTextField NtextField;
	 JLabel WornLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo_window window = new demo_window("ivy204");
					window.Accountframe.setVisible(true);
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
	public demo_window(String Cid,Prebuy p) throws SQLException {
		this.Cid=Cid;
		this.prebuy=p;
		Dback=new demo_back(Cid);
		this.countclick=0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
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
		MainPanel.setForeground(new Color(0, 0, 0));
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
				prebuy.resF.reserveframe.setVisible(true);
				Accountframe.setVisible(false);
				
			}
		});
		TimeLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/time.png")));
		TimeLabel.setBounds(33, 10, 68, 61);
		FooterPanel.add(TimeLabel);
		
		JLabel LogoutLabel = new JLabel("");
		LogoutLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				 Search swindow=new  Search();
//				swindow.frame.setVisible(true);
				JFrame f=new JFrame();
				JDialog d=new JDialog(f,"登出",true);
				d.setBounds(170, 222, 315, 200);
				 d.getContentPane().setLayout(null);  
				 JButton b = new JButton ("是");  
				 b.setBounds(102,100, 85, 23);
				 b.addActionListener ( new ActionListener()  
			        {  
			            public void actionPerformed( ActionEvent e )  
			            {  
			                d.setVisible(false); 
			                Accountframe.dispose();;
			            }  
			        });  
				JLabel st= new JLabel ("確定要登出嗎?");
				st.setBounds(80,46,269,46);
				 d.getContentPane().add(st);  
			        d.getContentPane().add(b);
			        b.setVisible(true);
//			        d.setSize(300,300);    
			        d.setVisible(true);  
				
				
				
				
			}
		});
		LogoutLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/Logout.png")));
		LogoutLabel.setBounds(234, 10, 68, 61);
		FooterPanel.add(LogoutLabel);
		
		JLabel AccountLabel = new JLabel("New label");
		AccountLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/Ataccount2.png")));
		AccountLabel.setBounds(336, 10, 68, 61);
		FooterPanel.add(AccountLabel);
		
		JLabel BagLabel = new JLabel("New label");
		BagLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//				Prebuy pwindow=new Prebuy();
//				pwindow.frame.setVisible(true);
				try {
					prebuy=new Prebuy(Cid);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				prebuy.frame.setVisible(true);
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
		
		JLabel AccountL = new JLabel("\u5E33\u865F");
		AccountLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				if(countclick==0) {
//				demo_window window = new demo_window();
//				window.Accountframe.setVisible(true);
//				Accountframe.setVisible(false);
//				countclick=1;}
//				else if(countclick==1) {
//					
//					countclick=0;
//				}
				
				
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
		
		accountT = new JTextField();
		accountT.setFont(new Font("新細明體", Font.PLAIN, 18));
		accountT.setText("12345678");
		accountT.setBounds(134, 201, 172, 28);
		MainPanel.add(accountT);
		accountT.setColumns(20);
//		accountT.setEditable(false);
		
		passwordT = new JTextField();
		passwordT.setFont(new Font("新細明體", Font.PLAIN, 18));
		passwordT.setText("ab3333333");
		passwordT.setBounds(134, 259, 172, 28);
		MainPanel.add(passwordT);
		passwordT.setColumns(20);
//		passwordT.setEditable(false);
		
		
		JLabel EditInfLabel = new JLabel("編輯會員資訊");
		EditInfLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EditInfLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		EditInfLabel.setForeground(SystemColor.window);
		EditInfLabel.setBounds(22, 10, 132, 29);
		
		JPanel EditInfPanel = new JPanel();
		EditInfPanel.add(EditInfLabel);
		EditInfPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(countclick==0) {
				accountT.setEditable(true);
				passwordT.setEditable(true);
				NtextField.setEditable(true);
				EditInfLabel.setText("OK!");
				countclick=1;
				System.out.println("count="+countclick);
				}
				else if(countclick==1) {
					if(accountT.getText().trim().length()<2||passwordT.getText().trim().length()<2
							||NtextField.getText().length()<2||NtextField.getText().equals("請輸入大於一個字")) {
						accountT.setText(Cid);
						passwordT.setText(password);
						NtextField.setText(Name);
						WornLabel.setText("格式不符，請重新輸入");
					}else {WornLabel.setText("");
					String Newid=accountT.getText();
					String NewPassw=passwordT.getText();
					
					
					String NewName=NtextField.getText();
					String LN=NewName.substring(0,1);
					String FN=NewName.substring(1);
					try {
						Dback.edit(Newid, NewPassw, LN, FN);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					accountT.setEditable(false);
					passwordT.setEditable(false);
					NtextField.setEditable(false);
					EditInfLabel.setText("編輯會員資訊");
					countclick=0;
					
					Cid=Newid;
					password=NewPassw;
					Name=NewName;
					
					System.out.println("count="+countclick);
					System.out.println("this.Cid="+Cid+"; this.password="+password+"; this.Name="+Name);
					
					
					}
					
				}
			}
		});
		
		EditInfPanel.setBackground(SystemColor.desktop);
		EditInfPanel.setBounds(122, 309, 184, 49);
		MainPanel.add(EditInfPanel);
		EditInfPanel.setLayout(null);
		EditInfPanel.setBorder(brdrLeft);
		
		NtextField = new JTextField();
		NtextField.setBackground(new Color(250, 245, 172));
		NtextField.setText("黃沁甯");
//		NtextField.setEditable(false);
		NtextField.setHorizontalAlignment(SwingConstants.CENTER);
		NtextField.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		NtextField.setBounds(0, 126, 436, 41);
		MainPanel.add(NtextField);
		NtextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 245, 172));
		panel.setBounds(0, 229, 436, 28);
		MainPanel.add(panel);
		panel.setLayout(null);
		
		
		WornLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WornLabel.setBounds(59, 0, 296, 28);
		panel.add(WornLabel);
		initialShow();
		
		
		
	}
	public void initialShow() throws SQLException {
		String info=Dback.CustomerInfo();
		this.Cid=info.split(",")[0];
		this.password=info.split(",")[1];
		this.Name=info.split(",")[2]+info.split(",")[3];	
		this.accountT.setText(Cid);
		this.passwordT.setText(password);
		this.NtextField.setText(Name);
		this.accountT.setEditable(false);
		this.passwordT.setEditable(false);
		this.NtextField.setEditable(false);
	}
}
