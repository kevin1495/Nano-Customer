package id.co.bca.spring.NanoCustomer.service;

import id.co.bca.spring.NanoCustomer.model.CustomerModel;
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

    public void insert(CustomerModel customer){ iCustRepo.create(customer); }
    public void update(CustomerModel customer){ iCustRepo.update(customer);}
    public void delete(CustomerModel customer){ iCustRepo.deleteUnique(customer); }
    public CustomerModel findCust(CustomerModel customer){return iCustRepo.retrieveUnique(customer);}
    public List<CustomerModel> allEmployees(){return iCustRepo.retrieveAll();}
}
