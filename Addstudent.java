package library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Addstudent {
	private JTextField studentnameField;
	private JTextField studentidField;
	private JTextField studentstreamField;
	private JTextField studentyearField;
	private JTextField studentmobileField;
	private JPanel panel;
	private JFrame frame;
	private JButton addButton;
	
	public StudentsDB sc = new StudentsDB();
	
	public Addstudent()
	{
		createPanel();
		createFrame();
	}
	
	
	private void createPanel()
	{
		panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel headingLabel = new JLabel("REGISTER STUDENT");
        headingLabel.setBounds(150, 50, 200, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel);
        
        JLabel studentname = new JLabel("Name:");
        studentname.setBounds(50, 100, 100, 30);
        panel.add(studentname);
        
        studentnameField = new JTextField();
        studentnameField.setBounds(200, 100, 200, 30);
        panel.add(studentnameField);
        
        JLabel studentid = new JLabel("ID: ");
        studentid.setBounds(50, 150, 100, 30);
        panel.add(studentid);
        
        studentidField = new JTextField();
        studentidField.setBounds(200, 150, 200, 30);
        panel.add(studentidField);
        
        JLabel studentstream = new JLabel("Stream: ");
        studentstream.setBounds(50, 200, 100, 30);
        panel.add(studentstream);
        
        studentstreamField = new JTextField();
        studentstreamField.setBounds(200, 200, 200, 30);
        panel.add(studentstreamField);
        
        JLabel studentyear = new JLabel("Year: ");
        studentyear.setBounds(50, 250, 100, 30);
        panel.add(studentyear);
        
        studentyearField = new JTextField();
        studentyearField.setBounds(200, 250, 200, 30);
        panel.add(studentyearField);
        
        JLabel studentmobile = new JLabel("Mobile: ");
        studentmobile.setBounds(50, 300, 100, 30);
        panel.add(studentmobile);
        
        studentmobileField = new JTextField();
        studentmobileField.setBounds(200, 300, 200, 30);
        panel.add(studentmobileField);
        
        addButton = new JButton("Register");
        addButton.setBounds(150, 350, 100, 30);
        panel.add(addButton);
        addButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		String name = studentnameField.getText();
        		String id = studentidField.getText();
        		String stream = studentstreamField.getText();
        		String year = studentyearField.getText();
        		String mob = studentmobileField.getText();
        		
        		sc.addStudent(name, id, stream, year, mob);
        		
        		JOptionPane.showMessageDialog(frame, "You are registered.");
        		frame.dispose();
        		new Studentpage();
        	}
        });
        
        JButton back = new JButton("Back");
        back.setBounds(150, 400, 100, 30);
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
		frame = new JFrame("Register Student:");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
        //new Addstudent();
    }

}

