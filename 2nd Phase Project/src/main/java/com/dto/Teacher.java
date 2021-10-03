package com.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	public Teacher(String teacherName, String description) {
		this.teacherName=teacherName;
		this.description=description;
	}
	
	

	public Teacher() {
		super();
	}



	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	@Column(name="teacherName")
	private String teacherName;
	
	@Column(name="disc")
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="teacher")
	@OrderColumn(name="id")
	private List<Subject> subjects;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	

}
