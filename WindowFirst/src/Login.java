import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Login {

  JFrame frame;
 private JTextField accTextField;
 private JTextField passTextField;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Login window = new Login();
     window.frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the application.
  */
 public Login() {
  initialize();
 }

 /**
  * Initialize the contents of the frame.
  */
 private void initialize() {
  frame = new JFrame();
  frame.getContentPane().setBackground(new Color(250,245,172,98));
  frame.getContentPane().setLayout(null);
  
  JLabel titleLabel = new JLabel("\u767B\u5165");
  titleLabel.setFont(new Font("�رd���S����(P)", Font.BOLD, 32));
  titleLabel.setBounds(29, 131, 70, 40);
  frame.getContentPane().add(titleLabel);
  
  accTextField = new JTextField();
  accTextField.setBounds(103, 198, 287, 40);
  frame.getContentPane().add(accTextField);
  accTextField.setColumns(10);
  
  JLabel accLabel = new JLabel("\u5E33\u865F");
  accLabel.setFont(new Font("�رd���S����(P)", Font.PLAIN, 24));
  accLabel.setBounds(32, 204, 57, 29);
  frame.getContentPane().add(accLabel);
  
  JLabel passLabel = new JLabel("\u5BC6\u78BC");
  passLabel.setFont(new Font("�رd���S����(P)", Font.PLAIN, 24));
  passLabel.setBounds(32, 268, 57, 29);
  frame.getContentPane().add(passLabel);
  
  passTextField = new JTextField();
  passTextField.setForeground(Color.BLACK);
  passTextField.setColumns(10);
  passTextField.setBounds(103, 262, 287, 40);
  frame.getContentPane().add(passTextField);
  
  JButton logButton = new JButton("\u767B\u5165");
  logButton.setContentAreaFilled(false);
  logButton.setOpaque(true);
  logButton.setBackground(new Color(0,0,0));
  logButton.setForeground(new Color(255, 255, 255));
  logButton.setFont(new Font("�رd���S����(P)", Font.PLAIN, 24));
  logButton.setBounds(123, 327, 194, 40);
  frame.getContentPane().add(logButton);
  
  JPanel topPanel = new JPanel();
  topPanel.setBackground(new Color(153,107,31));
  topPanel.setForeground(Color.BLACK);
  topPanel.setBounds(0, 0, 436, 40);
  frame.getContentPane().add(topPanel);
  
  logButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    
   }
  });
  
  frame.setBounds(100, 100, 450, 550);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  
 }
}