package id.co.bca.spring.NanoCustomer.controller;

import id.co.bca.spring.NanoCustomer.model.CustomerModel;
import id.co.bca.spring.NanoCustomer.repository.CustRepoSpringDataJPA;
import id.co.bca.spring.NanoCustomer.service.CustomerService;
import id.co.bca.spring.NanoCustomer.service.CustomerServiceJPA;
import id.co.bca.spring.NanoCustomer.service.ICustomerService;
import id.co.bca.spring.NanoCustomer.service.OccupationAndCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerServiceJPA customerServiceJPA;

    @Autowired
    OccupationAndCustomerService occupationAndCustomerService;

    @GetMapping("/all")
    public @ResponseBody List<CustomerModel> findAll(){
        return customerService.allEmployees();
    }

    @GetMapping("/id")
    public @ResponseBody CustomerModel getCustomer(@RequestParam("id") int id){
        CustomerModel customer = new CustomerModel();
        customer.setId(id);
        return customerService.findCust(customer);
    }

    @GetMapping("/add")
    public String addCustomer(@RequestParam("custname") String custName,
                              @RequestParam("custemail") String custEmail)
    {
        CustomerModel customer = new CustomerModel();
        customer.setId(0);
        customer.setCustName(custName);
        customer.setCustEmail(custEmail);
        customerService.insert(customer);
        return "redirect:/customer/all";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam("id") int id,
                                 @RequestParam("custname") String custName,
                                 @RequestParam("custemail") String custEmail)
    {
        CustomerModel customer = new CustomerModel();
        customer.setId(id);
        customer.setCustName(custName);
        customer.setCustEmail(custEmail);
        customerService.update(customer);
        return "redirect:/customer/all";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id){
        CustomerModel customer = new CustomerModel();
        customer.setId(id);
        customerService.delete(customer);
        return  "redirect:/customer/all";
    }

    @GetMapping("/all2")
    public @ResponseBody List<CustomerModel> findAll2(){
        return customerServiceJPA.allCustomers();
    }

    @GetMapping("/id2")
    public @ResponseBody CustomerModel getCustomer2(@RequestParam("id") int id){
        CustomerModel customer = new CustomerModel();
        customer.setId(id);
        return customerServiceJPA.FindTheCustomer(customer);
    }

    @GetMapping("/add2")
    public String addCustomer2(@RequestParam("custname") String custName,
                              @RequestParam("custemail") String custEmail)
    {
        CustomerModel customer = new CustomerModel();
        customer.setId(0);
        customer.setCustName(custName);
        customer.setCustEmail(custEmail);
        customerServiceJPA.insert(customer);
        return "redirect:/customer/all";
    }

    @GetMapping("/update2")
    public String updateCustomer2(@RequestParam("id") int id,
                                 @RequestParam("custname") String custName,
                                 @RequestParam("custemail") String custEmail)
    {
        CustomerModel customer = new CustomerModel();
        customer.setId(id);
        customer.setCustName(custName);
        customer.setCustEmail(custEmail);
        customerServiceJPA.update(customer);
        return "redirect:/customer/all";
    }

    @GetMapping("/delete2")
    public String deleteCustomer2(@RequestParam("id") int id){
        CustomerModel customer = new CustomerModel();
        customer.setId(id);
        customerServiceJPA.delete(customer);
        return  "redirect:/customer/all";
    }

    @GetMapping("/allpage")
    public @ResponseBody List<CustomerModel> findAllPage(@RequestParam("page") int page,
                                                         @RequestParam("size") int size)
    {
        return customerServiceJPA.allCustomersPage(page,size);
    }

    @GetMapping("/add-co")
    public String addCustomerNew(@RequestParam("custname") String custName,
                                 @RequestParam("custemail") String custEmail,
                                 @RequestParam("oid") int oid){
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustName(custName);
        customerModel.setCustEmail(custEmail);
        customerModel.setOccupationModel(null);

//        occupationAndCustomerService.addCustomerToOccupation(customerModel, oid);
        occupationAndCustomerService.addCustomerToOccupationWithTransactional(customerModel, oid);
        return  "redirect:/customer/all";
    };
}
