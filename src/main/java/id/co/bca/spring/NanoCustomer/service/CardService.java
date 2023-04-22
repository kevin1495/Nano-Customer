package id.co.bca.spring.NanoCustomer.service;

import id.co.bca.spring.NanoCustomer.model.CardModel;
import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import id.co.bca.spring.NanoCustomer.repository.CardRepo;
import id.co.bca.spring.NanoCustomer.repository.CustRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepo cardRepo;

    @Autowired
    CustRepo custRepo;

    public void insert(CardModel cardModel){
        cardRepo.save(cardModel);}
    public void update(CardModel cardModel){
        cardRepo.save(cardModel);}
    public void delete(CardModel cardModel){
        cardRepo.deleteById(cardModel.getId());}
    public List<CardModel> allCards(){return cardRepo.findAll();}
    public CardModel findTheCard(CardModel cardModel) {return cardRepo.findCardById(cardModel.getId());}
    public List<CardModel> findAllCardByCustId(CardModel cardModel) {return cardRepo.findAllByCustId(cardModel.getCustId());}
    public List<CardModel> allCardsPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return cardRepo.findAll(pageable).getContent();
    }

    @Transactional
    public void addCardWithCust(CardModel cardModel, Integer id){
        cardRepo.save(cardModel);
        CustomerModel customerModel = custRepo.findCustomerById(Integer.valueOf(id));
        custRepo.save(customerModel);
        cardRepo.save(cardModel);
    }

    @Transactional
    public void updateCardWithCust(CardModel cardModel, Integer id){
        cardRepo.save(cardModel);
        CustomerModel customerModel = custRepo.findCustomerById(Integer.valueOf(id));
        custRepo.save(customerModel);
        cardRepo.save(cardModel);
    }
}
