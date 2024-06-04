/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_projeck_oficial;
import java.util.HashMap;


/**
 * 
 * @author zuzab
 */
public abstract class Trader implements Runnable{
    static int counter;

    /**
     *The first name is always unique because it has a number added to it.
     */
    protected String firstName;

    /**
     *
     */
    protected String lastName;

    /**
     *
     */
    protected float investmentBudget;
    /**
     * A list mapping a specific Asset and their values that have been purchased.
     */
    private HashMap <Asset, Integer> listOfAssets;

    /**
     * Generate fields, initialize portfolio, increase global noTrader
     */
    public Trader() {
        this.firstName=GeneratingThings.generateRandomName()+ Integer.toString(counter);
        this.lastName= GeneratingThings.generateRandomSurname();
        this.investmentBudget = GeneratingThings.generateRandomFloat(100000,500000);
        listOfAssets = new HashMap<>();
        counter++;
    }

    
    
      
    /**
    *0)Select Market and then select an asset from it. 
    *1) myPrice - our proposed price; is similar to the current price of the asset.
    *2) myQuantity - the number of units we can buy with myPrice and investmentBudget;
    *3) If the myQuantity is non-zero, we make the transaction. As the market value changes, the price of the asset changes at myPrice. 
    *4)Add the bought asset to the wallet and change the value of your investmentBudget.
     */
    public void buySth(){
        Market myMarket = MainWorld.listOfMarkets.get(GeneratingThings.generateRandomNumber(0, MainWorld.noMarket));
        if ("Stock".equals(myMarket.getType())){
            Stock myAsset = (Stock) myMarket.pickAsset();

            synchronized (myAsset.monitorAsset) {
            System.out.println("Investor " + this.getFirstName());
            System.out.println("\tKUPIONO: " + myAsset.getName() + "cur. quantity: " + myAsset.getQuantity());
            int currQuantity=myAsset.getQuantity();
            float price = myAsset.getCurrentPrice();
            float myPrice = GeneratingThings.generateRandomNumberFromInterval((float) -0.04, (float) 0.04, price);
            int myQuantity = quantityOfAssetToBuy(myAsset, myPrice);
            if (myQuantity>0){
                myAsset.transaction( myQuantity,  myPrice);
                changeQuantityOfAsset(myAsset, myQuantity);
                this.investmentBudget-=myQuantity*myAsset.getCurrentPrice();
                }
             System.out.println("\tprice "+price + " -> " + myPrice + "\tquantity: "+ currQuantity + " -"+myQuantity + " -> " +  myAsset.getQuantity());
                }
            }
        else if ("Commodity".equals(myMarket.getType())){
            Commodity myAsset = (Commodity) myMarket.pickAsset();
            synchronized (myAsset.monitorAsset) {
            System.out.println("Investor " + this.getFirstName());
            System.out.println("\tKUPIONO: " + myAsset.getName() + "cur. quantity: " + myAsset.getQuantity());
            int currQuantity=myAsset.getQuantity();
            float price = myAsset.getCurrentPrice();
            float myPrice = GeneratingThings.generateRandomNumberFromInterval((float) -0.04, (float) 0.04, price);            
            int myQuantity = quantityOfAssetToBuy(myAsset, myPrice);
            if (myQuantity>0){
                myAsset.transaction( myQuantity,  myPrice);
                changeQuantityOfAsset(myAsset, myQuantity);
                this.investmentBudget-=myQuantity*myAsset.getCurrentPrice();
                }
            System.out.println("\tprice "+price + " -> " + myPrice + "\tquantity: "+ currQuantity + " -"+myQuantity + " -> " +  myAsset.getQuantity());
            }
                  }
        else if ("Currency".equals(myMarket.getType())){
            Currency myAsset = (Currency) myMarket.pickAsset();
            synchronized (myAsset.monitorAsset) {
            System.out.println("Investor " + this.getFirstName());

            System.out.println("\tKUPIONO: " + myAsset.getName() + "cur. quantity: " + myAsset.getQuantity());
            int currQuantity=myAsset.getQuantity();

        float price = myAsset.getCurrentPrice();
            float myPrice = GeneratingThings.generateRandomNumberFromInterval((float) -0.04, (float) 0.04, price);            
            int myQuantity = quantityOfAssetToBuy(myAsset, myPrice);
            if (myQuantity>0){
                myAsset.transaction( myQuantity,  myPrice);
                changeQuantityOfAsset(myAsset, myQuantity);
                this.investmentBudget-=myQuantity*myAsset.getCurrentPrice();
                }
            System.out.println("\tprice "+price + " -> " + myPrice + "\tquantity: "+ currQuantity + " -"+myQuantity + " -> " +  myAsset.getQuantity());
            }
        }
       
    
    }
  /**This method returns a number of assets we want to buy from the Market.
*1)If our proposed price is not within the availability range of the asset, we return zero.
*2)Otherwise, we allocate 10% - 30% of the budget for the asset ( budgetAsset) and calculate how many units of this Assset we are able to get (maxQuantity). 
*3)If our proposed maxQuantity is achievable under the condition that at least half of this Asset will still be on the market, we return maxQuantity. Otherwise, we buy 1/3 of the number of Asset available in the market.
*/
    private int quantityOfAssetToBuy(Asset myAsset, float myPrice){
        if (myPrice>=myAsset.getMinimalPrice() && myPrice<=myAsset.getMaximalPrice()){
                //we want to spend between 10% - 30% our budget
                float budgetAsset = GeneratingThings.generateRandomFloat((float) 0.1, (float) 0.3)*this.getInvestmentBudget();
                //
                int maxQuantity =(int) Math.floor(budgetAsset/myPrice); 
                if (myAsset.getQuantity()/2 > maxQuantity){ //if available quantity is bigger then asked
                    return maxQuantity;
                }
                else return (int) Math.floor(myAsset.getQuantity()/3);        
            }
        else 
            return 0;
}
        

    
    /**
       * 0) We randomize an asset from our wallet.
       * 1) myPrice - our proposed price is the same as the current price of the asset.
       * 2) myQuantity -Draw the number we can sell it.
       * 3) We make a transaction. (But this time we sell the asset, so the quantity is minus, and the new myPrice is the same, so the price will not change.  So in the end we only change the quantity of it available in the market.
       * 4)We remove the sold asset from our portfolio and increase the value of our investmentBudget.
     */
    public void sellSth(){
        
            if (this.listOfAssets.size()>0){
            Object[] myRandomAsset = this.listOfAssets.keySet().toArray();
            Asset myAsset = (Asset) myRandomAsset[GeneratingThings.generateRandomNumber(0,listOfAssets.size() )];
                synchronized (myAsset.monitorAsset) {
            System.out.println("Investor " + this.getFirstName());
            if (this.listOfAssets.get(myAsset)>0){
                if (myAsset.getType()=="Stock"){
                    myAsset=(Stock) myAsset;
                }
                int currQuantity = this.listOfAssets.get(myAsset); //ile jest w portfelu
                int quantity = GeneratingThings.generateRandomNumber(0,currQuantity); //ile chce sprzedać
                int assetQuantity = myAsset.getQuantity(); 
                myAsset.transaction(-quantity, myAsset.getCurrentPrice());
                changeQuantityOfAsset(myAsset, -quantity);
                this.investmentBudget+=quantity*myAsset.getCurrentPrice();
                System.out.println("\tSPRZEDANO: " +myAsset.getName() +"\tquantity na rynku: "+ assetQuantity + " + "+quantity + " -> " +  myAsset.getQuantity());
                System.out.println("\tSPRZEDANO: " +myAsset.getName() + "\tquantity w liście: "+ currQuantity + " - "+quantity + " -> " +  this.listOfAssets.get(myAsset));
            }
            }
//            System.out.println("ListaAssets: " + this.listOfAssets);

            }

        }
        
    /**
     *
     * @param myAsset -Asset that we buy or sell.
     * @param quantity - The number of Assets we are adding to or removing from our wallet. 

     */
    public void changeQuantityOfAsset(Asset myAsset, int quantity){
        if (this.listOfAssets.containsKey(myAsset)){
            listOfAssets.replace(myAsset,listOfAssets.get(myAsset)+quantity);
        }
        else{
            this.listOfAssets.put(myAsset,quantity);
        }         
    }
    
    /**
     *
     */
    public void increaseBudget(){
        this.investmentBudget+=investmentBudget*1.5;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public float getInvestmentBudget() {
        return investmentBudget;
    }

    /**
     *
     * @param investmentBudget
     */
    public void setInvestmentBudget(float investmentBudget) {
        this.investmentBudget = investmentBudget;
    }

}
