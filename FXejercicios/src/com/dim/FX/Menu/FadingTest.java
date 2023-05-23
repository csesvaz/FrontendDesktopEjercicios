package com.dim.FX.Menu;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadingTest {
	ListView<Item> lv1 = new ListView<>();
	ListView<Item> lv2 = new ListView<>();
	// Our custom Data Format
	static final DataFormat ITEM_LIST = new DataFormat("dim/itemlist");
	public FadingTest(Stage escenario) {
	 // Crear una nueva ventana modal
	 Stage escenariomodal = new Stage();
	 escenariomodal.initModality(Modality.APPLICATION_MODAL);
	 escenariomodal.initOwner(escenario);
	 escenariomodal.setTitle("Ventana Modal");
	 
	 Rectangle rect = new Rectangle(200, 50, Color.RED);
	HBox root = new HBox(rect);
	Scene scene = new Scene(root);
	escenariomodal.setScene(scene);
	escenariomodal.setTitle("Efecto Fading");
	escenariomodal.show();
	// Set up a fade-in and fade-out animation for the rectangle
	FadeTransition fadeInOut = new FadeTransition(Duration.seconds(2), rect);
	fadeInOut.setFromValue(1.0);
	fadeInOut.setToValue(.20);
	fadeInOut.setCycleCount(FadeTransition.INDEFINITE);
	fadeInOut.setAutoReverse(true);
	fadeInOut.play();
	 
	 
	}
	 
	 }