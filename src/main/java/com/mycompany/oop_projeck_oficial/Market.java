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
 * @param <T>
 */
public class Market <T>{

    /**
     *
     */
    public static int number;
    private String name;
    private String country;
    private String address;
    private float margin; //marża
    private Currency tradingCurrency;
    private String type = "Market";
    private List <T> availableAssets= new LinkedList();
    
    
    /**
     * Description for displaying detailed information
     * @return
     */
    public String describe(){
        String a,b,c,d,e,f;
        a="Name: " + this.name + "\n";
        b="Type: " + this.type + "\n";
        c="Country: " + this.country + "\n";
        d="Address: " + this.address + "\n";
        e="Margin: " + this.margin + "\n";
        f="Available assets: " + this.getNames() ;
        return a+b+c+d+e+f;
    }

    /**
     *
     * @param Type
     */
    public Market(String Type){
        this.name= this.type + number;
        this.type = Type;
        number++;
        MainWorld.noMarket++;
        this.country = GeneratingThings.generateRandomCountry();
        this.address = GeneratingThings.generateRandomAdress();
        this.margin = GeneratingThings.generateRandomFloat( 0,(float) 0.2);  
        System.out.println("This market has a type"+ this.type +" and name "+ this.name);
        loadMarket();
    }

    /**
     * I add 90% Asset from the previous makert of the same type.
     */
    public void loadMarket(){
        
        for (int i =0;i<MainWorld.listOfMarkets.size();i++){
            if (MainWorld.listOfMarkets.get(i).getType().equals(this.type)){
                for (int j=0;j<MainWorld.listOfMarkets.get(i).getAvailableAssets().size();j++){
                    if (GeneratingThings.generateRandomFloat(0, 1)>0.1){
                    this.availableAssets.add((T) MainWorld.listOfMarkets.get(i).getAvailableAssets().get(j));}
                }
                break;
            }
            }
        }
      private String getNames(){
        String name = "\n";
        
        for (int i =0;i<this.availableAssets.size();i++){
            name+=((Asset) this.availableAssets.get(i)).getName() + "\n";
        }
        return name;
    }
    

    /**
     *
     * @param number
     */
    public void createCompanies(int number){
        for (int i = 0;i <number;i++){
            new Company();
        }
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
     */
    protected void printClass() {
        System.out.println(this.getName()+ " " +this.getAddress() + " is created.");
    }

    /**
     *
     * @param assignAsset
     */
    public void addToAvailableAssets(T assignAsset) {
        this.availableAssets.add(assignAsset);
    }

    /**
     *
     * @return
     */
    public T pickAsset() {
        int index=GeneratingThings.generateRandomNumber(0, this.availableAssets.size());
        return availableAssets.get(index);
    }

    /**
     *
     * @return
     */
    public List<T> getAvailableAssets() {
        return availableAssets;
    }

    /**
     *
     * @param availableAssets
     */
    public void setAvailableAssets(List<T> availableAssets) {
        this.availableAssets = availableAssets;
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
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     */
    public Currency getTradingCurrency() {
        return tradingCurrency;
    }

    /**
     *
     * @param tradingCurrency
     */
    public void setTradingCurrency(Currency tradingCurrency) {
        this.tradingCurrency = tradingCurrency;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public float getMargin() {
        return margin;
    }

    /**
     *
     * @param margin
     */
    public void setMargin(float margin) {
        this.margin = margin;
    }

}
