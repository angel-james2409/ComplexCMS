package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.OrderItem;
import com.hexaware.MLP211.persistence.OrderItemDAO;

import java.util.List;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;


public class OrderItemDAOImpl implements OrderItemDAO{
    @Override
    public boolean insertOrderItem(OrderItem orderItem, int slno)throws Throwable
    {
         try{		
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		OrderItemJdbi jdbi = dbi.open(OrderItemJdbi.class);
        int i  =jdbi.insert(orderItem,orderItem.getOrder(), orderItem.getFoodItem(), slno);
       
        return true;   
        }catch(Throwable e ){
        e.printStackTrace();
			return false;
		}
    }  
    
    @Override
    public boolean updateOrderItem(OrderItem orderItem,int slno)throws Throwable
    {
          return false;
    } 
    @Override
    public boolean deleteOrderItem(int id,int slno)throws Throwable
    {
       return false; 
    }
    @Override
    public OrderItem findOrderItem(int id,int slno)throws Throwable
    {
        return null;
    }
    @Override
    public List<OrderItem> getAllOrderItems(int id) throws Throwable{
        return null;
    }
    
} 