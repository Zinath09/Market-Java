/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_projeck_oficial;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zuzab
 */
public class Investor extends Trader{
    private String tradingIdentifier;
    Thread myThread;
   
    /**
     * Creating a thread for an investor and assigning him an id.
     */
    public Investor() {
        super();
        System.out.println("INVESTOR");
        this.tradingIdentifier = "Investor"+"_"+counter;
        myThread = new Thread(this);
        myThread.start();
        MainWorld.noInvestor++;
    }

    /**
     * Description for displaying detailed information.
     * @return
     */
    public String describe(){
        String a,b,c,d;
        a="TradingIdentifier: " + this.tradingIdentifier + "\n";
        b="FirstName: " + this.firstName + "\n";
        c="LastName: " + this.lastName + "\n";
        d="InvestmentBudget: " + this.investmentBudget + "\n";
        return a+b+c+d;
    }
     
    /**
     * Every second (by default) the investor buys an asset, sells an asset and has a 10% chance to increase his budget by half.
     */
    @Override
    public void run() {
        while (true){
            try {
                this.myThread.sleep(1000/MainWorld.speed);
                this.buySth();
                this.sellSth();
                if (GeneratingThings.generateRandomFloat(0, 1)<0.1){
                    this.increaseBudget();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Investor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
//GETTERS & SETTERS
    public String getTradingIdentifier() {
        return tradingIdentifier;
    }
    /**
     *
     * @param tradingIdentifier
     */
    public void setTradingIdentifier(String tradingIdentifier) {
        this.tradingIdentifier = tradingIdentifier;
    }

}
