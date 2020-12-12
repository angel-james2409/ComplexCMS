package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.WalletTransaction;
import com.hexaware.MLP211.model.WalletComparator;
import com.hexaware.MLP211.model.WalletTransactionType;
import com.hexaware.MLP211.persistence.WalletTransactionDAO;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import com.hexaware.MLP211.model.Order;
import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.model.Wallet;
import java.util.Collections;

import java.util.LinkedList;
import java.util.List;
public class WalletTransactionDAOImpl implements WalletTransactionDAO{

    @Override
    public boolean insertWalletTransaction(WalletTransaction walletTransaction)throws Throwable{
        try{
            DBI dbi=new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false","root","Password123");
            WalletTransactionJdbi jdbi=dbi.open(WalletTransactionJdbi.class);
            if(walletTransaction.getTransactionType()==WalletTransactionType.PAYMENT)
                jdbi.insertPayment(walletTransaction, walletTransaction.getOrder().getCustomer().getId(),walletTransaction.getOrder().getVendor().getId(),walletTransaction.getTransactionDate().getTime(),walletTransaction.getOrder().getVendor().getId());
            else
                jdbi.insertRecharge(walletTransaction, walletTransaction.getTransactionDate().getTime(),walletTransaction.getWallet().getCustomer().getId());
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
      
    }
    @Override
    public boolean updateWalletTransaction(WalletTransaction walletTransaction)throws Throwable{
        return false;
    }
    @Override
    public boolean deleteWalletTransaction(int id)throws Throwable{
        return false;
    }

    @Override
    public WalletTransaction findWalletTransaction(int id) throws Throwable{
        return null;
    }
    @Override
    public List<WalletTransaction> getAllWalletTransactions() throws Throwable{
        try {
            DBI dbi=new DBI("jdbc:mysql://localhost:3306/MLP211?useSSL=false","root","Password123");
            WalletTransactionJdbi jdbi=dbi.open(WalletTransactionJdbi.class);
            List<WalletTransaction> allTrans=new LinkedList<WalletTransaction>();
            List<WalletTransaction> payments=jdbi.getAllPayments();
            List<WalletTransaction> recharges=jdbi.getAllRecharges();
            allTrans.addAll(payments);
            allTrans.addAll(recharges);
            WalletComparator wc=new WalletComparator();
            Collections.sort(allTrans,wc);
            return allTrans;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}



