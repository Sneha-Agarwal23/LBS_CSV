package library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Adminpage {
	private JFrame frame;
	private JPanel panel;
	
	public Adminpage()
	{
		createPanel();
		createFrame();
	}
	
	private void createPanel()
	{
		panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel headingLabel = new JLabel("ADMIN PAGE");
        headingLabel.setBounds(150, 50, 150, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel);
        
        
        JButton addBookButton = new JButton("Add New Book");
        addBookButton.setBounds(100, 100, 200, 30);
        panel.add(addBookButton);
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	frame.dispose();
                new Addbook();
            }
        });
        
        
        JButton upgradeQuantityButton = new JButton("Upgrade Quantity of a Book");
        upgradeQuantityButton.setBounds(100, 150, 200, 30);
        panel.add(upgradeQuantityButton);
        upgradeQuantityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                //JOptionPane.showMessageDialog(frame, "Upgrade Quantity of a Book functionality to be implemented.");
            	new Upgradebook();
            }
        });
        
        
        JButton searchBookButton = new JButton("Search a Book");
        searchBookButton.setBounds(100, 200, 200, 30);
        panel.add(searchBookButton);
        searchBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                //JOptionPane.showMessageDialog(frame, "Search a Book functionality to be implemented.");
            	new Searchbook();
            }
        });
        
        
        JButton showAllBooksButton = new JButton("Show All Books");
        showAllBooksButton.setBounds(100, 250, 200, 30);
        panel.add(showAllBooksButton);
        showAllBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//JOptionPane.showMessageDialog(frame, "Show all Book functionality to be implemented.");
            	new Showbooks();
            }
        });
        
        
        JButton showAllStudentsButton = new JButton("Show All Students");
        showAllStudentsButton.setBounds(100, 300, 200, 30);
        panel.add(showAllStudentsButton);
        showAllStudentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new Showstudents();
            }
        });
        
        JButton back = new JButton("Back");
        back.setBounds(150, 350, 100, 30);
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		frame.dispose();
        		new Homepage();
        	}
        });
        panel.add(back);
        
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(150, 400, 100, 30);
        panel.add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                frame.dispose();
                new Login();
            }
        });
        

	}
	
	private void createFrame()
	{
		frame = new JFrame("Admin Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
        new Adminpage();
    }

}
