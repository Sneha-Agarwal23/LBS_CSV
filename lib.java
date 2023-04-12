package library;

import java.util.Scanner;

public class lib {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Book_operation objb = new Book_operation();
		Student_operations objs = new Student_operations();
		
		int role;
		int choice;
		int searchChoice;
		do {
			System.out.println("Press 0 : To Exit");
			System.out.println("Press 1 : Student");
			System.out.println("Press 2 : Admin");
			role = sc.nextInt();
			switch(role)
			{
			case 0:
				System.exit(0);
				break;
			case 1:
				do {
					objb.studentMenu();
					choice = sc.nextInt();
					switch(choice)
					{
					case 0: 
						System.out.println("Thank You. Visit Again!!");
						break;
					
					case 1:
						System.out.println("Press 1 : To search a book with Book ID");
						System.out.println("Press 2 : To search a book with Author Name");
						searchChoice = sc.nextInt();
						if(searchChoice == 1)
							objb.searchById();
						else
							objb.searchByAuthor();
						break;
					
					case 2:
						objb.showAllBooks();
						break;
					
					case 3:
						Student s = new Student();
						objs.addStudent(s);
						break;
					
					case 4:
						objs.issueBook(objb);
						break;
					
					case 5:
						objs.returnBook(objb);
						break;
						
					case 6:
						objs.display(objb);
						break;
						
					default: System.out.println("Wrong Choice. Please enter the correct choice!");
						
					}
				}while(choice != 0);
				break;
			case 2:
				do {
					objb.adminMenu();
					choice = sc.nextInt();
					switch(choice)
					{
					case 0: 
						System.out.println("Thank You. Visit Again!!");
						break;
					case 1:
						Book b = new Book();
						objb.addBooks(b);
						break;
					
					case 2:
						objb.upgrade();
						break;
					
					case 3:
						System.out.println("Press 1 : To search a book with Book ID");
						System.out.println("Press 2 : To search a book with Author Name");
						searchChoice = sc.nextInt();
						if(searchChoice == 1)
							objb.searchById();
						else
							objb.searchByAuthor();
						break;
					
					case 4:
						objb.showAllBooks();
						break;
						
					case 5:
						objs.showAllStudents();
						break;
						
						
					default: System.out.println("Wrong Choice. Please enter the correct choice!");
					}
				}while(choice != 0);
				break;
			default:
				System.out.println("You don't belong here!");
			}
		}while(role != 0);
		
	}
}

