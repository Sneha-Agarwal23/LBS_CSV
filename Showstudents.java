package library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Showstudents {
	private JFrame frame;
	private JPanel panel;
	
	public String filepath = "C:\\Users\\snaga\\eclipse-workspace\\library\\src\\library\\student.csv";
	
	//private BooksDB db;
	//private StudentsDB sc;
	
	public Showstudents()
	{
		createPanel();
		createFrame();
	}
	
	/*public Showstudents(BooksDB db, StudentsDB sc)
	{
		createPanel();
		createFrame();
		this.db = db;
		this.sc = sc;
	}*/
	
	private void createPanel()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        JLabel headingLabel = new JLabel("ALL STUDENTS");
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(headingLabel, BorderLayout.NORTH);
        
        JTextArea studentlist = new JTextArea();
        studentlist.setEditable(false);
        JScrollPane scroll = new JScrollPane(studentlist);
        panel.add(scroll, BorderLayout.CENTER);
        
        
        BufferedReader br = null;
        try {
        	ArrayList<Student> b = new ArrayList<Student>();
        	String line = "";
        	br = new BufferedReader(new FileReader(filepath));
        	br.readLine();
        	while((line = br.readLine()) != null)
        	{
        		String[] s = line.split(",");
        		if(s.length > 0)
        		{
        			Student x = new Student();
        			x.setStudent_name(s[0]);
        			x.setStudent_id(s[1]);
        			x.setStudent_stream(s[2]);
        			x.setStudent_year(Integer.parseInt(s[3]));
        			x.setStudent_mobile(s[4]);
        			b.add(x);
        		}
        	}
        	int i = 0;
        	studentlist.append("SL No."+ "\t\t" +  "Name" + "\t\t" + "ID" + "\t\t" + "Stream" + "\t\t" + "Year " + "\t\t" + "Mobile" + "\n" );
        	for(Student x : b)
        	{
        		studentlist.append((i+1) + "\t\t" +  x.getStudent_name() + "\t\t" + x.getStudent_id() + "\t\t" + x.getStudent_stream() + "\t\t" + x.getStudent_year() + "\t\t" + x.getStudent_mobile() + "\n");
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
		frame = new JFrame("ALL STUDENTS:");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
	}
	
	public static void main(String[] args) {
        //new Showstudents();
    }

}
