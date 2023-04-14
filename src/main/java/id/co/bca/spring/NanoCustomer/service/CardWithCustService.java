package id.co.bca.spring.NanoCustomer.service;

import id.co.bca.spring.NanoCustomer.model.CardModel;
import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import id.co.bca.spring.NanoCustomer.model.OccupationModel;
import id.co.bca.spring.NanoCustomer.repository.CardRepoSpringDataJPA;
import id.co.bca.spring.NanoCustomer.repository.CustRepoSpringDataJPA;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardWithCustService {
    @Autowired
    CustRepoSpringDataJPA custRepoSpringDataJPA;
    @Autowired
    CardRepoSpringDataJPA cardRepoSpringDataJPA;

    @Transactional
    public void addCardWithCust(CardModel cardModel, Integer id){
        cardRepoSpringDataJPA.save(cardModel);
        CustomerModel customerModel = custRepoSpringDataJPA.findCustomerById(Integer.valueOf(id));
        custRepoSpringDataJPA.save(customerModel);
//        cardModel.setCustomerModel(customerModel);
        cardRepoSpringDataJPA.save(cardModel);
    }
}
