package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dto.Subject;
import com.dto.Teacher;

public class TeacherDaoImp implements TeacherDao {
	
	private SessionFactory factory;
	
	public TeacherDaoImp() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> listAllTeachers() {
		List<Teacher> teachers =null;
		Session session=factory.openSession();
		
		String hql="from Teacher";
		
		TypedQuery<Teacher> query= session.createQuery(hql);
		
		teachers=query.getResultList();
		
		session.close();
		return teachers;
	}

	@Override
	public Teacher addTeacher(Teacher teacher) {
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		
		session.save(teacher);
		
		trx.commit();
		session.close();
		return teacher;
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTeacher(int teacherId) {
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		Teacher teacher = session.get(Teacher.class, teacherId);
		
		SubjectDaoImp subjectDoaImpObj= new SubjectDaoImp();
		List<Subject> subjects = null;
		subjects=subjectDoaImpObj.searchSubjectByTeacherId(teacherId);
		System.out.println("Test teacher delete" + subjects.size() +"teacherId: " +teacherId);
		for(int i=0;i<subjects.size();i++) {
			System.out.println(0);
			Subject subjectObj= new Subject();
			subjectObj=subjects.get(i);
			subjectObj.setTeacher(null);
			session.update(subjectObj);
			System.out.println(i);
			System.out.println(subjectObj.getSubjectName());
		}
		
		session.delete(teacher);
		txn.commit();
		session.close();
		
	}

	@Override
	public Teacher searchTeacherById(int id) {
		Session session  = factory.openSession();
		//Transaction txn = session.beginTransaction();
		String hql = "FROM Teacher e where e.id = "+ id;
		@SuppressWarnings("unchecked")
		TypedQuery<Teacher> query = session.createQuery(hql);
		Teacher teacher = query.getSingleResult();
		session.close();
		return teacher;
	}

}
