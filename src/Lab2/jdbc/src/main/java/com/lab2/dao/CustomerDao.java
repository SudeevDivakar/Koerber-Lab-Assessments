package com.lab2.dao;

import com.lab2.exceptions.DaoException;

public interface CustomerDao {
    public Customer addCustomer(Customer customer) throws DaoException;
    public Customer findCustomerById(int id) throws DaoException;
}
