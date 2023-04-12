package library;

import java.util.Scanner;

public class Student {
	public String student_name;
	public String student_id;
	public String student_stream;
	public int student_year;
	public int limit;
	public String student_mobile;
	
	Scanner sc = new Scanner(System.in);

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
		limit = 3;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_stream() {
		return student_stream;
	}

	public void setStudent_stream(String student_stream) {
		this.student_stream = student_stream;
	}

	public int getStudent_year() {
		return student_year;
	}
	public void updatelimit(int x)
	{
		limit += x;
	}

	public void setStudent_year(int student_year) {
		this.student_year = student_year;
	}

	public String getStudent_mobile() {
		return student_mobile;
	}

	public void setStudent_mobile(String student_mobile) {
		this.student_mobile = student_mobile;
	}
	
	
	
	

}