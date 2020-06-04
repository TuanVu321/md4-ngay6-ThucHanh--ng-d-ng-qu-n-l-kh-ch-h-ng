package com.codegym.serviece.servieceCustomer;

import com.codegym.model.Customer;
import com.codegym.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerServiece{
   @Autowired
   private CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer model) {
        customerRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }
}
