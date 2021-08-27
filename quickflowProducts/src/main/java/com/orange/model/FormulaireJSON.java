package com.orange.model;

import java.util.ArrayList;

/**
 * @author Arnaud VAN DEN REYSEN
 */
public class FormulaireJSON {
    private int id;
    private String name;
    private ArrayList<String> formulaire;

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
    
    public ArrayList<String> getFormulaire() {
		return formulaire;
	}

	public void setFormulaire(ArrayList<String> formulaire) {
		this.formulaire = formulaire;
	}

    public FormulaireJSON() {

    }

    public FormulaireJSON(int id, String name, ArrayList<String> formulaire) {
        this.id = id;
        this.name = name;
        this.formulaire = formulaire;
    }

    @Override
	public String toString() {
		return "{" + id + ", " + name + ", " + formulaire + "}";
	}
}