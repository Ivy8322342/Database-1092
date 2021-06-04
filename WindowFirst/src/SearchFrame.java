import java.awt.EventQueue;

//test cir
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
public class SearchFrame {
//round corner prepare
//    AbstractBorder brdrLeft = new TextBubbleBorder(Color.BLACK,2,16,0);
//    AbstractBorder brdrRight = new TextBubbleBorder(Color.BLACK,2,16,0,false);
	 JFrame searchframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFrame window = new SearchFrame();
					window.searchframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		searchframe = new JFrame();
		searchframe.setBounds(100, 100, 450, 550);
		searchframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
searchframe.getContentPane().setLayout(null);
		
		JPanel NavPanel = new JPanel();
		NavPanel.setBackground(new Color(0, 0, 153));
		NavPanel.setBounds(0, 0, 436, 54);
		searchframe.getContentPane().add(NavPanel);
		
		
		
		//add pageLabel
		JLabel pageLabel=new JLabel("\u5546\u54C1\u6578\u91CF\u67E5\u8A62");
		pageLabel.setBounds(158,10,106,35);
		pageLabel.setForeground(new Color(255,255,255));
		NavPanel.add(pageLabel);
		pageLabel.setBackground(new Color(255,255,255));
		pageLabel.setFont(new Font("·L³n¥¿¶ÂÅé",Font.BOLD,26));
		
		
		
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(255, 255, 255));
		MainPanel.setBounds(0, 52, 436, 461);
		searchframe.getContentPane().add(MainPanel);
		MainPanel.setLayout(null);
		
		//
		
		GoodP p=new GoodP();
		MainPanel.add(p.getGoodP());
		
		
		
		
		
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
				searchframe.setVisible(false);
				
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
				searchframe.setVisible(false);
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
				searchframe.setVisible(false);
				
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
				searchframe.setVisible(false);
			}
		});
		BagLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/bag1.png")));
		BagLabel.setBounds(132, 10, 68, 61);
		FooterPanel.add(BagLabel);

    	GridBagConstraints gc;
    	JLabel label = new JLabel("Label 2");
    	label.setIcon(new ImageIcon(SearchFrame.class.getResource("/img/me1.jpg")));
    	label.setLocation(86, -232);
    	label.setBackground(Color.CYAN);
    	label.setSize(326, 274);
    	label.setForeground(Color.BLACK);
		
	}
	
}
