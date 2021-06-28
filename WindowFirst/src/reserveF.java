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
import java.sql.SQLException;
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

public class reserveF {

	ArrayList<JPanel> GoodArray = new ArrayList<JPanel>();

	JFrame reserveframe;
	JFrame diaframe;
	JPanel No;
	JPanel ContainP;
	JFrame QRframe;
	JLabel PageLabel;
	JPanel UpperGood = null;
	JPanel LowerGood = null;
	dialogFram dwindow;
	JLabel quan_1 = new JLabel("_");
	JLabel quan_2 = new JLabel("_");
	JLabel quan_3 = new JLabel("_");
	JLabel pname_1 = new JLabel("");
	JLabel pname_2 = new JLabel("");
	JLabel pname_3 = new JLabel("");
	int curPage = 1;
	int curSize = 0;
	int maxPage = 1;
	Reservation reservation;
	ArrayList<String> Listdis1 = new ArrayList<String>();
	ArrayList<String> Listdis2 = new ArrayList<String>();
	ArrayList<String> Listdis3 = new ArrayList<String>();

//	JPanel searchPanel_2 = new JPanel();
//	JLabel PageLabel = new JLabel("\u9801\u6578");
	private int page;
	int Product_ID;

	// 與產品呈現有關的方法
	public void addGood(String PName, String SName, String Pic, String QRcode, int Quantity) {
		GoodArray.add(new GoodP(PName, SName, Pic, QRcode, Quantity).getGoodP());
		curSize = GoodArray.size();
		if (curSize == 0) {
			maxPage = curSize + 1;
		}
		maxPage = (curSize - 1) / 2 + 1;
//	rePosition();
		showPage();
	}

	public void rePosition() {
		for (int i = 0; i < curSize; i++) {
			if (i % 2 == 0) {
				GoodArray.get(i).setBounds(14, 10, 394, 143);
			}
			if (i % 2 == 1) {
				GoodArray.get(i).setBounds(14, 172, 394, 143);
			}

		}
	}

	// 完成取貨會馬上在該頁面呈現變動:
	public void finishGood(ArrayList<JPanel> GoodArray, int index, int num) {
		GoodArray.remove(index);
	}

	// 剛開始的時候是呈現第一頁
	public void showPage() {
		if (GoodArray.size() > 0 && curPage <= maxPage) {
			maxPage = (int) ((GoodArray.size() + 1) / 2);
			// if curPage==1, the [0], [1] goods in arraylist will be
			// show; curPage==2,[2] [3];curPage==3, [4] [5]..
			ContainP.add(GoodArray.get((curPage - 1) * 2));
			GoodArray.get((curPage - 1) * 2).setVisible(true);
			GoodArray.get((curPage - 1) * 2).setBounds(14, 10, 394, 143);

			if ((GoodArray.size() - 1) > (curPage - 1) * 2 + 1) {

				ContainP.add(GoodArray.get((curPage - 1) * 2 + 1));
				GoodArray.get((curPage - 1) * 2 + 1).setBounds(14, 172, 394, 143);
				GoodArray.get((curPage - 1) * 2 + 1).setVisible(true);
			}
		} else {
			curPage = 1;
			maxPage = 1;

		}
		PageLabel.setText(curPage + "/" + maxPage);

	}

	public void CloseCurrentPage() {

		ContainP.removeAll();

		PageLabel.setText(curPage + "/" + maxPage);

	}

	public void nextPage() {
		if (curPage < maxPage) {
			// 先關掉目前頁面再生成新頁面
			CloseCurrentPage();
			curPage = curPage + 1;
			showPage();

		}
	}

