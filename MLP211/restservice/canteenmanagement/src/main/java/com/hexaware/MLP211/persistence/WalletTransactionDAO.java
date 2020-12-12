package com.hexaware.MLP211.persistence;
import com.hexaware.MLP211.model.WalletTransaction;

import java.util.List;
public interface WalletTransactionDAO{
    boolean insertWalletTransaction(WalletTransaction walletTransaction)throws Throwable;
    boolean updateWalletTransaction(WalletTransaction walletTransaction)throws Throwable;
    boolean deleteWalletTransaction(int id)throws Throwable;
    WalletTransaction findWalletTransaction(int id)throws Throwable;
    List<WalletTransaction> getAllWalletTransactions() throws Throwable;
}



