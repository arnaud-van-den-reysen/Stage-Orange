package com.orange.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Arnaud VAN DEN REYSEN
 */
@XmlRootElement
@Entity
@Table(name="produits")
public class Produit {
	
	@Id //Primary key
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int idprod;

	@Column(name="name")
	private String nameprod;

	@Column(name="description")
	private String description;
	
	public int getIdprod() {
		return idprod;
	}
	public void setIdprod(int idprod) {
		this.idprod = idprod;
	}
	public String getNameprod() {
		return nameprod;
	}
	public void setNameprod(String nameprod) {
		this.nameprod = nameprod;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Produit() {
		super();
	}
	
	
	public Produit(int idprod, String nameprod, String description) {
		super();
		this.idprod = idprod;
		this.nameprod = nameprod;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Produit [idprod=" + idprod + ", nameprod=" + nameprod + ", description=" + description + "]";
	}
	
	
	
}
