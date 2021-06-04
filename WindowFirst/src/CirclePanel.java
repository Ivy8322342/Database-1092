import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CirclePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
    }
    public static void main(String[] args) {
    	CirclePanel panel = new CirclePanel();

    	panel.setLayout(new GridBagLayout());

    	GridBagConstraints gc;

    	gc = new GridBagConstraints();
    	gc.gridy = 0;
    	panel.add(new JLabel("Label 1"), gc);

    	gc = new GridBagConstraints();
    	gc.gridy = 1;
    	panel.add(new JLabel("Label 2"), gc);
    }
}