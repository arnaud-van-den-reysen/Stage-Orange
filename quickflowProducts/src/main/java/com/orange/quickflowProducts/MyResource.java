
package com.orange.quickflowProducts;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

/** 
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public String /*Response*/ getIt() {
        return "{\"title\": \"Hi there!\"}";
        // return Response.ok()
		// 			.entity("{\"title\": \"Hi there!\"}")
		// 			.header("Access-Control-Allow-Origin","*")
		// 			.build();
    }
}
