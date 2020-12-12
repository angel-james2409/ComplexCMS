package com.hexaware.MLP211.util.action.customer;
import java.util.Calendar;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.util.util.InputUtil;
import com.hexaware.MLP211.factory.CustomerServiceImpl;
import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.model.ContactInfo;
import com.hexaware.MLP211.util.util.OutputUtil1;
import com.hexaware.MLP211.model.UserInfo;
public class CustomerUpdateMyInfoAction extends Action{

    @Override
    public void begin(){
        //System.out.println("Raji");
        System.out.println("\t\tUpdate Info");
        System.out.println("________________________________");
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
            
            String name,phoneOne,phoneTwo,email;
            Calendar dateOfBirth;
             InputUtil util2=new InputUtil();
             name=util2.readStringInput("Enter new name");
             phoneOne=util2.readStringInput("Enter new phone number1");
             phoneTwo=util2.readStringInput("Enter new phone number2");
             email=util2.readStringInput("Enter new email");
             dateOfBirth=util2. readCalendarInput("Enter new dateOfBirth");
             customer.setName(name);
             customer.getContactInfo().setPhoneOne(phoneOne);
             customer.getContactInfo().setPhoneTwo(phoneTwo);
             customer.getContactInfo().setEmail(email);
             customer.setDateOfBirth(dateOfBirth);
             boolean result=new CustomerServiceImpl().updateCustomer(customer);
             System.out.println(result);

        }catch(Throwable e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void end(){
        System.out.println("------end-----");
    }
}