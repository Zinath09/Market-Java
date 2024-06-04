/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_projeck_oficial;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.time.Second;

/**
 *
 * @author zuzab
 */
public class Stock extends Asset{

    /**
     *Assigned Company to shares.
     */
    protected Company owner;

    /**
     *Stock is assigned to market, it has a unique number.

     */
    public Stock() {
        super();
        this.type = "Stock";
        this.name = this.type + this.numer;// + GeneratingThings.generateRandomString();
        System.out.println(this.name + " is created");
        assignToMarkets();
        this.currentPrice=GeneratingThings.generateRandomFloat(10, 50);

        myThread = new Thread(this);
        myThread.start();
    }

    /**
     *Description for displaying detailed information
     * @return
     */
    public String describe(){
        String a,b,c,d,e;
        a="Name: " + this.name + "\n";
        b="Type: " + this.type + "\n";
        c="Current price: " + this.currentPrice + "\n";
        d="Quantity on markets: " + this.getQuantity() + "\n";
        e="Owner: " + this.owner.getName()+ "\n";
        return a+b+c+d+e;
    }

    @Override
    public void run() {
        Second current = new Second();
        while (true){
            try {
                this.series.add( new Second(), this.getCurrentPrice());
                current = ( Second ) current.next( ); 
                this.myThread.sleep(1000);
                this.getOwner().changeRevenue(this.currentPrice/100);
                synchronized(this.monitorAsset){
                if (GeneratingThings.generateRandomFloat(0, 1)>0.9999){
                    this.currentPrice=this.currentPrice/2;
                    this.setQuantity(this.getQuantity()*2);
                }
            }
            } catch (InterruptedException ex) {
                Logger.getLogger(Investor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * The Transaction is overridden to also change the totalSharesSumm of the company.
     * @param myQuantity
     * @param traderPrice
     */
    @Override
    public void transaction(Integer myQuantity, float traderPrice ){
            synchronized (this.monitorAsset) {
            this.owner.getMoneyFromSellingStocks(myQuantity, traderPrice, this.currentPrice);
            this.setCurrentPrice(traderPrice);
             }

    }

    /**
     *
     * @param change - quantity is changed at the company owner

     */
    @Override
    public void changeQuantity(int change) {
        this.owner.setNo_assets(this.owner.getNo_assets()+change);
    }  

    /**
     *quantity is changed at the company owner

     * @return
     */
    @Override
     public int getQuantity() {
        return this.owner.getNo_assets();
    }

    /**
     *
     * @param quantity
     */
    @Override
    public void setQuantity(int quantity) {
        this.owner.setNo_assets(quantity);
    }
     /**
     *
     * @return
     */
    public Company getOwner() {
        return owner;
    }

    /**
     *
     * @param owner
     */
    public void setOwner(Company owner) {
        this.owner = owner;
    }
    
}
