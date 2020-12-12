package com.hexaware.MLP211.util.action.customer;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.util.util.OutputUtil2;
import java.text.SimpleDateFormat;

import java.util.*;

import com.hexaware.MLP211.factory.CustomerService;
import com.hexaware.MLP211.factory.CustomerServiceImpl;
import com.hexaware.MLP211.factory.OrderService;
import com.hexaware.MLP211.factory.OrderServiceImpl;

import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.model.Order;
import com.hexaware.MLP211.model.UserInfo;

public class CustomerViewOrderHistoryAction extends Action{
    public void begin(){
        System.out.println("View order history ");
        System.out.println("-------------------");
    }
    public void execute(){

          //Service layer code.
         // List of order from service code.
         // for loop to display.
         try{
         Customer customer=null;

         CustomerService cs=new CustomerServiceImpl();
         customer =cs.findCustomer(UserInfo.Customer_Vendor_Id);

         //System.out.println("UI:..."+ customer);

         OrderService os= new OrderServiceImpl();
         List<Order> allOrders=os.getAllOrders();

         //System.out.println("UI:...."+allOrders.size());

         List<Order> thisCustomerOrders=new LinkedList<Order>();
         for(Order order:allOrders){
             if(order.getCustomer().equals(customer)){
                 //System.out.println("UI...:"+ order.getCustomer());
                 thisCustomerOrders.add(order);

             }
         }

         //System.out.println("UI:...."+thisCustomerOrders.size());
         OutputUtil2 util2=new OutputUtil2();
         util2.setTitle("Order History");
         util2.addColumn("Order Id",15);
         util2.addColumn("Order Date",20);
         util2.addColumn("Vendor",25);
         util2.addColumn("Total Value",20);
         util2.addColumn("Actual Delivery Time",20);
         
         util2.displayTitle('-');
         util2.displayColumns();

         for(Order order:thisCustomerOrders){
             util2.displayLeftAlign(order.getId()+" ",15 ,true,false);
             Calendar cal1=order.getOrderDate();
             if(cal1!=null){
                 Date date=cal1.getTime();
                 SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
                 String str=sdf.format(date);
                 util2.displayLeftAlign(str,20 ,false,false);

    
             }
             else
             util2.displayLeftAlign(" ",20 ,false,false);


             util2.displayLeftAlign(order.getVendor().getName(),27 ,false,false);
             util2.displayLeftAlign(order.getAmount()+" ",15 ,false,false);

             Calendar cal=order.getActualDeliveryTime();
             if(cal!=null){
                 Date date=cal.getTime();
                 SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
                 String str=sdf.format(date);

                util2.displayLeftAlign(str,20 ,false,true);

             }
             else

             util2.displayLeftAlign(" ",15,false,true);

            
         }
         String str=util2.replicate('-',util2.totalReportWidth);
         System.out.println("\t"+str);

        }catch(Throwable e){
            e.printStackTrace();
        }





    }
    public void end(){
        System.out.println("----------------------------");
    }

}