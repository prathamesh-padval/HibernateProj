package com.dev.util;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dev.model.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory=null;
	
	static {
		try {
			loadSessionFactory();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loadSessionFactory() {
		Configuration configuration=new Configuration();
		configuration.configure("/hibernate.cfg.xml");
		configuration.addAnnotatedClass(Employee.class);
		ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory=configuration.buildSessionFactory(srvcReg);
//		sessionFactory =new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();	
	}
	
	public static Session getSession() throws HibernateException{
		Session session=null;
		try{
			session=sessionFactory.openSession();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if (session==null) {
			System.err.println("Session is null");
		}
		
		return session;
	}
}
