package com.hb.annotations;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerSave {
	
	public static void main(String[] args) {
		
		Student01 student01 = new Student01();
		student01.setId(1001);
		student01.setName("John Cofee");
		student01.setGrade(100);
		
		Student01 student02 = new Student01();
		student02.setId(1002);
		student02.setName("Walter White");
		student02.setGrade(9999);
		
		Student01 student03 = new Student01();
		student03.setId(1003);
		student03.setName("Maximus Decimus");
		student03.setGrade(90);
		
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.save(student01);
		session.save(student02);
		session.save(student03);
		
		
		transaction.commit();
	

		session.close();
		sessionFactory.close();
	}

}
