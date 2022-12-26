package com.ammk.cms.dao;

import com.ammk.cms.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends CrudRepository<Customer,Integer>{
    List<Customer> findAll();
}
