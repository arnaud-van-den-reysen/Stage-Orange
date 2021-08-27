package com.orange.model;

import java.util.ArrayList;

import com.orange.model.FormulaireJSON;
import com.orange.model.ProduitFormulaire;
import com.orange.model.Source;
import com.orange.model.Destination;

/**
 * @author Arnaud VAN DEN REYSEN
 */
public class DataFormulaireJSON {
    private int id;
    private String name;
    private ArrayList<ProduitFormulaire> produitFormulaire;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    public ArrayList<ProduitFormulaire> getProduitFormulaire() {
		return produitFormulaire;
	}

	public void setProduitFormulaire(ArrayList<ProduitFormulaire> produitFormulaire) {
		this.produitFormulaire = produitFormulaire;
	}

    public DataFormulaireJSON() {

    }

    public DataFormulaireJSON(int id, String name, ArrayList<ProduitFormulaire> produitFormulaire) {
        this.id = id;
        this.name = name;
        this.produitFormulaire = produitFormulaire;
    }

    public DataFormulaireJSON(FormulaireJSON formulaireJSON) {
        this.id = formulaireJSON.getId();
        this.name = formulaireJSON.getName();
        ArrayList<ProduitFormulaire> newProduitForm = new ArrayList<ProduitFormulaire>();
        System.out.println("formulaireJSON: " + formulaireJSON.getFormulaire());
        for(int i = 0; i < formulaireJSON.getFormulaire().size(); i++) {
            if (formulaireJSON.getFormulaire().get(i).equals("source")) {
                System.out.println("if source == ? : " + formulaireJSON.getFormulaire().get(i));
                newProduitForm.add(new ProduitFormulaire(formulaireJSON.getFormulaire().get(i),new Source("hostname-source","login-source","pwd-source")));
            } else if(formulaireJSON.getFormulaire().get(i).equals("destination")) {
                System.out.println("if destination == ? : " + formulaireJSON.getFormulaire().get(i));
                newProduitForm.add(new ProduitFormulaire(formulaireJSON.getFormulaire().get(i),new Destination("hostname-destination","login-destination","pwd-destination")));
            } else {
                System.out.println("if autre == ? : " + formulaireJSON.getFormulaire().get(i));
                newProduitForm.add(new ProduitFormulaire(formulaireJSON.getFormulaire().get(i),"autreType"));
            }
            
        }
        this.produitFormulaire = newProduitForm;
    }

    @Override
	public String toString() {
		return "{" + id + ", " + name + ", " + produitFormulaire + "}";
	}
}