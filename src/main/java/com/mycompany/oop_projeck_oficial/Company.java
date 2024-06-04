/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_projeck_oficial;


/**
 *
 * @author zuzab
 */
public class Company{

    private String name;
    private static int no_name;
    private String country;
    private float openingPrice;
    private float currentPrice;
    private float capital;
    private int no_assets;
    private float totalSharesSumm;
    private Stock companyStock;
    private String cathegory;
    private float revenue;
    private int no_boughted_out;
    
    /**
     * Description for displaying detailed information
     * @return
     */
    public String describe(){
        String a,b,b1,c,d,e,f,g,h,i;
        a="Name: " + this.name + "\n";
        b="Cathegory: " + this.cathegory + "\n";
        b1= "Country: " + this.country + "\n";
        c="Company value in shares: " + this.totalSharesSumm + "\n";
        d="Inside capital: " + this.capital + "\n";
        e="Opening price: " + this.openingPrice + "\n";
        f="Current price: " + this.getCurrentPrice() + "\n";
        g="Name of company stock: " + this.companyStock.getName() + "\n";
        h="Number of company stock: " + this.no_assets+"\n" ;
        i="Number of stock boughted out: " + this.no_boughted_out ;
        return a+b+b1+c+d+e+f+g+h+i;
    }

    /**
     *Generating company value (opening price) . 
     * Creating assigned Stock with price equal to company value/no_assets. 
     * This quantity of this company stock is then published on the Stock markets. 
     * Then the company buys 20% of its shares, the value of this company (currentPrice) is then equal to the value in shares (totalSharesSumm) and what it has in its capital (capital).

     */
    public Company() {
        companyStock  = new Stock();
        this.cathegory = GeneratingThings.generateRandomCathregory();
        this.name="Company"+String.valueOf(no_name);
        System.out.println(this.name + " is created");
        no_name++;
        this.openingPrice = GeneratingThings.generateRandomFloat(10000, 50000);
        this.capital = this.openingPrice;
        this.currentPrice = this.openingPrice;
        this.country=GeneratingThings.generateRandomCountry();
        lounchStocks(); 
        updateIndex();
        buyOwnStocks(Math.round((float)0.2 * this.no_assets)); //Pobieranie 20% swoich akcji
        MainWorld.noCompany++;
        MainWorld.listOfAssets.add(companyStock);
    }

    
     private void updateIndex() {
        for (int i =0;i<MainWorld.listOfIndexes.size();i++){
            if (MainWorld.listOfIndexes.get(i).getType().equals(this.cathegory)){
                MainWorld.listOfIndexes.get(i).getListCompanyOfCathegory().add(this);
            }
        }
    }
    /**
     *Lounching assigned Stock with a price equal to the value of the company/number of its assets. This number is then published on the Stock markets
     */
    private void lounchStocks(){
        this.no_assets =GeneratingThings.generateRandomNumber(100, 500);
        float stockPrice = this.openingPrice/this.no_assets;
        companyStock.setCurrentPrice(stockPrice);
        companyStock.setOwner(this);
        companyStock.setQuantity(no_assets);
        this.capital -= stockPrice*no_assets;
        this.totalSharesSumm+=stockPrice*no_assets;
        }
    
    /**
     * Reduce the number of stocks on the Market and the company's value in shares changes by the change in current price.
     * @param quantity -number of Stocks bought by the investor
     * @param newPrice
     * @param oldPrice
     */
    public void getMoneyFromSellingStocks(int quantity, float newPrice, float oldPrice){
        this.no_assets-=quantity;
        this.totalSharesSumm+=(newPrice-oldPrice)*quantity;
    }
    
    /**
     * Buying stock out of the market.
     * @param quantity
     */
    public void buyOwnStocks(int quantity){
            this.no_assets-=quantity;
            this.capital+=this.companyStock.getCurrentPrice();
            this.totalSharesSumm-=this.companyStock.getCurrentPrice();
            System.out.println("The company bought out " + quantity + "stocks!");
            no_boughted_out+=quantity;
        }
    
    /**
     * 
     * Category allows you to get the right index assignment.
     * @return
     */
    public String getCathegory() {
        return cathegory;
    }

    /**
     *
     * @param cathegory
     */
    public void setCathegory(String cathegory) {
        this.cathegory = cathegory;
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
    public float getOpeningPrice() {
        return openingPrice;
    }

    /**
     *
     * @param openingPrice
     */
    public void setOpeningPrice(float openingPrice) {
        this.openingPrice = openingPrice;
    }

    /**
     *
     * @return
     */
    public float getCurrentPrice() {
        currentPrice=this.getCapital()+this.totalSharesSumm+this.revenue;
        return currentPrice;
    }

    /**
     *
     * @param currentPrice
     */
    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     *
     * @return
     */
    public float getCapital() {
        return capital;
    }

    /**
     *
     * @param capital
     */
    public void setCapital(float capital) {
        this.capital = capital;
    }

    /**
     *
     * @return
     */
    public int getNo_name() {
        return no_name;
    }

    /**
     *
     * @param no_name
     */
    public void setNo_name(int no_name) {
        this.no_name = no_name;
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
     * @return
     */
    public int getNo_assets() {
        return no_assets;
    }

    /**
     *
     * @param no_assets
     */
    public void setNo_assets(int no_assets) {
        this.no_assets = no_assets;
    }

    /**
     *
     * @return
     */
    public float getTotalSharesSumm() {
        return totalSharesSumm;
    }

    /**
     *
     * @param totalSharesSumm
     */
    public void setTotalSharesSumm(float totalSharesSumm) {
        this.totalSharesSumm = totalSharesSumm;
    }

    /**
     *
     * @return
     */
    public Stock getCompanyStock() {
        return companyStock;
    }

    /**
     *
     * @param companyStock
     */
    public void setCompanyStock(Stock companyStock) {
        this.companyStock = companyStock;
    }

     public float changeRevenue(float change) {
        return revenue+change;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }


   
}
