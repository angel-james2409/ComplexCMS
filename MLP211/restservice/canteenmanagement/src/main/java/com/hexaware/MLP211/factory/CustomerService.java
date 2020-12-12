
package com.hexaware.MLP211.factory;
import com.hexaware.MLP211.model.Customer;
import java.util.List;


public interface CustomerService {
    boolean addCustomer(Customer customer)throws Throwable;
    boolean updateCustomer(Customer customer)throws Throwable;
    boolean removeCustomer(int id)throws Throwable;
    Customer findCustomer(int id)throws Throwable;
    List<Customer> getAllCustomers() throws Throwable;
    
}