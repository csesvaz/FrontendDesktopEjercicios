package com.dim.FX.Menu;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class TabTest {
	@SuppressWarnings("unchecked")
	public TabTest(Stage escenario) {
		// Crear una nueva ventana modal
		Stage escenariomodal = new Stage();
		escenariomodal.initModality(Modality.APPLICATION_MODAL);
		escenariomodal.initOwner(escenario);

		GeneralTab generalTab = new GeneralTab("General");
		AddressTab addressTab = new AddressTab("Address");
		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(generalTab, addressTab);
		BorderPane root = new BorderPane();
		root.setCenter(tabPane);
		root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		Scene scene = new Scene(root);
		escenariomodal.setTitle("Menu de Solapas");
		escenariomodal.setScene(scene);
		escenariomodal.show();
	}
}