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

import com.orange.model.Test_json;
import com.orange.model.Jdoc;

/**
 * @author Arnaud VAN DEN REYSEN
 * @version (2021/07/08)
 */
@Path("test_json")
public class JSONResources {

	/*
	GET /test_json
	GET /test_json/test_json/:id
	POST /test_json/test_json
	PUT /test_json/test_json
	DELETE /test_json/test_json/:id
	*/
	
	JSONRepository repo = new JSONRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getTest_jsons() {
		System.out.println("/GET = " + repo.getTest_jsons());
		List<Test_json> tj = repo.getTest_jsons();
		GenericEntity<List<Test_json>> myEntity = new GenericEntity<List<Test_json>> (tj) {};
		// return repo.getTest_jsons();
		return Response.status(200)
			.entity(myEntity)
			//.header("Access-Control-Allow-Origin","*")
			.build();
	}

	@GET
	@Path("test_json/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Test_json getTest_json(@PathParam("id") int id) {
		System.out.println("/GET/" + id + " = " + repo.getTest_json(id));
		return repo.getTest_json(id);
	}

	@POST
	@Path("test_json")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Test_json createTest_json(Jdoc pa) {
		System.out.println("adding ..."+pa);
		Test_json p = new Test_json(pa);
		System.out.println("adding ..."+p.getJdoc());
		repo.create(p);
		return p;// inutile
	}

	@PUT
	@Path("test_json")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Test_json updateTest_json(Test_json p) {
		System.out.println("update ..."+p);
		// Test_json p = new Test_json(pa);
		if(repo.getTest_json(p.getId()).getId()==0) {
			repo.create(p);
		} else {
			repo.update(p);
		}
		
		return p;// inutile
	}

	@DELETE
	@Path("test_json/{id}")
	public Test_json deleteTest_json(@PathParam("id") int id) {
		Test_json p = repo.getTest_json(id);
		if(p.getId()!=0) {
			System.out.println("/DELETE/" + id + " = " + repo.getTest_json(id));
			repo.delete(repo.getTest_json(id));
		}
		return p;// plutôt renvoyer un msg d'erreur
	}
}
