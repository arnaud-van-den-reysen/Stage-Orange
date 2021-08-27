package com.orange.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
// C'est quoi les bons imports? ça !
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Type;
import com.vladmihalcea.hibernate.type.json.JsonType;

import org.hibernate.annotations.GenericGenerator;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Arnaud VAN DEN REYSEN
 * @version (2021/07/08)
 */
@XmlRootElement
@Entity
@Table(name="product_json")//defini le nom de la table
@TypeDef(name = "json", typeClass = JsonType.class)
public class Test_json {
	
	@Id //Primary key
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int id;

	@Type(type = "json")
	@Column(name="json", columnDefinition ="json")
	private Jdoc jdoc;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jdoc getJdoc() {
		return jdoc;
	}

	public void setJdoc(Jdoc jdoc) {
		this.jdoc = jdoc;
	}

	public Test_json() {
		super();
	}
	
	public Test_json(Jdoc jdoc) {
		super();
		this.jdoc = jdoc;
	}

	public Test_json(Jdoc jdoc, int id) {
		super();
		this.jdoc = jdoc;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "{" + id + ", " + jdoc + "}";
	}
}
