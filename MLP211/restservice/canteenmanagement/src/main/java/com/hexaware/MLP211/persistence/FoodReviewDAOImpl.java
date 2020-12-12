package com.hexaware.MLP211.persistence;

import com.hexaware.MLP211.model.FoodReview;
import com.hexaware.MLP211.persistence.FoodReviewDAO;
import java.util.List;

public class FoodReviewDAOImpl implements FoodReviewDAO{
    @Override
    public boolean insertFoodReview(FoodReview foodReview)throws Throwable
    {
        return false;   
    }
    @Override
    public boolean updateFoodReview(FoodReview foodReview)throws Throwable
    {
            return false; 
    } 
    @Override
    public boolean deleteFoodReview(int id)throws Throwable
    {
        return false;
    }
    @Override
    public FoodReview findFoodReview(int id)throws Throwable
    {
        return null;
    }
    @Override
    public List<FoodReview> getAllFoodReviews() throws Throwable{
        return null;
    }
    
} 