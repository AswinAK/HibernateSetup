package com.aswin.hibernate;

import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aswin.hibernate.entity.Student;

import java.sql.Connection;

public class TestHibernate {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			Student studOne = new Student("Daffy","Duck","dd@ncsu.edu");
			
			session.beginTransaction();
			
			session.save(studOne);
			
			session.getTransaction().commit();

			System.out.println("Student saved with ID "+studOne.getId());
			
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student retrievedStudent = session.get(Student.class, studOne.getId());
			
			System.out.println("Retrieved student is "+retrievedStudent);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
