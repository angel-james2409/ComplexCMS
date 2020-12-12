package com.hexaware.MLP211.util.action.admin;
import com.hexaware.MLP211.factory.VendorServiceImpl;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.util.util.OutputUtil2;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.hexaware.MLP211.model.Vendor;


public class AdminViewVendorAction extends Action{

    @Override
    public void begin(){
        //System.out.println("Implemented by Raji");
        System.out.println("\t\t Vendor List");
        System.out.println("\t-----------------------------");
    }

    @Override
    public void execute(){
        try{
            List<Vendor> vendors;
            vendors=new VendorServiceImpl().getAllVendors();

            OutputUtil2 util=new OutputUtil2();

            util.setTitle("VENDOR LISTING");

            util.addColumn("NAME", 19);
            util.addColumn("ADDRESS", 30);
            util.addColumn("CONTACTPERSON NAME", 20);
            util.addColumn("PHONE1", 15);
            util.addColumn("PHONE2", 15);
            util.addColumn("EMAIL", 28);
            util.addColumn("RATING", 8);
            //util.addColumn("RATING COUNT", 8);
            
            util.displayTitle('-');
            util.displayColumns();

            for(Vendor vendor:vendors){
                String name=vendor.getName();
                util.displayLeftAlign(name,20, true, false);
               
                String address= vendor.getAddress();
		        util.displayLeftAlign(address, 31, false, false);

		        String contactPersonName= vendor.getContactPersonName();
		        util.displayLeftAlign(contactPersonName, 21, false, false);

                String ph1=vendor.getContactInfo().getPhoneOne();
                util.displayLeftAlign(ph1, 17, false, false);

                String ph2=vendor.getContactInfo().getPhoneTwo();
                util.displayLeftAlign(ph2, 17, false, false);

                String email=vendor.getContactInfo().getEmail();
                util.displayLeftAlign(email, 29, false, false);

		        int rating= vendor.getRating();
                util.displayLeftAlign(rating+"", 10, false, true);

            }

            String str=util.replicate('-', util.totalReportWidth);
            System.out.println("\t"+str);

        }catch(Throwable e){
            e.printStackTrace();
        }


    }

    @Override
    public void end(){
        System.out.println("-------------------------------------");
    }

}