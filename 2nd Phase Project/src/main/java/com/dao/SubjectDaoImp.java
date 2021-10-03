package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Transaction;

import com.dto.Subject;

public class SubjectDaoImp implements SubjectDao {
	
	private SessionFactory factory;
	
	public SubjectDaoImp() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}

	@Override
	public List<Subject> listAllSubjects() {
		List<Subject> subjects =null;
		Session session=factory.openSession();
		
		String hql="from Subject";
		
		@SuppressWarnings("unchecked")
		TypedQuery<Subject> query= session.createQuery(hql);
		
		subjects=query.getResultList();
		session.close();
		return subjects;
	}

	@Override
	public Subject addSubject(Subject subject) {
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		
		session.save(subject);
		
		trx.commit();
		session.close();
		return subject;
	}

	@Override
	public void updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubject(int subjectId) {
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		Subject subject = session.get(Subject.class, subjectId);
		session.delete(subject);
		txn.commit();
		session.close();
		
	}

	@Override
	public Subject searchSubjectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subject>  searchSubjectByTeacherId(int teacherId) {
		List<Subject> subjects = null;
		Session session  = factory.openSession();
		//Transaction txn = session.beginTransaction();
		String hql = "FROM Subject e where e.teacher = "+ teacherId;
		@SuppressWarnings("unchecked")
		TypedQuery<Subject> query = session.createQuery(hql);
		subjects = query.getResultList();
		session.close();
		return subjects;
	}

	@Override
	public List<Subject> searchSubjectsByClassId(int classId) {
		List<Subject> subjects = null;
		Session session  = factory.openSession();
		//Transaction txn = session.beginTransaction();
		String hql = "FROM Subject e where e.class1 = "+ classId;
		@SuppressWarnings("unchecked")
		TypedQuery<Subject> query = session.createQuery(hql);
		subjects = query.getResultList();
		session.close();
		return subjects;
	}
	
}
