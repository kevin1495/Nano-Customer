package id.co.bca.spring.NanoCustomer.service;

import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ICustomerService {
    void insert(CustomerModel customer);
    void update(CustomerModel customer);
    void delete(CustomerModel customer);
    CustomerModel FindTheCustomer(CustomerModel customer);
    List<CustomerModel> allCustomers();
    List<CustomerModel> allCustomersPage(int page, int size);

}
