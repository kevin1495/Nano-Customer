package id.co.bca.spring.NanoCustomer.repository;

import id.co.bca.spring.NanoCustomer.model.CustomerModel;

import java.util.List;

public interface ICustRepo {
    void create(CustomerModel customer);
    List<CustomerModel> retrieveAll();
    CustomerModel retrieveUnique(CustomerModel customer);
    void update(CustomerModel customer);
    void deleteUnique(CustomerModel customer);
}
