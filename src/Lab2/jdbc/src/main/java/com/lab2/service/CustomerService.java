package com.lab2.service;

import com.lab2.dao.Customer;

public interface CustomerService {
    public Customer addCustomer(Customer customer);
    public Customer findCustomerById(int id);
}