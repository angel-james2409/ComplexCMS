package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.FoodReview;
import java.util.List;


public interface FoodReviewDAO  {
    boolean insertFoodReview(FoodReview foodReview)throws Throwable;
    boolean updateFoodReview(FoodReview foodReview)throws Throwable;
    boolean deleteFoodReview(int id)throws Throwable;
    FoodReview findFoodReview(int id)throws Throwable;
    List<FoodReview> getAllFoodReviews() throws Throwable;
    
}
