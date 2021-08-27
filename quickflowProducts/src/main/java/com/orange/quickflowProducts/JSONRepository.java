package com.orange.quickflowProducts;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.Metadata;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;

import com.orange.model.Test_json;

/**
 * @author Arnaud VAN DEN REYSEN
 * @version (2021/07/08)
 */
public class JSONRepository{
	private SessionFactory sessionFactory;
	public JSONRepository()  {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry )
				.addAnnotatedClass(Test_json.class) //thanks vladmihalcea :D don't use hbm.xml files stupid!
				.buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

	public List<Test_json>  getTest_jsons() {
		List<Test_json> pp = new ArrayList<Test_json>();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			pp = session.createQuery( "FROM Test_json T",Test_json.class).getResultList();//.list() is deprecated
			session.getTransaction().commit();
			session.close();
			return pp;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public Test_json getTest_json(int id) {
		try {
			Test_json p = new Test_json();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			p = (Test_json) session.get(Test_json.class,id);
			session.getTransaction().commit();
			session.close();
			System.out.println(p);
			return p;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void create(Test_json p) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
			session.close();
			System.out.println(p);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(Test_json p) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
			session.close();
			System.out.println(p);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void delete(Test_json p) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(p);
			session.getTransaction().commit();
			session.close();
			System.out.println(p);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
