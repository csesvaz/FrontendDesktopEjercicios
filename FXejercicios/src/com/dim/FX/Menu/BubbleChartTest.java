package com.dim.FX.Menu;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.BubbleChart;

public class BubbleChartTest {
	// Crear el contenido de la ventana modal
	public BubbleChartTest(Stage escenario) {
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
		BubbleChart<Number, Number> chart = new BubbleChart<>(xAxis, yAxis);
		chart.setTitle("Population by Year and Country");
		// Get the data for the chart
		ObservableList<XYChart.Series<Number, Number>> chartData = XYChartDataUtil.getCountrySeries();
		// Set the bubble radius
		setBubbleRadius(chartData);
		// Set the data for the chart
		chart.setData(chartData);
		StackPane root = new StackPane(chart);
		root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		Scene scene = new Scene(root);
		escenariomodal.setScene(scene);
		escenariomodal.setTitle("Gráfico de barras verticales");
		escenariomodal.show();
	}

	private void setBubbleRadius(ObservableList<XYChart.Series<Number, Number>> chartData) {
		for (XYChart.Series<Number, Number> series : chartData) {
			for (XYChart.Data<Number, Number> data : series.getData()) {
				data.setExtraValue(20); // Bubble radius
			}
		}
	}

}