package id.co.bca.spring.NanoCustomer.service;

import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import id.co.bca.spring.NanoCustomer.repository.CustRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{

    @Autowired
    CustRepo custRepo;
    @Override
    public void insert(CustomerModel customer) {
        custRepo.save(customer);
    }

    @Override
    public void update(CustomerModel customer) {
        custRepo.save(customer);
    }

    @Override
    public void delete(CustomerModel customer) {
        custRepo.deleteById(customer.getId());
    }

    @Override
    public CustomerModel FindTheCustomer(CustomerModel customer) {
        return custRepo.findCustomerById(customer.getId());
    }

    @Override
    public List<CustomerModel> allCustomers() {
        return custRepo.findAllByOrderByCustName();
    }

    @Override
    public List<CustomerModel> allCustomersPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return custRepo.findAllByOrderByCustName(pageable).getContent();
    }
}
