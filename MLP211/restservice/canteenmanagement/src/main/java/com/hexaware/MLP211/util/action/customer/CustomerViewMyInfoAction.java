package com.hexaware.MLP211.util.action.customer;
 import com.hexaware.MLP211.model.ContactInfo;
import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.model.UserInfo;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.factory.CustomerServiceImpl;
 import com.hexaware.MLP211.util.util.OutputUtil1;


public class CustomerViewMyInfoAction extends Action{

    @Override
    public void begin(){
        //System.out.println("begin");
        //System.out.println("Raji");
        System.out.println("\t\tMY INFO");
        System.out.println("\t----------------------");
    }

    @Override
    public void execute(){
      try{
          int id=UserInfo.Customer_Vendor_Id;
          Customer customer=new CustomerServiceImpl().findCustomer(id);
          OutputUtil1 util= new OutputUtil1();
          util.displayString("Name",customer.getName());
          util.displayDate("Dateofbirth",customer.getDateOfBirth());
          util.displayString("PhoneOne",customer.getContactInfo().getPhoneOne());
          util.displayString("PhoneTwo",customer.getContactInfo().getPhoneTwo());
          util.displayString("Email",customer.getContactInfo().getEmail());
      }catch(Throwable e){
          e.printStackTrace();
      }
        

    }

    @Override
    public void end(){
        //System.out.println("end");
        System.out.println("-------------END-----------");
    }

}