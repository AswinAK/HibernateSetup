package com.aswin.hibernate;

import java.sql.DriverManager;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aswin.hibernate.entity.Student;

import java.sql.Connection;

public class HibernateUpdate {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student s where s.lastName ='Kumar'").getResultList();
			
			for(Student s: students)
				System.out.println(">> "+s);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
