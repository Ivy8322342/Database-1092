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

public class PackageFrame {

	JFrame packageframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PackageFrame window = new PackageFrame();
					window.packageframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PackageFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		packageframe = new JFrame();
		packageframe.setBounds(100, 100, 450, 550);
		packageframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		packageframe.getContentPane().setLayout(null);
		
		JPanel NavPanel = new JPanel();
		NavPanel.setBackground(new Color(0, 0, 153));
		NavPanel.setBounds(0, 0, 436, 54);
		packageframe.getContentPane().add(NavPanel);
		
		JLabel pageLabel = new JLabel("\u9810\u8CB7\u6E05\u55AE");
		pageLabel.setForeground(Color.WHITE);
		pageLabel.setFont(new Font("·L³n¥¿¶ÂÅé", Font.BOLD, 26));
		pageLabel.setBackground(Color.WHITE);
		NavPanel.add(pageLabel);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setLayout(null);
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBounds(0, 52, 436, 461);
		packageframe.getContentPane().add(MainPanel);
		
		JPanel FooterPanel = new JPanel();
		FooterPanel.setLayout(null);
		FooterPanel.setBackground(new Color(224, 255, 255));
		FooterPanel.setBounds(0, 380, 436, 81);
		MainPanel.add(FooterPanel);
		
		JLabel TimeLabel = new JLabel("");
		TimeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//show QRcode
//				QRcode codeframe=new QRcode();
//				codeframe.QRframe.setVisible(true);
//				Accountframe.setVisible(false);
				ReserveFrame reframe=new ReserveFrame();
				reframe.reserveframe.setVisible(true);
				packageframe.setVisible(false);
				
			}
		});
		TimeLabel.setIcon(new ImageIcon(PackageFrame.class.getResource("/img/time.png")));
		TimeLabel.setBounds(33, 10, 68, 61);
		FooterPanel.add(TimeLabel);
		
		JLabel BagLabel = new JLabel("New label");
		BagLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PackageFrame pwindow=new PackageFrame();
				pwindow.packageframe.setVisible(true);
				packageframe.setVisible(false);
			}
		});
		BagLabel.setIcon(new ImageIcon(PackageFrame.class.getResource("/img/bag1.png")));
		BagLabel.setBounds(132, 10, 68, 61);
		FooterPanel.add(BagLabel);
		
		JLabel SearchLabel = new JLabel("New label");
		SearchLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchFrame swindow=new SearchFrame();
				swindow.searchframe.setVisible(true);
				packageframe.setVisible(false);
			}
		});
		SearchLabel.setIcon(new ImageIcon(PackageFrame.class.getResource("/img/search.png")));
		SearchLabel.setBounds(234, 10, 68, 61);
		
		FooterPanel.add(SearchLabel);
		
		JLabel AccountLabel = new JLabel("New label");
		AccountLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				demo_window window = new demo_window();
				window.Accountframe.setVisible(true);
				packageframe.setVisible(false);
				
			}
			
		});
		AccountLabel.setIcon(new ImageIcon(PackageFrame.class.getResource("/img/account2.png")));
		AccountLabel.setBounds(336, 10, 68, 61);
		FooterPanel.add(AccountLabel);
		

         
		
	}

}
