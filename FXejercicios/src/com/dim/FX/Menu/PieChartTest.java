package com.dim.FX.Menu;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.geometry.Side;
public class PieChartTest{
// Crear el contenido de la ventana modal
 
public PieChartTest(Stage escenario) {
 // Crear una nueva ventana modal
 Stage escenariomodal = new Stage();
 escenariomodal.initModality(Modality.APPLICATION_MODAL);
 escenariomodal.initOwner(escenario);
 escenariomodal.setTitle("Ventana Modal");
PieChart chart = new PieChart();
chart.setTitle("Population in 2000");
// Place the legend on the left side
chart.setLegendSide(Side.LEFT);
// Set the data for the chart
ObservableList<PieChart.Data> chartData = PieChartUtil.getChartData();
chart.setData(chartData);
StackPane root = new StackPane(chart);
root.setStyle("-fx-padding: 10;" + 
 "-fx-border-style: solid inside;" + 
 "-fx-border-width: 2;" +
 "-fx-border-insets: 5;" + 
 "-fx-border-radius: 5;" + 
 "-fx-border-color: blue;");
Scene scene = new Scene(root);
escenariomodal.setScene(scene);
escenariomodal.setTitle("Gráfico de sectores");
escenariomodal.show();
 
}
 
 
 }