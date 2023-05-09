package com.dim.FX.Ejercicio110;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.collections.FXCollections;

public class TaskList extends ObservableListBase<Task> {
    private ObservableList<Task> tasks = FXCollections.observableArrayList();


    public Task get(int index) {
        return tasks.get(index);
    }

  
    public int size() {
        return tasks.size();
    }


    protected void doAdd(int index, Task element) {
        tasks.add(index, element);
    }

    
    protected Task doSet(int index, Task element) {
        return tasks.set(index, element);
    }

 
    protected Task doRemove(int index) {
        return tasks.remove(index);
    }
}