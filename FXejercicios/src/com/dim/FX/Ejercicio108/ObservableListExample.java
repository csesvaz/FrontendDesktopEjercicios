package com.dim.FX.Ejercicio108;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ObservableListExample {

    public static void main(String[] args) {

        ObservableList<String> observableList = FXCollections.observableArrayList();
    
        observableList.addListener((ListChangeListener<? super String>) change-> {

              while (change.next()) {
                if (change.wasAdded()) {
                    System.out.println("Se agregó un elemento: " + change.getAddedSubList().get(0));
                } else if (change.wasRemoved()) {
                    System.out.println("Se eliminó un elemento: " + change.getRemoved().get(0));
                } else if (change.wasUpdated()) {
                    System.out.println("Se actualizó un elemento");
                }
            }
        });

        observableList.add("Elemento 1");
        observableList.add("Elemento 2");
        observableList.set(1, "Elemento 33333");
        observableList.remove("Elemento 1");
    }
}