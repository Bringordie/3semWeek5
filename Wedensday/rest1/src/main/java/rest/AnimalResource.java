/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entities.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
@Path("animal")
public class AnimalResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        //return "Hello from my first web service.";
        return getRandomAnimal();
    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    public String getRandomAnimal() {
        //TODO return proper representation object
        Animal animal = new Animal();
        //List<Animal> animallist = new ArrayList<Animal>();
        List<Animal> list = new ArrayList<Animal>();
        list.add(new Animal("Dog", 2012, "Bark"));
        list.add(new Animal("Cat", 2015, "Miav"));
        list.add(new Animal("Duck", 2013, "Quack"));
        list.add(new Animal("Wheezel", 2002, "wheez"));
        
        int max = 3;
        int min = 0;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min; 
        return list.get(randomNum).toString();
    }
    
}