	public void lastPage() {
		if (curPage > 1) {
			CloseCurrentPage();
			curPage--;
			showPage();

		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reserveF window = new reserveF();
					window.reserveframe.setVisible(true);

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
	public reserveF() throws SQLException {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		page = 1;
		reservation = new Reservation();
		reserveframe = new JFrame();
		reserveframe.setBounds(100, 100, 450, 550);
		reserveframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reserveframe.getContentPane().setLayout(null);

		quan_1 = new JLabel("");
		quan_2 = new JLabel("_");
		quan_3 = new JLabel("");
		pname_1 = new JLabel("");
		pname_2 = new JLabel("");
		pname_3 = new JLabel("");

		JPanel NavPanel = new JPanel();
		NavPanel.setBackground(new Color(153, 107, 31));
		NavPanel.setBounds(0, 0, 436, 54);
		reserveframe.getContentPane().add(NavPanel);

		// add pageLabel
		JLabel pageLabel = new JLabel("\u9810\u7D04\u53D6\u8CA8\u6E05\u55AE");
		pageLabel.setBounds(158, 10, 106, 35);
		pageLabel.setForeground(new Color(255, 255, 255));
		NavPanel.add(pageLabel);
		pageLabel.setBackground(new Color(255, 255, 255));
		pageLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(250, 245, 172, 98));
		MainPanel.setBounds(0, 52, 436, 461);
		reserveframe.getContentPane().add(MainPanel);
		MainPanel.setLayout(null);

		JPanel FooterPanel = new JPanel();
		FooterPanel.setBounds(0, 380, 436, 81);
		FooterPanel.setBackground(new Color(153, 107, 31));
		MainPanel.add(FooterPanel);
		FooterPanel.setLayout(null);

		JLabel TimeLabel = new JLabel("");
		TimeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				reserveF rwindow;
//				try {
//					rwindow = new reserveF();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				rwindow.reserveframe.setVisible(true);
//				reserveframe.setVisible(false);

			}

		});

		TimeLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/time.png")));
		TimeLabel.setBounds(33, 10, 68, 61);
		FooterPanel.add(TimeLabel);

		JLabel SearchLabel = new JLabel("New label");
		SearchLabel.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {
//				SearchFrame swindow = new SearchFrame();
//				swindow.frame.setVisible(true);
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
//				demo_window window = new demo_window();
//				window.Accountframe.setVisible(true);
				reserveframe.setVisible(false);

			}

		});
		AccountLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/account2.png")));
		AccountLabel.setBounds(336, 10, 68, 61);
		FooterPanel.add(AccountLabel);

		JLabel BagLabel = new JLabel("New label");
		BagLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//				Prebuy pwindow = new Prebuy();
