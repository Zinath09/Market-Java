/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_projeck_oficial;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;

/**
 * Asset description
 * @author zuzab
 */
public abstract class Asset implements Runnable{

    Thread myThread;
    /**
     *A list that collects the time and current price of the asset.
     */
    TimeSeries series = new TimeSeries(numer);
    /**
     *Current Value of the Asset
     */
   
    protected float currentPrice;
     /**
     *The minimum value at which an asset can be purchased
     */
    
    protected float minimalPrice;

     /**
     *The maximum value at which an asset can be purchased
     */
    protected float maximalPrice;

    

    /**
     *The number provides a unique name. 
     */
    protected static int numer;

    /**
     * Type of object 
     */
    protected String type = "Asset";

    /**
     * The name depends on the number of the object that was created so it is unique
     */
    protected String name;

    public Object monitorAsset = new Object();

    /**
     *Increase the number, set the name and prices of the asset.
     */
    public Asset() {
        this.numer++;
        this.name = this.type + this.numer + GeneratingThings.generateRandomString();
        setCurrentPrice(GeneratingThings.generateRandomFloat(10, 50));
        changePrices();
        
    }
        /**
     *Every second the value of the asset is recorded in the history.
     */
    @Override
    public void run() {
        Second current = new Second();
        while (true){
            try {
                this.series.add( new Second(), this.getCurrentPrice());
                current = ( Second ) current.next( ); 
                this.myThread.sleep(1000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Investor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    

    
    /**
     * The transaction changes the current value of all prices and the quantity of the asset available on the market.
     * @param myQuantity - the number of an asset a trader wants to buy or sell.
     * @param traderPrice - the price requested by the trader within the allowed range
     */
    public void transaction(Integer myQuantity, float traderPrice ){
        synchronized(this.monitorAsset){
        this.setCurrentPrice(traderPrice);
        this.changeQuantity(-myQuantity);
        };
    }
    
    /**
     * Function that assigns this asset to 70% of all markets of this type. 
     This is where the problem may arise that if there are few assets initially, the investor may choose an asset from an empty market.
     */
    protected void assignToMarkets() {
        for (int i =0;i<MainWorld.noMarket;i++){
            if (MainWorld.listOfMarkets.get(i).getType().equals(this.type)){
                    if ((float)0.7> GeneratingThings.generateRandomFloat(0, 1)){
                        MainWorld.listOfMarkets.get(i).addToAvailableAssets(this);
                    }
        }
        }
    }
    /**
     *Create a range at which you can buy an asset. If a trader gives a lower or higher price, he cancels the purchase.
     */
    public synchronized void  changePrices() {
        float diff= GeneratingThings.generateRandomFloat((float)0.02,(float) 0.08);
        this.minimalPrice=this.currentPrice*(1-diff); 
        this.maximalPrice=this.currentPrice*(1+diff);
    }    
    /**
     * When something wants to change the value of the asset, the range also changes.
     * @param currentPrice
     */
     public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
        changePrices();
    }


        /**
     *Because quantity is not a field for each asset, it cannot be changed. (Stock has its own quantity inside Company).
     * @param change
     */
    public void changeQuantity(int change) {
    }  

    /**
     * Because quantity is not a field for each asset, it cannot be getted. (Stock has its own quantity inside Company).
     * @return
     */
    public int getQuantity(){
        return 0;
    }

    /**
     *Because quantity is not a field for each asset, it cannot be changed. (Stock has its own quantity inside Company).
     * @param quantity
     */
    public void setQuantity(int quantity){
    }
    /**
     *
     * @return
     */
    public float getCurrentPrice() {
        return currentPrice;
    }

    /**
     * @return the minimalPrice
     */
    public float getMinimalPrice() {
        return minimalPrice;
    }

    /**
     * @return the maximalPrice
     */
    public float getMaximalPrice() {
        return maximalPrice;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public TimeSeries getSeries() {
        return series;
    }

    /**
     *
     * @param series
     */
    public void setSeries(TimeSeries series) {
        this.series = series;
    }

    /**
     *
     * @return
     */
    public static int getNumer() {
        return numer;
    }

    /**
     *
     * @param numer
     */
    public static void setNumer(int numer) {
        Asset.numer = numer;
    }

    /**
     *
     * @return
     */
    public Object getMonitorAsset() {
        return monitorAsset;
    }

    /**
     *
     * @param monitorAsset
     */
    public void setMonitorAsset(Object monitorAsset) {
        this.monitorAsset = monitorAsset;
    }
}
