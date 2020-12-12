package com.hexaware.MLP211.factory;

import com.hexaware.MLP211.model.Customer;

import com.hexaware.MLP211.persistence.CustomerDAOImpl;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    @Override
    public boolean addCustomer(Customer customer)throws Throwable
    {
        return new CustomerDAOImpl().insertCustomer(customer);
    }
    @Override
    public boolean updateCustomer(Customer customer)throws Throwable
    {
        return new CustomerDAOImpl().updateCustomer(customer);
    } 
    @Override
    public boolean removeCustomer(int id)throws Throwable
    {
        return new CustomerDAOImpl().deleteCustomer(id);
    }@Override
    public Customer findCustomer(int id)throws Throwable
    {
        return new CustomerDAOImpl().findCustomer(id);
    }
    @Override
    public List<Customer> getAllCustomers() throws Throwable{
        return new CustomerDAOImpl().getAllCustomers();
    }
    
} 