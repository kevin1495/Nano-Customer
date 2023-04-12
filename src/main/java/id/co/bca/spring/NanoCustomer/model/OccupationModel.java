package id.co.bca.spring.NanoCustomer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Table(name="occupation")
public class OccupationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "occupationModel")
    private List<CustomerModel> customerModels;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomerModel> getCustomerModels() {
        return customerModels;
    }

    public void setCustomerModels(List<CustomerModel> customerModels) {
        this.customerModels = customerModels;
    }
}
