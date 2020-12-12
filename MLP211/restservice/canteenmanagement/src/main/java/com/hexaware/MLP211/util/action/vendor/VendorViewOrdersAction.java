package com.hexaware.MLP211.util.action.vendor;
import com.hexaware.MLP211.model.FoodItem;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.factory.OrderServiceImpl;
import com.hexaware.MLP211.factory.VendorServiceImpl;
import com.hexaware.MLP211.model.Order;
import com.hexaware.MLP211.model.Vendor;
import com.hexaware.MLP211.model.OrderStatus;
import com.hexaware.MLP211.util.util.OutputUtil2;
import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.factory.OrderService;
import com.hexaware.MLP211.factory.VendorService;
import com.hexaware.MLP211.model.UserInfo;
import java.util.List;
import java.util.LinkedList;
import java.text.SimpleDateFormat;


public class VendorViewOrdersAction extends Action{

     @Override
     public void begin(){
      //System.out.println("Vikal Singh");    
      System.out.println("\t\tViewOrders");
      System.out.println("\t-----------------------------");
     }
  
     @Override
      public void execute(){
          try{
               OrderService os=new OrderServiceImpl();
               List<Order>allOrders=os.getAllOrders();
      
               Vendor vendor=null;
               int vendorId=UserInfo.Customer_Vendor_Id;
               VendorService vs=new VendorServiceImpl();
               vendor=vs.findVendor(vendorId);
               List<Order> vendorOrders=new LinkedList<Order>();
               for(Order order:allOrders){
                    if(order.getVendor().equals(vendor)){
                         vendorOrders.add(order);
                    }
               }
               OutputUtil2 util=new OutputUtil2();
               util.setTitle("Order Listing");

               util.addColumn("Order Id",15);
               util.addColumn("Order Date/Time",20);
               util.addColumn("Customer",30);
               util.addColumn("Total",15);
               util.addColumn("Status",20);

               util.displayTitle('-');
               util.displayColumns();

               for(Order order:vendorOrders){
                    util.displayLeftAlign(order.getId()+"",15,true,false);   
                    SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
                    String str=sdf.format(order.getOrderDate().getTime());
                    util.displayCenterAlign(str,20,false,false);
                    util.displayCenterAlign(order.getCustomer().getName(),30,false,false);
                    util.displayCenterAlign(order.computeTotal()+"",15,false,false);
                    util.displayRightAlign(order.getOrderStatus().toString(), 20, false, true);

               }

      }catch(Throwable e){
           e.printStackTrace();
      }

      }
  
      @Override
      public void end(){
           //System.out.println("end");
           System.out.println("-------------END----------------");
      }
  
 }