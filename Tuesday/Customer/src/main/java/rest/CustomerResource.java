/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entity.Customer;
import facade.CustomerFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author frederikbraagaard
 */
@Path("customer")
public class CustomerResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    Gson gson = new Gson();
    CustomerFacade cf = new CustomerFacade();

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String json = gson.toJson(cf.allCustomers());
        return json;
    }
    
    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomCustomer() {
        List<Customer> list = cf.allCustomers();
        int max = list.size()-1;
        int min = 0;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min; 
        String json = gson.toJson(list.get(randomNum));
        return json;
    }


    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getUserByID(@QueryParam("id") int id) {
        String json = gson.toJson(cf.findByID(id));
        return json;
    }

}
