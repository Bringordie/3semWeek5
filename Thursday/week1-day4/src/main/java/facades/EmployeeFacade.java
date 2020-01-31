package facades;

import dto.EmployeeDTO;
import dto.EmployeeListDTO;
import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    //Private Constructor to ensure Singleton
    public EmployeeFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Employee getEmployeeById(int id) {
        EntityManager em = getEntityManager();
        TypedQuery<Employee> q = em.createQuery("SELECT e FROM Employee e where e.id = :id", Employee.class);
        q.setParameter("id", Long.valueOf(id));
        return q.getSingleResult();
    }
    
    //Fra timen
//    public List<EmployeeDTO2> getEmployeeByIdDTO(int id) {
//        EntityManager em = getEntityManager();
//        TypedQuery<Employee> q = em.createQuery("SELECT e FROM Employee e where e.id = :id", Employee.class);
//        q.setParameter("id", id);
//        return new EmployeeListDTO(q.getResultList()).getEmployeeDTOs();
//    }

    
    public EmployeeDTO getCustomerByID(int id) {
        EntityManager em = getEntityManager();
        Employee e = em.find(Employee.class, Long.valueOf(id));
        return new EmployeeDTO(e);
    }
    
    public List<Employee> getEmployeesByName(String name) {
        EntityManager em = getEntityManager();
        TypedQuery<Employee> q = em.createQuery("SELECT e FROM Employee e where e.name = :name", Employee.class);
        q.setParameter("name", name);
        return q.getResultList();
    }
    
    public List<Employee> getAllEmployees() {
        EntityManager em = getEntityManager();
        TypedQuery<Employee> q = em.createQuery("SELECT e FROM Employee e", Employee.class);
        return q.getResultList();
    }
    
    public List<Employee> getEmployeeWithHighestSalary() {
        EntityManager em = getEntityManager();
        TypedQuery<Employee> q = em.createQuery("select MAX(e.salary) from Employee e", Employee.class);
        //https://stackoverflow.com/questions/16348354/how-do-i-write-a-max-query-with-a-where-clause-in-jpa-2-0
        return q.getResultList();
    }
    
    public void createEmployee(Employee employee) {
       EntityManager em = getEntityManager();
       em.createNativeQuery("INSERT INTO EMPLOYEEDTO (name, address, salary) VALUES (?,?,?)")
      .setParameter(1, employee.getName())
      .setParameter(2, employee.getAddress())
      .setParameter(3, employee.getAddress())
      .executeUpdate();
       //https://www.baeldung.com/jpa-insert
    }
    
    public static void main(String[] args) {
        EmployeeFacade pf = new EmployeeFacade();
        EntityManager em = pf.getEntityManager();
//        em.getTransaction().begin();
//        em.persist(new Employee("Harry Potter", "Hogwats", 50000));
//        em.persist(new Employee("Frederik", "Address1", 12321389));
//        em.persist(new Employee("Peter", "Address2", 235325));
//        em.persist(new Employee("Martin", "Address3", 21123));
//        em.getTransaction().commit();
        //pf.getAllEmployees().forEach((employee) -> {System.out.println(employee);});
           //pf.getEmployeesByName("Peter").forEach((employee) -> {System.out.println(employee);});
           System.out.println(pf.getEmployeeById(151));

    }

}
