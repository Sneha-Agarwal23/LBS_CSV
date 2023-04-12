package library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Issuebook {
	private JFrame frame;
	private JPanel panel;
	private JTextField sidField;
	private JTextField bidField;
	private JButton issue;
	
	
	public Issuebook()
	{
		createPanel();
		createFrame();
	}
	
	private void createPanel()
	{
		panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel headingLabel = new JLabel("ISSUE BOOK");
        headingLabel.setBounds(150, 50, 150, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel);
        
        JLabel sid = new JLabel("Student ID: ");
        sid.setBounds(50, 100, 100, 30);
        panel.add(sid);
        
        sidField = new JTextField();
        sidField.setBounds(200, 100, 200, 30);
        panel.add(sidField);
        
        JLabel bid = new JLabel("Book ID: ");
        bid.setBounds(50, 150, 100, 30);
        panel.add(bid);
        
        bidField = new JTextField();
        bidField.setBounds(200, 150, 200, 30);
        panel.add(bidField);
        
        issue = new JButton("ISSUE");
        issue.setBounds(150, 250, 100, 30);
        panel.add(issue);
        issue.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		String s = sidField.getText();
        		String b = bidField.getText();
        		
        		StudentsDB sc = new StudentsDB();
        		sc.issueBook(s, b);
        		
        		JOptionPane.showMessageDialog(frame, "Book Issued");
        		frame.dispose();
        		new Studentpage();
        	}
        });
        
        JButton back = new JButton("Back");
        back.setBounds(150, 300, 100, 30);
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		frame.dispose();
        		new Studentpage();
        	}
        });
        panel.add(back);
	}
	private void createFrame()
	{
		frame = new JFrame("ISSUE BOOK");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
        //new Issuebook();
    }

}
