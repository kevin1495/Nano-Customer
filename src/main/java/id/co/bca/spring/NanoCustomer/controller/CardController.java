package id.co.bca.spring.NanoCustomer.controller;

import id.co.bca.spring.NanoCustomer.model.CardModel;
import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import id.co.bca.spring.NanoCustomer.service.CardService;
import id.co.bca.spring.NanoCustomer.service.CardWithCustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;
    @Autowired
    CardWithCustService cardWithCustService;
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<CardModel> findAll(){
        return cardService.allCards();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody CardModel getCard(@RequestParam("id") int id){
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

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public String addCustomerNew(@RequestParam("cardtype") String cardType,
                                 @RequestParam("cardnumber") String cardNumber,
                                 @RequestParam("cid") int oid){
        CardModel cardModel = new CardModel();
        cardModel.setCardType(cardType);
        cardModel.setCardNumber(cardNumber);
        cardModel.setCustomerModel(null);

        cardWithCustService.addCardWithCust(cardModel, oid);
        return  "redirect:/card/all";
    };
    @GetMapping("/add-v1")
    @ResponseStatus(HttpStatus.OK)
    public String addCard(@RequestParam("cardtype") String cardType,
                              @RequestParam("cardnumber") String cardNumber)
    {
        CardModel card = new CardModel();
        card.setId(0);
        card.setCardType(cardType);
        card.setCardNumber(cardNumber);
        cardService.insert(card);
        return "redirect:/card/all";
    }

    @GetMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String updateCard(@RequestParam("id") int id,
                                 @RequestParam("cardnumber") String cardNumber,
                                 @RequestParam("cardtype") String cardType)
    {
        CardModel card = new CardModel();
        card.setId(id);
        card.setCardNumber(cardNumber);
        card.setCardType(cardType);
        cardService.update(card);
        return "redirect:/card/all";
    }

    @GetMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCard(@RequestParam("id") int id){
        CardModel card = new CardModel();
        card.setId(id);
        cardService.delete(card);
        return  "redirect:/card/all";
    }

    @GetMapping("/allpage")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<CardModel> findAllPage(@RequestParam("page") int page,
                                                         @RequestParam("size") int size)
    {
        return cardService.allCardsPage(page,size);
    }
}
