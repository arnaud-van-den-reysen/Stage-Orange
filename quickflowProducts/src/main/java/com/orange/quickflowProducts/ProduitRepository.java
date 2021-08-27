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

import com.orange.model.Produit;

/**
 * @author Arnaud Van Den Reysen
 */
public class ProduitRepository {

	private SessionFactory sessionFactory;

	public ProduitRepository()  {
		
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

	public List<Produit> getProduits() {
		List<Produit> pp = new ArrayList<Produit>();
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			pp = session.createQuery( "from Produit",Produit.class).list();
			session.getTransaction().commit();
			session.close();
			System.out.println(pp);
			return pp;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public Produit getProduit(int idprod) {
		try {
			Produit p = new Produit();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			p = (Produit) session.get(Produit.class,idprod);
			session.getTransaction().commit();
			session.close();
			System.out.println(p);
			return p;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void create(Produit p) {
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

	public void update(Produit p) {
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

	public void delete(Produit p) {
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
