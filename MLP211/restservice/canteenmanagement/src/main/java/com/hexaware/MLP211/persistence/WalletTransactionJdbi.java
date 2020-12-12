package com.hexaware.MLP211.persistence;
import java.util.Date;
import com.hexaware.MLP211.model.Customer;
import com.hexaware.MLP211.model.Order;


import com.hexaware.MLP211.model.WalletTransaction;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;

import java.util.List;

public interface WalletTransactionJdbi {
     @SqlUpdate("insert into Wallet_Payment (customer_id,payment_amt,vendor_id,transaction_date,order_id) values (:cid, :wt.transactionAmount, :vid, :tdate, :oid)")
     @GetGeneratedKeys
     int insertPayment(@BindBean("wt") WalletTransaction walletTransaction, @Bind("cid") int custid,@Bind("vid") int vndid, @Bind("tdate") Date transaction, @Bind("oid") int orderId)throws Throwable;

     @SqlUpdate("insert into wallet_recharge(wallet_recharge_date,wallet_recharge_amount,customer_id) values (:tdate, :wt.transactionAmount, :cid)")
     int insertRecharge(@BindBean("wt") WalletTransaction walletTransaction, @Bind("tdate") Date transaction, @Bind("cid") int customer)throws Throwable;
     
     @SqlUpdate("----------")
     int  delete(int id)throws Throwable; 
     
     @SqlQuery("----------")
     @RegisterMapper(WalletTransactionPaymentRowMapper.class)  
     WalletTransaction find (int id)throws Throwable;

     @SqlQuery("Select * from Wallet_Payment")
     @RegisterMapper(WalletTransactionPaymentRowMapper.class) 
     List<WalletTransaction> getAllPayments()throws Throwable;

     @SqlQuery("select * from wallet_recharge")
     @RegisterMapper(WalletTransactionRechargeRowMapper.class) 
     List<WalletTransaction> getAllRecharges()throws Throwable;
}

