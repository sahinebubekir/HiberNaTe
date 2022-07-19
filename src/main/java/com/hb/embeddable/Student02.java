package com.hb.embeddable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student02 {
	


	//@Id Annotasyonu altinda bulunan degiskeni ilgili tabloda primary key yapar
	@Id
	private int id;

	/*
	@Column(name = "student_name")
	 Eger tablodaki sutunun adini farkli bir isimle olusturmak istenirse name attribute'u ile yukaridaki
	 sekilde kullanilabilir.
	 */
	@Column(name = "student_name")
	private String name;
	
	private Course02 course02;
	
	@Column(name = "gano_grade")
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
		return "Student02 [id=" + id + ", name=" + name + ", course02=" + course02 + ", grade=" + grade + "]";
	}

	public Course02 getCourse02() {
		return course02;
	}

	public void setCourse02(Course02 course02) {
		this.course02 = course02;
	}
	
	
	
	
	


}
