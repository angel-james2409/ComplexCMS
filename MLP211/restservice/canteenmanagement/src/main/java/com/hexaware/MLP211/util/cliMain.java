package com.hexaware.MLP211.util;

import com.hexaware.MLP211.util.menu.CustomerMenu;
import com.hexaware.MLP211.util.menu.Menu;
import com.hexaware.MLP211.util.menu.VendorMenu;
import com.hexaware.MLP211.model.UserLogin;
import com.hexaware.MLP211.util.action.UserLoginAction;
import com.hexaware.MLP211.util.menu.AdminMenu;

public class cliMain{
    public static void main(String... args) {
        //Menu menu;
        //menu= new VendorMenu();
        //menu=new CustomerMenu();
        //menu=new AdminMenu();
         new UserLoginAction().go();
        
    }
}