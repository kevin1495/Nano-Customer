package co.id.bca.spring.NanoCustomer.controller;

import co.id.bca.spring.NanoCustomer.model.Customer;
import co.id.bca.spring.NanoCustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/all")
    public @ResponseBody List<Customer> findAll(){
        return customerService.allEmployees();
    }

    @GetMapping("/id")
    public @ResponseBody Customer getCustomer(@RequestParam("id") int id){
        Customer customer = new Customer();
        customer.setId(id);
        return customerService.findCust(customer);
    }

    @GetMapping("/add")
    public String addCustomer(@RequestParam("custname") String custName,
                              @RequestParam("custemail") String custEmail)
    {
        Customer customer = new Customer();
        customer.setId(0);
        customer.setCustName(custName);
        customer.setCustEmail(custEmail);
        customerService.insert(customer);
        return "redirect:/customer/all";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("id") int id,
                                 @RequestParam("custname") String custName,
                                 @RequestParam("custemail") String custEmail)
    {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setCustName(custName);
        customer.setCustEmail(custEmail);
        customerService.update(customer);
        return "redirect:/customer/all";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id){
        Customer customer = new Customer();
        customer.setId(id);
        customerService.delete(customer);
        return  "redirect:/customer/all";
    }
}
