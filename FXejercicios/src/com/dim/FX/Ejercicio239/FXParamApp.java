package com.dim.FX.Ejercicio239;

import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
public class FXParamApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public void start(Stage stage) {
		// toma los parámetros parameters
		Parameters p = this.getParameters();
		Map<String, String> namedParams = p.getNamed();
		List<String> unnamedParams = p.getUnnamed();
		List<String> rawParams = p.getRaw();
		String paramStr = "Parámetros con nombre: " + namedParams +
		"\n" +
		"Parámetros sin nombres: " + unnamedParams + "\n" +
		"Parámetros sin procesar: " + rawParams;
		TextArea ta = new TextArea(paramStr);
		Group root = new Group(ta);
		stage.setScene(new Scene(root));
		stage.setTitle("Parámetros de una aplicación JavaFX");
		stage.show();
	}
}