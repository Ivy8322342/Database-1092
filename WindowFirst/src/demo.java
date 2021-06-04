import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class demo {
	ArrayList<JPanel> GoodArray=new ArrayList<JPanel>();
	JFrame reserveframe;
	JFrame diaframe;
	JPanel No;
	JFrame QRframe;
	 dialogFram dwindow;
	
	
	public void add() {
	GoodArray.add(new GoodP().getGoodP());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		demo de=new demo();
		de.add();
		de.add();
		de.add();
		de.add();
		de.add();
		de.add();
		de.add();
		de.add();
		de.add();
		de.add();
		System.out.println(de.GoodArray.size());
		
		
	}

}
