package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.FoodItem;
import com.hexaware.MLP211.persistence.FoodItemDAO;
import java.util.List;

import org.skife.jdbi.v2.DBI;

public class FoodItemDAOImpl implements FoodItemDAO{
    @Override
    public boolean insertFoodItem(FoodItem foodItem)throws Throwable
    {
        try{
            DBI dbi= new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false","root", "Password123");
            FoodItemJdbi jdbi=dbi.open(FoodItemJdbi.class);
            int rowgen= jdbi.insert(foodItem, foodItem.getVendor());
            return true;
            }
            catch(Throwable e){
                e.printStackTrace();
                return false;
            }   
    }
    @Override
    public boolean updateFoodItem(FoodItem foodItem)throws Throwable{
        
            DBI dbi= new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false","root", "Password123");
            FoodItemJdbi jdbi=dbi.open(FoodItemJdbi.class);
            int rowgen= jdbi.update(foodItem,foodItem.getVendor());
            if(rowgen>0)
                return true;
            else 
                return false;  
    } 
    @Override
    public boolean deleteFoodItem(int id)throws Throwable{
        DBI dbi= new DBI("jdbc:mysql://localhost:3306/MLP211","root", "Password123");
        FoodItemJdbi jdbi=dbi.open(FoodItemJdbi.class);
        int rowgen= jdbi.delete(id);
        if(rowgen>0)
            return true;
        else 
            return false;
    }
    @Override
    public FoodItem findFoodItem(int id)throws Throwable{
        DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		FoodItemJdbi jdbi = dbi.open(FoodItemJdbi.class);
		FoodItem obj=jdbi.find(id);
		return obj;
    }
    @Override
    public List<FoodItem> getAllFoodItems() throws Throwable{
        DBI dbi = new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false", "root", "Password123");
		FoodItemJdbi jdbi = dbi.open(FoodItemJdbi.class);
		return jdbi.getAll();
    }
    
} 