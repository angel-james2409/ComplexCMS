package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.OrderItem;
import java.util.List;


public interface OrderItemDAO  {
    boolean insertOrderItem(OrderItem orderItem,int slno)throws Throwable;
    boolean updateOrderItem(OrderItem orderItem,int slno)throws Throwable;
    boolean deleteOrderItem(int id,int slno)throws Throwable;
    OrderItem findOrderItem(int id,int slno)throws Throwable;
    List<OrderItem> getAllOrderItems(int id) throws Throwable;
    
}