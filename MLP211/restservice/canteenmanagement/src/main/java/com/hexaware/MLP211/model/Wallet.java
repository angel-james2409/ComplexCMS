package com.hexaware.MLP211.model;
public class Wallet{
    private int id;
    private Customer customer;
    public Wallet(){

    }
    public Wallet(int id,Customer customer){
        this.id=id;
        this.customer=customer;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public Customer getCustomer(){
        return this.customer;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }
    @Override
    public String toString(){
        return "Wallet [ ID :"+this.id+" ]";
    }
    @Override
    public int hashCode(){
        int n=this.id;
        n=n*10;
        return n;
    }
    @Override
    public boolean equals(Object obj){
        boolean result=false;
        Wallet temp=(Wallet) obj;
        if(this.id==temp.id)
            result= true;
        return result;
    }

}