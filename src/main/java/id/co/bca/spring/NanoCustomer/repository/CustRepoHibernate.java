package id.co.bca.spring.NanoCustomer.repository;

import id.co.bca.spring.NanoCustomer.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Repository
public class CustRepoHibernate implements ICustRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void create(Customer customer) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    @Override
    public List<Customer> retrieveAll() {
        return entityManager.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer retrieveUnique(Customer customer) {
        return entityManager.find(Customer.class, customer.getId());
    }

    @Override
    public void update(Customer customer) {
        transactionTemplate.execute(new TransactionCallback<Customer>() {
            @Override
            public Customer doInTransaction(TransactionStatus status) {
                Customer dbCust = entityManager.find(Customer.class, customer.getId());
                dbCust.setCustName(customer.getCustName());
                dbCust.setCustEmail(customer.getCustEmail());
                return null;
            }
        });
    }

    @Override
    public void deleteUnique(Customer customer) {
        transactionTemplate.execute(new TransactionCallback<Customer>() {
            @Override
            public Customer doInTransaction(TransactionStatus status) {
                Query query = entityManager.createQuery("delete from Customer where id=:id");
                query.setParameter("id",customer.getId());
                query.executeUpdate();
                return null;
            }
        });
    }
}
