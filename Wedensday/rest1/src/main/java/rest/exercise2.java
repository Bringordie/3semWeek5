/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author frederikbraagaard
 */
@Path("random")
public class exercise2 {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public exercise2() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     * @return an instance of java.lang.String
     */
   
   @GET
   @Produces(MediaType.APPLICATION_JSON)
    public String getExercise2() {
        //TODO return proper representation object
        return "Hello this is exercise 2 with json end point.";
    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    

}
