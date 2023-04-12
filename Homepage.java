package library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Homepage extends JFrame implements ActionListener{
	private JPanel panel;
	private JFrame frame;
	private JButton adminButton;
	private JButton studentButton;
	
	public Homepage()
	{
		createPanel();
		createFrame();
	}
	
	private void createPanel()
	{
		panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        
        
		JLabel headingLabel = new JLabel("Who Are You?");
	    headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
	    headingLabel.setBounds(100, 20, 100, 30);
	    
	    adminButton = new JButton("Admin");
	    adminButton.addActionListener(this);
	    
	    studentButton = new JButton("Student");
	    studentButton.addActionListener(this);
	    
	    
        headingLabel.setBounds(175, 20, 300, 30);
        adminButton.setBounds(75, 100, 100, 30);
        studentButton.setBounds(300, 100, 100, 30);
        
        panel.add(headingLabel);
        panel.add(adminButton);
        panel.add(studentButton);
        
	}
	
	private void createFrame()
	{
		frame = new JFrame("HOMEPAGE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == adminButton)
		{
			JOptionPane.showMessageDialog(this, "You are Admin");
			new Adminpage();
		}
		else if(e.getSource() == studentButton)
		{
			JOptionPane.showMessageDialog(this, "You are Student");
			new Studentpage();
		}
	}
	
	public static void main(String[] args) {
        //new Homepage();
    }
	

}
