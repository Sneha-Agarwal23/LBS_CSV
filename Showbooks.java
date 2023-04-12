package library;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

//import com.sun.tools.javac.util.List;

import java.awt.event.*;

public class Showbooks {
	private JFrame frame;
	private JPanel panel;
	public String filepath = "C:\\Users\\snaga\\eclipse-workspace\\library\\src\\library\\book.csv";
	
	public Showbooks()
	{
		createPanel();
		createFrame();
	}
	
	private void createPanel()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        JLabel headingLabel = new JLabel("ALL BOOKS");
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel, BorderLayout.NORTH);
        
        JTextArea booklist = new JTextArea();
        booklist.setEditable(false);
        JScrollPane scroll = new JScrollPane(booklist);
        panel.add(scroll, BorderLayout.CENTER);
        
        
        BufferedReader br = null;
        try {
        	ArrayList<Book> b = new ArrayList<Book>();
        	String line = "";
        	br = new BufferedReader(new FileReader(filepath));
        	br.readLine();
        	while((line = br.readLine()) != null)
        	{
        		String[] s = line.split(",");
        		if(s.length > 0)
        		{
        			Book x = new Book();
        			x.setBook_id(Integer.parseInt(s[0]));
        			x.setBook_name(s[1]);
        			x.setAuthor_name(s[2]);
        			x.setBook_quantity(Integer.parseInt(s[3]));
        			b.add(x);
        		}
        	}
        	
        	int i = 0;
        	booklist.append("SL No."+ "\t\t" +  "Book ID" + "\t\t" + "Book Name" + "\t\t" + "Author Name" + "\t\t" + "Total Quantity" +  "\t\t" + "Available Quantity" + "\n");
        	for(Book x : b)
        	{
        		booklist.append((i+1) + "\t\t" +  x.getBook_id() + "\t\t" + x.getBook_name() + "\t\t" + x.getAuthor_name() + "\t\t" + x.getBook_quantity() + "\t\t" + x.getBook_quantity_copy() + "\n");
        		i++;
        	}
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        finally {
        	try {
        		br.close();
        	}
        	catch(Exception ex) {
        		ex.printStackTrace();
        	}
        }
  
        
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		frame.dispose();
        		new Adminpage();
        	}
        });
        panel.add(back, BorderLayout.SOUTH);
	}
	
	
	private void createFrame()
	{
		frame = new JFrame("ALL BOOKS:");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
        //new Showbooks();
    }

}
