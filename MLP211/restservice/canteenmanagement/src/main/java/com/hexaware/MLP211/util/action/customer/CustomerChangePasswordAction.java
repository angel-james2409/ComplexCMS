package com.hexaware.MLP211.util.action.customer;

import java.util.Calendar;

import com.hexaware.MLP211.model.UserInfo;
import com.hexaware.MLP211.model.UserLogin;
import com.hexaware.MLP211.factory.UserLoginService;
import com.hexaware.MLP211.factory.UserLoginServiceImpl;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.util.util.InputUtil;

public class CustomerChangePasswordAction extends Action{

    @Override
    public void begin(){
        //System.out.println("Anshuman");
        System.out.println("\t\tChange Password");
        System.out.println("\t_______________");
    }


        @Override
    public void execute(){
        try{
        //Service Code: Change Password
        //get old password,get new password,get retypr password
        String password,newPassword1,newPassword2;
        UserLoginService uls=new UserLoginServiceImpl();
        
        String currentUserName=UserInfo.username;
        UserLogin ul=uls.findUserLogin(currentUserName);


       
        InputUtil util=new InputUtil();
        password=util.readPasswordInput("Type Exisiting Password");
         
        if(password.equals(ul.getPassword())){
            newPassword1=util.readPasswordInput("Type new password");
            newPassword2=util.readPasswordInput("ReType new password");
            if(newPassword1.equals(newPassword2))
            {
                ul.setPassword(newPassword1);
                ul.setLastPasswordUpdate(Calendar.getInstance());
                boolean result=uls.updateUserLogin(ul);
                System.out.println(result);
            }
            else
            {
                System.out.println("\t\t new password did not match");
                System.out.println("\t\t try again");
            }
            
        }
        else
        {
            System.out.println("\t\t password did not match");
            System.out.println("\t\t try again");
        }

    }catch (Throwable e){
        e.printStackTrace();
    }

    }

    @Override
    public void end(){
        System.out.println("Password Changed ");
        //Or Not Changed
    }
}