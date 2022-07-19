package com.hb.annotations;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch {

	public static void main(String[] args) {	
		
		Student01 student01 = new Student01();
		Student01 student02 = new Student01();
		Student01 student03 = new Student01();
		
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
//		student01 = session.get(Student01.class, 1001);
//		student02 = session.get(Student01.class, 1002);
//		student03 = session.get(Student01.class, 1003);
//		System.out.println(student01);
		
		//Native query ile select islemi
		String query = "SELECT * FROM STUDENT01";
		
		//Listenin her bir elemani bir kayittir, ve elemanlar column'lardan olustugu icin Object Array icindeik
		// her bir element bir kolon bilgisi tutar.
		
		//Tum verileri almak icin 1.yol
		List <Object[]> resultList01 = session.createSQLQuery(query).getResultList();
		
		for(Object[] w: resultList01) {
			//System.out.println(Arrays.toString(w));
			System.out.println(w[0]);
		} 
		System.out.println("-------------");
		
		//2.Yol HQL (Hibernate Query Language)
		//Tablo adini class ismi ile kullanmak gerekiyor student01 yazilirsa hata alinir, bknz Student01:12
		//HQL Sorgularinda FROM'dan sonra Entity ismini kullaniyoruz.
		String hQuery = "FROM Student01";
		List<Student01> resultList02 = session.createQuery(hQuery).getResultList();
		
		for(Student01 w: resultList02) {
			System.out.println(w);
		}

		System.out.println("-------------");
		
		
		//Ismi John Coffee olan ogrenciyi getirelim
		String sqlQuery02 = "Select * FROM STUDENT01 WHERE name = 'John Cofee'";
		List <Object[]> resultList03 = session.createSQLQuery(sqlQuery02).getResultList();
		
		
		for(Object[] w: resultList03) {
			System.out.println(Arrays.toString(w));
		}

		System.out.println("-------------");

		//Eger sorgu sonucu unique bir sonuc doneceginden eminsek 
		Object[] arr = (Object[]) session.createSQLQuery(sqlQuery02).uniqueResult();
		System.out.println(Arrays.toString(arr));
		

		System.out.println("-------------");
		
		//HQL ile unique result dondurme alias ile
		String hqlQuery02 = "FROM Student01 s where s.name = 'John Cofee'";
		Object obj = session.createQuery(hqlQuery02).uniqueResult();
		
		System.out.println(obj);
		System.out.println("-------------");
		
		//Notu 100 olan ogrencileri HQL ile getimre
		String hqlQuery03 = "FROM Student01 s where s.grade=100";
		List<Object> resultList04 = session.createQuery(hqlQuery03).getResultList();
		
		for (Object w : resultList04) {
			System.out.println(w);
		}
		
		System.out.println("-------------");
		
		
		//Notu 100 olan ogrencilerin sadece isimlerini HQL ile getimre
		String hqlQuery04 = "select name from Student01 where grade=100";
		List<Object> resultList05 = session.createQuery(hqlQuery04).getResultList();
		
		for(Object w: resultList05) {
			System.out.println(w);
		}
		
		transaction.commit();
		
		session.close();
		sessionFactory.close();
	}

}
