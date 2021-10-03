package com.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	@Column(name="student_fname")
	private String studentFirstName;
	
	@Column(name="student_lname")
	private String studentLastName;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="class_id", foreignKey=@ForeignKey(name="class_id_foreign"))
	private Class1 class1;
	
	
	public Student(){
		
	}
	
	public Student(String studentFirstName,String studentLastName){
		this.studentFirstName=studentFirstName;
		this.studentLastName=studentLastName;
	}

	public Student(String fname, String lname, Class1 class1) {
		// TODO Auto-generated constructor stub
		this.studentFirstName=fname;
		this.studentLastName=lname;
		this.class1=class1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public Class1 getClass1() {
		return class1;
	}

	public void setClass1(Class1 class1) {
		this.class1 = class1;
	}
	
	

}
