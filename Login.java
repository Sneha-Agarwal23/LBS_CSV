package library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    public Login()
    {
    	super("Login Screen");
    	
    	JLabel headingLabel = new JLabel("LIBRARY MANAGEMENT SYSTEM");
	    headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
	    headingLabel.setBounds(200, 20, 100, 30);
	    
	    JLabel usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(300, 30));

        JLabel passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 30));

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 300));
        panel.setLayout(null);
        
       
        headingLabel.setBounds(175, 20, 500, 30);
        usernameLabel.setBounds(75, 75, 100, 30);
        usernameField.setBounds(200, 75, 150, 30);
        passwordLabel.setBounds(75, 125, 100, 30);
        passwordField.setBounds(200, 125, 150, 30);
        loginButton.setBounds(200, 200, 100, 30);
        
        panel.add(headingLabel);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
        
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent e)
    {
    	String username = usernameField.getText();
    	String password = new String(passwordField.getPassword());
    	
    	if(username.equals("doodle") && password.equals("doodle"))
    	{
    		JOptionPane.showMessageDialog(this, "Login Successful");
    		new Homepage();
    		dispose();
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(this, "Invalid Credentials");
    	}
    }
    
    public static void main(String[] args) {
        new Login();
    }

}
