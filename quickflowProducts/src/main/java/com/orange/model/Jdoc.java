package com.orange.model;

/**
 * @author Arnaud VAN DEN REYSEN
 */
public class Jdoc {
    private int idprod;
    private String nameprod;
    private String description;

    public int getIdprod() {
        return idprod;
    }

    public String getNameprod() {
        return nameprod;
    }

    public String getDescription() {
        return description;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public void setNameprod(String nameprod) {
        this.nameprod = nameprod;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Jdoc() {

    }

    public Jdoc(int idprod, String namedprod, String description) {
        this.idprod = idprod;
        this.nameprod = nameprod;
        this.description = description;
    }

    @Override
	public String toString() {
		return "{" + idprod + ", " + nameprod + ", " + description + "}";
	}
}