package id.co.bca.spring.NanoCustomer.service;

import id.co.bca.spring.NanoCustomer.model.Customer;
import id.co.bca.spring.NanoCustomer.repository.ICustRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    @Qualifier("custRepoHibernate")
    ICustRepo iCustRepo;

    public void insert(Customer customer){ iCustRepo.create(customer); }
    public void update(Customer customer){ iCustRepo.update(customer);}
    public void delete(Customer customer){ iCustRepo.deleteUnique(customer); }
    public Customer findCust(Customer customer){return iCustRepo.retrieveUnique(customer);}
    public List<Customer> allEmployees(){return iCustRepo.retrieveAll();}
}
