package com.hb.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

	public static void main(String[] args) {
		
		Course02 course01 = new Course02();
		course01.setElective("Almanca, Ingilizce, Muzik");
		course01.setMandatory("Matematik, Turkce, Fizik");
		
		Student02 student01 = new Student02();
		student01.setId(1000);
		student01.setGrade(55);
		student01.setName("Ebubekir");
		student01.setCourse02(course01);
		
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		Transaction transaction = session.beginTransaction();
		
		session.save(student01);
		
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

}
