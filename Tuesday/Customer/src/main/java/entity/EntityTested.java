/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author frederikbraagaard
 */
public class EntityTested {
    public static void main(String[] args) {
        Customer customer = new Customer();
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(new Customer("First name", "Last name"));
        em.persist(new Customer("First name2", "Last name2"));
        em.persist(new Customer("First name3", "Last name3"));
        em.persist(new Customer("First name4", "Last name4"));
        em.getTransaction().commit();
        
        // Retrieve all the Customer objects from the database:
        TypedQuery<Customer> query =
            em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> results = query.getResultList();
        for (Customer p : results) {
            System.out.println(p);
        }

        // Close the database connection:
        em.close();
        emf.close();
    }
}
