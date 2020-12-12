package com.hexaware.MLP211.model;
import java.util.Calendar;
import java.util.List;
import java.util.LinkedList;

public class Order{
    private int id;
    private Calendar orderDate;
    private Calendar orderTime;
    private double amount;
    private double discount;
    private Calendar estimatedDeliveryTime;
    private Calendar actualDeliveryTime;
    private OrderStatus orderStatus;
    private Vendor vendor= new Vendor();
    private Customer customer= new Customer();
    private List<OrderItem> orderItems= new LinkedList<OrderItem>();
    
    public Order(){

    }
    public Order(int id, Calendar orderDate, Calendar orderTime, double amount, double discount, Calendar estimatedDeliveryTime, Calendar actualDeliveryTime, OrderStatus orderstatus, Vendor vendor, Customer customer, List<OrderItem> orderItems){
        this.id= id;
        this.orderDate= orderDate;
        this.orderTime= orderTime;
        this.amount= amount;
        this.discount= discount;
        this.estimatedDeliveryTime= estimatedDeliveryTime;
        this.actualDeliveryTime= actualDeliveryTime;
        this.orderStatus= orderStatus;
        this.vendor= vendor;
        this.customer= customer;
        this.orderItems= orderItems;
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
    public void setOrderDate(Calendar orderDate){
        this.orderDate=orderDate;
    }
    public Calendar getOrderDate(){
        return this.orderDate;
    }
    public void setOrderTime(Calendar orderTime){
        this.orderTime=orderTime;
    }
    public Calendar getOrderTime(){
        return this.orderTime;
    }
    public void setAmount(double amount){
        this.amount=amount;
    }
    public double getAmount(){
        return this.amount;
    }
    
    public void setDiscount(double discount){
        this.discount= discount;
    }
    public double getDiscount(){
        return this.discount;
    }
    public void setEstimatedDeliveryTime(Calendar estimatedDeliveryTime){
        this.estimatedDeliveryTime=estimatedDeliveryTime;
    }
    public Calendar getEstimatedDeliveryTime(){
        return this.estimatedDeliveryTime;
    }
    public void setActualDeliveryTime(Calendar actualDeliveryTime){
        this.actualDeliveryTime=actualDeliveryTime;
    }
    public Calendar getActualDeliveryTime(){
        return this.actualDeliveryTime;
    }
    public void setOrderStatus(OrderStatus orderStatus){
        this.orderStatus=orderStatus;
    }
    public OrderStatus getOrderStatus(){
        return this.orderStatus;
    }
    public void setVendor(Vendor vendor){
        this.vendor=vendor;
    }
    public Vendor getVendor(){
        return this.vendor;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }
    public Customer getCustomer(){
        return this.customer;
    }
    public void setOrderItemsList(List<OrderItem> orderItems){
        this.orderItems=orderItems;
    }
    public List<OrderItem> getOrderItemsList(){
        return this.orderItems;
    }

    public void addItem(OrderItem orderItem){
        this.orderItems.add(orderItem);
    }

    public double computeTotal(){
        double total=0;
      
        for(OrderItem orderItem: orderItems){
            double temp;
            temp=orderItem.getFoodItem().getPrice()*orderItem.getQuantity();
            total=total+ temp;
            
        }
        this.amount=total;
        return total;
    }

    public double computeDiscount(){
        Calendar today= Calendar.getInstance();
        Calendar birthDate= customer.getDateOfBirth();

        if(today.get(Calendar.MONTH)==birthDate.get(Calendar.MONTH) && today.get(Calendar.DATE)==birthDate.get(Calendar.DATE)){
            discount=this.computeTotal()*0.15;
            return (discount);
        }
        return 0;
    }

    public Calendar computeEstimatedTime(){
        int estimatedTime=0;
        for(OrderItem orderItem: orderItems){
            if(orderItem.getFoodItem().getPreparationTime() > estimatedTime){
                estimatedTime= orderItem.getFoodItem().getPreparationTime();
            }
        }
        Calendar calendar= Calendar.getInstance();
        calendar.add(Calendar.MINUTE,estimatedTime);
        this.estimatedDeliveryTime=calendar;
        return calendar;
    }

    @Override
    public boolean equals(Object ob){
        if(this==ob)
            return true;
        if(ob==null)
            return false;
        if(!(ob instanceof Order))
            return false;
        
        boolean result= false;
        Order temp= (Order) ob;
        if(temp.id==this.id)
            result= true;
        
        return result;
    }
    @Override
    public int hashCode(){
        int n= this.id;
        //n=n*2;
        return n;
    }
    //@Override
    //public String toString(){
    //    return "Order[ Id: "+this.id+" Order Date: "+this.orderDate.getTime()+" Order Time: "+this.orderTime.getTime()+" Amount: "+this.amount+" Discount: "+this.discount+" Estimated Delivery Time: "+this.estimatedDeliveryTime.getTime()+" Order Staus: "+this.orderStatus+" Vendor Details:"+this.vendor+" Customer Details: "+this.customer+"OrderItems: " +this.orderItems+" ]";
    //}

    @Override
    public String toString(){
        String str="";
        str=str+"\n\n";

        str=str+"\t\t------------------------------------------------------------------------------------------------------";
        str=str+"\t\t   Order ID :"+this.id+"\n";
        str=str+"\t\t   Order Date/Time :"+this.orderDate.getTime()+"\n";
        str=str+"\t\t   Vendor : "+this.vendor.getName();
        str=str+"\t\t------------------------------------------------------------------------------------------------------";



        double sum=0;
        for(OrderItem oi:this.orderItems){
            str=str+"\t\t"+ String.format("%40s",oi.getFoodItem().getName());
            str=str+String.format("%5d",oi.getQuantity());
            str=str+String.format("%10.2f",oi.getPrice());
            str=str+String.format("%12.2f",oi.getPrice()*oi.getQuantity());
            str=str+"\n";
            sum=sum+(oi.getQuantity()*oi.getPrice());
        }
        str=str+"\t\t TOTAL :"+String.format("%60s",sum+"");
        str=str+"\t\t Delivery Time (Approximate) : "+this.estimatedDeliveryTime.getTime();
        str=str+"\n";
        str=str+"\t\t--------------------------------------------------------------------------------------------------------------";


        return str;
    
    }
}