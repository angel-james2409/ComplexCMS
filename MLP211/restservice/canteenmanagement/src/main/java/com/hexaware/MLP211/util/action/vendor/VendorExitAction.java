package com.hexaware.MLP211.util.action.vendor;
import com.hexaware.MLP211.util.action.Action;

public class VendorExitAction extends Action{

   @Override
   public void begin(){
    //System.out.println("Begin");
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