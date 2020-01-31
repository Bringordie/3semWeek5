package rest.service;

import com.google.gson.Gson;
import facades.FacadeExample;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("bankcustomer")
public class BankCustomerResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    FacadeExample facade = FacadeExample.getFacadeExample(emf);
    Gson gson = new Gson();
    FacadeExample fe = new FacadeExample();

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCustomers() {
        String json = gson.toJson(fe.getAllBankCustomers());
        return json;
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getCustomerByID(@QueryParam("id") int id) {
        String json = gson.toJson(fe.getCustomerByID(id));
        return json;
    }

}
