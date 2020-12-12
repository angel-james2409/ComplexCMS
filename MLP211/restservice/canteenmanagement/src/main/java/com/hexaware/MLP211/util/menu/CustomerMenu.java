package com.hexaware.MLP211.util.menu;
import com.hexaware.MLP211.util.action.Action;
import java.util.LinkedList;

import com.hexaware.MLP211.util.action.customer.CustomerViewMyInfoAction;
import com.hexaware.MLP211.util.action.customer.CustomerChangePasswordAction;
import com.hexaware.MLP211.util.action.customer.CustomerExitAction;
import com.hexaware.MLP211.util.action.customer.CustomerOrderFoodItemsAction;
import com.hexaware.MLP211.util.action.customer.CustomerRechargeWalletAction;
import com.hexaware.MLP211.util.action.customer.CustomerUpdateMyInfoAction;
import com.hexaware.MLP211.util.action.customer.CustomerViewOrderHistoryAction;
import com.hexaware.MLP211.util.action.customer.CustomerViewWalletDetailsAction;

public class CustomerMenu extends Menu{
    @Override
    public void init(){
        menuItems= new LinkedList<String>();
        menuItems.add("View My Info");
        menuItems.add("View Wallet Details");
        menuItems.add("Order Food Items");   
        menuItems.add("View Order History");
        menuItems.add("Change Password");     
        menuItems.add("Update My Info");
        menuItems.add("Recharge Wallet");
        menuItems.add("Exit");
    }

    @Override
    public void dispatchAction(int choice){
        Action action=null;
        switch(choice){
            case 1:action=new CustomerViewMyInfoAction();
                    break;
            case 2:action=new CustomerViewWalletDetailsAction();
                    break; 
            case 3:action= new CustomerOrderFoodItemsAction();
                    break;           
            case 4:action= new CustomerViewOrderHistoryAction();
                    break;
            case 5:action= new CustomerChangePasswordAction();
                    break;
            case 6:action= new CustomerUpdateMyInfoAction();
                    break;
            case 7:action= new CustomerRechargeWalletAction();
                    break;  
            case 8:action= new CustomerExitAction();      
        }
        action.go();
    }
}