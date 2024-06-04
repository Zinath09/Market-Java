/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_projeck_oficial;

/**
 *
 * @author zuzab

 */
public class Commodity extends Asset{

    /**
     *Commodity number on the market.
     */
    protected int quantity;
    
  

    /**
     *Change Asset Type, add quantity, assign to markets,increase gloobal noCommodity. 
     */
    public Commodity() {
            super();
            this.setCurrentPrice(GeneratingThings.generateRandomFloat(100, 2000));
            this.type =  "Commodity";
            this.name = this.type + numer ;
            this.quantity = GeneratingThings.generateRandomNumber(100, 2000);
            System.out.println(this.name + " is created");
            assignToMarkets();
            MainWorld.noCommodity++;
            myThread = new Thread(this);
            myThread.start();
    }
    /**
     *Description for displaying detailed information
     * @return
     */
    public String describe(){
        String a,b,c,d;
        a="Name: " + this.name + "\n";
        b="Type: " + this.type + "\n";
        c="Current price: " + this.currentPrice + "\n";
        d="Quantity on markets: " + this.quantity + "\n";
        return a+b+c;
    }
    /**
     *
     * @param change
     */
    @Override
    public void changeQuantity(int change) {
        this.quantity+=change;
    }  

    /**
     *
     * @return
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
