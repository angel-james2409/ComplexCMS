package com.hexaware.MLP211.util.action.admin;
import com.hexaware.MLP211.factory.CustomerServiceImpl;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.util.util.OutputUtil2;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.hexaware.MLP211.model.Customer;


public class AdminViewCustomerAction extends Action{

    @Override
    public void begin(){
        //System.out.println("Anshuman");  
        System.out.println("\t\tView Customer");
        System.out.println("\t-----------------------------");
    }

    @Override
    public void execute(){
       try{
            List<Customer> customers;
            customers=new CustomerServiceImpl().getAllCustomers();

            OutputUtil2 util=new OutputUtil2();

            util.setTitle("CUSTOMER LISTING");

            util.addColumn("NAME", 30);
            util.addColumn("DATE OF BIRTH", 15);
            util.addColumn("PHONE1", 15);
            util.addColumn("PHONE2", 15);
            util.addColumn("EMAIL", 30);

            util.displayTitle('-');
            util.displayColumns();

            for(Customer customer:customers){
                String name=customer.getName();
                util.displayLeftAlign(name, 31, true, false);
               
                Date cdob=customer.getDateOfBirth().getTime();
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
                String cdobstr=sdf.format(cdob);
                util.displayCenterAlign(cdobstr, 17, false, false);

                String ph1=customer.getContactInfo().getPhoneOne();
                util.displayLeftAlign(ph1, 17, false, false);

                String ph2=customer.getContactInfo().getPhoneTwo();
                util.displayLeftAlign(ph2, 17, false, false);

                String email=customer.getContactInfo().getEmail();
                util.displayLeftAlign(email, 32, false, true);

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