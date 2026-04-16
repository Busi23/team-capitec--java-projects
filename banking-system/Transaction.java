/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.transaction;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author didik
 */
public class Transaction {
        //type of transactions
        public enum Type{
            DEPOSIT, WITHDRAWAL
        }
    //add private final fields  
    private final Type type;
    private final double amount;
    private final double balanceAfter;
    private final LocalDateTime timestamp;
    
    //initialize each transaction record
    public Transaction(Type type, double amount, double balanceAfter){
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp= LocalDateTime.now();
    }
    
    // gettters for all fields
    public Type getType(){
        return type;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public double getBalanceAfter(){
        return balanceAfter;
    }
    
    public LocalDateTime getTimestamp(){
        return timestamp;
    }
    
    //format the date to readable string
   
        @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); //Year-Month-Date Hour:Minute Pattern
        String formattedDate = timestamp.format(formatter);
        
        return String.format("[%s] %s R %.2f Balanace: R %.2f", //R for Rand, %.2f to show 2 decimal places
                formattedDate, type.name(), amount, balanceAfter);          
    }
}


