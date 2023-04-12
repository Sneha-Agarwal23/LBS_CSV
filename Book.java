package library;

import java.util.Scanner;

public class Book {
	public int book_id;
	public String book_name;
	public String author_name;
	public int book_quantity;
	public int book_quantity_copy;

	Scanner sc = new Scanner(System.in);

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public int getBook_quantity() {
		return book_quantity;
	}
	
	public int getBook_quantity_copy() {
		return book_quantity_copy;
	}
	
	public void setupdateqty(int book_quantity_copy) {
		this.book_quantity_copy = book_quantity_copy;
	}

	public void setBook_quantity(int book_quantity) {
		this.book_quantity = book_quantity;
		this.book_quantity_copy = book_quantity;
	}
	
	

}