package com.orange.quickfowProductsTest;

import java.util.ArrayList;
import java.util.List;
 
import org.hibernate.*;
import org.hibernate.query.*;
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
import com.orange.model.ProduitFormulaire;
import com.orange.model.Source;
import com.orange.quickflowProducts.DataFormulaireRepository;
import com.orange.model.DataFormulaire;
import com.orange.model.DataFormulaireJSON;

public class DataFormulaireRepositoryTest {

    private DataFormulaireRepository dataFormulaireRepository = new DataFormulaireRepository();

    @Test
    public void testGetDataFormulaires() {
        System.out.println("Running testGetDataFormulaires...");
        
        assertFalse(dataFormulaireRepository.getDataFormulaires().isEmpty());
    }

    @Test
    public void testGetDataFormulaire() {
        System.out.println("Running testGetDataFormulaire...");
        
        assertEquals(1025,dataFormulaireRepository.getDataFormulaire(1).getDataFormulaireJSON().getId());
    }

    @Test
    public void testUpdate() {
        System.out.println("Running testGetDataFormulaire...");

        ArrayList<ProduitFormulaire> produitFormulaire = new ArrayList<ProduitFormulaire>();
        produitFormulaire.add(new ProduitFormulaire("source",new Source("orange","ici","vdr")));
        produitFormulaire.add(new ProduitFormulaire("destination",new Source("ga","thoa","stop")));

        DataFormulaire dataFormulaire = new DataFormulaire(new DataFormulaireJSON(140,"Test pour Update",produitFormulaire));

        assertEquals("Test pour Update",dataFormulaire.getDataFormulaireJSON().getName());
    }
}