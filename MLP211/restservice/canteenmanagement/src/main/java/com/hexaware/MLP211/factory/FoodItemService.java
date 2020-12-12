package com.hexaware.MLP211.factory;
import com.hexaware.MLP211.model.FoodItem;
import java.util.List;


public interface FoodItemService{
    boolean addFoodItem(FoodItem foodItem)throws Throwable;
    boolean updateFoodItem(FoodItem foodItem)throws Throwable;
    boolean removeFoodItem(int id)throws Throwable;
    FoodItem findFoodItem(int id)throws Throwable;
    List<FoodItem> getAllFoodItems() throws Throwable;
    
}