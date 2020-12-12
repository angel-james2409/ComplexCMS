package com.hexaware.MLP211.util.menu;

import java.util.LinkedList;

import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.util.action.vendor.VendorAcceptRejectOrderAction;
import com.hexaware.MLP211.util.action.vendor.VendorAddFoodAction;
import com.hexaware.MLP211.util.action.vendor.VendorExitAction;
import com.hexaware.MLP211.util.action.vendor.VendorUpdateMyInfoAction;
import com.hexaware.MLP211.util.action.vendor.VendorViewMyInfoAction;
import com.hexaware.MLP211.util.action.vendor.VendorViewOrdersAction;
import com.hexaware.MLP211.util.action.vendor.VendorChangePasswordAction;
public class VendorMenu extends Menu{
    @Override
    public void init(){
        menuItems= new LinkedList<String>();
        menuItems.add("View My Info");
        menuItems.add("Accept/Reject Orders");      
        menuItems.add("View Orders");
        menuItems.add("Update My Info");
        menuItems.add("Add New Food Item");
        menuItems.add("Change Password");
        menuItems.add("Exit");
    }

    @Override
    public void dispatchAction(int choice){
        Action action=null;
        switch(choice){
            case 1:action=new VendorViewMyInfoAction();
                    break;
            case 2:action=new VendorAcceptRejectOrderAction();
                    break;           
            case 3:action= new VendorViewOrdersAction();
                    break;
            case 4:action= new VendorUpdateMyInfoAction();
                    break;
            case 5:action= new VendorAddFoodAction();
                    break;
            case 6:action= new VendorChangePasswordAction();
                    break;
            case 7:action= new VendorExitAction();
        }
        action.go();
    }
}