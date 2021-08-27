package com.orange.quickflowProducts;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.orange.model.Produit;

@Path("/v1/produits")
public class ProduitResources {

	/*
	GET /v1/produits
	GET /v1/produits/produit/:idprod
	POST /v1/produits/produit
	PUT /v1/produits/produit
	DELETE /v1/produits/produit/:idprod
	*/
	
	ProduitRepository repo = new ProduitRepository();

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Produit>/*Response*/ getProduits() {
		System.out.println("Getting product...");
		// return Response.ok()
		// 			.entity(repo.getProduits())
		// 			.header("Access-Control-Allow-Origin","*")
		// 			.build();
		return repo.getProduits();
	}
	
	@GET
	@Path("produit/{idprod}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Produit getProduit(@PathParam("idprod") int idprod) {
		return repo.getProduit(idprod);
	}
	
	@POST
	@Path("produit")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Produit createProduit(Produit p) {
		System.out.println("adding ..."+p);
		repo.create(p);
		//très important si tu veux faire l'update du front en direct
		return p;
	}
	
	/**
	 * IF does not exist
	 * THEN create
	 * ELSE update
	 */
	@PUT
	@Path("produit")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Produit updateProduit(Produit p) {
		if(repo.getProduit(p.getIdprod()).getIdprod()==0) {
			//create ne fonctionne pas avec "curl -X PUT" ... Pourquoi ?
			System.out.println("does not exist : create ..."+p);
			repo.create(p);
		} else {
			System.out.println("update ..."+p);
			repo.update(p);
		}
		return p;
	}

	@DELETE
	@Path("produit/{idprod}")
	public Produit deleteProduit(@PathParam("idprod") int idprod) {
		Produit p = repo.getProduit(idprod);
		if(p.getIdprod()!=0) {
			repo.delete(repo.getProduit(idprod));
		}
		//pas du tout inutile!!!
		return p;
	}
}
