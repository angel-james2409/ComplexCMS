package com.hexaware.MLP211.factory;
import com.hexaware.MLP211.model.OrderItem;
import java.util.List;


public interface OrderItemService  {
    boolean addOrderItem(OrderItem orderItem)throws Throwable;
    boolean updateOrderItem(OrderItem orderItem)throws Throwable;
    boolean removeOrderItem(int id)throws Throwable;
    OrderItem findOrderItem(int id)throws Throwable;
    List<OrderItem> getAllOrderItems() throws Throwable;
    
}