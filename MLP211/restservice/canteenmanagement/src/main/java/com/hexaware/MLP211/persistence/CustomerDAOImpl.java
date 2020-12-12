package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.persistence.CustomerDAO;
import java.util.List;

import org.skife.jdbi.v2.DBI;


public class CustomerDAOImpl implements CustomerDAO{
    @Override
    public boolean insertCustomer(Customer customer)throws Throwable
    {
		try{
		
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		CustomerJdbi jdbi = dbi.open(CustomerJdbi.class);   
        int i=jdbi.insert(customer,customer.getDateOfBirth().getTime(), customer.getContactInfo().getEmail(), customer.getContactInfo().getPhoneOne(), customer.getContactInfo().getPhoneTwo());
        customer.setId(i);
        return true;

		}catch(Throwable e){
            e.printStackTrace();
			return false;
		}
		
    }
    @Override
    public boolean updateCustomer(Customer customer)throws Throwable
    {
        boolean result=false;
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		CustomerJdbi jdbi = dbi.open(CustomerJdbi.class);
		int rc=jdbi.update(customer, customer.getDateOfBirth().getTime(),customer.getContactInfo().getEmail(), customer.getContactInfo().getPhoneOne(), customer.getContactInfo().getPhoneTwo());
		if(rc>0) result=true;
		return result;
    } 
    @Override
    public boolean deleteCustomer(int id)throws Throwable
    {
        boolean result=false;
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		CustomerJdbi jdbi = dbi.open(CustomerJdbi.class);
		int rc=jdbi.delete(id);
		if(rc>0) result=true;
        return result;
    }
    @Override
    public Customer findCustomer(int id)throws Throwable
    {
        Customer c=null;
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		CustomerJdbi jdbi = dbi.open(CustomerJdbi.class);
		c=jdbi.find(id);
		return c;
    }
    @Override
    public List<Customer> getAllCustomers() throws Throwable{
        DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		CustomerJdbi jdbi = dbi.open(CustomerJdbi.class);
		return jdbi.getAll();
    }
    
} 