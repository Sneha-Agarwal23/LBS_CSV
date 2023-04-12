package library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class disp {
	private JFrame frame;
	private JPanel panel;
	String stid;
	public String filepath = "C:\\Users\\snaga\\eclipse-workspace\\library\\src\\library\\student.csv";
	public String issuepath = "C:\\Users\\snaga\\eclipse-workspace\\library\\src\\library\\issuedbooks.csv";
	
	public disp(String stid)
	{
		createPanel();
		createFrame();
		this.stid = stid;
	}
	private void createPanel()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        JLabel headingLabel = new JLabel("BOOKS ISSUED PER STUDENT:");
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel, BorderLayout.NORTH);
        
        JTextArea blist = new JTextArea();
        blist.setEditable(false);
        JScrollPane scroll = new JScrollPane(blist);
        panel.add(scroll, BorderLayout.CENTER);
        
         
        ArrayList<Book> st = new ArrayList<Book>();
    	BufferedReader br = null;
        try {
        	
        	String line = "";
        	br = new BufferedReader(new FileReader(issuepath));
        	br.readLine();
        	while((line = br.readLine()) != null)
        	{
        		String[] s = line.split(",");
        		if(s.length > 0)
        		{
        			if(stid.equalsIgnoreCase(s[0]))
        			{
        				blist.append("Student Name"+ "\t\t" + s[1] + "\t\t" + "Student ID" + "\t\t" + s[0] + "\n");
        				Student x = new Student();
            			Book b = new Book();
            			x.setStudent_id(s[0]);
            			x.setStudent_name(s[1]);
            			b.setBook_id(Integer.parseInt(s[2]));
            			b.setBook_name(s[3]);
            			st.add(b);
        			}
        		}
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
        blist.append("Sl No." + "\t\t" + "Book Name" + "\t\t" + "Book ID" + "\n");
        int i = 0;
        for(Book x : st)
        {
        	blist.append((i+1) + "\t\t" + x.getBook_name() + "\t\t" + x.getBook_id() + "\n");
        	i++;
        }
        
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		frame.dispose();
        		new Studentpage();
        	}
        });
        panel.add(back, BorderLayout.SOUTH);
	}
	
	private void createFrame()
	{
		frame = new JFrame("STUDENT'S ISSUED BOOKS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}

	public static void main(String[] args) {
      
    }
}
