package id.co.bca.spring.NanoCustomer.controller;

import id.co.bca.spring.NanoCustomer.model.CardModel;
import id.co.bca.spring.NanoCustomer.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestCardController {
    @Autowired
    CardService cardService;
    @GetMapping("/card")
    @ResponseStatus(HttpStatus.OK)
    public List<CardModel> findAll(){
        return cardService.allCards();
    }

    @GetMapping("/card/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CardModel getCard(@PathVariable("id") int id){
        CardModel card = new CardModel();
        card.setId(id);
        return cardService.findTheCard(card);
    }

    @GetMapping("/card/cust/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CardModel> findAllCustCard(@PathVariable("id") int id){
        CardModel card = new CardModel();
        card.setCustId(id);
        return cardService.findAllCardByCustId(card);
    }

    @PostMapping("/card")
    @ResponseStatus(HttpStatus.OK)
    public CardModel addCardCust(@RequestBody CardModel cardModel){
        Integer cid = cardModel.getCustId();
        cardService.addCardWithCust(cardModel, cid);
        return cardModel;
    };

    @PutMapping("/card/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CardModel updateCard(@RequestBody CardModel cardModel,@PathVariable("id") int id)
    {
        cardModel.setId(id);
        Integer cid = cardModel.getCustId();
        cardService.updateCardWithCust(cardModel,cid);
        return cardModel;
    }

    @DeleteMapping("/card/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCard(@PathVariable("id") int id){
        CardModel card = new CardModel();
        card.setId(id);
        cardService.delete(card);
    }

    @GetMapping("/card/{page}/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<CardModel> findAllPage(@PathVariable("page") int page,
                                       @PathVariable("size") int size)
    {
        return cardService.allCardsPage(page,size);
    }
}
