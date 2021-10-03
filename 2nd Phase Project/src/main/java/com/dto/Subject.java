package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	@Column(name="subjectName")
	private String subjectName;
	@Column(name="disc")
	private String description;
	@ManyToOne
	@JoinColumn(name="classId")
	private Class1 class1;
	@ManyToOne
	@JoinColumn(name="teacherId")
	private Teacher teacher;
	
	
	public Subject(){
		
	}
	public Subject(String subjectName,String description, Class1 class1, Teacher teacher){
		this.subjectName=subjectName;
		this.description=description;
		this.class1=class1;
		this.teacher=teacher;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Class1 getClass1() {
		return class1;
	}
	public void setClass1(Class1 class1) {
		this.class1 = class1;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
}
