package com.hexaware.MLP211.util.action.admin;

import com.hexaware.MLP211.util.action.Action;

public class AdminExitAction extends Action{

    @Override
    public void begin(){
       // System.out.println("begin");
    }

    @Override
    public void execute(){
        System.exit(0);
    }

    @Override
    public void end(){
        //System.out.println("end");
        System.out.println("----------------------------");
    }
}