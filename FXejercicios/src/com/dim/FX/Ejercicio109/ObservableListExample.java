package com.dim.FX.Ejercicio109;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ObservableListExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create an ObservableList of Strings
        ObservableList<String> items = FXCollections.observableArrayList("Apple", "Banana", "Orange");

        // Create a ListView to display the items
        ListView<String> listView = new ListView<>(items);

        // Add a new item to the list
        items.add("Grapes");

        // Create a StackPane to hold the ListView
        StackPane root = new StackPane(listView);

        // Create a Scene with the StackPane as the root node
        Scene scene = new Scene(root, 300, 250);

        // Set the title of the window and display it
        primaryStage.setTitle("ObservableList Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}