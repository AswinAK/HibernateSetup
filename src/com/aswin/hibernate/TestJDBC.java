package com.aswin.hibernate;

import java.sql.DriverManager;

import java.sql.Connection;

public class TestJDBC {

	public static void main(String[] args) {
		
		String url ="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String userName="root";
		String password="ncsudb123";
		
		try{
			Connection conn = DriverManager.getConnection(url,userName,password);
			System.out.println("connection successful...");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
