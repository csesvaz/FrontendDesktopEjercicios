package com.dim.FX.Menu;

import java.util.Arrays;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TableViewAddDeleteRows {
private final TextField fNameField = new TextField();
private final TextField lNameField = new TextField();
private final DatePicker dobField = new DatePicker();
TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList());
@SuppressWarnings("unchecked")
public TableViewAddDeleteRows(Stage escenario) {
 // Crear una nueva ventana modal
 Stage escenariomodal = new Stage();
 escenariomodal.initModality(Modality.APPLICATION_MODAL);
 escenariomodal.initOwner(escenario);
 escenariomodal.setTitle("Ventana Modal");
 
 TableViewSelectionModel<Person> tsm = table.getSelectionModel();
tsm.setSelectionMode(SelectionMode.MULTIPLE);
// Add columns to the TableView
table.getColumns().addAll(PersonTableUtil.getIdColumn(), 
 PersonTableUtil.getFirstNameColumn(), 
 PersonTableUtil.getLastNameColumn(), 
 PersonTableUtil.getBirthDateColumn());
GridPane newDataPane = this.getNewPersonDataPane();
Button restoreBtn = new Button("Restore Rows");
restoreBtn.setOnAction(e -> restoreRows()); 
Button deleteBtn = new Button("Delete Selected Rows");
deleteBtn.setOnAction(e -> deleteSelectedRows()); 
VBox root = new VBox(newDataPane, new HBox(restoreBtn, deleteBtn), table);
root.setSpacing(5);
root.setStyle("-fx-padding: 10;" + 
 "-fx-border-style: solid inside;" + 
 "-fx-border-width: 2;" +
 "-fx-border-insets: 5;" + 
 "-fx-border-radius: 5;" + 
 "-fx-border-color: blue;");
Scene scene = new Scene(root);
escenariomodal.setTitle("Añadir y borrar filas");
 escenariomodal.setScene(scene);
 escenariomodal.show();
 
}
public GridPane getNewPersonDataPane() {
GridPane pane = new GridPane();
pane.setHgap(10);
pane.setVgap(5);
pane.addRow(0, new Label("First Name:"), fNameField);
pane.addRow(1, new Label("Last Name:"), lNameField);
pane.addRow(2, new Label("Birth Date:"), dobField);
Button addBtn = new Button("Add");
addBtn.setOnAction(e -> addPerson());
// Add the "Add" button
pane.add(addBtn, 2, 0);
return pane;
}
public void deleteSelectedRows() {
TableViewSelectionModel<Person> tsm = table.getSelectionModel();
if (tsm.isEmpty()) {
System.out.println("Seleccione la fila a borrar.");
return;
}
// Get all selected row indices in an array
ObservableList<Integer> list = tsm.getSelectedIndices();
Integer[] selectedIndices = new Integer[list.size()];
selectedIndices = list.toArray(selectedIndices);
// Sort the array
Arrays.sort(selectedIndices);
//Delete rows (last to first)
for(int i = selectedIndices.length - 1; i >= 0; i--) {
tsm.clearSelection(selectedIndices[i].intValue());
table.getItems().remove(selectedIndices[i].intValue());
}
}
public void restoreRows() {
table.getItems().clear();
table.getItems().addAll(PersonTableUtil.getPersonList());
}
public Person getPerson() {
return new Person(fNameField.getText(), 
lNameField.getText(), 
dobField.getValue());
}
public void addPerson() {
Person p = getPerson();
table.getItems().add(p);
clearFields();
}
public void clearFields() {
fNameField.setText(null);
lNameField.setText(null);
dobField.setValue(null);
}
}


