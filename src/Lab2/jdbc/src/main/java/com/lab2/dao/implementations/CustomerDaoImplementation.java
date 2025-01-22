package com.lab2.dao.implementations;

import com.lab2.dao.Customer;
import com.lab2.dao.CustomerDao;
import com.lab2.exceptions.DaoException;
import com.lab2.factory.ConnectionFactory;

import java.sql.*;

public class CustomerDaoImplementation implements CustomerDao {
    Connection conn;

    public CustomerDaoImplementation() {
        conn = ConnectionFactory.getConnection();
        if (conn == null) {
            throw new DaoException("Error while trying to connect to database");
        }
    }

    @Override
    public Customer addCustomer(Customer customer) throws DaoException {
        try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO customer (name, address, phone_number) values (?, ?, ?);", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getAddress());
            pstmt.setString(3, customer.getPhoneNumber());
            int res = pstmt.executeUpdate();
            if (res > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        customer.setId(rs.getInt(1));
                        return customer;
                    } else {
                        throw new DaoException("No ID generated for the new customer.");
                    }
                }
            }
            throw new DaoException("Unable to Add Customer");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Error while Adding Customer");
        }
    }

    @Override
    public Customer findCustomerById(int id) throws DaoException {
        try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customer WHERE id = ?;")) {
            pstmt.setInt(1, id);

            ResultSet res = pstmt.executeQuery();

            if(res.next()) {
                return new Customer(res.getInt("id"), res.getString("name"), res.getString("address"), res.getString("phone_number"));
            }
            throw new DaoException("Customer Not in Database");
        }
        catch (SQLException ex) {
            throw new DaoException("Error in finding single customer");
        }
    }
}
