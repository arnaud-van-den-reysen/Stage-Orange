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

import com.orange.model.DataFormulaire;
import com.orange.service.HibernateUtil;

/**
 * CRUD Hibernate DataFormulaire
 * @author Arnaud VAN DEN REYSEN
 */
public class DataFormulaireRepository {
    /*
    GET /dataformulaires
    GET /dataformulaires/:id 
    POST /dataformulaires
    PUT /dataformulaires/:id
    DELETE /dataformulaires/:id
    */

	/**
	 * Retourne une liste de l'ensemble des columnes de la tables DataFormulaire
	 * @return List<DataFormulaire> 
	 */
    public List<DataFormulaire> getDataFormulaires() {
		List<DataFormulaire> data = new ArrayList<DataFormulaire>();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			data = session.createQuery("FROM DataFormulaire",DataFormulaire.class).getResultList();//.list() is deprecated
			session.getTransaction().commit();
			session.close();
			System.out.println("GET DataFormulaire Hibernate:" + data);
			return data;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Retourne la columne choisi de la table DataFormulaire
	 * GET DataFormulaire
	 * @param id
	 * @return DataFormulaire
	 */
    public DataFormulaire getDataFormulaire(int id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			DataFormulaire data = (DataFormulaire) session.get(DataFormulaire.class,id);
			session.getTransaction().commit();
			session.close();
			System.out.println("GET DataFormulaire " + id + " Hibernate:" + data);
			return data;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * GET DataFormulaire selon la FOREIGN KEY associé avec Formulaire
	 * @param id
	 * @return DataFormulaire
	 */
	public DataFormulaire getFormulaireDataFormulaire(int id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			DataFormulaire data = session.createQuery("FROM DataFormulaire DF WHERE DF.formulaire.id=:id",DataFormulaire.class)
				.setParameter("id", id)
				.getSingleResult();
			session.getTransaction().commit();
			session.close();
			System.out.println("GET DataFormulaire " + id + " Hibernate:" + data);
			return data;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Créer une nouvelle columne dans la table DataFormulaire
	 * @param data
	 */
    public void create(DataFormulaire data) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(data);
			session.getTransaction().commit();
			session.close();
			System.out.println("SAVE DataFormulaire Hibernate:" + data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Modifie la columne choisi dans la table DataFormulaire
	 * @param data
	 */
    public void update(DataFormulaire data) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(data);
			session.getTransaction().commit();
			session.close();
			System.out.println("UPDATE DataFormulaire Hibernate:" + data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Supprime la column choisi dans la table DataFormulaire
	 * @param data
	 */
    public void delete(DataFormulaire data) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(data);
			session.getTransaction().commit();
			session.close();
			System.out.println("DELETE DataFormulaire Hibernate:" + data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}