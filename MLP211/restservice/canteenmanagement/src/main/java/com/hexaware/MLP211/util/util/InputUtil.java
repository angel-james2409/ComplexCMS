package com.hexaware.MLP211.util.util;
import java.util.Scanner;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.hexaware.MLP211.model.Order;
import com.hexaware.MLP211.model.FoodItem;
import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.model.Vendor;
import com.hexaware.MLP211.model.OrderStatus;

public class InputUtil{
    public byte readByteInput(String promptMessage){
        System.out.print("\t\t "+promptMessage+" : ");
        Scanner s=new Scanner(System.in);
        byte n=s.nextByte();
        return n;
    }

    public short readShortInput(String promptMessage){
        System.out.print("\t\t "+promptMessage+" : ");
        Scanner s=new Scanner(System.in);
        short n=s.nextShort();
        return n;
    }

    public int readIntInput(String promptMessage){
        System.out.print("\t\t "+promptMessage+" : ");
        System.out.flush();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        return n;
    }

    public long readLongInput(String promptMessage){
        System.out.print("\t\t "+promptMessage+" : ");
         System.out.flush();
        Scanner s=new Scanner(System.in);
        long n=s.nextLong();
        return n;
    }

    public float readFloatInput(String promptMessage){
        System.out.print("\t\t "+promptMessage+" : ");
         System.out.flush();
        Scanner s=new Scanner(System.in);
        float n=s.nextFloat();
        return n;
    }

    public double readDoubleInput(String promptMessage){
        System.out.print("\t\t "+promptMessage+" : ");
         System.out.flush();
        Scanner s=new Scanner(System.in);
        double n=s.nextDouble();
        return n;
    }

    public char readCharInput(String promptMessage){
        System.out.print("\t\t "+promptMessage+" : ");
         System.out.flush();
        Scanner s=new Scanner(System.in);
        Character n=s.next().charAt(0);
        return n;
    }

    public boolean readBooleanInput(String promptMessage){
        System.out.print("\t\t "+promptMessage+"(y/n) : ");
         System.out.flush();
        Scanner sc=new Scanner(System.in);
        boolean n;
        String s=sc.next();
        if(s.charAt(0)=='Y'||s.charAt(0)=='y')
        n=true;
        else n=false;
        return n;
    }

    public String readPasswordInput(String promptMessage){
        System.out.print("\t\t "+promptMessage+" : ");
        System.out.flush();
        Console cons=System.console();
        char[] arr;
        arr=cons.readPassword();
        String n=new String(arr);
        return n;
    }

    public String readStringInput(String promptMessage){
        System.out.print("\t\t "+promptMessage+" : ");
         System.out.flush();
        Console cons=System.console();
            String n=cons.readLine();
            return n;
    }

    public Calendar readCalendarInput(String promptMessage){
        System.out.print(promptMessage+"(dd/mm/yyyy) : ");
         System.out.flush();
        Scanner s=new Scanner(System.in);
        String n=s.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try{
            d=sdf.parse(n);
        }catch(Exception e) {
            e.printStackTrace();
        }
        Calendar cal=Calendar.getInstance();
        cal.setTime(d);
        return cal;
    }

    public int readOrderIdInput(String promptMessage, List<Order> allOrders){
        System.out.println("\n\n");
        System.out.println("\t\t"+promptMessage);
        System.out.println("\t\t-------------------------------------------------------------------------");
        for(Order order:allOrders){
            System.out.printf("\t\t %d",order.getId());
            System.out.printf("\t %s %s",order.getCustomer().getName());
            System.out.printf("%f",order.computeTotal());
        }
            System.out.println("\t\t-------------------------------------------------------------------------");
            System.out.print("\t\t"+promptMessage+ " : ");
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            return n;
    }

      public int readOrderIdInput(String promptMessage, List<Order> allOrders, OrderStatus status){
        System.out.println("\n\n");
        System.out.println("\t\t"+promptMessage);
        System.out.println("\t\t-------------------------------------------------------------------------");
        for(Order order:allOrders){
            if(order.getOrderStatus().equals(status)){
            System.out.printf("\t\t %d",order.getId());
            System.out.printf("\t %s %s",order.getCustomer().getName());
            System.out.printf("%f",order.computeTotal());
            }
        }
            System.out.println("\t\t-------------------------------------------------------------------------");
            System.out.print("\t\t"+promptMessage+ " : ");
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            return n;
    }

    public int readOrderIdInput(String promptMessage, List<Order> allOrders, OrderStatus status, Vendor v){
        System.out.println("\n\n");
        System.out.println("\t\t"+promptMessage);
        System.out.println("\t\t-------------------------------------------------------------------------");
        for(Order order:allOrders){
            if(order.getVendor().equals(v)){
                if(order.getOrderStatus().equals(status)){
                System.out.printf("\t\t %d",order.getId());
                System.out.printf("\t %s",order.getCustomer().getName());
                System.out.printf("%f",order.getAmount());
            }
            }
        }
            System.out.println("\t\t-------------------------------------------------------------------------");
            System.out.print("\t\t"+promptMessage+ " : ");
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            return n;
    }

    

    public int readVendorIdInput(String promptMessage, List<Vendor> vendors){
        System.out.println("\n\n");
        System.out.println("\t\t"+promptMessage);
        System.out.println("\t\t-------------------------------------------------------------------------");
        for(Vendor vendor:vendors){
            System.out.printf("\t\t %5d",vendor.getId());
            System.out.printf("\t %s",vendor.getName());
            System.out.println();

        }
        System.out.println("\t\t-------------------------------------------------------------------------");
            System.out.print("\t\t"+promptMessage+ " : ");
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            return n;
    }

    public int readCustomerIdInput(String promptMessage, List<Customer> customers){
        System.out.println("\n\n");

        System.out.println("\t\t"+promptMessage);
        System.out.println("\t\t-------------------------------------------------------------------------");
        for(Customer customer:customers){
            System.out.printf("\t\t%5d",customer.getId());
            System.out.printf("\t%s",customer.getName());
            System.out.println();
        }
            System.out.println("\t\t-------------------------------------------------------------------------");
            System.out.print("\t\t"+promptMessage+ " : ");
            System.out.flush();
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            return n;
    }
    public int readFoodItemsInput(String promptMessage, List<FoodItem> foodItems){
         System.out.println("\n\n");
        System.out.println("\t\t"+promptMessage+ " : ");
        System.out.println("\n\t\t-------------------------------------------------------------------------");
        for(FoodItem foodItem:foodItems){
            System.out.printf("\t\t%d",foodItem.getId(),"\n");
            System.out.printf("\t%s",foodItem.getName(),"\n");
            System.out.println();
        }
          System.out.println("\t\t-------------------------------------------------------------------------");
            System.out.printf("\t\t"+promptMessage+ " : ");
            System.out.flush();
           Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            return n;
    }

     public int readFoodItemsInput(String promptMessage, List<FoodItem> foodItems, Vendor vendor){
         System.out.println("\n\n");
        System.out.println("\t\t"+promptMessage+ " : ");
        System.out.println("\n\t\t-------------------------------------------------------------------------");
        for(FoodItem foodItem:foodItems){
            if(foodItem.getVendor().equals(vendor)){
            System.out.printf("\t\t%d",foodItem.getId(),"\n");
            System.out.printf("\t%s",foodItem.getName(),"\n");
            System.out.println();
            }
        }
          System.out.println("\t\t-------------------------------------------------------------------------");
            System.out.printf("\t\t"+promptMessage+ " : ");
            System.out.flush();
           Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            return n;
    }

    

}