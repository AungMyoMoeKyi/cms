package com.ammk.cms.service;

import com.ammk.cms.dao.CustomerDAO;
import com.ammk.cms.exception.CustomerNotFoundException;
import com.ammk.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer){
        return customerDAO.save(customer);
    }

    public List<Customer> findAllCustomers(){
        return customerDAO.findAll();
    }

    public Customer findCustomer(int customerId){

        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not available");
        return optionalCustomer.get();
    }

    public void deleteCustomer(int customerId){
        customerDAO.deleteById(customerId);
    }

    public Customer updateCustomer(int customerId,Customer customer){
        customer.setCustomerId(customerId);
        return customerDAO.save(customer);
    }
}
