package id.co.bca.spring.NanoCustomer.controller;

import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import id.co.bca.spring.NanoCustomer.repository.CustRepoSpringDataJPA;
import id.co.bca.spring.NanoCustomer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RestCustController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    CustRepoSpringDataJPA custRepoSpringDataJPA;
    @GetMapping("/cust")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerModel> findAll(){return iCustomerService.allCustomers();}
    @GetMapping("/cust/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  CustomerModel findCustById(@PathVariable("id") int id){
        CustomerModel customer = new CustomerModel();
        customer.setId(id);
        return iCustomerService.FindTheCustomer(customer);
    }
    @PostMapping("/cust")
    @ResponseStatus(HttpStatus.OK)
    public CustomerModel addCust(@RequestBody CustomerModel customerModel){
//        return custRepoSpringDataJPA.save(customerModel);
          iCustomerService.insert(customerModel);
          return customerModel;
    }
    @PutMapping("/cust/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerModel updateCust(@RequestBody CustomerModel customerModel, @PathVariable("id") int id){
        customerModel.setId(id);
        return custRepoSpringDataJPA.save(customerModel);
    }
    @DeleteMapping("cust/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCust(@PathVariable("id") int id){custRepoSpringDataJPA.deleteById(id);}
}
