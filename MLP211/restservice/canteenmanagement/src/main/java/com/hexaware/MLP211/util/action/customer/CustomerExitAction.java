package com.hexaware.MLP211.util.action.customer;

import com.hexaware.MLP211.util.action.Action;

public class CustomerExitAction extends Action{

    @Override
    public void begin(){
        //System.out.println("begin");
    }

    @Override
    public void execute(){
        System.exit(0);
    }

    @Override
    public void end(){
        //System.out.println("end");
    }
}