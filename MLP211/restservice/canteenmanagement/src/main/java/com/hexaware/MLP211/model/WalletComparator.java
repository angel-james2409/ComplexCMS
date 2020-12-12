package com.hexaware.MLP211.model;
import com.hexaware.MLP211.model.WalletTransaction;
import java.util.Comparator;
import java.util.Calendar;
import java.util.Date;

public class WalletComparator implements Comparator<WalletTransaction>{

    public int compare(WalletTransaction wt1, WalletTransaction wt2){
        if(wt1.getTransactionDate().compareTo(wt2.getTransactionDate()) < 0)
          return -1;

        if(wt1.getTransactionDate().compareTo(wt2.getTransactionDate())> 0)
          return 1;

        return 0;  
    }
}