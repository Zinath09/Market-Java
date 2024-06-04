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
public class Index {
    private String name;
    private String type;
    private List <Company> listCompanyOfCathegory= new LinkedList();

    /**
     *Set type, name and add all companies of this type to the index.
     */
    public Index() {
        this.name = "Index of "+GeneratingThings.cathegories[MainWorld.noIndex];
        System.out.println("Index" + MainWorld.noIndex);
        this.type = GeneratingThings.cathegories[MainWorld.noIndex];
        MainWorld.noIndex++;
        for (int i=0;i<MainWorld.listOfCompanies.size()-1;i++)
        {
            if (MainWorld.listOfCompanies.get(i).getCathegory().equals(this.type)){
                listCompanyOfCathegory.add(MainWorld.listOfCompanies.get(i));
            } 
        }
    }

    /**
     *Description for displaying detailed information
     * @return
     */
    public String describe(){
        String a,b,c;
        a="Name: " + this.name + "\n";
        b="Type: " + this.type + "\n";
        c="Company in Index: " + this.getNames();
        return a+b+c;
    }
    private String getNames(){
        String name = "\n";
        
        for (int i =0;i<this.listCompanyOfCathegory.size();i++){
            name+=((Company) this.listCompanyOfCathegory.get(i)).getName() + "\n";
        }
        return name;
    }
    /**
     *
     * @return
     */
    public String getName() {
        return name;}
    
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
    public List<Company> getListCompanyOfCathegory() {
        
        return listCompanyOfCathegory;
    }

       }



