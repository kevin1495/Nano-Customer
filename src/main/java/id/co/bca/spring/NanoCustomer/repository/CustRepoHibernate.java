package id.co.bca.spring.NanoCustomer.repository;

import id.co.bca.spring.NanoCustomer.model.CustomerModel;
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
    public void create(CustomerModel customer) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    @Override
    public List<CustomerModel> retrieveAll() {
        return entityManager.createQuery("from CustomerModel", CustomerModel.class).getResultList();
    }

    @Override
    public CustomerModel retrieveUnique(CustomerModel customer) {
        return entityManager.find(CustomerModel.class, customer.getId());
    }

    @Override
    public void update(CustomerModel customer) {
        transactionTemplate.execute(new TransactionCallback<CustomerModel>() {
            @Override
            public CustomerModel doInTransaction(TransactionStatus status) {
                CustomerModel dbCust = entityManager.find(CustomerModel.class, customer.getId());
                dbCust.setCustName(customer.getCustName());
                dbCust.setCustEmail(customer.getCustEmail());
                return null;
            }
        });
    }

    @Override
    public void deleteUnique(CustomerModel customer) {
        transactionTemplate.execute(new TransactionCallback<CustomerModel>() {
            @Override
            public CustomerModel doInTransaction(TransactionStatus status) {
                Query query = entityManager.createQuery("delete from CustomerModel where id=:id");
                query.setParameter("id",customer.getId());
                query.executeUpdate();
                return null;
            }
        });
    }
}
