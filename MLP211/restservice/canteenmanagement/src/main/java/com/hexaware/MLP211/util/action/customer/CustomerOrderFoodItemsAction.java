package com.hexaware.MLP211.util.action.customer;


import java.util.*;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.model.FoodItem;
import com.hexaware.MLP211.model.Order;
import com.hexaware.MLP211.model.OrderStatus;
import com.hexaware.MLP211.model.OrderItem;
import com.hexaware.MLP211.util.util.InputUtil;
import com.hexaware.MLP211.util.util.OutputUtil1;
import com.hexaware.MLP211.factory.FoodItemService;
import com.hexaware.MLP211.factory.VendorService;
import com.hexaware.MLP211.factory.VendorServiceImpl;
import com.hexaware.MLP211.factory.FoodItemServiceImpl;
import com.hexaware.MLP211.factory.CustomerServiceImpl;
import com.hexaware.MLP211.factory.OrderService; 
import com.hexaware.MLP211.factory.OrderServiceImpl; 
import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.model.Vendor;

import com.hexaware.MLP211.model.UserInfo;
public class CustomerOrderFoodItemsAction extends Action{

    @Override
    public void begin(){
        //System.out.println("begin");
         System.out.println("\t\tORDERING FOOD ");
          //System.out.println("---Radhika---");
          System.out.println("\t-----------------------------");
    }

    @Override
     public void execute(){
       try{
           Customer c=new CustomerServiceImpl().findCustomer(UserInfo.Customer_Vendor_Id);
           FoodItemService foodItemService=new FoodItemServiceImpl();

           VendorService vs=new VendorServiceImpl();
           List<Vendor> vendors=vs.getAllVendors();

            

           List<FoodItem> allfoodItems=foodItemService.getAllFoodItems();

           InputUtil util=new InputUtil();

           

           int vendorId=util.readVendorIdInput("Select Vendor to Place Order ", vendors);
           Vendor vendor=vs.findVendor(vendorId);

           Order order=new Order();
           order.setCustomer(c);
           order.setVendor(vendor);
           

           while(true){
                int foodId=util.readFoodItemsInput("Select The Food you want to Order " ,allfoodItems, vendor);
                FoodItem foodItem=foodItemService.findFoodItem(foodId);

                order.setVendor(foodItem.getVendor());
                
                double price=foodItem.getPrice();

                OutputUtil1 util1=new OutputUtil1();
                util1.displayDouble("Price ", price);

                int qty=util.readIntInput("Quantity");

                OrderItem oi=new OrderItem();
                oi.setFoodItem(foodItem);
                oi.setPrice(price);
                oi.setQuantity(qty);
                oi.setOrder(order);
                order.addItem(oi);

                boolean orderMore;
                orderMore=util.readBooleanInput("Do you want to Order More") ;
                if(orderMore==false)
                    break;
           }
           

           double total=order.computeTotal();
           double disc=order.computeDiscount();
           Calendar estimatedTimeCal=order.computeEstimatedTime();
           
           order.setOrderDate(Calendar.getInstance());
           order.setOrderTime(Calendar.getInstance());
           order.setOrderStatus(OrderStatus.PENDING);
           // display Order

           OrderService orderService=new OrderServiceImpl();
           boolean result = orderService.addOrder(order);
            /// wallet deduction code here
            
           System.out.println(result);


       }catch(Throwable e){
           e.printStackTrace();
       }
    }

    @Override
    public void end(){
        //System.out.println("end");
         System.out.println("-------------");
    }

}