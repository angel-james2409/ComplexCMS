package com.hexaware.MLP211.util.action.admin;
import com.hexaware.MLP211.util.util.InputUtil;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.factory.UserLoginServiceImpl;
import com.hexaware.MLP211.factory.VendorServiceImpl;
import com.hexaware.MLP211.model.Vendor;
import java.util.List;

public class AdminDeleteVendorAction extends Action{

    @Override
    public void begin(){
        //System.out.println("Implemented by Raji");
        System.out.println("\t\t Delete Vendor");
        System.out.println("\t----------------------------------------");
    }

    @Override
    public void execute(){
        try{
            List<Vendor> list = new VendorServiceImpl().getAllVendors();
            int id=0;
            id=new InputUtil().readVendorIdInput("Enter id To Delete the Vendor", list);
        	 boolean res2= new UserLoginServiceImpl().removeUserLogin((new VendorServiceImpl().findVendor(id)).getName());
            boolean res=new VendorServiceImpl().removeVendor(id);
            System.out.println(res+", "+res2);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    @Override
    public void end(){
        System.out.println("-----------------------------------------------");
    }

}