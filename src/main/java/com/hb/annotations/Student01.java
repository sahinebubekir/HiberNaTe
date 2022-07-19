package com.hb.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Veri tabaninda bir tablo karsiligi oldugunu gosterir

//@Entity anotasyonuna name ile bir deger verirseniz tablo isminiz ve sorgularda kullanacaginiz entity ismi verilen isim olacaktir
//@Entity(name = "student01")
@Entity
//Table anotasyonunun name properties'i olusturulacak tablonun ismini belirler
//@Table(name = "tbl_student1")
public class Student01 {

	//@Id Annotasyonu altinda bulunan degiskeni ilgili tabloda primary key yapar
	@Id
	private int id;

	/*
	@Column(name = "student_name")
	 Eger tablodaki sutunun adini farkli bir isimle olusturmak istenirse name attribute'u ile yukaridaki
	 sekilde kullanilabilir.
	 */
	@Column
	private String name;
	
	@Column
	private int grade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student01 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
	
	
	
	
}
