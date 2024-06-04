/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_projeck_oficial;
import java.util.Random;
import java.util.*;
/**
 *
 * @author zuzab
 */
public class MainWorld {
   static List <Market> listOfMarkets = new LinkedList();
   static List <Asset> listOfAssets = new LinkedList();
   static List <Trader> listOfTraders= new LinkedList();
   static List <Company> listOfCompanies= new LinkedList();
   static List <Index> listOfIndexes= new LinkedList();
   static int speed=1;
   //asstes
//   static int  noStock; //aka  'noAction'  there is no sucha number because number of stock is the same as no of company
   static int  noCommodity;
   static int  noCurrency;
   
   //markets
   static int  noMarket;
   static int  noCommodityMarkets;
   static int  noCurrencyMarkets;
   static int  noStockMarkets;

   //Traders
   static int  noInvestor;
   static int  noFund;

   //Company & Indexes
   static int  noCompany;
   static int  noIndex;

    public static void main(String[] args) {
        createObjects();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
    
        
     public static void createObjects() {
        noMarket=noCommodityMarkets+noCurrencyMarkets+noStockMarkets;
        createInitialMarkets(0);
        createInvestors(0);
        createCurrencies(5);
        createCommodities(5);
        createCompanies(5);      
         createIndexes(2);        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Control().setVisible(true);
            }
        }
        );
         System.out.println("-------------KONIEC TWORZENIA OBIEKTÓW STARTOWYCH----------------");
    }
     
     public static void createInitialMarkets(int noOfNewMarkets) {
        for (int i = 0; i < 2; i++) {
                listOfMarkets.add(new Market <Commodity> ("Commodity"));
                noCommodityMarkets++;
                createInvestors(2);

        }
        for (int i = 0; i < 2; i++) {
                listOfMarkets.add(new Market <Currency>("Currency"));
                noCurrencyMarkets++;
                createInvestors(2);

        }
        for (int i = 0; i < 2; i++) {
                listOfMarkets.add(new Market<Stock>("Stock"));
                noStockMarkets++;
                createInvestors(2);

        }
    }

     public static void createCommodityMarkets(int noOfNewMarkets) {
        for (int i = 0; i < noOfNewMarkets; i++) {
                listOfMarkets.add(new Market <Commodity> ("Commodity"));
                noCommodityMarkets++;
                createInvestors(2);

        }}
     
     public static void createCurrencyMarkets(int noOfNewMarkets) {
        for (int i = 0; i < noOfNewMarkets; i++) {
                listOfMarkets.add(new Market <Currency> ("Currency"));
                noCurrencyMarkets++;
                createInvestors(2);

        }}
     
     public static void createStockMarkets(int noOfNewMarkets) {
        for (int i = 0; i < noOfNewMarkets; i++) {
                listOfMarkets.add(new Market <Stock> ("Stock"));
                 noStockMarkets++;
                createInvestors(2);
        }}
        
public static void createCompanies(int noOfNewCompany) {
        for (int i = 0; i < noOfNewCompany; i++) {
                Company myLovelyCompany = new Company();
                listOfCompanies.add(myLovelyCompany);
        }
    }

public static void createInvestors(int noOfNewInvestor) {
        for (int i = 0; i < noOfNewInvestor; i++) {
                Investor myLovelyInvestor = new Investor();
                listOfTraders.add(myLovelyInvestor);
                
        }
    }

public static void createCurrencies(int noOfNewCurrency) {
        for (int i = 0; i < noOfNewCurrency; i++) {
                Currency myLovelyCurrency = new Currency();
                listOfAssets.add(myLovelyCurrency);
        }
    }
public static void createIndexes(int noOfNewIndexes) {
        for (int i = 0; i < noOfNewIndexes; i++) {
            if (GeneratingThings.cathegories.length>listOfIndexes.size()){
                    
                   
                Index myLovelyIndex = new Index();
                listOfIndexes.add(myLovelyIndex);
                System.out.println("Index added");}
        }
    }

public static void createCommodities(int noOfNewCommodity) {
        for (int i = 0; i < noOfNewCommodity; i++) {
                Commodity myLovelyCommodity = new Commodity();
                listOfAssets.add(myLovelyCommodity);
        }
    }
}

