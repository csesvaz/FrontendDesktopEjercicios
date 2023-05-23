package com.dim.FX.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.ScatterChart;
import javafx.application.Application;
import javafx.scene.chart.LineChart;
public class LineChartTest
{
// Crear el contenido de la ventana modal
 
public LineChartTest(Stage escenario) {
 // Crear una nueva ventana modal
 Stage escenariomodal = new Stage();
 escenariomodal.initModality(Modality.APPLICATION_MODAL);
 escenariomodal.initOwner(escenario);
 escenariomodal.setTitle("Ventana Modal");
 
 NumberAxis xAxis = new NumberAxis();
xAxis.setLabel("Year");
// Customize the x-axis, so points are scattred uniformly
xAxis.setAutoRanging(false);
xAxis.setLowerBound(1900);
xAxis.setUpperBound(2300);
xAxis.setTickUnit(50);
NumberAxis yAxis = new NumberAxis();
yAxis.setLabel("Population (in millions)");
LineChart<Number,Number> chart = new LineChart<>(xAxis, yAxis);
chart.setTitle("Population by Year and Country");
// Set the data for the chart
ObservableList<XYChart.Series<Number,Number>> chartData = 
XYChartDataUtil.getCountrySeries();
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
escenariomodal.setTitle("Gráfico de barras verticales");
escenariomodal.show();
 
}
 
 
 
private ObservableList<XYChart.Series<Number,String>> getChartData(
ObservableList<XYChart.Series<String,Number>> oldData) {
ObservableList<XYChart.Series<Number, String>> newData = 
FXCollections.observableArrayList();
// Read (String, Number) from old data and convert it into 
// (Nubmer, String) in new data
for(XYChart.Series<String, Number> oldSeries: oldData) {
XYChart.Series<Number, String> newSeries = new XYChart.Series<>();
newSeries.setName(oldSeries.getName());
for(XYChart.Data<String, Number> oldItem: oldSeries.getData()) {
XYChart.Data<Number, String> newItem = 
new XYChart.Data<>(oldItem.getYValue(), 
 oldItem.getXValue());
newSeries.getData().add(newItem);
}
newData.add(newSeries);
}
return newData;
}
}
