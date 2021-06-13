package org.example.controller;

import org.example.entity.Customer;
import org.example.repository.CustomerRepository;
import  org.example.repository.impl.CustomerRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerController {
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    public Customer getCustomerById(Long id) throws SQLException{
        return customerRepository.getById(id);
    }
    public Customer editCustomer(Customer customer) throws  SQLException{
        return customerRepository.update(customer);
    }
    public List<Customer> getAllCustomers() throws SQLException {
        return customerRepository.getAll();
    }

    public void saveCustomer(Customer customer) throws SQLException {
        customerRepository.add(customer);
    }

    public void deleteCustomer(Long id) throws SQLException {
        customerRepository.remove(id);
    }

}
