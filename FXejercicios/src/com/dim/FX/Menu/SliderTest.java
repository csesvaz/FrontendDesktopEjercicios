package com.dim.FX.Menu;

import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class SliderTest {
	Rectangle rect = new Rectangle(0, 0, 300, 50);
	Slider redSlider = getSlider();
	Slider greenSlider = getSlider();
	Slider blueSlider = getSlider();

	public SliderTest(Stage escenario) {
		// Crear una nueva ventana modal
		Stage escenariomodal = new Stage();
		escenariomodal.initModality(Modality.APPLICATION_MODAL);
		escenariomodal.initOwner(escenario);

		// Add a ChangeListener to all sliders
		redSlider.valueProperty().addListener(this::changed);
		greenSlider.valueProperty().addListener(this::changed);
		blueSlider.valueProperty().addListener(this::changed);
		GridPane root = new GridPane();
		root.setVgap(10);
		root.add(rect, 0, 0, 2, 1);
		root.add(new Label("Utilizar el deslizador para cambiar el color de relleno"), 0, 1, 2, 1);
		root.addRow(2, new Label("Rojo:"), redSlider);
		root.addRow(3, new Label("Verde:"), greenSlider);
		root.addRow(4, new Label("Azul:"), blueSlider);
		root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		Scene scene = new Scene(root);

		escenariomodal.setTitle("Deslizador selector");
		escenariomodal.setScene(scene);
		escenariomodal.show();
		// Adjust the fill color of the rectangle
		changeColor();
	}

	public Slider getSlider() {
		Slider slider = new Slider(0, 255, 125);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(85);
		slider.setMinorTickCount(10);
		slider.setBlockIncrement(20);
		slider.setSnapToTicks(true);
		return slider;
	}

	// A change listener to track the change in color
	public void changed(ObservableValue<? extends Number> prop, Number oldValue, Number newValue) {
		changeColor();
	}

	public void changeColor() {
		int r = (int) redSlider.getValue();
		int g = (int) greenSlider.getValue();
		int b = (int) blueSlider.getValue();
		Color fillColor = Color.rgb(r, g, b);
		rect.setFill(fillColor);
	}

}