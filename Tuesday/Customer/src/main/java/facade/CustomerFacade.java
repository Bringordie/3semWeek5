/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author frederikbraagaard
 */
public class CustomerFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Customer findByID(int id) {
        EntityManager em = getEntityManager();
        TypedQuery q = em.createQuery("SELECT c FROM Customer c where c.id = :id", Customer.class);
        q.setParameter("id", id);
        return (Customer) q.getSingleResult();
    }
    
    public List<Customer> findByLastName(String name) {
        EntityManager em = getEntityManager();
        TypedQuery q = em.createQuery("SELECT c FROM Customer c where c.name = :name", Customer.class);
        q.setParameter("name", name);
        return q.getResultList();
    }
    
    public int getNumberOfCustomers() {
        EntityManager em = getEntityManager();
        TypedQuery q = em.createQuery("SELECT COUNT(c) FROM Customer c", Customer.class);
        return (Integer) q.getSingleResult();
    }

    public List<Customer> allCustomers() {
        EntityManager em = getEntityManager();
        TypedQuery q = em.createQuery("SELECT c FROM Customer c", Customer.class);
        return q.getResultList();
    }
    
    public void addCustomer(Customer customer) {
       EntityManager em = getEntityManager();
       em.createNativeQuery("INSERT INTO Customer (firstname, lastname) VALUES (?,?)")
      .setParameter(1, customer.getFirstName())
      .setParameter(2, customer.getLastName())
      .executeUpdate();
    }
    
}
