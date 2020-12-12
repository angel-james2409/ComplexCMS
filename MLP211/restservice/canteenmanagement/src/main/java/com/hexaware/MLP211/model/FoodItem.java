package com.hexaware.MLP211.model;
public class FoodItem{
    private int id;
    private String name;
    private String description;
    private double price;
    private int rating;
    private Vendor vendor=new Vendor();
    private int preparationTime;
    private int ratingCount;


    public FoodItem(){
        
    }
    public FoodItem(int id,String name,String description,double price,int rating,Vendor vendor, int preparationTime){
        this.id=id;
        this.name=name;
        this.description=description;
        this.price=price;
        this.rating=rating;
        this.vendor=vendor;
        this.preparationTime=preparationTime;
    }
    public void setId(int id)
    {
        this.id=id;
    
    }
    public int getId() {
        return this.id;
    }
    public void setName(String name)
    {
        this.name=name;
        
    }
       public String getName(){
        return this.name;
        
    }
    public void setDescription(String description)
    {
        this.description=description;
        
    }
       public String getDescription(){
        return this.description;
        
    }
    public void setPrice(double price)
    {
        this.price=price;
    
    }
    public double getPrice() 
    {
        return this.price;
    }
     public void setRating(int rating)
    {
        this.rating=rating;
    
    }
      public int getRating() 
    {
        return this.rating; 
    }
     public void setVendor( Vendor vendor){
         this.vendor=vendor;

     }
     public Vendor getVendor() 
    {
        return this.vendor; 
     }
    public void setPreparationTime(int preparationTime)
    {
        this.preparationTime=preparationTime;
    }
    public int getPreparationTime()
    {
        return this.preparationTime;
    }

    public void setRatingCount(int ratingCount)
    {
        this.ratingCount=ratingCount;
    
    }
    public int getRatingCount() {
        return this.ratingCount;
    }    

     @Override
     public boolean equals(Object obj){
         if(this==obj)
            return true;
         if(obj==null)
            return false;
         if(!(obj instanceof FoodItem ))
            return false;
         boolean result=true;
         FoodItem temp=(FoodItem)obj;
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
        return "FoodReview [Id:"+this.id+",Name:"+this.name+",Description:"+this.description+",Price:"+this.price+",Preparation time:"+this.preparationTime+",Rating:"+this.rating+",RATING COUNT: "+this.ratingCount+",Vendor:"+this.vendor+"]";
    }

        
}