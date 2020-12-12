package com.hexaware.MLP211.util.action.admin;

import java.util.Calendar;

import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.factory.CustomerService;
import com.hexaware.MLP211.factory.CustomerServiceImpl;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.util.util.InputUtil;
import com.hexaware.MLP211.factory.UserLoginServiceImpl;
import com.hexaware.MLP211.factory.UserLoginService;
import com.hexaware.MLP211.model.UserType;
import com.hexaware.MLP211.model.UserLogin;

public class AdminAddCustomerAction extends Action{

    @Override
    public void begin(){
        //System.out.println("Anshuman");
        System.out.println("\t\t Add Customer");
        System.out.println("\t--------------------------------------");
    }

    @Override
    public void execute(){
        System.out.println("execute");

        String name,phoneOne,phoneTwo,email;
        Calendar dob;

        InputUtil util=new InputUtil();
        

        name=util.readStringInput("Enter Name");
        phoneOne=util.readStringInput("Enter Phone number1");
        phoneTwo=util.readStringInput("Enter Phone number2");
        email=util.readStringInput("Enter Email");
        dob=util.readCalendarInput("Enter DOB");
        
        Customer customer=new Customer();
        customer.setName(name);
        customer.getContactInfo().setPhoneOne(phoneOne);
        customer.getContactInfo().setPhoneTwo(phoneTwo);
        customer.getContactInfo().setEmail(email);
        customer.setDateOfBirth(dob);

        CustomerService customerService;
        customerService=new CustomerServiceImpl();

        try{
            boolean result=customerService.addCustomer(customer);

            UserLoginService userLoginService=new UserLoginServiceImpl();
            UserLogin userLogin=new UserLogin();
            userLogin.setUserName(name);    
            userLogin.setPassword(name);
            userLogin.setLastPasswordUpdate(Calendar.getInstance());
            userLogin.setUserType(UserType.CUSTOMER);
            userLogin.setCustomerVendorId(customer.getId());

            boolean accCreated=userLoginService.addUserLogin(userLogin);
            
            if(result == true && accCreated == true)
                System.out.println(result);

           
        }catch(Throwable e){
            e.printStackTrace();
        }

    }

    @Override
    public void end(){
        System.out.println("-----------END---------------");
    }

}