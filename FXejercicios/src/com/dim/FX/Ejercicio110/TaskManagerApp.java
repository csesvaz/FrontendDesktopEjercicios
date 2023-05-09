package com.dim.FX.Ejercicio110;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TaskManagerApp extends Application {
  
    public void start(Stage primaryStage) {
        TaskList taskList = new TaskList();
        taskList.add(new Task("Hacer la compra"));
        taskList.add(new Task("Limpiar la casa"));
        taskList.add(new Task("Preparar la cena"));

        TaskListView taskListView = new TaskListView(taskList);
        Scene scene = new Scene(taskListView, 400, 400);

        primaryStage.setTitle("Gestor de tareas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}