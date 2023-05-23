package com.dim.FX.Menu;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;




public class TableViewListado {
@SuppressWarnings("unchecked")
public TableViewListado(Stage escenario) {
 // Crear una nueva ventana modal
 Stage escenariomodal = new Stage();
 escenariomodal.initModality(Modality.APPLICATION_MODAL);
 escenariomodal.initOwner(escenario);
 escenariomodal.setTitle("Ventana Modal");
 TableColumn<Person, String> ageCol = new TableColumn<>("Age");
 ageCol.setCellValueFactory(cellData -> {
 Person p = cellData.getValue();
 LocalDate dob = p.getBirthDate();
 String ageInYear = "Unknown";
 if (dob != null) {
 long years = YEARS.between(dob, LocalDate.now());
 if (years == 0) {
 ageInYear = "< 1 year";
 } else if (years == 1) {
 ageInYear = years + " year";
 } else {
 ageInYear = years + " years";
 }
 }
 return new ReadOnlyStringWrapper(ageInYear);
 });
 
 TableColumn<Person, Person.AgeCategory> ageCategoryCol = 
 new TableColumn<>("Age Category");
 ageCategoryCol.setCellValueFactory(
 new PropertyValueFactory<>("ageCategory"));
 
 
 
 TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList());
 table.setTableMenuButtonVisible(true);
 table.getColumns().addAll(PersonTableUtil.getIdColumn(), 
 PersonTableUtil.getFirstNameColumn(),
 PersonTableUtil.getLastNameColumn(), 
 PersonTableUtil.getBirthDateColumn(),
 ageCol,
 ageCategoryCol);
 
VBox root = new VBox(table);
root.setStyle("-fx-padding: 10;" + 
 "-fx-border-style: solid inside;" + 
 "-fx-border-width: 2;" +
 "-fx-border-insets: 5;" + 
 "-fx-border-radius: 5;" + 
 "-fx-border-color: blue;");
Scene scene = new Scene(root);
escenariomodal.setTitle("Contenido de una TableView");
 escenariomodal.setScene(scene);
 escenariomodal.show();
 
}
}
