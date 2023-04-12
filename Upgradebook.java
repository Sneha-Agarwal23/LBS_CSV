package library;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Upgradebook {
	private JFrame frame;
	private JPanel panel;
	private BooksDB db;
	private JTextField bookname;
	private JTextField bookid;
	private JTextField qty;
	private JButton update;
	
	public String filepath = "C:\\Users\\snaga\\eclipse-workspace\\library\\src\\library\\book.csv";
	
	public Upgradebook()
	{
		createPanel();
		createFrame();
	}
	
	private void createPanel()
	{
		panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel headingLabel = new JLabel("UPGRADE BOOK QUANTITY");
        headingLabel.setBounds(100, 50, 300, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel);
        
        JLabel bname = new JLabel("Book Name:");
        bname.setBounds(50, 100, 100, 30);
        panel.add(bname);
        
        bookname = new JTextField();
        bookname.setBounds(200, 100, 200, 30);
        panel.add(bookname);
        
        JLabel bid = new JLabel("Book ID: ");
        bid.setBounds(50, 150, 100, 30);
        panel.add(bid);
        
        bookid = new JTextField();
        bookid.setBounds(200, 150, 200, 30);
        panel.add(bookid);
        
        JLabel bqty = new JLabel("Quantity: ");
        bqty.setBounds(50, 200, 100, 30);
        panel.add(bqty);
        
        qty = new JTextField();
        qty.setBounds(200, 200, 200, 30);
        panel.add(qty);
        
        update = new JButton("UPDATE");
        update.setBounds(125, 300, 200, 30);
        panel.add(update);
        update.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		String n = bookname.getText();
        		String i = bookid.getText();
        		String q = qty.getText();
        		
        		if(n.isEmpty() || i.isEmpty() || q.isEmpty())
        		{
        			JOptionPane.showMessageDialog(frame, "Please Enter Valid Details");
        		}
        		else
        		{
        			BooksDB db = new BooksDB();
        			db.updatebookqty(n, i, q);
        			frame.dispose();
        			new Adminpage();
        		}
        	}
        });
        
        JButton back = new JButton("Back");
        back.setBounds(125, 350, 200, 30);
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
		frame = new JFrame("UPGRADE BOOK QUANTITY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
        new Upgradebook();
    }


}
