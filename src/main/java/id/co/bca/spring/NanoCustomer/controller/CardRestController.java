package id.co.bca.spring.NanoCustomer.controller;

import id.co.bca.spring.NanoCustomer.model.CardModel;
import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import id.co.bca.spring.NanoCustomer.service.CardService;
import id.co.bca.spring.NanoCustomer.service.CardWithCustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CardRestController {
    @Autowired
    CardService cardService;
    @Autowired
    CardWithCustService cardWithCustService;
    @GetMapping("/card")
    @ResponseStatus(HttpStatus.OK)
    public List<CardModel> findAll(){
        return cardService.allCards();
    }

    @GetMapping("/card/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CardModel findCardById(@PathVariable("id") int id){
        CardModel card = new CardModel();
        card.setId(id);
        return cardService.findTheCard(card);
    }

//    @GetMapping("/custid")
//    public @ResponseBody CardModel getCardByCustId(@RequestParam("id") int id){
//        CardModel card = new CardModel();
//        card.getCustomerModel().setId(id);
//        return cardService.findTheCard(card);
//    }

    @PostMapping("/card/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CardModel addCard(@RequestBody CardModel cardModel, @PathVariable("id") int id){
        cardWithCustService.addCardWithCust(cardModel, id);
        return  cardModel;
    };

    @PutMapping("/card/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CardModel updateCard(@RequestBody CardModel cardModel, @PathVariable("id") int id)
    {
        cardModel.setId(id);
        cardService.update(cardModel);
        return cardModel;
    }

    @DeleteMapping("/card/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCard(@PathVariable("id") int id)
    {
        CardModel cardModel = new CardModel();
        cardModel.setId(id);
        cardService.delete(cardModel);
    }

    @GetMapping("/card/{page}/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<CardModel> findAllPage(@PathVariable("page") int page,
                                           @PathVariable("size") int size)
    {
        return cardService.allCardsPage(page,size);
    }

}
