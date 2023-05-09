package com.dim.FX.Ejercicio100;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloFXApp extends Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	public void start(Stage stage) {
		Label nombre = new Label("Escribe tu nombre:");
		TextField cajanombre = new TextField();
		Label msg = new Label();
		msg.setStyle("-fx-text-fill: blue;");
		// Crear botones
		Button diceHolaBtn = new Button("Contesta saludando");
		Button salirBtn = new Button("Salir");
		// Añadir un evento al botón dice hola
		diceHolaBtn.setOnAction(e -> {
			String name = cajanombre.getText();
			if (name.trim().length() > 0) {
				msg.setText("Buenos días " + name);
			} else {
				msg.setText("Hola persona anónima");
			}
		});
		// Añadir un evento al botón salir
		salirBtn.setOnAction(e -> Platform.exit());
		// Crear el nodo raiz
		VBox root = new VBox();
		// establecer el espaciado vertical entre hijos a 5px
		root.setSpacing(5);
		// Añadir hijos al nodo raiz
		root.getChildren().addAll(nombre, cajanombre, msg, diceHolaBtn, salirBtn);
		Scene scene = new Scene(root, 350, 150);
		stage.setScene(scene);
		stage.setTitle("Aplicación Hello JavaFX mejorada");
		stage.show();
	}

}