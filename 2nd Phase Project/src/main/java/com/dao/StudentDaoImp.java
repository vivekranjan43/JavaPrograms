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

import com.dto.Student;

public class StudentDaoImp implements StudentDao {
	
	private SessionFactory factory;
	
	public StudentDaoImp() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}

	@Override
	public List<Student> listAllStudents() {
		List<Student> students =null;
		Session session=factory.openSession();
		
		String hql="from Student";
		
		@SuppressWarnings("unchecked")
		TypedQuery<Student> query= session.createQuery(hql);
		
		students=query.getResultList();
		session.close();
		return students;
	}

	@Override
	public Student addStudent(Student student) {
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		
		session.save(student);
		
		trx.commit();
		session.close();
		return student;
	}

	@Override
	public void deleteStudent(int stId) {
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		Student student = session.get(Student.class, stId);
		session.delete(student);
		txn.commit();
		session.close();
		
		
	}

	@Override
	public List<Student> searchStudentsByClassId(int classId) {
		List<Student> students = null;
		Session session  = factory.openSession();
		//Transaction txn = session.beginTransaction();
		String hql = "FROM Student e where e.class1 = "+ classId;
		@SuppressWarnings("unchecked")
		TypedQuery<Student> query = session.createQuery(hql);
		students = query.getResultList();
		session.close();
		return students;
	}

}
