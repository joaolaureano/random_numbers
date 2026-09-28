package com.example;

import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.chart.NumberAxis; 
import javafx.scene.chart.ScatterChart; 
import javafx.scene.chart.XYChart; 
         
public class ScatterView extends Application {
   private static float[] dataToPlot = new float[0];

   ScatterChart<Number, Number> scatterChart;
   NumberAxis xAxis,yAxis;

   ScatterView(){
   }

   public void setSize(){
      this.xAxis = new NumberAxis(0, dataToPlot.length, Math.max(1, dataToPlot.length / 10));
      this.xAxis.setLabel("Index");

      yAxis = new NumberAxis(0, 1, 0.1);
      yAxis.setLabel("Value");
   }


   public void setData(float[] data){
      XYChart.Series<Number, Number> series = new XYChart.Series<>();
      for(int i = 0; i < data.length; i++){
         series.getData().add(new XYChart.Data<>(i, data[i]));
      }

      scatterChart.getData().addAll(series);
   }

   @Override
   public void start(Stage stage) {
      setSize();
      scatterChart = new ScatterChart<>(xAxis, yAxis);
      setData(dataToPlot);

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
   public static void start(float[] data){
      dataToPlot = data;
      launch();
   }
}