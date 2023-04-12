package library;
import java.util.*;
import java.io.*;
public class BooksDB {
	public String filepath = "C:\\Users\\snaga\\eclipse-workspace\\library\\src\\library\\book.csv";
	//BooksDB db = new BooksDB(); 
    public void addBook(String id, String bname, String aname, String qty) 
    {
    	Book b = new Book();
    	b.setBook_id(Integer.parseInt(id));
    	b.setBook_name(bname);
    	b.setAuthor_name(aname);
    	b.setBook_quantity(Integer.parseInt(qty));
    	
    	FileWriter fw = null;
    	//BufferedWriter fw = null;
    	try {
    		fw = new FileWriter(filepath,true);
    		
    		//fw.append("ID, BOOK NAME, AUTHOR NAME, TOTAL QUANTITY, AVAILABLE QUANTITY, \n");
    		fw.append(String.valueOf(b.getBook_id()));
    		fw.append(",");
    		fw.append(b.getBook_name());
    		fw.append(",");
    		fw.append(b.getAuthor_name());
    		fw.append(",");
    		fw.append(String.valueOf(b.getBook_quantity()));
    		fw.append(",");
    		fw.append(String.valueOf(b.getBook_quantity_copy()));
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
    
    public void updatebookqty(String name, String i, String qty)
    {
    	//BooksDB db = new BooksDB();
    	Book b = null;
    	int id = Integer.parseInt(i);
    	ArrayList<Book> allbook = new ArrayList<Book>();
    	BufferedReader br = null;
    	try {
        	
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
        			allbook.add(x);
        		}
        	}
        	
        	for(Book x : allbook)
        	{
        		if(x.getBook_id() == id && x.getBook_name().equalsIgnoreCase(name))
        		{
        			b = x;
        			int q = b.getBook_quantity();
        	    	int qt = Integer.parseInt(qty);
        	    	q += qt;
        	    	x.setBook_quantity(q);
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
    	
    	
    	FileWriter fw = null;
    	try {
    		fw = new FileWriter(filepath,true);

    		//fw.write(String.valueOf(b.getBook_id()) + "," + b.getBook_name() + "," + b.getAuthor_name() + "," + String.valueOf(b.getBook_quantity()) + "," + String.valueOf(b.getBook_quantity_copy())+ "\n");
    		
    		//fw.append("ID, BOOK NAME, AUTHOR NAME, TOTAL QUANTITY, AVAILABLE QUANTITY, \n");
    		for(Book x : allbook)
    		{
    			fw.append(String.valueOf(x.getBook_id()));
        		fw.append(",");
        		fw.append(x.getBook_name());
        		fw.append(",");
        		fw.append(x.getAuthor_name());
        		fw.append(",");
        		fw.append(String.valueOf(x.getBook_quantity()));
        		fw.append(",");
        		fw.append(String.valueOf(x.getBook_quantity_copy()));
        		fw.append("\n");
    		}
    		
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
    
    public Book searchBook(String i, String n)
    {
    	Book b = null;
    	int id = Integer.parseInt(i);
    	BufferedReader br = null;
    	try {
        	ArrayList<Book> allbook = new ArrayList<Book>();
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
        			allbook.add(x);
        		}
        	}
        	
        	for(Book x : allbook)
        	{
        		if(x.getBook_id() == id || x.getBook_name().equalsIgnoreCase(n))
        		{
        			b = x;
        			break;
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
    	return b;
    }
    

}
