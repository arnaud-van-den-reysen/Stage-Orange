package com.orange.service;
 
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.orange.model.Formulaire;
import com.orange.model.DataFormulaire;

/**
 * @author arnaud VAN DEN REYSEN
 * Singleton
 * Gestion SessionFactory Hibernate
 */
public class HibernateUtil {

	private static volatile SessionFactory sessionFactory;

	static {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry )
				.addAnnotatedClass(Formulaire.class) //thanks vladmihalcea :D don't use hbm.xml files stupid!
				.addAnnotatedClass(DataFormulaire.class)
				.buildMetadata().buildSessionFactory();
			System.out.println("***************************");
            System.out.println("***************************");
			System.out.println("One Session Factory created");
			System.out.println("***************************");
			System.out.println("***************************");
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

	/**
	 * 
	 * @return Singleton SessionFactory
	 */
	public final static SessionFactory getSessionFactory()  {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
	}

	private HibernateUtil() {

	}

}