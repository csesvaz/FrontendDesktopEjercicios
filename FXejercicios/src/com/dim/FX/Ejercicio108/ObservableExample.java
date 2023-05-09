package com.dim.FX.Ejercicio108;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ObservableExample {

    public static void main(String[] args) {

        IntegerProperty integerProperty = new SimpleIntegerProperty(0);

        integerProperty.addListener((Observable observable) -> {
            System.out.println("La propiedad ha cambiado a: " + integerProperty.getValue());
        });

        integerProperty.set(1);
        integerProperty.set(2);
        integerProperty.set(3345);
    }
}
