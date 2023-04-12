package library;

import java.util.Scanner;

public class Student_operations {
	Scanner sc = new Scanner(System.in);
	Student totalStudents[] = new Student[50];
	
	public static int count = 0;
	
	public void addStudent(Student s)
	{
		for(int i = 0; i < count; i++)
		{
			if(s.student_id.equalsIgnoreCase(totalStudents[i].student_id))
			{
				System.out.println("Student of ID" + s.student_id + "is already registered!");
				return;
			}
		}
		if(count <= 50)
		{
			totalStudents[count] = s;
			count++;
		}
	}
	
	public void showAllStudents()
	{
		System.out.println("Student Name\t\tStudent ID\t\tStream\t\tYear\t\tMobile No\t\t");
		for(int i = 0; i < count; i++)
		{
			System.out.println(
					totalStudents[i].student_name + "\t\t" 
					+ totalStudents[i].student_id + "\t\t"
					+ totalStudents[i].student_stream + "\t\t"
					+ totalStudents[i].student_year + "\t\t"
					+ totalStudents[i].student_mobile
					);
		}
	}
	
	public int isRegistered()
	{
		System.out.println("Enter Student ID :");
		String x = sc.nextLine();
		for(int i = 0; i < count; i++)
		{
			if(totalStudents[i].student_id.equalsIgnoreCase(x))
				return i;
		}
		System.out.println("Student is not registered. Please register before issuing the book!");
		return -1;
	}
	
	public void issueBook(Book_operation b)
	{
		int index = this.isRegistered();
		if(index != -1)
		{
			b.showAllBooks();
			Book x = b.checkout();
			if(x != null)
			{
				if(totalStudents[index].book_count >= 3)
				{
					System.out.println("Student can issue maximum of 3 books at a time.");
					return;
				}
				else
				{
					System.out.println("Book is issued.");
					totalStudents[index].issued_book[totalStudents[index].book_count] = x;
					totalStudents[index].book_count++;
					return;
				}
				
			}
			else
				System.out.println("Book not available.");
		}
	}
	
	public void returnBook(Book_operation b)
	{
		int index = this.isRegistered();
		if(index != -1)
		{
			System.out.println("ID\t\tBook Name\t\tAuthor Name");
			Student s = totalStudents[index];
			for(int i = 0; i < s.book_count; i++)
			{
				System.out.println(s.issued_book[i].book_id + "\t\t"
						+ s.issued_book[i].book_name +"\t\t"
						+ s.issued_book[i].author_name);
			}
			System.out.println("Enter the ID of the book you want to return: ");
			int x = sc.nextInt();
			for(int i = 0; i < s.book_count; i++)
			{
				if(x == s.issued_book[i].book_id)
				{
					b.checkin(s.issued_book[i]);
					s.issued_book[i] = null;
					s.book_count--;
					System.out.println("Book Returned. Thank You!!");
					return;
				}
			}
			System.out.println("Wrong Book ID entered.");
			
		}
	}
		
	public void display(Book_operation b)
	{
		int index = this.isRegistered();
		if(index != -1)
		{
			System.out.println("ID\t\tBook Name\t\tAuthor Name");
			Student s = totalStudents[index];
			for(int i = 0; i < s.book_count; i++)
			{
				System.out.println(s.issued_book[i].book_id + "\t\t"
						+ s.issued_book[i].book_name +"\t\t"
						+ s.issued_book[i].author_name);
			}
		}
	}
}

