package com.hexaware.MLP211.util.action.customer;

import com.hexaware.MLP211.util.action.Action;

public class CustomerViewWalletDetailsAction extends Action{

    @Override
    public void begin(){
        //System.out.println("Radhika");
         System.out.println("\t\tMy Wallet Info");
        System.out.println("\t-----------------------------------");
    }

    @Override
    public void execute(){
        System.out.println("executing");
        //service layer code
        //display custoemr details 

    }

    @Override
    public void end(){
        //System.out.println("end");
         System.out.println("-----------END-------------");
    }

}