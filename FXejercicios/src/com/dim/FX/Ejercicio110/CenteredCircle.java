package com.dim.FX.Ejercicio110;


//CenteredCircle.java


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CenteredCircle extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Circle c = new Circle(100, 100, 50);
	    c.setFill(Color.RED);
		Group root = new Group(c);
		Scene scene = new Scene(root, 100, 100);
  /* quitar el comentario para ver el efecto del binding
		*/	// Bind the centerX, centerY, and radius to the scene width and height
				c.centerXProperty().bind(scene.widthProperty().divide(2));
				c.centerYProperty().bind(scene.heightProperty().divide(2));
				c.radiusProperty().bind(Bindings.min(scene.widthProperty(),
				                                     scene.heightProperty())
				                                .divide(2));
	
		// Set the stage properties and make it visible
		stage.setTitle("Binding in JavaFX");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}
}