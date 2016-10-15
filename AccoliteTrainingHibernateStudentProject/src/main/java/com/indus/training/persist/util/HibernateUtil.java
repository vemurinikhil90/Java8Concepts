package com.indus.training.persist.util;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
	
			File file=new File("C://IndusValley//Training//JEEUILayer//AccoliteTrainingHibernateStudentProject//src//main//resources//hibernate.cfg.xml");
			
			Configuration configuration = new Configuration().configure(file);
			ServiceRegistryBuilder builder = new ServiceRegistryBuilder().
			applySettings(configuration.getProperties());
			SessionFactory factory = configuration.buildSessionFactory(builder.buildServiceRegistry());
			
			return factory;	
			// Create the SessionFactory from hibernate.cfg.xml
			//return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
