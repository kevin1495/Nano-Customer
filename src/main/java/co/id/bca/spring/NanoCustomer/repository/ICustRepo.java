package co.id.bca.spring.NanoCustomer.repository;

import co.id.bca.spring.NanoCustomer.model.Customer;

import java.util.List;

public interface ICustRepo {
    void create(Customer customer);
    List<Customer> retrieveAll();
    Customer retrieveUnique(Customer customer);
    void update(Customer customer);
    void deleteUnique(Customer customer);
}
