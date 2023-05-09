package com.dim.FX.Ejercicio110;
import javafx.scene.control.ListView;

public class TaskListView extends ListView<Task> {
    private TaskList taskList;

    public TaskListView(TaskList taskList) {
        this.taskList = taskList;
        setItems(taskList);
    }
}