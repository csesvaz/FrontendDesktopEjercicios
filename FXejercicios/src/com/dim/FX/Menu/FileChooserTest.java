package com.dim.FX.Menu;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import static javafx.stage.FileChooser.ExtensionFilter;

public class FileChooserTest {
private Stage primaryStage;
private HTMLEditor resumeEditor;
private final FileChooser fileDialog = new FileChooser();
public FileChooserTest(Stage escenario) {
 // Crear una nueva ventana modal
 Stage escenariomodal = new Stage();
 escenariomodal.initModality(Modality.APPLICATION_MODAL);
 escenariomodal.initOwner(escenario);
 escenariomodal.setTitle("Ventana Modal");
 primaryStage = escenariomodal; // Used in file dialogs later
resumeEditor = new HTMLEditor();
resumeEditor.setPrefSize(600, 300);
fileDialog.getExtensionFilters()
 .add(new ExtensionFilter("HTML Files", "*.htm", "*.html"));
Button openBtn = new Button("Open");
Button saveBtn = new Button("Save");
Button closeBtn = new Button("Close");
openBtn.setOnAction(e -> openFile());
saveBtn.setOnAction(e -> saveFile());
closeBtn.setOnAction(e -> escenariomodal.close());
HBox buttons = new HBox(20, openBtn, saveBtn, closeBtn);
buttons.setAlignment(Pos.CENTER_RIGHT);
VBox root = new VBox(resumeEditor, buttons);
root.setSpacing(20);
root.setStyle("-fx-padding: 10;" + 
 "-fx-border-style: solid inside;" + 
 "-fx-border-width: 2;" +
 "-fx-border-insets: 5;" + 
 "-fx-border-radius: 5;" + 
 "-fx-border-color: blue;");
Scene scene=new Scene(root, 350, 250);
escenariomodal.setTitle("Ventana Modal");
escenariomodal.setScene(scene);
escenariomodal.show();


}
private void openFile() {
	fileDialog.setTitle("Open Resume");
	File file = fileDialog.showOpenDialog(primaryStage);
	if (file == null) {
	return;
	}
	try {
	byte[] resume = Files.readAllBytes(file.toPath());
	resumeEditor.setHtmlText(new String(resume));
	}
	catch(IOException e) {
	e.printStackTrace();
	}
	}
	private void saveFile() {
	fileDialog.setTitle("Save Resume");
	fileDialog.setInitialFileName("untitled.htm");
	File file = fileDialog.showSaveDialog(primaryStage);
	if (file == null) {
	return;
	}
	try {
	String html = resumeEditor.getHtmlText();
	Files.write(file.toPath(), html.getBytes()); 
	}
	catch(IOException e) {
	e.printStackTrace();
	}
	}
	}

