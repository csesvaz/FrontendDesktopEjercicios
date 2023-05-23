package com.dim.FX.Menu;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Generico {
	public Generico(Stage escenario) {
		 // Crear una nueva ventana modal
		 Stage escenariomodal = new Stage();
		 escenariomodal.initModality(Modality.APPLICATION_MODAL);
		 escenariomodal.initOwner(escenario);
		 
		 // Crear el contenido de la ventana modal
		 
		 
		 VBox root = new VBox(10);
		 root.setPadding(new Insets(10));
		 root.getChildren().addAll(new Label("Esta es una ventana modal"));
		 
		 Scene scene=new Scene(root, 350, 250);
		 escenariomodal.setTitle("Ventana Modal");
		 escenariomodal.setScene(scene);
		 escenariomodal.show();
		 
		 
		 }
		}