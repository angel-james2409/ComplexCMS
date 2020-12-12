package com.hexaware.MLP211.util.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OutputUtil1{
    public void displayInt(String caption,int data){
        System.out.printf("\t\t%s : ",caption);
        NumberFormat fmt=NumberFormat.getIntegerInstance();
        fmt.setGroupingUsed(true);
        String str=fmt.format(data);
        System.out.printf("\t\t%s",str);
        System.out.println();
    }

    public void displayShort(String caption,short data){
        System.out.printf("\t\t%s : ",caption);
        NumberFormat fmt=NumberFormat.getIntegerInstance();
        fmt.setGroupingUsed(true);
        String str=fmt.format(data);
        System.out.printf("\t\t%s",str);
        System.out.println();
    }
    public void displayByte(String caption,byte data){
        System.out.printf("\t\t%s : ",caption);
        NumberFormat fmt=NumberFormat.getIntegerInstance();
        fmt.setGroupingUsed(true);
        String str=fmt.format(data);
        System.out.printf("\t\t%s",str);
        System.out.println();
    }
    public void displayLong(String caption,long data){
        System.out.printf("\t\t%s : ",caption);
        NumberFormat fmt=NumberFormat.getIntegerInstance();
        fmt.setGroupingUsed(true);
        String str=fmt.format(data);
        System.out.printf("\t\t%s",str);
        System.out.println();
    }
    public void displayFloat(String caption,float data){
        System.out.printf("\t\t%s : ",caption);
        NumberFormat fmt=NumberFormat.getNumberInstance();
        fmt.setGroupingUsed(true);
        fmt.setMinimumFractionDigits(2);
        fmt.setMaximumFractionDigits(2);
        String str=fmt.format(data);
        System.out.printf("\t\t%s",str);
        System.out.println();
    }
    public void displayDouble(String caption,double data){
        System.out.printf("\t\t%s : ",caption);
        NumberFormat fmt=NumberFormat.getNumberInstance();
        fmt.setGroupingUsed(true);
        fmt.setMinimumFractionDigits(2);
        fmt.setMaximumFractionDigits(2);
        String str=fmt.format(data);
        System.out.printf("\t\t%s",str);
        System.out.println();
    }
    public void displayDate(String caption,Calendar data){
        System.out.printf("\t\t%s : ",caption);
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String str=sdf.format(data.getTime());
        System.out.printf("\t\t%s",str);
        System.out.println();
    }
    public void displayString(String caption,String data){
        System.out.printf("\t\t%s : ",caption);
        System.out.printf("\t\t%s",data);
        System.out.println();
    }

}