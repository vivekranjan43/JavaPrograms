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

import com.dto.Class1;

public class Class1DoaImp implements Class1Dao {
	
	private SessionFactory factory;
	
	public Class1DoaImp() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Class1> listAllClasses() {
		List<Class1> classes =null;
		Session session=factory.openSession();
		
		String hql="from Class1";
		
		TypedQuery<Class1> query= session.createQuery(hql);
		
		classes=query.getResultList();
		session.close();
		return classes;
	}

	@Override
	public Class1 addClass(Class1 class1) {
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		
		session.save(class1);
		
		trx.commit();
		session.close();
		return class1;

	}

	@Override
	public void updateClass1(Class1 class1) {
		Session session = factory.openSession();
		Transaction trx = session.beginTransaction();
		
		session.update(class1);
		
		trx.commit();
		session.close();
		
	}

	@Override
	public Class1 searchClass1ById(int id) {
		Session session  = factory.openSession();
		//Transaction txn = session.beginTransaction();
		String hql = "FROM Class1 e where e.id = "+ id;
		@SuppressWarnings("unchecked")
		TypedQuery<Class1> query = session.createQuery(hql);
		Class1 class1 = query.getSingleResult();
		session.close();
		return class1;
		
		
	}

	@Override
	public void deleteClass1(int classId) {
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		Class1 class1 = session.get(Class1.class, classId);
		session.delete(class1);
		txn.commit();
		session.close();
		
	}
	
	
	

}
