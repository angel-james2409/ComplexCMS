package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.FoodItem;
import java.util.List;


public interface FoodItemDAO{
    boolean insertFoodItem(FoodItem foodItem)throws Throwable;
    boolean updateFoodItem(FoodItem foodItem)throws Throwable;
    boolean deleteFoodItem(int id)throws Throwable;
    FoodItem findFoodItem(int id)throws Throwable;
    List<FoodItem> getAllFoodItems() throws Throwable;
    
}