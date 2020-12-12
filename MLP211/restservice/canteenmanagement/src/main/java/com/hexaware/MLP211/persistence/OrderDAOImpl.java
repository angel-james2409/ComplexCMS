package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.Order;
import com.hexaware.MLP211.persistence.OrderDAO;
import java.util.List;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;


public class OrderDAOImpl  implements OrderDAO{
    @Override
    public boolean insertOrder(Order order)throws Throwable
    {
        try{		
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
        OrderJdbi jdbi = dbi.open(OrderJdbi.class);
        
        System.out.println("DAO :"+order.getVendor());
        System.out.println("DAO :"+order.getCustomer());
        System.out.println("DAO :"+ order.getEstimatedDeliveryTime());
        System.out.println("DAO :"+ order.getOrderTime());
        System.out.println("DAO :"+ order.getOrderDate());
        System.out.println("DAO :"+ order.getOrderStatus());

        int i  =jdbi.insert(order, order.getVendor().getId(),order.getCustomer().getId(),order.getOrderDate().getTime(),order.getEstimatedDeliveryTime().getTime(),order.getOrderStatus().toString());
        
        order.setId(i);
        return true;   
        }catch(Throwable e ){
            e.printStackTrace();
			return false;
		}
    }
    @Override
    public boolean updateOrder(Order order)throws Throwable
    {
             try{		
         DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
         OrderJdbi jdbi = dbi.open(OrderJdbi.class);
         int i  =jdbi.update1(order, order.getVendor().getId(),order.getCustomer().getId(),order.getOrderDate().getTime(),order.getEstimatedDeliveryTime().getTime(),order.getOrderStatus().toString());
          order.setId(i);
         return true;   
        }catch(Throwable e ){
        e.printStackTrace();
        return false;
                }
    } 
    @Override
    public boolean deleteOrder(int id)throws Throwable
    {
        boolean result=false;
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		OrderJdbi jdbi = dbi.open(OrderJdbi.class);
		int rc=jdbi.delete(id);
		if(rc>0) result=true;
		return result;
    }
    @Override
    public Order findOrder(int id)throws Throwable
    {
        Order o=null;
		DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		OrderJdbi jdbi = dbi.open(OrderJdbi.class);
		o=jdbi.find(id);
		return o;
    }
    @Override
    public List<Order> getAllOrders() throws Throwable{
        DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		OrderJdbi jdbi = dbi.open(OrderJdbi.class);
		return jdbi.getAll();
    }
    
} 