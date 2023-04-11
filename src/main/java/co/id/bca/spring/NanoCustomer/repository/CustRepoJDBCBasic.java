package co.id.bca.spring.NanoCustomer.repository;

import co.id.bca.spring.NanoCustomer.datasource.NanoCustDataSource;
import co.id.bca.spring.NanoCustomer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustRepoJDBCBasic implements ICustRepo {
    @Autowired
    NanoCustDataSource nanoCustDataSource;

    @Override
    public void create(Customer customer) {
        nanoCustDataSource.insertCustomer(customer);
    }

    @Override
    public List<Customer> retrieveAll() {
        return nanoCustDataSource.getAllCustomer();
    }

    @Override
    public Customer retrieveUnique(Customer customer) {
        return nanoCustDataSource.getSpesificCustomer(customer);
    }

    @Override
    public void update(Customer customer) {
        nanoCustDataSource.updateCustomer(customer);
    }

    @Override
    public void deleteUnique(Customer customer) {
        nanoCustDataSource.deleteCustomer(customer);
    }
}
