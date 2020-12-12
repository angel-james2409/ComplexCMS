package com.hexaware.MLP211.util.action.admin;

import com.hexaware.MLP211.model.UserType;
import com.hexaware.MLP211.model.Vendor;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.util.util.InputUtil;
import com.hexaware.MLP211.factory.VendorService;
import com.hexaware.MLP211.factory.VendorServiceImpl;
import com.hexaware.MLP211.factory.UserLoginService;
import com.hexaware.MLP211.factory.UserLoginServiceImpl;
import com.hexaware.MLP211.util.action.UserLoginAction;
import java.util.Calendar;
import com.hexaware.MLP211.model.UserLogin;

public class AdminAddVendorAction extends Action{

    @Override
    public void begin(){
        //System.out.println("Anshuman");
        System.out.println("\t\t Add Vendor");
        System.out.println("\t----------------------------------------");
    }

    @Override
    public void execute(){

        System.out.println("execute");
        String name,phoneOne,phoneTwo,email,address,contactPerson;
        int rating;
       
        InputUtil util=new InputUtil();
        

        name=util.readStringInput("Enter Name");
        phoneOne=util.readStringInput("Enter Phone number1");
        phoneTwo=util.readStringInput("Enter Phone number2");
        address=util.readStringInput("Enter the address");
        contactPerson=util.readStringInput("Enter the contact person");
        email=util.readStringInput("Enter Email");
        rating=util.readIntInput("Enter the rating");

        Vendor vendor=new Vendor();

        vendor.setName(name);
        vendor.getContactInfo().setPhoneOne(phoneOne);
        vendor.getContactInfo().setPhoneTwo(phoneTwo);
        vendor.setAddress(address);
        vendor.setContactPersonName(contactPerson);
        vendor.getContactInfo().setEmail(email);
        vendor.setRating(rating);

        VendorService vendorService;
        vendorService=new VendorServiceImpl();
        
        try{
            boolean result=vendorService.addVendor(vendor);
            UserLoginService userLoginService=new UserLoginServiceImpl();
            UserLogin userLogin=new UserLogin();
            userLogin.setUserName(name);    
            userLogin.setPassword(name);
            userLogin.setLastPasswordUpdate(Calendar.getInstance());
            userLogin.setUserType(UserType.VENDOR);
            userLogin.setCustomerVendorId(vendor.getId());

            boolean accCreated=userLoginService.addUserLogin(userLogin);

            if(result == true && accCreated == true)
                System.out.println(result);
               
            }catch(Throwable e){
                e.printStackTrace();
            }

    }

    @Override
    public void end(){
        System.out.println("---------------------END--------------------------");
    }

}