package com.hexaware.MLP211.factory;
import com.hexaware.MLP211.persistence.WalletTransactionDAOImpl;
import com.hexaware.MLP211.model.WalletTransaction;
import com.hexaware.MLP211.factory.WalletTransactionService;

import java.util.List;
public class WalletTransactionServiceImpl implements WalletTransactionService{

    @Override
    public boolean addWalletTransaction(WalletTransaction walletTransaction)throws Throwable{
        try {
            return   new WalletTransactionDAOImpl().insertWalletTransaction(walletTransaction);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
            //TODO: handle exception
        }
    }
    @Override
    public boolean updateWalletTransaction(WalletTransaction walletTransaction)throws Throwable{
        try {
            return  new WalletTransactionDAOImpl().updateWalletTransaction(walletTransaction);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
            //TODO: handle exception
        }
    }
    @Override
    public boolean removeWalletTransaction(int id)throws Throwable{
        try {
            return new WalletTransactionDAOImpl().deleteWalletTransaction(id);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
            //TODO: handle exception
        }
    }

    @Override
    public WalletTransaction findWalletTransaction(int id) throws Throwable{
        
            return  new WalletTransactionDAOImpl().findWalletTransaction(id);        
       
    }
    @Override
    public List<WalletTransaction> getAllWalletTransactions() throws Throwable{
    
            return new WalletTransactionDAOImpl().getAllWalletTransactions();
       
    }
}



