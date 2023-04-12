package library;
import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class Booksperstudent {
	private JFrame frame;
	private JPanel panel;
	private JTextField sidField;
	private JButton okbutton;
	
	
	public Booksperstudent()
	{
		createPanel();
		createFrame();
	}
	
	private void createPanel()
	{
		panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel headingLabel = new JLabel("STUDENT'S ISSUED BOOKS:");
        headingLabel.setBounds(100, 50, 300, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel);
        
        JLabel sid = new JLabel("Student ID: ");
        sid.setBounds(50, 100, 100, 30);
        panel.add(sid);
        
        sidField = new JTextField();
        sidField.setBounds(200, 100, 200, 30);
        panel.add(sidField);
        
        
        okbutton = new JButton("SHOW");
        okbutton.setBounds(150, 200, 100, 30);
        panel.add(okbutton);
        okbutton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		String s = sidField.getText();
        		
        		new disp(s);
        	}
        });
        
        
	}
	private void createFrame()
	{
		frame = new JFrame("STUDENT'S ISSUED BOOKS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String args[])
	{
		new Booksperstudent();
	}

}
