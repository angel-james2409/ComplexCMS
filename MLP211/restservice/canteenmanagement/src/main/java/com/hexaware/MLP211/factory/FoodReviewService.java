package com.hexaware.MLP211.factory;
import com.hexaware.MLP211.model.FoodReview;
import java.util.List;


public interface FoodReviewService  {
    boolean addFoodReview(FoodReview foodReview)throws Throwable;
    boolean updateFoodReview(FoodReview foodReview)throws Throwable;
    boolean removeFoodReview(int id)throws Throwable;
    FoodReview findFoodReview(int id)throws Throwable;
    List<FoodReview> getAllFoodReviews() throws Throwable;
    
}
