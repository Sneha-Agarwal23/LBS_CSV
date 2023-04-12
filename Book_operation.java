package library;

import java.util.Scanner;

public class Book_operation {
	Book totalbooks[] = new Book[100];
	public static int count;
	
	Scanner sc = new Scanner(System.in);
	
	public int compareBook(Book b1, Book b2)
	{
		if(b1.book_name.equalsIgnoreCase(b2.book_name))
		{
			System.out.println("This book already exists in the Library.");
			System.out.println("Please find the Book ID and upgrade its count");
			return 0;
		}
		if(b1.book_id == b2.book_id)
		{
			System.out.println("This book already exists in the Library. Please update its count.");
			return 0;
		}
		return 1;
	}
	
	public void addBooks(Book b)
	{
		for(int i = 0; i < count; i++)
		{
			if(this.compareBook(b, this.totalbooks[i]) == 0)
				return;
		}
		if(count < 100)
		{
			totalbooks[count] = b;
			count++;
		}
		else
			System.out.println("No space left in the Library");
	}
	
	public void searchById()
	{
		System.out.println("\t\t\t\t Searching by Book Id\n");
		int id;
		System.out.println("Enter the Book ID");
		id = sc.nextInt();
		int flag = 0;
		System.out.println("ID\t\tName\t\tAuthor\t\tTotal Quantity\t\tAvailable Quantity");
		for(int i = 0; i < count; i++)
		{
			if(id == totalbooks[i].book_id)
			{
				System.out.println(
						totalbooks[i].book_id + "\t\t" 
						+ totalbooks[i].book_name + "\t\t"
						+ totalbooks[i].author_name + "\t\t"
						+ totalbooks[i].book_quantity + "\t\t"
						+ totalbooks[i].book_quantity_copy
						);
				flag++;
				return;
			}
		}
		if(flag == 0)
			System.out.println("No book found with ID : " + id);
	}
	
	public void searchByAuthor()
	{
		System.out.println("\t\t\t\t Searching by Author Name\n");
		String x;
		System.out.println("Enter the Author Name: ");
		x = sc.nextLine();
		int flag = 0;
		System.out.println("ID\t\tName\t\tAuthor\t\tTotal Quantity\t\tAvailable Quantity");
		for(int i = 0; i < count; i++)
		{
			if(x.equalsIgnoreCase(totalbooks[i].author_name))
			{
				System.out.println(
						totalbooks[i].book_id + "\t\t" 
						+ totalbooks[i].book_name + "\t\t"
						+ totalbooks[i].author_name + "\t\t"
						+ totalbooks[i].book_quantity + "\t\t"
						+ totalbooks[i].book_quantity_copy
						);
				flag++;
				return;
			}
		}
		if(flag == 0)
			System.out.println("No book found with the author name : " + x);
	}
	
	public void showAllBooks()
	{
		System.out.println("\t\t\t\t Books In The Library");
		System.out.println("ID\t\tName\t\tAuthor\t\tTotal Quantity\t\tAvailable Quantity");
		for(int i = 0; i < count; i++)
		{
			System.out.println(
					totalbooks[i].book_id + "\t\t" 
					+ totalbooks[i].book_name + "\t\t"
					+ totalbooks[i].author_name + "\t\t"
					+ totalbooks[i].book_quantity + "\t\t"
					+ totalbooks[i].book_quantity_copy
					);
		}
	}
	
	public void upgrade()
	{
		System.out.println("\t\t\t\t Upgrading the Quantity of Books");
		System.out.println("Enter the Book Id: ");
		int id;
		id = sc.nextInt();
		for(int i = 0; i < count; i++)
		{
			if(id == totalbooks[i].book_id)
			{
				System.out.println("Enter the number of books to be added: ");
				int x = sc.nextInt();
				totalbooks[i].book_quantity += x;
				totalbooks[i].book_quantity_copy += x;
				return;
			}
		}
	}
	
	public int isAvailable(int id)
	{
		for(int i = 0; i < count; i++)
		{
			if(id == totalbooks[i].book_id)
			{
				if(totalbooks[i].book_quantity_copy > 0)
				{
					System.out.println(totalbooks[i].book_quantity_copy + " Copies of " + totalbooks[i].book_name + " are available.");
					return i;
				}
				System.out.println("Book is out of stock");
				return -1;
			}
		}
		System.out.println("No such book with ID" +id + " is available in library");
		return -1;
	}
	
	public Book checkout()
	{
		int id;
		System.out.println("Enter the Book Id: ");
		id = sc.nextInt();
		int index = isAvailable(id);
		if(index != -1)
		{
			totalbooks[index].book_quantity_copy--;
			return totalbooks[index];
		}
		return null;
	}
	
	public void checkin(Book b)
	{
		for(int i = 0; i < count; i++)
		{
			if(b.equals(totalbooks[i]))
			{
				totalbooks[i].book_quantity_copy++;
				return;
			}
		}
	}
	
	public void studentMenu()
	{
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Press 0 : Exit");
		System.out.println("Press 1 : Search a book");
		System.out.println("Press 2 : To show all Books");
		System.out.println("Press 3 : To Register Student");
		System.out.println("Press 4 : To issue a book");
		System.out.println("Press 5 : To return a book");
		System.out.println("Press 6 : To display the books current student has issued");
		System.out.println("--------------------------------------------------------------------------");
	}
	
	public void adminMenu()
	{
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Press 0 : Exit");
		System.out.println("Press 1 : Add New Book");
		System.out.println("Press 2 : Update the Quantity of Book");
		System.out.println("Press 3 : Search a book");
		System.out.println("Press 4 : To show all Books");
		System.out.println("Press 5 : To show all Registered Students");
		System.out.println("--------------------------------------------------------------------------");
	}
}
