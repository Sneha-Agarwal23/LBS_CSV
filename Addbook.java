package library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Addbook {
	private JTextField bookidField;
	private JTextField booknameField;
	private JTextField authornameField;
	private JTextField bookquantityField;
	private JPanel panel;
	private JFrame frame;
	private JButton addButton;
	
	public BooksDB obj1 = new BooksDB();
	public StudentsDB sc;
	
	public Addbook()
	{
		createPanel();
		createFrame();
	}
	
	public Addbook(BooksDB db, StudentsDB sc)
	{
		createPanel();
		createFrame();
		this.obj1 = db;
		this.sc = sc;
		
	}
	
	private void createPanel()
	{
		panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel headingLabel = new JLabel("Add New Book");
        headingLabel.setBounds(150, 50, 150, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel);
        
        JLabel bookid = new JLabel("Book ID: ");
        bookid.setBounds(50, 100, 100, 30);
        panel.add(bookid);
        
        bookidField = new JTextField();
        bookidField.setBounds(200, 100, 200, 30);
        panel.add(bookidField);
        
        JLabel bookname = new JLabel("Book Name: ");
        bookname.setBounds(50, 150, 100, 30);
        panel.add(bookname);
        
        booknameField = new JTextField();
        booknameField.setBounds(200, 150, 200, 30);
        panel.add(booknameField);
        
        JLabel authorname = new JLabel("Author Name: ");
        authorname.setBounds(50, 200, 100, 30);
        panel.add(authorname);
        
        authornameField = new JTextField();
        authornameField.setBounds(200, 200, 200, 30);
        panel.add(authornameField);
        
        JLabel bookquantity = new JLabel("Book Quantity: ");
        bookquantity.setBounds(50, 250, 100, 30);
        panel.add(bookquantity);
        
        bookquantityField = new JTextField();
        bookquantityField.setBounds(200, 250, 200, 30);
        panel.add(bookquantityField);
        
        addButton = new JButton("Add Book");
        addButton.setBounds(150, 330, 100, 30);
        panel.add(addButton);
        addButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		String id = bookidField.getText();
        		String bname = booknameField.getText();
        		String aname = authornameField.getText();
        		String bqty = bookquantityField.getText();
        		
          		obj1.addBook(id, bname, aname, bqty);
        		
        		JOptionPane.showMessageDialog(frame, "Book Added");
        		frame.dispose();
        		new Adminpage();
        	}
        });
        
        JButton back = new JButton("Back");
        back.setBounds(150, 375, 100, 30);
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
		frame = new JFrame("Add New Book:");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String args[])
	{
		//new Addbook();
	}
}
