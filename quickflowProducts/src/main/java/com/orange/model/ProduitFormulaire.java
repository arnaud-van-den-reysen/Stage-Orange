package com.orange.model;

import com.orange.model.Destination;
import com.orange.model.Source;

/**
 * @author Arnaud VAN DEN REYSEN
 */
public class ProduitFormulaire {
    private String type;
    private Source source;
    private Destination destination;
    private String autreType;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Source getSource() {
        return this.source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getAutreType() {
        return this.autreType;
    }

    public void setAutreType(String autreType) {
        this.autreType = autreType;
    }

    public ProduitFormulaire() {
    }

    public ProduitFormulaire(String type, Source source) {
        this.type = type;
        this.source = source;
    }

    public ProduitFormulaire(String type, Destination destination) {
        this.type = type;
        this.destination = destination;
    }

    public ProduitFormulaire(String type, String autreType) {
        this.type = type;
        this.autreType = autreType;
    }

    @Override
    public String toString() {
        return "{" +
            " type='" + getType() + "'" +
            ", source='" + getSource() + "'" +
            ", destination='" + getDestination() + "'" +
            ", autreType='" + getAutreType() + "'" +
            "}";
    }  
}