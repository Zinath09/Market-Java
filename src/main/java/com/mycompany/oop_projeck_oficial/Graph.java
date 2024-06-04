/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_projeck_oficial;

/**
 *
 * @author zuzab
 */
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 

import org.jfree.data.time.TimeSeries; 
import org.jfree.data.time.TimeSeriesCollection; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.ui.ApplicationFrame; 

public class Graph extends ApplicationFrame {
    int[] indexes;
    String title;
   public Graph( final String title, int[] indexes ) {
      super( title );
      this.title = title;
      this.indexes= indexes;
      final XYDataset dataset = createDataset( );         
      final JFreeChart chart = createChart( dataset );         
      final ChartPanel chartPanel = new ChartPanel( chart );         
      chartPanel.setPreferredSize( new java.awt.Dimension( 900 , 370 ) );         
      setContentPane( chartPanel );
   }
    @Override
 public void windowClosing(WindowEvent event) {
        
    }
//    @Override
//    public void windowClosed(WindowEvent event) {
//       
//    }
   private XYDataset createDataset( ) {
       TimeSeries series = new TimeSeries( "Random Data" );         
      TimeSeriesCollection dataset = new TimeSeriesCollection();
      double value = 100.0;         
      
      for (int i = 0; i <this.indexes.length; i++) {
         
           try {
               series = (TimeSeries) (MainWorld.listOfAssets.get(this.indexes[i]).getSeries()).clone();
           } catch (CloneNotSupportedException ex) {
               Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
           }
         
         dataset.addSeries(series);//MainWorld.listOfAssets.get(this.indexes[i]).getSeries());
      }
      
      return dataset;
   }     

   private JFreeChart createChart( final XYDataset dataset ) {
      return ChartFactory.createTimeSeriesChart(             
         this.title, 
         "Time",              
         "Prices",              
         dataset,             
         false,              
         false,              
         false);
   }

}   