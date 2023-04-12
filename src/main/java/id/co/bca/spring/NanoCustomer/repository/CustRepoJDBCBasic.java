package id.co.bca.spring.NanoCustomer.repository;

import id.co.bca.spring.NanoCustomer.datasource.NanoCustDataSource;
import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustRepoJDBCBasic {
    @Autowired
    NanoCustDataSource nanoCustDataSource;

    public void create(CustomerModel customer) {
        nanoCustDataSource.insertCustomer(customer);
    }

    public List<CustomerModel> retrieveAll() {
        return nanoCustDataSource.getAllCustomer();
    }

    public CustomerModel retrieveUnique(CustomerModel customer) {
        return nanoCustDataSource.getSpesificCustomer(customer);
    }

    public void update(CustomerModel customer) {
        nanoCustDataSource.updateCustomer(customer);
    }

    public void deleteUnique(CustomerModel customer) {
        nanoCustDataSource.deleteCustomer(customer);
    }
}
