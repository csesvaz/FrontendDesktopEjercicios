package com.dim.FX.Ejercicio107;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjemploBinding extends Application {
    
    public void start(Stage primaryStage) {
        
        // Creamos un objeto IntegerProperty con valor inicial de cero
        IntegerProperty contador = new SimpleIntegerProperty(0);
        
        // Creamos dos botones
        Button boton1 = new Button("Botón 1. Pulsa cinco veces");
        Button boton2 = new Button("Botón 2. Se desactivará");
        
        // Establecemos el binding de la propiedad "disable" del botón2
        boton2.disableProperty().bind(Bindings.greaterThanOrEqual(contador, 5));
        
        // Creamos un evento para el botón1 que incrementa el valor del contador
        boton1.setOnAction(event -> contador.set(contador.get() + 1));
        
        // Creamos un layout VBox y agregamos los botones
        VBox root = new VBox(10, boton1, boton2);
        root.setPadding(new Insets(10));
        
        // Creamos la escena y la mostramos
        Scene scene = new Scene(root, 200, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ejemplo Binding");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}