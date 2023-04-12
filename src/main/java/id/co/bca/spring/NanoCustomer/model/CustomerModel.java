package id.co.bca.spring.NanoCustomer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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
    @JsonBackReference
    @OneToMany(mappedBy = "customerModel")
    private List<CardModel> cardModels;

    @ManyToOne
    @JoinColumn(name = "occupation_id")
    @JsonManagedReference
    private OccupationModel occupationModel;

    public OccupationModel getOccupationModel() {
        return occupationModel;
    }

    public void setOccupationModel(OccupationModel occupationModel) {
        this.occupationModel = occupationModel;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
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
