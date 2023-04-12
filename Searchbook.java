package library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Searchbook {
	private JPanel panel;
	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	
	
	public Searchbook()
	{
		createPanel();
		createFrame();
	}
	
	
	
	private void createPanel()
	{
		panel = new JPanel();
		panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        
        JLabel headingLabel = new JLabel("SEARCH A BOOK");
        headingLabel.setBounds(150, 50, 250, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel);
        
        JLabel l1 = new JLabel("BOOK ID: ");
        l1.setBounds(50,100,150,30);
        panel.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(150,100,200,30);
        panel.add(t1);
        
        JLabel l2 = new JLabel("BOOK NAME: ");
        l2.setBounds(50,150,150,30);
        panel.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(150,150,200,30);
        panel.add(t2);
        
        
        JButton s = new JButton("SEARCH");
        s.setBounds(150, 250, 100, 30);
        panel.add(s);
        s.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		String i = t1.getText();
        		String n = t2.getText();
        		if(i.isEmpty() && n.isEmpty())
        		{
        			JOptionPane.showMessageDialog(frame, "Please Enter Valid Details");
        		}
        		else
        		{
        			BooksDB db = new BooksDB();
        			Book b = db.searchBook(i, n);
        			if(b == null)
        				JOptionPane.showMessageDialog(frame, "Book Not Found");
        			else
        			{	
        				//JOptionPane.showMessageDialog(frame, "Book Found");
        				
        		        JOptionPane.showMessageDialog(frame, "Book ID - " + b.getBook_id()+"\t\t" + "  Book Name - " + b.getBook_name() +"\t\t" + "   Author Name - " + b.getAuthor_name() +"\n");
        		        
        			}
        			
        		}
        	}
        });
        
        JButton back = new JButton("Back");
        back.setBounds(150,300,100,30);
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		frame.dispose();
        		new Adminpage();
        	}
        });
        panel.add(back);
        
	}
	
	private void createFrame()
	{
		frame = new JFrame("SEARCH BOOK");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
        //new Searchbook();
    }
	

}
