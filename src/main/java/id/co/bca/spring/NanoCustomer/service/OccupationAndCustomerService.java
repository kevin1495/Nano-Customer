package id.co.bca.spring.NanoCustomer.service;

import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import id.co.bca.spring.NanoCustomer.model.OccupationModel;
import id.co.bca.spring.NanoCustomer.repository.CustRepoSpringDataJPA;
import id.co.bca.spring.NanoCustomer.repository.OccupRepoSpringDataJPA;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccupationAndCustomerService {

    @Autowired
    OccupRepoSpringDataJPA occupRepoSpringDataJPA;

    @Autowired
    CustRepoSpringDataJPA custRepoSpringDataJPA;

    public void addCustomerToOccupation(CustomerModel customerModel, int id){
        custRepoSpringDataJPA.save(customerModel);
        OccupationModel occupationModel = occupRepoSpringDataJPA.findOccupationById(Integer.valueOf(id));
        occupationModel.getCustomerModels().add(customerModel);
        occupRepoSpringDataJPA.save(occupationModel);
        customerModel.setOccupationModel(occupationModel);
        custRepoSpringDataJPA.save(customerModel);
    }

    @Transactional
    public void addCustomerToOccupationWithTransactional(CustomerModel customerModel, int id){
        custRepoSpringDataJPA.save(customerModel);
        OccupationModel occupationModel = occupRepoSpringDataJPA.findOccupationById(Integer.valueOf(id));
        occupRepoSpringDataJPA.save(occupationModel);
        customerModel.setOccupationModel(occupationModel);
        custRepoSpringDataJPA.save(customerModel);
    }
}
