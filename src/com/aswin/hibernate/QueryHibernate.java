package com.aswin.hibernate;

import java.sql.DriverManager;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aswin.hibernate.entity.Student;

import java.sql.Connection;

public class QueryHibernate {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			session.beginTransaction();
			
			Student student = session.get(Student.class, 3);
			
			student.setFirstName("Foo");
			
			session.getTransaction().commit();
			
			
			
			//batch update
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("update Student set email = 'test@tt.com'").executeUpdate();
			
			session.getTransaction().commit();
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
