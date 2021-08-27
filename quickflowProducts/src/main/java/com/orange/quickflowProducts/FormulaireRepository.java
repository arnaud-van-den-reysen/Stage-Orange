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

import com.orange.model.Formulaire;
import com.orange.service.HibernateUtil;

public class FormulaireRepository {
    /*
    GET /produits -> OK
    GET /produits/:id -> OK
    POST /produits -> OK?
    PUT /produits/:id -> OK
    DELETE /produits/:id -> OK
    PATCH /produits/:id -> NOK (Some browsers, servers and web app do not support it)
    */

	/**
	 * GET /produit
	 * @return list de la table Formulaire
	 */
    public List<Formulaire> getFormulaires() {
		List<Formulaire> data = new ArrayList<Formulaire>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			data = session.createQuery("FROM Formulaire",Formulaire.class).getResultList();//.list() is deprecated
			session.getTransaction().commit();
			session.close();
			System.out.println("GET Formulaire Hibernate:" + data);
			return data;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * GET /produit/:id
	 * @return list de la table Formulaire
	 */
    public Formulaire getFormulaire(int id) {
		try {
			Formulaire data = new Formulaire();
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			data = (Formulaire) session.get(Formulaire.class,id);
			session.getTransaction().commit();
			session.close();
			System.out.println("GET Formulaire " + id + " Hibernate:" + data);
			return data;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Créer une nouvelle donnée
	 * @param data
	 * @return
	 */
    public Formulaire create(Formulaire data) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(data);
			session.getTransaction().commit();
			session.close();
			System.out.println("SAVE Formulaire Hibernate:" + data);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Update la donnée choisi dans la table Formulaire
	 * @param data
	 */
    public void update(Formulaire data) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(data);
			session.getTransaction().commit();
			session.close();
			System.out.println("UPDATE Formulaire Hibernate:" + data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Supprime la donnée choisi dans table Formulaire
	 * @param data
	 */
    public void delete(Formulaire data) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(data);
			session.getTransaction().commit();
			session.close();
			System.out.println("DELETE Formulaire Hibernate:" + data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}