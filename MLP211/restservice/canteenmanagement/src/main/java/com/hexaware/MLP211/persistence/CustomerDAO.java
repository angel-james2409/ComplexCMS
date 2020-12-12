package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.Customer;
import java.util.List;


public interface CustomerDAO {
    boolean insertCustomer(Customer customer)throws Throwable;
    boolean updateCustomer(Customer customer)throws Throwable;
    boolean deleteCustomer(int id)throws Throwable;
    Customer findCustomer(int id)throws Throwable;
    List<Customer> getAllCustomers() throws Throwable;
    
}
