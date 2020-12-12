package com.hexaware.MLP211.util.menu;
import com.hexaware.MLP211.util.action.Action;
import java.util.LinkedList;
import java.util.List;

import com.hexaware.MLP211.util.action.admin.AdminDeleteCustomerAction;
import com.hexaware.MLP211.util.action.admin.AdminDeleteVendorAction;
import com.hexaware.MLP211.util.action.admin.AdminExitAction;
import com.hexaware.MLP211.util.action.admin.AdminViewVendorAction;
import com.hexaware.MLP211.util.action.admin.AdminAddVendorAction;
import com.hexaware.MLP211.util.action.admin.AdminAddCustomerAction;
import com.hexaware.MLP211.util.action.admin.AdminViewCustomerAction;

public class AdminMenu extends Menu{
    @Override
    public void init(){
        menuItems= new LinkedList<String>();
        menuItems.add("View Vendor");
        menuItems.add("View Customer");
        menuItems.add("Delete Vendor");
        menuItems.add("Delete Customer");
        menuItems.add("Add New Vendor");
        menuItems.add("Add New Customer");        
        menuItems.add("Exit");
    }
    @Override
    public void dispatchAction(int choice){
        Action action=null;
        switch(choice){
            case 1:action=new AdminViewVendorAction();
                    break;
            case 2:action= new AdminViewCustomerAction();
                    break;
            case 3:action=new AdminDeleteVendorAction();
                    break; 
            case 4:action= new AdminDeleteCustomerAction();
                    break;
            case 5:action=new AdminAddVendorAction();
                    break;
            case 6:action=new AdminAddCustomerAction();
                    break;           
            case 7:action= new AdminExitAction();

        }
        action.go();
    }
}