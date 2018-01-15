package com.aswin.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aswin.hibernate.entity.Instructor;
import com.aswin.hibernate.entity.InstructorDetail;
import com.aswin.hibernate.entity.Student;

public class OneToOneDelete {
	
	public static void main(String args[]) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try{
			
			int id = 1;
			
			session.beginTransaction();
			
			Instructor toDelete = session.get(Instructor.class, 1);
			
			if(toDelete==null) {
				System.out.println("instructor not found");
				return;
			}
			
			session.delete(toDelete);
			
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("Done persisting instructor");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
