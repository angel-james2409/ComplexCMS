package com.hexaware.MLP211.model;
import java.util.Calendar;
import com.hexaware.MLP211.model.UserType;

public class UserInfo{
    public static String username;
    public static String password;
    public static int userId;
    public static UserType userType;
    public static int Customer_Vendor_Id;

    public static Calendar loginTime=Calendar.getInstance();
    public  String toString(){
        String str="";
        str=str+"[\n User Name : "+ username;
        str=str+"\n User Type : "+userType.toString();
        str=str+"\n Id : "+Customer_Vendor_Id;
        str=str+"\n Login Time : "+loginTime.getTime();
        str=str+" ]";
        return str;
    }
}