package entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author frederikbraagaard
 */
public class MakeTestData {
    public static void main(String[] args) {
        BankCustomer bankc = new BankCustomer();
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(new BankCustomer("First name", "Last name", "accountNumber", 500, 1, "internalinfo"));
        em.persist(new BankCustomer("First name2", "Last name2", "accountNumber2", 501, 2, "internalinfo2"));
        em.persist(new BankCustomer("First name3", "Last name3", "accountNumber3", 502, 3, "internalinfo3"));
        em.persist(new BankCustomer("First name4", "Last name4", "accountNumber4", 503, 4, "internalinfo4"));
        em.getTransaction().commit();
        //String firstName, String lastName, String accountNumber, double balance, int customerRanking, String internalInfo
        

        // Close the database connection:
        em.close();
        emf.close();
    }
    
}
