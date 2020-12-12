package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.Order;
import java.util.List;


public interface OrderDAO {
    boolean insertOrder(Order order)throws Throwable;
    boolean updateOrder(Order order)throws Throwable;
    boolean deleteOrder(int id)throws Throwable;
    Order findOrder(int id)throws Throwable;
    List<Order> getAllOrders() throws Throwable;
    
}