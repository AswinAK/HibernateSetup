package com.aswin.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aswin.hibernate.entity.Instructor;
import com.aswin.hibernate.entity.InstructorDetail;
import com.aswin.hibernate.entity.Student;

public class OneToOneDemo {
	
	public static void main(String args[]) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try{
			Instructor newInstructor = new Instructor("Joey", "Trib", "jtrib@abc.com");
			
			InstructorDetail detail = new InstructorDetail("www.joey.com","food");
			
			newInstructor.setInstructorDetail(detail);
			
			session.beginTransaction();
			
			session.save(newInstructor);
			
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
