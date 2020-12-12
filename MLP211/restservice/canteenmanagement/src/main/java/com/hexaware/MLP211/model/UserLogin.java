package com.hexaware.MLP211.model;
import java.util.Calendar;
public class UserLogin{
    private String username;
    private String password;
    private int customerVendorId;
    private Calendar lastPasswordUpdate;
    private UserType usertype;
    public UserLogin(){
        
    }
    public UserLogin(String username,String password,int customerVendorId, Calendar lastPasswordUpdate,UserType usertype){
        this.username=username;
        this.password=password;
        this.customerVendorId=customerVendorId;
        this.lastPasswordUpdate=lastPasswordUpdate;
        this.usertype=usertype;
    }
    public void setUserName(String username){
        this.username=username;
    }
    public String getUserName(){
        return this.username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setCustomerVendorId(int customerVendorId){
        this.customerVendorId=customerVendorId;
    }
    public int getCustomerVendorId(){
        return this.customerVendorId;
    }
    public void setLastPasswordUpdate(Calendar lastPasswordUpdate){
        this.lastPasswordUpdate=lastPasswordUpdate;
    }
    public Calendar getLastPasswordUpdate(){
        return this.lastPasswordUpdate;
    }
    public void setUserType(UserType usertype){
        this.usertype=usertype;
    }
    public UserType getUserType(){
        return this.usertype;
    } 
    @Override
    public String toString(){
        return "UserLogin [ USERNAME;- "+this.username+", CUSTOMER_VENDOR_ID;- "+this.customerVendorId+", LAST_PASSWORD_UPDATE:- "+this.lastPasswordUpdate.getTime()+", USER_TYPE:- "+this.usertype+" ]";
    }
    @Override
    public int hashCode(){
        int n=this.customerVendorId;
        return n;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if(!(obj instanceof UserLogin))
            return false;
        boolean result=false;
        UserLogin temp=(UserLogin) obj;
        if(temp.username==this.username && temp.password==this.password)
            result=true;
        return result;

    }





}