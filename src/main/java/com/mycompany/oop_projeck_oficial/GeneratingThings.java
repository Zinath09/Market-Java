/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_projeck_oficial;
import java.util.Random;

   

/**
 *
 * @author zuzab
 */
public class GeneratingThings {
    final static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random random = new Random();
    final static String names[] = {"James", "Robert", "John", "William", "Richard", "Thomas", "Karen", "Susan", "Sarah"};
    final static String surnames[]= {"Walker", "Johnson", "Taylor", "Brown", "Smith", "Wood", "Wood","Clarke"};
    final static String countries[] = {"Poland", "Russia", "Germany", "Georgia", "Greece", "Andalusia", "Italy"};
    final static String streets[] = {"Fleet Street","Harley Street","Kingsway","Wall Street","High Holborn","Baker Street","Downing Street"};
    final static String cities[] = {"London","Birmingham","Leeds","Glasgow","Sheffield","Manchester","Edynburg"};
    final static String cathegories[] = {"Food","Entertainment","Sports","Recreation","Music","Business","IT","Government","HumanResources"};
    
    public static String generateRandomCathregory() {
      int index = random.nextInt(cathegories.length);
      String randomcathegories = cathegories[index];
      return randomcathegories;
    }
    
   public static float generateRandomNumberFromInterval(float min, float max, float estimator ) {
      float myNumber = estimator*(random.nextFloat(max - min)+min+1);
      return myNumber;
    }

     public static int generateRandomNumber(int min, int max) {
      int newInt= random.nextInt( max-min)+min;
      return newInt;
    }
     public static float generateRandomFloat(float min, float max) {
      float newFloat= (float) random.nextFloat(max-min)+ min;
      return newFloat;
    }
   public static String generateRandomString() {
    StringBuilder sb = new StringBuilder();
    int length = 7;
    for(int i = 0; i < length; i++) {
      int index = random.nextInt(alphabet.length());
      char randomChar = alphabet.charAt(index);
      sb.append(randomChar);
    }
    String randomString = sb.toString();
//    System.out.println("Random String is: " + randomString);
    return randomString;
    }
     public static String generateRandomName() {
      int index = random.nextInt(names.length);
      String randomName = names[index];
      return randomName;
    }
       public static String generateRandomSurname() {
      int index = random.nextInt(surnames.length);
      String randomSurname = surnames[index];
      return randomSurname;
    }
      public static String generateRandomCountry() {
      int index = random.nextInt(countries.length);
      String randomCountry = countries[index];
      return randomCountry;
    }
      public static String generateRandomAdress() {
      int index = random.nextInt(streets.length);
      String randomStreet = streets[index];
      String number= String.valueOf(random.nextInt(100));

      index = random.nextInt(cities.length);
      String randomCity = cities[index];
      return randomStreet+ " "+number +" "+ randomCity;
    }
   
}
