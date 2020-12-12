package com.hexaware.MLP211.factory;
import com.hexaware.MLP211.model.OrderItem;
import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.model.Vendor;
import com.hexaware.MLP211.model.Order;
import com.hexaware.MLP211.factory.OrderService;
import com.hexaware.MLP211.factory.CustomerServiceImpl;
import com.hexaware.MLP211.factory.VendorServiceImpl;
import java.util.List;
import com.hexaware.MLP211.persistence.OrderItemDAO;
import com.hexaware.MLP211.persistence.OrderItemDAOImpl;
import com.hexaware.MLP211.persistence.OrderDAO; 
import com.hexaware.MLP211.persistence.OrderDAOImpl;

public class OrderServiceImpl implements OrderService{
    @Override
    public boolean addOrder(Order order)throws Throwable
    {

        System.out.println("Service : "+ order.getOrderStatus());
        try{
        OrderDAO dao = new OrderDAOImpl();
        dao.insertOrder(order);
        
        List<OrderItem> items = order.getOrderItemsList();
        int count=0;
        for(OrderItem item:items){
             OrderItemDAO dao1 = new OrderItemDAOImpl();
             dao1.insertOrderItem(item,count);
             count++;
         
        }
            return true;
        }
            catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
   @Override
    public boolean updateOrder(Order order)throws Throwable
    {
        Customer customer= new CustomerServiceImpl().findCustomer(order.getCustomer().getId());
        order.setCustomer(customer);

        Vendor vendor= new VendorServiceImpl().findVendor(order.getVendor().getId());
        order.setVendor(vendor);
        return new OrderDAOImpl().updateOrder(order); 
    } 
    @Override
    public boolean removeOrder(int id)throws Throwable
    {
        return new OrderDAOImpl().deleteOrder(id);
    }
    @Override
    public Order findOrder(int id)throws Throwable
    {
        return new OrderDAOImpl().findOrder(id);
    }
    @Override
    public List<Order> getAllOrders() throws Throwable{
        List<Order> orders= new OrderDAOImpl().getAllOrders();
        for(Order ord: orders){
            Customer customer= new CustomerServiceImpl().findCustomer(ord.getCustomer().getId());
            ord.setCustomer(customer);

            Vendor vendor= new VendorServiceImpl().findVendor(ord.getVendor().getId());
            ord.setVendor(vendor);
        }
        return orders;
    }
    
} 