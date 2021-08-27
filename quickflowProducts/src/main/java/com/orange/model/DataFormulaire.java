package com.orange.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.GenerationType;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.GenericGenerator;

import com.vladmihalcea.hibernate.type.json.JsonType;

import javax.xml.bind.annotation.XmlRootElement;

import com.orange.model.FormulaireJSON;

/**
 * @author Arnaud VAN DEN REYSEN
 */
@XmlRootElement
@Entity
@TypeDef(name = "json", typeClass = JsonType.class)
public class DataFormulaire {

	/**
	 * Cette façon de créer un increment ID permet d'éviter d'avoir une table supplémentaire pour l'incrémentation (l'autre aussi bizarrement)
	 */
    @Id
	@Column(unique = true, nullable = false)
    // @GeneratedValue(generator="increment")
	// @GenericGenerator(name="increment", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	/**
	 * FetchType.LAZY permet d'éviter le problème N+1 query qui fait qu'il y a un appel de toute les jointures plutôt que seule celles nécessaires.
	 * Problème qui n'arrive pas avec la logique OneToOne bidirectionnel
	 * PrimaryKeyJoinColumn Hibernate one to one mapping with shared primary key : car ça permet de plus facilement gérer les routes Angular quand on veut Formulaire et DataFormulaire
	 * 
	 */
	@OneToOne /*(fetch = FetchType.LAZY)*/
	@JoinColumn(name="formulaire_id")
	// @PrimaryKeyJoinColumn
	private Formulaire formulaire;

    @Type(type = "json")
	@Column(name="dataFormulaireJSON", columnDefinition ="json")
    private DataFormulaireJSON dataFormulaireJSON;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Formulaire getFormulaire() {
		return this.formulaire;
	}

	public void setFormulaire(Formulaire formulaire) {
		this.formulaire = formulaire;
	}

    public DataFormulaireJSON getDataFormulaireJSON() {
		return dataFormulaireJSON;
	}

	public void setDataFormulaireJSON(DataFormulaireJSON dataFormulaireJSON) {
		this.dataFormulaireJSON = dataFormulaireJSON;
	}

    public DataFormulaire() {

    }

	/**
	 * 
	 * @param dataFormulaireJSON
	 */
    public DataFormulaire(DataFormulaireJSON dataFormulaireJSON) {
        this.dataFormulaireJSON = dataFormulaireJSON;
    }

	/**
	 * 
	 * @param id
	 * @param dataFormulaireJSON
	 */
	public DataFormulaire(int id, DataFormulaireJSON dataFormulaireJSON) {
		this.id = id;
        this.dataFormulaireJSON = dataFormulaireJSON;
    }

	/**
	 * 
	 * @param formulaireJSON
	 */
	public DataFormulaire(FormulaireJSON formulaireJSON) {
		this.dataFormulaireJSON = new DataFormulaireJSON(formulaireJSON);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", formulaire='" + getFormulaire() + "'" +
			", dataFormulaireJSON='" + getDataFormulaireJSON() + "'" +
			"}";
	}
	
}