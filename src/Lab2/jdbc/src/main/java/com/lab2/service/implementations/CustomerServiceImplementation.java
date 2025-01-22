package com.lab2.service.implementations;

import com.lab2.dao.Customer;
import com.lab2.dao.implementations.CustomerDaoImplementation;
import com.lab2.service.CustomerService;

public class CustomerServiceImplementation implements CustomerService {
    CustomerDaoImplementation customerDaoImplementation = new CustomerDaoImplementation();

    @Override
    public Customer addCustomer(Customer customer) {
        return customerDaoImplementation.addCustomer(customer);
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerDaoImplementation.findCustomerById(id);
    }
}


