package com.hexaware.MLP211.model;
import java.util.Calendar;



public class FoodReview{
    private int id;
    private Calendar reviewDate;
    private String remarks;
    private int rating;
    private Customer customer;
    private Order order;
    public FoodReview(){

    }

   public FoodReview(int id,Calendar reviewDate,String remarks,int rating,Customer customer,Order order){
        this.id=id;
        this.reviewDate=reviewDate;
        this.remarks=remarks;
        this.rating=rating;
        this.customer=customer;
        this.order=order;
    }
   
      public void setId(int id)
    {
        this.id=id;
        
    }
       public int getId(){
        return this.id;
        
    }
     public void setReviewDate(Calendar reviewDate)
    {
        this.reviewDate=reviewDate;
    }
     public Calendar getReviewDate(){
        return this.reviewDate;
    }
     public  void setRemarks(String remarks)
    {
        this.remarks=remarks;
    }
     public String getRemarks(){
        return this.remarks;
    }
    
    
     public  void setrating(int rating)
    {
        this.rating=rating;
    }
     public int getRating(){
        return this.rating;
    }
    public  void setCustomer(Customer customer)
    {
        this.customer=customer;
    }
     public Customer getCustomer(){
        return this.customer;
    }
    public  void setOrder(Order order)
    {
        this.order=order;
    }
     public Order getOrder(){
        return this.order;
    }


    
    @Override
    public boolean equals(Object obj){
            if(this==obj)
            return true;
            if(obj==null)
            return false;
            if(!(obj instanceof FoodReview ))
            return false;
            boolean result=true;
            FoodReview temp=(FoodReview)obj;
            if(this.id==temp.id)
            result=true;
            return result;

    }
    @Override
    public int hashCode(){
        int n=this.id;
        return n;
    }
    @Override
    public String toString(){
        return "FoodReview[Id:"+this.id+",reviewDate:"+this.reviewDate.getTime()+",Remarks:"+this.remarks+",Rating:"+this.rating+",customer:"+this.customer+",order:"+this.order+"]";
    }

}