/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_projeck_oficial;

import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author zuzab
 */
public class Currency extends Asset{

    protected int quantity;
    private float exchangeRate;
    private List <String> countryCurrency= new LinkedList();

    /**
     *Change Asset Type, add quantity and exchangeRate, assign to markets,increase gloobal noCurrency. 
     */
    public Currency(){
        super();
        this.type = "Currency";
        this.name = this.type + this.numer ;//+ GeneratingThings.generateRandomString();
        System.out.println(this.name + " is created");
        assignToMarkets();
        this.quantity = GeneratingThings.generateRandomNumber(100, 2000);
        this.exchangeRate =this.currentPrice;
        this.countryCurrency.add(GeneratingThings.generateRandomCountry());
        MainWorld.noCurrency++;
        myThread = new Thread(this);
        myThread.start();
    }
    /**
     *Description for displaying detailed information
     * @return
     */
    public String describe(){
        String a,b,c,d,e,f;
        a="Name: " + this.name + "\n";
        b="Type: " + this.type + "\n";
        c="Current price: " + this.currentPrice + "\n";
        d="Quantity on markets: " + this.quantity + "\n";
        e="Exchange Rate: " + this.currentPrice + "\n";
        f="Legal tender in: " + this.countryCurrency + "\n" ;
        return a+b+f+c+d+e;
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
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
     
    /**
     *
     * @return
     */
    public float getExchangeRate() {
        return exchangeRate;
    }

    /**
     *
     * @param exchangeRate
     */
    public void setExchangeRate(float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     *
     * @return
     */
    public List<String> getCountryCurrency() {
        return countryCurrency;
    }

    /**
     *
     * @param countryCurrency
     */
    public void setCountryCurrency(List<String> countryCurrency) {
        this.countryCurrency = countryCurrency;
    }
    
}
