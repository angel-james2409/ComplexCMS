package com.hexaware.MLP211.util.action;

import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.util.util.InputUtil;
import com.hexaware.MLP211.factory.UserLoginService;
import com.hexaware.MLP211.factory.UserLoginServiceImpl;
import com.hexaware.MLP211.model.UserLogin;
import com.hexaware.MLP211.model.UserInfo;
import com.hexaware.MLP211.util.menu.Menu;
import com.hexaware.MLP211.util.menu.VendorMenu;
import com.hexaware.MLP211.util.menu.CustomerMenu;
import com.hexaware.MLP211.util.menu.AdminMenu;
import com.hexaware.MLP211.model.UserType;


public class UserLoginAction extends Action{

    @Override
    public void begin(){
        System.out.println("Anshuman");
        System.out.println("\t\tUser Login");
        System.out.println("\t\t-----------");
    }

    @Override
    public void execute(){
        //Service Code: Login User
        try{
            String username, password;
            InputUtil util=new InputUtil();
            username=util.readStringInput("Enter User Name");
            password=util.readPasswordInput("Enter Password");
    
            UserLoginService userLoginService=new UserLoginServiceImpl();
    
            UserLogin userLogin=userLoginService.findUserLogin(username);
    
            if(userLogin==null){
                System.out.println("\n\n...Login Failed...");
                System.exit(0);
            }
            else{

                if(username.equals(userLogin.getUserName()) && password.equals(userLogin.getPassword())){

                
                UserInfo.Customer_Vendor_Id=userLogin.getCustomerVendorId();
                UserInfo.userType=userLogin.getUserType();
                UserInfo.username=userLogin.getUserName();
                UserInfo.password=userLogin.getPassword();
    
                Menu m=null;
                if(UserInfo.userType==UserType.ADMIN)
                    m=new AdminMenu();
    
                if(UserInfo.userType==UserType.CUSTOMER)
                    m=new CustomerMenu();
    
                if(UserInfo.userType==UserType.VENDOR)
                    m=new VendorMenu();
        
                m.handle();
                }else{
                    System.out.println("\n\n...Login Failed....");
                System.exit(0);
                }

            }
    
            }catch(Throwable e){
                e.printStackTrace();
            }
    
    
    }

    @Override
    public void end(){
        System.out.println("-------END-------");
    }

}