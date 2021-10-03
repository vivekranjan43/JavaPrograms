package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dto.User;
import com.util.HibernateUtil;

public class UserDaoImp implements UserDao {
	
	private SessionFactory factory;
	
	/*
	 * public UserDaoImp() { StandardServiceRegistry ssr = new
	 * StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	 * Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	 * factory = meta.getSessionFactoryBuilder().build(); }
	 */

	@Override
	public void addUser (User user) {
		
			Transaction transaction = null;
	        User validUser = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	        	session.beginTransaction();
	            // get an user object    

		
		
		session.save(user);
		session.getTransaction().commit();
		session.close();		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}	
	
	@Override
	public boolean validateUser(User user) {	
		
		Transaction transaction = null;
        User validUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            validUser = (User) session.createQuery("FROM User U WHERE U.userName = :userName").setParameter("userName", user.getUserName())
                .uniqueResult();

            if (user != null && validUser.getPassword().equals(user.getPassword())) {
                return true;
            }
            // commit transaction
            //transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                //transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
	}
	
}
