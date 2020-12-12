package com.hexaware.MLP211.model;
public class ContactInfo{
    private String phoneOne;
    private String phoneTwo;
    private String email;

    public ContactInfo(){

    }
    public ContactInfo(String phoneOne, String phoneTwo, String email){
        this.phoneOne=phoneOne;
        this.phoneTwo=phoneTwo;
        this.email=email;
    }

    public void setPhoneOne(String phoneOne){
        this.phoneOne= phoneOne;
    }
    public String getPhoneOne(){
        return this.phoneOne;
    }
    public void setPhoneTwo(String phoneTwo){
        this.phoneTwo= phoneTwo;
    }
    public String getPhoneTwo(){
        return this.phoneTwo;
    }
    public void setEmail(String email){
        this.email= email;
    }
    public String getEmail(){
        return this.email;
    }
    @Override
    public String toString(){
        return "[ Phone Number1: "+this.phoneOne+" Phone Number2: "+this.phoneTwo+ " Email: " +this.email+"]";
    }
}