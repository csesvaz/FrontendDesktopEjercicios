package com.dim.FX.Ejercicio110;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ObservableListApplication extends Application {

    int cuenta=200;
    public void start(Stage primaryStage) {
        // Creamos una lista observable de Strings
        ObservableList<String> items = FXCollections.observableArrayList(
                "Item inicial 1", "Item inicial 2", "Item inicial 3");

        // Creamos una ListView y la vinculamos con la lista observable
        ListView<String> listView = new ListView<>(items);

        // Creamos un botón que agrega un nuevo elemento a la lista observable
        Button addButton = new Button("Agregar Item");
        addButton.setOnAction(e -> items.add("Nuevo Item" + (++cuenta)));

        // Creamos un VBox que contiene la ListView y el botón
        VBox root = new VBox(listView, addButton);

        // Creamos una escena y la establecemos en la ventana principal
        Scene scene = new Scene(root, 250, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}