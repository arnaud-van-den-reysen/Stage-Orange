package com.orange.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.GenericGenerator;

import com.vladmihalcea.hibernate.type.json.JsonType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Définition de la table Formulaire
 * @author Arnaud VAN DEN REYSEN
 */
@XmlRootElement
@Entity
// @Table(name="Formulaire")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Formulaire {

	/**
	 * PRIMARY KEY
	 */
    @Id
	@Column(unique = true, nullable = false)
    // @GeneratedValue(generator="increment")
	// @GenericGenerator(name="increment", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	/**
	 * 
	 */
	@OneToOne(
		mappedBy="formulaire",
		cascade=CascadeType.ALL,
		orphanRemoval = true
		//fetch = FetchType.LAZY
	)
	@JsonIgnore //evite les problemes de boucle serialization 
	private DataFormulaire dataFormulaire;
	
	/**
	 * JSON
	 */
    @Type(type = "json")
	@Column(name="formulaireJSON", columnDefinition ="json")
    private FormulaireJSON formulaireJSON;

	/**
	 * return PRIMARY KEY
	 * @return id
	 */
    public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * return DataFormulaire
	 * @return DataFormulaire
	 */
	public DataFormulaire getDataFormulaire() {
		return this.dataFormulaire;
	}

	public void setDataFormulaire(DataFormulaire dataFormulaire) {
		this.dataFormulaire = dataFormulaire;
	}

    public FormulaireJSON getFormulaireJSON() {
		return formulaireJSON;
	}

	public void setFormulaireJSON(FormulaireJSON formulaireJSON) {
		this.formulaireJSON = formulaireJSON;
	}

    public Formulaire() {

    }

    public Formulaire(FormulaireJSON formulaireJSON) {
        this.formulaireJSON = formulaireJSON;
    }

	public Formulaire(int id, FormulaireJSON formulaireJSON) {
		this.id = id;
        this.formulaireJSON = formulaireJSON;
    }

    @Override
	public String toString() {
		return "{" + id + ", " + formulaireJSON + "}";
	}

	/**
	 * Mapping Bidirectionnel OneToOne
	 * Associe un DataFormulaire à ce Formulaire
	 * @param dataFormulaire
	 */
	public void addDataFormulaire(DataFormulaire dataFormulaire) {
		dataFormulaire.setFormulaire(this);
		this.dataFormulaire = dataFormulaire;
	}

	/**
	 * Mapping Bidirectionnel OneToOne
	 * Remove le DataFormulaire associé à Formulaire
	 */
	public void removeDataFormulaire() {
		if ( dataFormulaire != null ) {
			dataFormulaire.setFormulaire(null);
			this.dataFormulaire = null;
		}
	}
}