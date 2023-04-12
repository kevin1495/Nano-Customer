package id.co.bca.spring.NanoCustomer.repository;

import id.co.bca.spring.NanoCustomer.datasource.NanoCustDataSource;
import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustRepoJDBCBasic implements ICustRepo {
    @Autowired
    NanoCustDataSource nanoCustDataSource;

    @Override
    public void create(CustomerModel customer) {
        nanoCustDataSource.insertCustomer(customer);
    }

    @Override
    public List<CustomerModel> retrieveAll() {
        return nanoCustDataSource.getAllCustomer();
    }

    @Override
    public CustomerModel retrieveUnique(CustomerModel customer) {
        return nanoCustDataSource.getSpesificCustomer(customer);
    }

    @Override
    public void update(CustomerModel customer) {
        nanoCustDataSource.updateCustomer(customer);
    }

    @Override
    public void deleteUnique(CustomerModel customer) {
        nanoCustDataSource.deleteCustomer(customer);
    }
}
