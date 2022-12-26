package com.ammk.cms.api;

import com.ammk.cms.model.Customer;
import com.ammk.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customers")
public class CustomerResource {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping(value = "/{customerId}")
    public Customer findCustomer(@PathVariable int customerId){
        return customerService.findCustomer(customerId);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable int customerId){
        customerService.deleteCustomer(customerId);
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId,@RequestBody Customer customer){
        return customerService.updateCustomer(customerId,customer);
    }
}
