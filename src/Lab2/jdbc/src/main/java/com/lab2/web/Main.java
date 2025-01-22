package com.lab2.web;

import com.lab2.dao.Customer;
import com.lab2.service.implementations.CustomerServiceImplementation;

public class Main {
    public static void main(String[] args) {
        CustomerServiceImplementation customerServiceImplementation = new CustomerServiceImplementation();

        Customer customer = new Customer("Sudeev", "Bengaluru", "8861840737");
        customerServiceImplementation.addCustomer(customer);

        System.out.println(customerServiceImplementation.findCustomerById(1));   // Will return customer successfully
        System.out.println(customerServiceImplementation.findCustomerById(2).toString());   // Throws error on purpose because id is not present in database
    }
}
