package com.hexaware.MLP211.model;
import java.util.Calendar;
public class WalletTransaction{
    private int transactionId;
    private Calendar transactionDate;
    private Wallet wallet;
    private double transactionAmount;
    private Order order;
    private WalletTransactionType transactionType;

    public WalletTransaction(){

    }
    public WalletTransaction(int transactionId,Calendar transactionDate,Wallet wallet,double transactionAmount,Order order,WalletTransactionType transactionType){
        this.transactionId=transactionId;
        this.transactionDate=transactionDate;
        this.transactionAmount=transactionAmount;
        this.wallet=wallet;
        this.order=order;
        this.transactionType=transactionType;
    }
    public void setTransactionId(int transactionId ){
        this.transactionId=transactionId;
    }
    public  int getTransactionId(){
        return this.transactionId;
    }
    public void setTransactionDate(Calendar transactionDate ){
        this.transactionDate=transactionDate;
    }
    public  Calendar getTransactionDate(){
        return this.transactionDate;
    }
    public void setTransactionAmount(double transactionAmount ){
        this.transactionAmount=transactionAmount;
    }
    public  double getTransactionAmount(){
        return this.transactionAmount;
    }
    public void setWallet(Wallet wallet ){
        this.wallet=wallet;
    }
    public  Wallet getWallet(){
        return this.wallet;
    }
    public void setOrder(Order order){
        this.order=order;
    }
    public Order getOrder(){
        return this.order;
    }
    public void setTransactionType(WalletTransactionType transactionType){
        this.transactionType=transactionType;
    }
    public WalletTransactionType getTransactionType(){
        return this.transactionType;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if(!(obj instanceof WalletTransaction ))
            return false;
        boolean result=false;
        WalletTransaction temp=(WalletTransaction)obj;
        if(this.transactionId==temp.transactionId)
        result=true;
        return result;
    }
    @Override
    public int hashCode(){
        int n=this.transactionId;
        return n;
    }
    @Override
    public String toString(){
        return "WALLET TRANSACTION [TRANSACTION ID:"+this.transactionId+","+"TRANSACTION DATE:"+this.transactionDate.getTime()+","+"WALLET ID:"+this.wallet+","+"TRANSACTION AMOUNT:"+this.transactionAmount+","+"ORDER ID:"+this.order+","+"TRANSACTION TYPE:"+this.transactionType+"]";
    }
        

}