package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeExample {

    private static FacadeExample instance;
    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
    
    //Private Constructor to ensure Singleton
    public FacadeExample() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeExample getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeExample();
        }
        return instance;
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public CustomerDTO getCustomerByID(int id) {
        EntityManager em = getEntityManager();
        BankCustomer e = em.find(BankCustomer.class, Long.valueOf(id));
        return new CustomerDTO(e);
    }
    
    public List<CustomerDTO> getCustomerByName(String name) {
        EntityManager em = getEntityManager();
        TypedQuery<CustomerDTO> q = em.createQuery("SELECT b FROM BankCustomer b where b.firstName = :name", CustomerDTO.class);
        q.setParameter("name", name);
        return q.getResultList();
    }
    
    public void addCustomer (BankCustomer cust) {
        em.getTransaction().begin();
        em.persist(new BankCustomer(cust.getFirstName(), cust.getLastName(), 
        cust.getAccountNumber(), cust.getBalance(), cust.getCustomerRanking(), 
        cust.getInternalInfo()));
        em.getTransaction().commit();

        // Close the database connection:
        //em.close();
        //emf.close();
    }
    
    public List<BankCustomer> getAllBankCustomers() {
        EntityManager em = getEntityManager();
        TypedQuery<BankCustomer> q = em.createQuery("SELECT b FROM BankCustomer b", BankCustomer.class);
        return q.getResultList();
    }
    
    public static void main(String[] args) {
        FacadeExample fe = new FacadeExample();
        //fe.addCustomer(new BankCustomer("First name", "Last name", "accountNumber", 500, 1, "internalinfo"));
        //fe.addCustomer(new BankCustomer("First name1", "Last name2", "accountNumber2", 502, 2, "internalinfo2"));
        //fe.addCustomer(new BankCustomer("First name2", "Last name3", "accountNumber3", 503, 3, "internalinfo3"));
        //fe.addCustomer(new BankCustomer("First name3", "Last name4", "accountNumber4", 504, 4, "internalinfo4"));
        //fe.getAllBankCustomers().forEach((bankcustomer) -> {System.out.println(bankcustomer);});
        //System.out.println(fe.getCustomerByID(1).toString());
        //System.out.println(fe.getCustomerByName("First name").toString());
    }

}
