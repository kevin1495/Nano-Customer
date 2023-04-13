package id.co.bca.spring.NanoCustomer.service;

import id.co.bca.spring.NanoCustomer.model.CardModel;
import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import id.co.bca.spring.NanoCustomer.model.OccupationModel;
import id.co.bca.spring.NanoCustomer.repository.CardRepoSpringDataJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepoSpringDataJPA cardRepoSpringDataJPA;

    public void insert(CardModel cardModel){cardRepoSpringDataJPA.save(cardModel);}
    public void update(CardModel cardModel){cardRepoSpringDataJPA.save(cardModel);}
    public void delete(CardModel cardModel){cardRepoSpringDataJPA.deleteById(cardModel.getId());}
    public List<CardModel> allCards(){return cardRepoSpringDataJPA.findAll();}
    public CardModel findTheCard(CardModel cardModel) {return cardRepoSpringDataJPA.findCardById(cardModel.getId());}
//    public CardModel findTheCardByCustId(CardModel cardModel) {return cardRepoSpringDataJPA.findCardByCustId(cardModel.getCustomerModel().getId());}
    public List<CardModel> allCardsPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return cardRepoSpringDataJPA.findAll(pageable).getContent();
    }
}
