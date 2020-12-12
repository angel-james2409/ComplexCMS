package com.hexaware.MLP211.util.menu;
import java.util.List;
import java.util.Scanner;
import com.hexaware.MLP211.util.menu.AdminMenu;

abstract public class Menu{
    protected List<String> menuItems;
    abstract public void init();
    
    
    final public void display(){
        if(this instanceof AdminMenu)
            System.out.println("\t\tADMIN MENU");
        if(this instanceof CustomerMenu)
            System.out.println("\t\tCUSTOMER MENU");
        if(this instanceof VendorMenu)
            System.out.println("\t\tVENDOR MENU");

        int i=0;
        for(String menuItem: menuItems)
            System.out.printf( "\n\t\t %d . %s" , ++i , menuItem);
        
            System.out.println();
     }

    
    

    public int propmtForChoice(){
        Scanner sc= new Scanner(System.in);
        System.out.println("\t\t \nEnter Choice");
        System.out.println("\t\t ---------------------------------------");
        int choice= sc.nextInt();
        return choice;
    }
    abstract public void dispatchAction(int i);
    public final void handle(){
        while(true){
        init();
        display();
        int n= propmtForChoice();
        dispatchAction(n);
        }
    }
}


