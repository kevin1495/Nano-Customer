package id.co.bca.spring.NanoCustomer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @Column(name = "cust_name")
    private String custName;
    @Column(name = "cust_email")
    private String custEmail;
    @Column(name = "cust_type")
    private String custType;
    @Column(name = "cust_balance")
    private BigDecimal custBalance;

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public BigDecimal getCustBalance() {
        return custBalance;
    }

    public void setCustBalance(BigDecimal custBalance) {
        this.custBalance = custBalance;
    }

    public int getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }
}
