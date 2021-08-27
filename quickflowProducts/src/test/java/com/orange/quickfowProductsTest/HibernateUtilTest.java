package com.orange.quickfowProductsTest;
 
import java.util.ArrayList;
import java.util.List;
 
import org.hibernate.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import com.orange.service.HibernateUtil;
import com.orange.model.Formulaire;
import com.orange.model.FormulaireJSON;
 
public class HibernateUtilTest {

    private static SessionFactory sessionFactory;
    private Session session;

    @BeforeAll
    public static void initAll() {
        sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println("SessionFactory created!");
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed!");
    }

    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
        if (session == null) {
            System.out.println("Session failed");
        } else {
            System.out.println("Session created");
        }
    }
     
    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }   
     
    @Test
    public void testCreate() {
        System.out.println("Running testCreate...");

        session.beginTransaction();

        ArrayList<String> formulaireArray = new ArrayList<String>();
        formulaireArray.add("source");
        formulaireArray.add("enrichment");
        formulaireArray.add("destination");
        Formulaire formulaire = new Formulaire(new FormulaireJSON(1,"test",formulaireArray));

        Integer id = (Integer) session.save(formulaire);
        
        session.getTransaction().commit();
        
        assertTrue(id > 0);
    }

    @Test
    public void testUpdate() {
        System.out.println("Running testUpdate...");
     
        Integer id = 4;
        ArrayList<String> formulaireArray = new ArrayList<String>();
        formulaireArray.add("source");
        formulaireArray.add("destination");
        Formulaire formulaire = new Formulaire(4,new FormulaireJSON(2,"Transfert de fichier",formulaireArray));
        
        session.beginTransaction();
        session.update(formulaire);
        session.getTransaction().commit();
        
        Formulaire updatedFormulaire = session.find(Formulaire.class, id);
        
        assertEquals("Transfert de fichier", updatedFormulaire.getFormulaireJSON().getName());
    }
     
    @Test
    public void testGet() {
        System.out.println("Running testGet...");
     
        Integer id = 12;
        
        Formulaire formulaire = session.find(Formulaire.class, id);
        
        assertEquals("Test", formulaire.getFormulaireJSON().getName()); 
    }
     
    @Test
    public void testList() {
        System.out.println("Running testList...");
     
        List<Formulaire> resultList = session.createQuery("from Formulaire", Formulaire.class).getResultList();
        
        assertFalse(resultList.isEmpty());
    }
     
    @Test
    public void testDelete() {
        System.out.println("Running testDelete...");
     
        Integer id = 15;//modifier cette valeur
        Formulaire formulaire = session.find(Formulaire.class, id);
        
        session.beginTransaction();
        session.delete(formulaire);
        session.getTransaction().commit();
        
        Formulaire deletedFormulaire = session.find(Formulaire.class, id);
        
        assertNull(deletedFormulaire);
    }
}