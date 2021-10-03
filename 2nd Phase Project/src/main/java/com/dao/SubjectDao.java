package com.dao;

import java.util.List;

import com.dto.Subject;

public interface SubjectDao {
	public List<Subject> listAllSubjects();
	public Subject addSubject(Subject subject);
	public void updateSubject(Subject subject);
	public void deleteSubject(int subjectId);
	public Subject searchSubjectById(int id);
	public List<Subject> searchSubjectByTeacherId(int teacherId);
	public List<Subject> searchSubjectsByClassId(int classId);

}
