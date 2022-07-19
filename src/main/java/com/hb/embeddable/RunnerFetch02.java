package com.hb.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
	
	public static void main(String[] args) {
		
		Student02 student01 = new Student02();
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		Transaction transaction = session.beginTransaction();
		
		student01 = session.get(Student02.class, 1000);
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		System.out.println(student01.toString());
	}

}
