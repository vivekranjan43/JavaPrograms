package com.dao;

import java.util.List;

import com.dto.Teacher;

public interface TeacherDao {
	public List<Teacher> listAllTeachers();
	public Teacher addTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher);
	public void deleteTeacher(int teacherId);
	public Teacher searchTeacherById(int id);
}
