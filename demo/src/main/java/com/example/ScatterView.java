package com.example;

import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.chart.NumberAxis; 
import javafx.scene.chart.ScatterChart; 
import javafx.scene.chart.XYChart; 
         
public class ScatterView extends Application { 
   ScatterChart<String, Number> scatterChart;
   NumberAxis xAxis,yAxis;

   ScatterView(){
      // setSize();
      // this.scatterChart = new ScatterChart(xAxis, yAxis);
   }

   public void setSize(){
      this.xAxis = new NumberAxis(0, 1, 3); 
      this.xAxis.setLabel("Area");          
        
      yAxis = new NumberAxis(0, 1, 4); 
      yAxis.setLabel("Weight"); 
   }


   public void setData(float[] data){
      XYChart.Series series = new XYChart.Series();  
      for(int i = 0; i < data.length; i++){
         series.getData().add(new XYChart.Data(i, data[i])); 
      }

      scatterChart.getData().addAll(series); 
   }

   @Override 
   public void start(Stage stage) {     
      //Creating a Group object  
      Group root = new Group(scatterChart); 
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 400);  
      //Setting title to the Stage 
      stage.setTitle("Random number scatter plot"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   } 
   public static void start(){ 
      launch(); 
   } 
}