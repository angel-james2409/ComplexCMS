package com.hexaware.MLP211.factory;
import com.hexaware.MLP211.model.WalletTransaction;

import java.util.List;
public interface WalletTransactionService{
    boolean addWalletTransaction(WalletTransaction walletTransaction)throws Throwable;
    boolean updateWalletTransaction(WalletTransaction walletTransaction)throws Throwable;
    boolean removeWalletTransaction(int id)throws Throwable;
    WalletTransaction findWalletTransaction(int id)throws Throwable;
    List<WalletTransaction> getAllWalletTransactions() throws Throwable;
}
