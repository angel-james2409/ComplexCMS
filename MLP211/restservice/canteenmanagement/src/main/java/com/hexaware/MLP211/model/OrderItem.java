package com.hexaware.MLP211.model;
import java.util.*;

public class OrderItem{
    private Order order=new Order();
    private FoodItem foodItem= new FoodItem();
    private int quantity;
    private double price;
    private  double discount;

	public OrderItem(){
        
    }

    public OrderItem(Order order,FoodItem foodItem,int quantity,double price,double discount){
        this.order=order;
        this.foodItem=foodItem;
        this.quantity=quantity;
        this.price=price;
        this.discount=discount;
    }

    public void setOrder(Order order)
    {
         this.order=order;
    }
    public  Order getOrder()
    {
        return  this.order;
    }

    public  void setFoodItem (FoodItem foodItem)
    {
        this.foodItem=foodItem;
    }
    public FoodItem getFoodItem()
    {
        return this.foodItem;
    }
    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }
    public int getQuantity()
    {
        return this.quantity;
    }

    public void setPrice(double price)
    {
        this.price=price;
    }
    public double getPrice()
    {
        return this.price;
    }

    public void setDiscount(double Discount)
    {
        this.discount=discount;
    }
    public double getDiscount()
    {
        return this.discount;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if(!(obj instanceof OrderItem))
            return false;
        boolean result  =  false;
        OrderItem temp = (OrderItem) obj;
        if(this.order.getId()==(temp.getOrder().getId()) && this.foodItem.getId()==(temp.getFoodItem().getId()));
            result = true;
        return result;
    }
    @Override
    public int hashCode(){
        int n=this.order.getId();
        n=n*10;
        return n;
    }
    @Override
    public String toString(){
     return "OrderItem:["+ "FoodItem : "+this.foodItem+" Quantity : "+this.quantity+"Price : "+this.price+"Discount : "+this.discount+"]";
    } 
}