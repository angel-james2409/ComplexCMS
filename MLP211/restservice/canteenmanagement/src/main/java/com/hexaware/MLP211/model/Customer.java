package com.hexaware.MLP211.model;
import java.util.*;
import java.util.Calendar;
public class Customer{
    private int id;
    private String name;
    private Calendar dateOfBirth;
    private ContactInfo contact=new ContactInfo();
    public Customer(int id,String name,Calendar dateOfBirth,ContactInfo contact ){
        this.id=id;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.contact=contact;
    }
   public  Customer(){
       
    }
     public void setId(int id)
    {
        this.id=id;
    }
     public int getId()
    {
        return this.id;
    }

    public  void setName (String name)
    {
        this.name=name;
    }
     public  String getName()
    {
        return this.name;
    }
    public void setDateOfBirth(Calendar dateOfBirth)
    {
        this.dateOfBirth=dateOfBirth;
    }
    public Calendar getDateOfBirth()
    {
        return this.dateOfBirth;
    }
    public void setContactInfo(ContactInfo contact){
        this.contact=contact;
    }
    public ContactInfo getContactInfo(){
        return this.contact;
    } 
    @Override
    public boolean equals(Object obj)
    {

        if(this==obj)
        return true;
        if(obj==null)
        return false;
        if(!(obj instanceof Customer))
        return false;
        boolean result  =  false;
        Customer temp = (Customer) obj;
        if(this.id==(temp.id))
            result = true;
        return result;
    }
    @Override
    public int hashCode()
    {
        int n=this.id;
      //  n=n*10;
        return n;
    }
    @Override
    public String toString()
    {
     return  "Customer[ ID :"+this.id+" Name : "+this.name+" DateOfBirth : "+this.dateOfBirth.getTime()+"]";
    } 

    
}