package com.hexaware.MLP211.factory;

import com.hexaware.MLP211.persistence.FoodItemDAO;
import com.hexaware.MLP211.persistence.FoodItemDAOImpl;
import com.hexaware.MLP211.model.FoodItem;
import com.hexaware.MLP211.model.Vendor;
import java.util.List;

public class FoodItemServiceImpl implements FoodItemService{
    @Override
    public boolean addFoodItem(FoodItem foodItem)throws Throwable{
        return new FoodItemDAOImpl().insertFoodItem(foodItem);   
    }
    @Override
    public boolean updateFoodItem(FoodItem foodItem)throws Throwable{
            return new FoodItemDAOImpl().updateFoodItem(foodItem); 
    } 
    @Override
    public boolean removeFoodItem(int id)throws Throwable{
        return new FoodItemDAOImpl().deleteFoodItem(id);
    }
    @Override
    public FoodItem findFoodItem(int id)throws Throwable{
        FoodItem fi=null;
        FoodItemDAO dao= new FoodItemDAOImpl();
        fi= dao.findFoodItem(id);
        Vendor v= new VendorServiceImpl().findVendor(fi.getVendor().getId());
        fi.setVendor(v);
        return fi;
    }
    @Override
    public List<FoodItem> getAllFoodItems() throws Throwable{
        List<FoodItem> allFoodItems= null;
        FoodItemDAO dao= new FoodItemDAOImpl();
        allFoodItems = dao.getAllFoodItems();
        for(FoodItem fi: allFoodItems){
            Vendor v= new VendorServiceImpl().findVendor(fi.getVendor().getId());
            fi.setVendor(v);
        }
        return allFoodItems;
    }
    
} 