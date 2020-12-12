package com.hexaware.MLP211.util.action.customer;

import java.util.Calendar;

import com.hexaware.MLP211.model.UserInfo;
import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.model.Wallet;
import com.hexaware.MLP211.model.WalletTransaction;
import com.hexaware.MLP211.model.WalletTransactionType;
import com.hexaware.MLP211.factory.CustomerService;
import com.hexaware.MLP211.factory.CustomerServiceImpl;
import com.hexaware.MLP211.factory.WalletTransactionService;
import com.hexaware.MLP211.factory.WalletTransactionServiceImpl;
import com.hexaware.MLP211.util.action.Action;
import com.hexaware.MLP211.util.util.InputUtil;

public class CustomerRechargeWalletAction extends Action{

    @Override
    public void begin(){
        //System.out.println("Vikal Singh");
        System.out.println("\t\tRecharge Wallet");
        System.out.println("\t___________________________");
    }

    @Override
    public void execute(){
        try {
            int customerId=UserInfo.Customer_Vendor_Id;
            CustomerService customerService=new CustomerServiceImpl();
            Customer customer=customerService.findCustomer(customerId);

            Wallet wallet =new Wallet();
            wallet.setCustomer(customer);

            double rechargeAmount;

            InputUtil util;
            util=new InputUtil();

            rechargeAmount=util.readDoubleInput("Enter Amount to Recharge");

            WalletTransaction wt=new WalletTransaction();

            wt.setTransactionType(WalletTransactionType.RECHARGE);

            wt.setWallet(wallet);

            wt.setTransactionAmount(rechargeAmount);

            wt.setTransactionDate(Calendar.getInstance());



            WalletTransactionService wts=new WalletTransactionServiceImpl();
            boolean result=wts.addWalletTransaction(wt);
            System.out.println(result);
        } catch (Throwable e) {
            e.printStackTrace();
            //TODO: handle exception
        }
        //Service Code: 
        //Display Existing Amount
        //Get Recharge Amount
        //Update Wallet
        
    }

    @Override
    public void end(){
        System.out.println("Recharged Successfully");
    }
}