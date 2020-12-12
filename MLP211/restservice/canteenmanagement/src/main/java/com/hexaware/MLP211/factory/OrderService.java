package com.hexaware.MLP211.factory;
import com.hexaware.MLP211.model.Order;
import java.util.List;


public interface OrderService {
    boolean addOrder(Order order)throws Throwable;
    boolean updateOrder(Order order)throws Throwable;
    boolean removeOrder(int id)throws Throwable;
    Order findOrder(int id)throws Throwable;
    List<Order> getAllOrders() throws Throwable;
    
}