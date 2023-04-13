package id.co.bca.spring.NanoCustomer.service;

import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import id.co.bca.spring.NanoCustomer.repository.CustRepoSpringDataJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceJPA implements ICustomerService{

    @Autowired
    CustRepoSpringDataJPA custRepoSpringDataJPA;
    @Override
    public void insert(CustomerModel customer) {
        custRepoSpringDataJPA.save(customer);
    }

    @Override
    public void update(CustomerModel customer) {
        custRepoSpringDataJPA.save(customer);
    }

    @Override
    public void delete(CustomerModel customer) {
        custRepoSpringDataJPA.deleteById(customer.getId());
    }

    @Override
    public CustomerModel FindTheCustomer(CustomerModel customer) {
        return custRepoSpringDataJPA.findCustomerById(customer.getId());
    }

    @Override
    public List<CustomerModel> allCustomers() {
        return custRepoSpringDataJPA.findAllByOrderByCustName();
    }

    @Override
    public List<CustomerModel> allCustomersPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return custRepoSpringDataJPA.findAllByOrderByCustName(pageable).getContent();
    }
}