//				pwindow.frame.setVisible(true);
				reserveframe.setVisible(false);
			}
		});
		BagLabel.setIcon(new ImageIcon(demo_window.class.getResource("/img/bag1.png")));
		BagLabel.setBounds(132, 10, 68, 61);
		FooterPanel.add(BagLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 436, 376);
		MainPanel.add(scrollPane);

		JPanel OutContantP = new JPanel();
		OutContantP.setBackground(new Color(250, 245, 172, 98));
		scrollPane.setViewportView(OutContantP);
		OutContantP.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (curPage < maxPage) {
					nextPage();
					PageLabel.setText(curPage + "/" + maxPage);
				}
			}
		});
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(275, 336, 106, 28);
		OutContantP.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u4E0B\u4E00\u9801");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel.setBounds(22, 0, 75, 25);
		panel_2.add(lblNewLabel);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lastPage();
				PageLabel.setText(curPage + "/" + maxPage);
			}
		});
		panel_2_1.setBackground(new Color(0, 0, 0));
		panel_2_1.setBounds(70, 336, 106, 28);
		OutContantP.add(panel_2_1);
		panel_2_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\u4E0A\u4E00\u9801");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(21, 0, 75, 25);
		panel_2_1.add(lblNewLabel_1);

		ContainP = new JPanel();
		ContainP.setAutoscrolls(true);
		ContainP.setBackground(new Color(250, 245, 172, 98));
		ContainP.setBounds(10, 1, 414, 325);
		OutContantP.add(ContainP);
		ContainP.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(186, 336, 75, 28);
		OutContantP.add(panel);
		panel.setLayout(null);
		PageLabel = new JLabel("");
		PageLabel.setBounds(10, 0, 55, 28);
		panel.add(PageLabel);

		PageLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));

		// add to Spanel
		addGood("義美全糖豆漿", "政治", "義美全糖豆漿.jpg", "義美全糖豆漿.png", 4);
		addGood("義", "政治", "義美全糖豆漿.jpg", "義美全糖豆漿.png", 5);
		addGood("義美全糖豆漿", "政治", "義美全糖豆漿.jpg", "義美全糖豆漿.png", 5);
		System.out.println("curSize " + curSize + " maxP: " + maxPage + " curPage: " + curPage);

		showPage();

	}

	public void LabelDistribute(String area) {
		try {
			ArrayList<String> result = reservation.ReservationBtn();

			System.out.println(result.size());
			if (result.size() > 0) {
				for (int i = 0; i < result.size(); i++) {
					switch ((i + 1) % 3) {
					case 1:
						Listdis1.add(result.get(i));
						break;
					case 2:
						Listdis2.add(result.get(i));
						break;
					case 0:
						Listdis3.add(result.get(i));
						break;
					}
				}
				if (Listdis3.size() > 0) {
					setLabels(Listdis1.get(0), pname_1, quan_1);
					setLabels(Listdis2.get(0), pname_2, quan_2);
					setLabels(Listdis3.get(0), pname_3, quan_3);
				} else if (Listdis2.size() > 0) {
					setLabels(Listdis1.get(0), pname_1, quan_1);
					setLabels(Listdis2.get(0), pname_2, quan_2);
				} else if (Listdis1.size() > 0) {
					setLabels(Listdis1.get(0), pname_1, quan_1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clearALs() {
		Listdis1.clear();
		Listdis2.clear();
		Listdis3.clear();

		System.out.println("Clear the ArrayLists!!");
	}

	public void clearRVLabel() {
		pname_1.setText("");
		pname_2.setText("");
		pname_3.setText("");
		quan_1.setText("");
		quan_2.setText("");
		quan_3.setText("");

		System.out.println("Clear Product and Quantity_Left Labels!");
	}

	public void setLabels(String info, JLabel pLabel, JLabel nLabel) {
		String[] s = info.split(";");
		pLabel.setText(s[0]);
		nLabel.setText(s[1]);
	}

	public void ShownextP() {

		if (Listdis1.size() > page && Listdis2.size() > page && Listdis3.size() > page) {
			clearRVLabel();
			page++;
			setLabels(Listdis1.get(page - 1), pname_1, quan_1);
			setLabels(Listdis2.get(page - 1), pname_2, quan_2);
			setLabels(Listdis3.get(page - 1), pname_3, quan_3);
			PageLabel.setText("p " + page + "");
		} else if (Listdis1.size() > page && Listdis2.size() > page) {
			clearRVLabel();
			page++;
			setLabels(Listdis1.get(page - 1), pname_1, quan_1);
			setLabels(Listdis2.get(page - 1), pname_2, quan_2);
			PageLabel.setText("p " + page + "");
		} else if (Listdis1.size() > page) {
			clearRVLabel();
			page++;
			setLabels(Listdis1.get(page - 1), pname_1, quan_1);
			PageLabel.setText("p " + page + "");
		} else {
			System.out.println("這是最後一頁");
		}
	}

	public void ShowlastP() {

		if (page - 1 <= 0) {
			System.out.println("first page!!");
		} else {
			clearRVLabel();
			page--;
			setLabels(Listdis1.get(page - 1), pname_1, quan_1);
			setLabels(Listdis2.get(page - 1), pname_2, quan_2);
			setLabels(Listdis3.get(page - 1), pname_3, quan_3);
			PageLabel.setText("p " + page + "");
		}
	}

	
//應該不用這個method
//	public void ShowPName() throws SQLException {
//		String pname = reservation.ProductName(Product_ID);
//		quanLabel_1.setText(pname+"剩餘數量:");
//		quanLabel_2.setText(pname+"剩餘數量:");
//		quanLabel_2_1.setText(pname+"剩餘數量:");
//		frame.setTitle(pname);
//	}

}