package com.orange.quickflowProducts;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

import com.orange.model.Formulaire;
import com.orange.model.FormulaireJSON;
import com.orange.model.DataFormulaire;
import com.orange.model.DataFormulaireJSON;
import com.orange.quickflowProducts.FormulaireRepository;
import com.orange.quickflowProducts.DataFormulaireRepository;

@Path("/produits")
public class FormulaireResources {

    /*
    GET /produits -> OK
    GET /produits/:id -> OK
    POST /produits -> OK?
    PUT /produits/:id -> OK
    DELETE /produits/:id -> OK
    PATCH /produits/:id -> NOK (Some browsers, servers and web app do not support it)
    */

    FormulaireRepository repository = new FormulaireRepository();
	DataFormulaireRepository datarepo = new DataFormulaireRepository();

	/**
	 * GET /produits
	 * @return list des données Formulaire
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFormulaires() {
        System.out.println("/GET = " + repository.getFormulaires());
		List<Formulaire> tj = repository.getFormulaires();
		GenericEntity<List<Formulaire>> myEntity = new GenericEntity<List<Formulaire>> (tj) {};
		return Response.status(200)
			.entity(myEntity)
			.build();
    }

	/**
	 * GET /produits/:id
	 * @param id
	 * @return la donnée demandée de Formulaire
	 */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFormulaire(@PathParam("id") int id) {
		System.out.println("/GET/" + id + " = " + repository.getFormulaire(id));
        Formulaire tj = repository.getFormulaire(id);
		GenericEntity<Formulaire> myEntity = new GenericEntity<Formulaire> (tj) {};
		return Response.status(200)
			.entity(myEntity)
			.build();
    }

	/**
	 * CREATE Formulaire et DataFormulaire associé avec une PrimaryKeyJoinColumn 
	 * @param formulaireJSON
	 * @return
	 */
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createFormulaire(FormulaireJSON formulaireJSON) {
		System.out.println("adding ..."+formulaireJSON);
		Formulaire formulaire = new Formulaire(formulaireJSON);
		DataFormulaire dataFormulaire = new DataFormulaire(formulaireJSON);
		formulaire.addDataFormulaire(dataFormulaire);
		System.out.println("adding ..."+formulaire.getFormulaireJSON());
		repository.create(formulaire);
		// System.out.println("formulaire.getId(): " + formulaire.getId());
		// datarepo.create(dataFormulaire);
		GenericEntity<Formulaire> myEntity = new GenericEntity<Formulaire> (formulaire) {};
		return Response.status(201)
			.entity(myEntity)
            .build();
	}

	/**
	 * PUT /produits/:id
	 * @param id
	 * @param formulaire
	 * @return remplace la donnée choisi
	 */
    @PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateFormulaire(@PathParam("id") int id, Formulaire formulaire) {
		System.out.println("update ..."+formulaire);
		if(repository.getFormulaire(id).getId()==0) {
			repository.create(formulaire);
		} else {
			repository.update(formulaire);
		}
		GenericEntity<Formulaire> myEntity = new GenericEntity<Formulaire> (formulaire) {};
		return Response.status(200)
			.entity(myEntity)
            .build();
	}

	/**
	 * DELETE /produits/:id
	 * @param id
	 * @return Supprime la donnée choisi
	 */
    @DELETE
	@Path("/{id}")
	public Response deleteFormulaire(@PathParam("id") int id) {
		Formulaire formulaire = repository.getFormulaire(id);
		if(formulaire.getId()!=0) {
			System.out.println("/DELETE/" + id + " = " + repository.getFormulaire(id));
			repository.delete(repository.getFormulaire(id));
		}
		GenericEntity<Formulaire> myEntity = new GenericEntity<Formulaire> (formulaire) {};
		return Response.status(200)
			.entity(myEntity)
            .build();
	}
}