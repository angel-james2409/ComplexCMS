package com.hexaware.MLP211.util.action.vendor;
import com.hexaware.MLP211.model.FoodItem;
import com.hexaware.MLP211.model.Vendor;
import com.hexaware.MLP211.model.UserInfo;
import com.hexaware.MLP211.factory.FoodItemServiceImpl;
import com.hexaware.MLP211.factory.VendorServiceImpl;

import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.util.util.InputUtil;

public class VendorAddFoodAction extends Action{
    @Override
    public void begin(){
        System.out.println("\t\tAdd Food");
        System.out.println("\t----------------------------------");
     //System.out.println("Begin");
    }
    @Override
    public void execute(){

        try{
    
        String name,description;
        int prepTime;
        double price;

        InputUtil util=new InputUtil();

        name=util.readStringInput("Enter Food Name");
        description=util.readStringInput("Enter Description");
        prepTime=util.readIntInput("Preparation Time (Mins)");
        price=util.readDoubleInput("Enter Price");

        Vendor v=new VendorServiceImpl().findVendor(UserInfo.Customer_Vendor_Id);

        FoodItem foodItem=new FoodItem();
        foodItem.setName(name);
        foodItem.setDescription(description);
        foodItem.setPrice(price);
        foodItem.setPreparationTime(prepTime);
        foodItem.setVendor(v);

        boolean result=new FoodItemServiceImpl().addFoodItem(foodItem);

        System.out.println(result);

        }catch(Throwable e){
            e.printStackTrace();
        }


    }
 
     @Override
     public void end(){
          System.out.println("---------------END---------------");
     }

}