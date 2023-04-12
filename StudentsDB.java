package library;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
public class StudentsDB 
{
	public String filepath = "C:\\Users\\snaga\\eclipse-workspace\\library\\src\\library\\student.csv";
	public String issuepath = "C:\\Users\\snaga\\eclipse-workspace\\library\\src\\library\\issuedbooks.csv";
    
    public void addStudent(String n, String id, String stream, String yr, String mob) {
        Student s = new Student();
        s.setStudent_name(n);
        s.setStudent_id(id);
        s.setStudent_stream(stream);
        s.setStudent_year(Integer.parseInt(yr));
        s.setStudent_mobile(mob);
        
        FileWriter fw = null;
    	try {
    		fw = new FileWriter(filepath,true);
    		
    		//fw.append("NAME, ID, STREAM, YEAR, MOBILE NO, \n");
    		fw.append(s.getStudent_name());
    		fw.append(",");
    		fw.append(s.getStudent_id());
    		fw.append(",");
    		fw.append(s.getStudent_stream());
    		fw.append(",");
    		fw.append(String.valueOf(s.getStudent_year()));
    		fw.append(",");
    		fw.append(s.getStudent_mobile());
    		fw.append("\n");	
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		try {
    			fw.flush();
    			fw.close();
    		}
    		catch(Exception ex) {
    			ex.printStackTrace();
    		}
    	}
    }
    
    public void issueBook(String sid, String bid)
    {
    	Student cur = null;
    	BufferedReader br = null;
        try {
        	ArrayList<Student> st = new ArrayList<Student>();
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
        			st.add(x);
        		}
        	}
        	for(Student x : st)
        	{
        		if(x.getStudent_id().equalsIgnoreCase(sid))
        		{
        			cur = x;
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
    	BooksDB db = new BooksDB();
    	Book curb = db.searchBook(bid, "");
    	cur.updatelimit(-1);
    	int y = curb.getBook_quantity_copy();
    	curb.setupdateqty(y-1);
    	
    	FileWriter fw = null;
    	try {
    		fw = new FileWriter(issuepath,true);
    		
    		//fw.append("ID, BOOK NAME, AUTHOR NAME, TOTAL QUANTITY, AVAILABLE QUANTITY, \n");
    		fw.append(cur.getStudent_id());
    		fw.append(",");
    		fw.append(cur.getStudent_name());
    		fw.append(",");
    		fw.append(String.valueOf(curb.getBook_id()));
    		fw.append(",");
    		fw.append(curb.getBook_name());
    		fw.append("\n");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		try {
    			fw.flush();
    			fw.close();
    		}
    		catch(Exception ex) {
    			ex.printStackTrace();
    		}
    	}
    }
    
    public void returnbook(String sid, String bid)
    {
    	int r = Integer.parseInt(bid);
    	Student cur = null;
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
        			if(sid.equalsIgnoreCase(s[0]))
        			{
        				Student x = new Student();
            			Book b = new Book();
            			x.setStudent_id(s[0]);
            			x.setStudent_name(s[1]);
            			b.setBook_id(Integer.parseInt(s[2]));
            			b.setBook_name(s[3]);
            			st.add(b);
            			cur = x;
        			}
        		}
        	}
        	for(Book x : st)
        	{
        		if(x.getBook_id() == r)
        		{
        			int y = x.getBook_quantity_copy();
        			x.setupdateqty(y+1);
        		}
        	}
        	cur.updatelimit(1);
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
    }
    
    

}
