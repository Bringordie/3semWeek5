package rest.service;

import facades.EmployeeFacade;
import java.util.List;
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


@Path("employee")
public class EmployeeResource {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EmployeeFacade facade =  EmployeeFacade.getFacadeExample(emf);
    EmployeeFacade ef = new EmployeeFacade();
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getUserByID(@QueryParam("id")int id) {
        return ef.getEmployeeById(id).toString();
    }
    
    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getUsersByName(EmployeeResource entity, @PathParam("name") String name) {
        return ef.getEmployeesByName(name).toString();
    }
    
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public String showAllEmployees() {
        return ef.getAllEmployees().toString();
    }
    
    @GET
    @Path("/highestpaid")
    @Produces({MediaType.APPLICATION_JSON})
    public String showHighestPaid(EmployeeResource entity, @PathParam("id") int id) {
        return "The highest paid employee is paid: "+ef.getEmployeeWithHighestSalary().toString();
    }
    
}
