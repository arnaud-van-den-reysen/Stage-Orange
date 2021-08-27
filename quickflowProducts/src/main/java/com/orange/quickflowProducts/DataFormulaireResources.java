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

import com.orange.model.DataFormulaire;
import com.orange.model.DataFormulaireJSON;
import com.orange.quickflowProducts.DataFormulaireRepository;

@Path("/dataFormulaire")
public class DataFormulaireResources {

    /*
	GET /dataFormulaire -> OK
    GET /dataFormulaire/:id -> OK
	GET /dataFormulaire/formulaire/:id -> OK
    POST /dataFormulaire -> OK
    PUT /dataFormulaire/:id -> OK
    DELETE /dataFormulaire/:id -> OK 
    */

	DataFormulaireRepository repository = new DataFormulaireRepository();

	/**
	 * Retourne la liste des données DataFormulaire
	 * GET /dataFormulaire
	 * @return 200 si OK
	 */
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDataFormulaires() {
        System.out.println("/GET = " + repository.getDataFormulaires());
		List<DataFormulaire> tj = repository.getDataFormulaires();
		GenericEntity<List<DataFormulaire>> myEntity = new GenericEntity<List<DataFormulaire>> (tj) {};
		return Response.status(200)
			.entity(myEntity)
			.build();
    }

	/**
	 * Retourne la données DataFormulaire choisi
	 * GET /dataFormulaire/:id
	 * @return 200 si OK
	 */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDataFormulaire(@PathParam("id") int id) {
		System.out.println("/GET/" + id + " = " + repository.getDataFormulaire(id));
        DataFormulaire tj = repository.getDataFormulaire(id);
		GenericEntity<DataFormulaire> myEntity = new GenericEntity<DataFormulaire> (tj) {};
		return Response.status(200)
			.entity(myEntity)
			.build();
    }

	/**
	 * Retourne la données DataFormulaire associé avec la FK choisi
	 * GET /dataFormulaire/formulaire/:id
	 * @return 200 si OK
	 */
	@GET
    @Path("/formulaire/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFormulaireDataFormulaire(@PathParam("id") int id) {
		System.out.println("/GET/" + id + " = " + repository.getFormulaireDataFormulaire(id));
        DataFormulaire tj = repository.getFormulaireDataFormulaire(id);
		GenericEntity<DataFormulaire> myEntity = new GenericEntity<DataFormulaire> (tj) {};
		return Response.status(200)
			.entity(myEntity)
			.build();
    }

	/**
	 * Créer la données dans la table DataFormulaire
	 * POST /dataFormulaire
	 * @return 201 si OK
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createDataFormulaire(DataFormulaire dataFormulaire) {
		System.out.println("adding ..."+dataFormulaire);
		repository.create(dataFormulaire);
		return Response.status(201)
            .build();
	}

	/**
	 * Modifie la données choisi dans la table DataFormulaire
	 * PUT /dataFormulaire
	 * @return 200 si OK
	 */
    @PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDataFormulaire(@PathParam("id") int id, DataFormulaire dataFormulaire) {
		System.out.println("update ..."+dataFormulaire);
		if(repository.getDataFormulaire(id).getId()==0) {
			repository.create(dataFormulaire);
		} else {
			repository.update(dataFormulaire);
		}
		return Response.status(200)
            .build();
	}

	/**
	 * Supprime la données choisi dans la table DataFormulaire
	 * PUT /dataFormulaire
	 * @return 200 si OK
	 */
	@DELETE
	@Path("/{id}")
	public Response deleteDataFormulaire(@PathParam("id") int id) {
		DataFormulaire dataFormulaire = repository.getDataFormulaire(id);
		if(dataFormulaire.getId()!=0) {
			System.out.println("/DELETE/" + id + " = " + repository.getDataFormulaire(id));
			repository.delete(repository.getDataFormulaire(id));
		}
		return Response.status(200)
            .build();
	}
}