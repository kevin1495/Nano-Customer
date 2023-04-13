package id.co.bca.spring.NanoCustomer.controller;

import id.co.bca.spring.NanoCustomer.model.CardModel;
import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import id.co.bca.spring.NanoCustomer.service.CardService;
import id.co.bca.spring.NanoCustomer.service.CardWithCustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;
    @Autowired
    CardWithCustService cardWithCustService;
    @GetMapping("/all")
    public @ResponseBody List<CardModel> findAll(){
        return cardService.allCards();
    }

    @GetMapping("/id")
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
    public String deleteCard(@RequestParam("id") int id){
        CardModel card = new CardModel();
        card.setId(id);
        cardService.delete(card);
        return  "redirect:/card/all";
    }

    @GetMapping("/allpage")
    public @ResponseBody List<CardModel> findAllPage(@RequestParam("page") int page,
                                                         @RequestParam("size") int size)
    {
        return cardService.allCardsPage(page,size);
    }


}
