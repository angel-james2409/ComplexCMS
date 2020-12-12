package com.hexaware.MLP211.factory;

import com.hexaware.MLP211.model.OrderItem;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService{
    @Override
    public boolean addOrderItem(OrderItem orderItem)throws Throwable
    {
        return false;   
    }
    @Override
    public boolean updateOrderItem(OrderItem orderItem)throws Throwable
    {
            return false; 
    } 
    @Override
    public boolean removeOrderItem(int id)throws Throwable
    {
        return false;
    }
    @Override
    public OrderItem findOrderItem(int id)throws Throwable
    {
        return null;
    }
    @Override
    public List<OrderItem> getAllOrderItems() throws Throwable{
        return null;
    }
    
} 