package com.dao;

import java.util.List;

import com.dto.Student;

public interface StudentDao {
	public List<Student> listAllStudents();
	public Student addStudent(Student student);
	void deleteStudent(int stId);
	public List<Student> searchStudentsByClassId(int classId);
}
