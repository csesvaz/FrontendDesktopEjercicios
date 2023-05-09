package com.dim.FX.Ejercicio105;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class FXLifeCycleApp extends Application {
	public FXLifeCycleApp() {
		String name = Thread.currentThread().getName();
		System.out.println("Paso por el Constructor de FXLifeCycleApp(): " +
		name);
	}
	public static void main(String[] args) {
	
		Application.launch(args);

	}
	
	public void init() {
		String name = Thread.currentThread().getName();
		System.out.println("Paso por el Método init(): " + name);
	}
	
	public void start(Stage stage) {
		String name = Thread.currentThread().getName();
		System.out.println("Paso por el Método start() : " + name);
		Scene scene = new Scene(new Group(), 200, 200);
		stage.setScene(scene);
		stage.setTitle("Ciclo de vida de una aplicación JavaFX ");
		stage.show();
	}
	
	public void stop() {
		String name = Thread.currentThread().getName();
		System.out.println("Paso por el Método stop(): " + name);
	}
}