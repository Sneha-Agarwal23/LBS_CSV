package library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Studentpage {
	private JFrame frame;
	private JPanel panel;
	
	public Studentpage()
	{
		createPanel();
		createFrame();
	}
	
	private void createFrame()
	{
		frame = new JFrame("Student Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 550);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	private void createPanel()
	{
		panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel headingLabel = new JLabel("STUDENT PAGE");
        headingLabel.setBounds(150, 50, 150, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel);
        
        
        JButton searchBookButton = new JButton("Search a Book");
        searchBookButton.setBounds(100, 100, 200, 30);
        panel.add(searchBookButton);
        searchBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	//JOptionPane.showMessageDialog(frame, "Search a Book functionality to be implemented.");
            	new Searchbook();
            }
        });
        
        
        JButton registerStudentButton = new JButton("Register a Student");
        registerStudentButton.setBounds(100, 150, 200, 30);
        panel.add(registerStudentButton);
        registerStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                //JOptionPane.showMessageDialog(frame, "Register a student functionality to be implemented.");
            	new Addstudent();
            }
        });
        
        
        JButton issueBookButton = new JButton("Issue a Book");
        issueBookButton.setBounds(100, 200, 200, 30);
        panel.add(issueBookButton);
        issueBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                //JOptionPane.showMessageDialog(frame, "Issue a Book functionality to be implemented.");
            	new Issuebook();
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
        
        
        JButton returnBookButton = new JButton("Return a Book");
        returnBookButton.setBounds(100, 300, 200, 30);
        panel.add(returnBookButton);
        returnBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//JOptionPane.showMessageDialog(frame, "Return a book functionality to be implemented.");
            	new Returnbook();
            }
        });
        
        JButton displayBookButton = new JButton("Student Issued Books");
        displayBookButton.setBounds(100, 350, 200, 30);
        panel.add(displayBookButton);
        displayBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new Booksperstudent();
            	//JOptionPane.showMessageDialog(frame, "Display books issued by a student functionality to be implemented.");
            }
        });
        
        JButton back = new JButton("Back");
        back.setBounds(150, 400, 100, 30);
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		frame.dispose();
        		new Homepage();
        	}
        });
        panel.add(back);
        
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(150, 450, 100, 30);
        panel.add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                frame.dispose();
                new Login();
            }
        });

	}
	
	public static void main(String[] args) {
        //new Studentpage();
    }

}
