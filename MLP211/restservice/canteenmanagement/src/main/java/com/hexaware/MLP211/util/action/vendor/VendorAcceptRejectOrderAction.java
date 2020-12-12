package com.hexaware.MLP211.util.action.vendor;
import com.hexaware.MLP211.factory.OrderServiceImpl;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.model.Order;
import com.hexaware.MLP211.model.UserInfo;
import com.hexaware.MLP211.factory.VendorServiceImpl;
import com.hexaware.MLP211.util.util.InputUtil;
import com.hexaware.MLP211.model.OrderStatus;
import com.hexaware.MLP211.model.Vendor;
import com.hexaware.MLP211.factory.OrderService;
import com.hexaware.MLP211.factory.VendorService;
import java.util.List;


public class VendorAcceptRejectOrderAction extends Action{

   @Override
   public void begin(){
      //System.out.println("angel");
      System.out.println("\t\tAccept/Reject order");
      System.out.println("\t---------------------------------");

   }

   @Override
   public void execute(){
      System.out.println("execute");

      try{
         OrderService os=new OrderServiceImpl();
         List<Order>allOrders=os.getAllOrders();

         Vendor vendor=null;
         int vendorId=UserInfo.Customer_Vendor_Id;
         VendorService vs=new VendorServiceImpl();
         vendor=vs.findVendor(vendorId);

         InputUtil util=new InputUtil();
         int ordId=util.readOrderIdInput("Select the Order to Accept/Reject", allOrders, OrderStatus.PENDING,vendor );

         Order order=os.findOrder(ordId);

         System.out.println("\n\t\t 1.ACCEPT");
         System.out.println("\n\t\t 2.REJECT");
         int choice=util.readIntInput("Enter Choice");
         if(choice==1)
            order.setOrderStatus(OrderStatus.ACCEPTED);
         if(choice==2)
         order.setOrderStatus(OrderStatus.CANCELLED);
         System.out.println(order);
         boolean result=os.updateOrder(order);
         System.out.println(result);



      }catch(Throwable e){
         e.printStackTrace();
      }


    }

    @Override
    public void end(){
       //System.out.println("end");  
       System.out.println("-------------END------------");
    }
}