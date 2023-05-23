package com.dim.FX.Menu;

import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ColorPickerTest {
	public ColorPickerTest(Stage escenario) {
		 // Crear una nueva ventana modal
		 Stage escenariomodal = new Stage();
		 escenariomodal.initModality(Modality.APPLICATION_MODAL);
		 escenariomodal.initOwner(escenario);
		 
		 ColorPicker bgColor = new ColorPicker(Color.RED);
		Rectangle rect = new Rectangle(0, 0, 100, 50);
		rect.setFill(bgColor.getValue());
		rect.setStyle("-fx-stroke-width: 2; -fx-stroke: black;");
		bgColor.setOnAction(e -> rect.setFill(bgColor.getValue()));
		HBox root = new HBox(new Label("Color:"), bgColor, rect);
		root.setSpacing(10);
		root.setStyle("-fx-padding: 10;" + 
		 "-fx-border-style: solid inside;" + 
		 "-fx-border-width: 2;" +
		 "-fx-border-insets: 5;" + 
		 "-fx-border-radius: 5;" + 
		 "-fx-border-color: blue;");
		Scene scene = new Scene(root); 
		 escenariomodal.setTitle("Seleccionando colorl");
		 escenariomodal.setScene(scene);
		 escenariomodal.show();
		 
		 
		 }
		}