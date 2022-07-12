package com.reactive.service;

import com.reactive.dao.CustomerDao;
import com.reactive.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomer() {
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getAllCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return  customers;
    }

    public Flux<Customer> loadAllCustomerStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getAllCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return  customers;
    }
}
