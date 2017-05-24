//Spring 2015
//COSC 211 and 212


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RomanCalculator2 extends JPanel implements ActionListener {
	private JTextField tf = null; 
	private JButton[] arrBtn = null; 
	private JPanel jp = null; 
	private String[] btnNames = { "I", "V", "X", "L", "C", "D","M", "CE", "-", "+", ",", "/",
			"%", "*", "="}; 
	private boolean isOpPressed = false; 
	private char op = ' ';
	private int num2 = 0; 
	private int num1 = 0; 
	private int result = 0; 
	
public RomanCalculator2() 
{ 
	super(); 
	tf = new JTextField(); 
	arrBtn = new JButton[btnNames.length];
	jp = new JPanel(); 
	
	jp.setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints(); 
	tf.setHorizontalAlignment(JTextField.RIGHT);
	
	this.add(tf, BorderLayout.NORTH);
	
	for (int i = 0; i < arrBtn.length; i++) 
	{ 
		arrBtn[i] = new JButton(btnNames[i]); 
		arrBtn[i].addActionListener((ActionListener) this);
		jp.add(arrBtn[i]);  
	}
	gbc.gridx = 1;
	gbc.gridy = 1;
	arrBtn[0] = new JButton(btnNames[0]);
	arrBtn[0].addActionListener(this);
	jp.add(arrBtn[0], gbc);
	gbc.gridx = 2;
	gbc.gridy = 1;
	arrBtn[1] = new JButton(btnNames[1]);
	arrBtn[1].addActionListener(this);
	
	gbc.gridx = 1;
	gbc.gridy = GridBagConstraints.RELATIVE;
	gbc.gridwidth = 2;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	
	
}
	
	public static void main(String[] args) 
	{    
		EventQueue.invokeLater(new Runnable()
		{

		public void run() 
		{
			try 
			{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} 
			catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				ex.printStackTrace();
			}

			JFrame frame = new JFrame("Calculator");
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame.setSize(600,600);
			RomanCalculator cal = new RomanCalculator();

			frame.add(cal);
			frame.add(new Panel());
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true); 
			
		} 
	}	); 
	 

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
