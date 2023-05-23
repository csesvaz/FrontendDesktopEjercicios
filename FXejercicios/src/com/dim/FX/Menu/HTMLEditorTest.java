package com.dim.FX.Menu;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;

public class HTMLEditorTest {
public HTMLEditorTest(Stage escenario) {
 // Crear una nueva ventana modal
 Stage escenariomodal = new Stage();
 escenariomodal.initModality(Modality.APPLICATION_MODAL);
 escenariomodal.initOwner(escenario);
 
 
 HTMLEditor editor = new HTMLEditor();
 editor.setPrefSize(600, 300);
 
 TextArea html = new TextArea();
 html.setPrefSize(600, 300);
 html.setStyle("-fx-font-size:10pt; -fx-font-family: \"Courier New\";");
 
 Button htmlToText = new Button("Convert HTML to Text");
 Button textToHtml = new Button("Convert Text to HTML");
 htmlToText.setOnAction(e -> editor.setHtmlText(html.getText()));
 textToHtml.setOnAction(e -> html.setText(editor.getHtmlText()));
 HBox buttons = new HBox(htmlToText, textToHtml);
 buttons.setSpacing(10);
 
 VBox root = new VBox(editor, buttons, html);
 root.setSpacing(10);
 root.setStyle("-fx-padding: 10;" + 
 "-fx-border-style: solid inside;" + 
 "-fx-border-width: 2;" +
 "-fx-border-insets: 5;" + 
 "-fx-border-radius: 5;" + 
 "-fx-border-color: blue;");
 
 Scene scene=new Scene(root);
 escenariomodal.setTitle("Editor HTML");
 escenariomodal.setScene(scene);
 escenariomodal.show();
 
 
 }
}