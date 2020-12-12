package com.hexaware.MLP211.util.action.vendor;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.util.util.OutputUtil1;
import com.hexaware.MLP211.model.UserInfo;
import com.hexaware.MLP211.model.Vendor;
import com.hexaware.MLP211.factory.VendorServiceImpl;
import com.hexaware.MLP211.model.ContactInfo;

public class VendorViewMyInfoAction extends Action{

     @Override
     public void begin(){
     // System.out.println("Vikal Singh");
      System.out.println("\t\tView Info");
      System.out.println("\t-----------------------------");
     }
  
     @Override
      public void execute(){
           try{
           int id=UserInfo.Customer_Vendor_Id;
           Vendor vendor=new VendorServiceImpl().findVendor(id);
           OutputUtil1 util=new OutputUtil1();
           util.displayString("name",vendor.getName());
           util.displayString("address",vendor.getAddress());
           util.displayString("contact person",vendor.getContactPersonName());
           util.displayString("phone one",vendor.getContactInfo().getPhoneOne());
           util.displayString("phone two",vendor.getContactInfo().getPhoneTwo());
           util.displayString("email",vendor.getContactInfo().getEmail());

           
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