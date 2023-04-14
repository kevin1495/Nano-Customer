package id.co.bca.spring.NanoCustomer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="card")
public class CardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "cust_id")
    private Integer custId ;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "cust_id")
//    @JsonManagedReference
//    private CustomerModel customerModel;
//
//    public CustomerModel getCustomerModel() {
//        return customerModel;
//    }
//
//    public void setCustomerModel(CustomerModel customerModel) {
//        this.customerModel = customerModel;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
