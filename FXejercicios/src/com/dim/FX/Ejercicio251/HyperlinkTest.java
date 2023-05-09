package com.dim.FX.Ejercicio251;
// HyperlinkTest.java
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
public class HyperlinkTest extends Application {
private WebView webview;
public static void main(String[] args) {
Application.launch(args);
}
@Override
public void start(Stage stage) {
// Must create a WebView object from the JavaFX Application Thread
webview = new WebView(); 
// Create some hyperlinks
Hyperlink mdefensa = new Hyperlink("M.Defensa");
mdefensa.setOnAction(e -> loadPage("https://reclutamiento.defensa.gob.es/"));
Hyperlink gcivil = new Hyperlink("G.Civil");
gcivil.setOnAction(e -> loadPage("https://www.guardiacivil.es"));
Hyperlink googleLink = new Hyperlink("Google");
googleLink.setOnAction(e -> loadPage("http://www.google.com"));
HBox linkBox = new HBox(mdefensa, gcivil, googleLink);
linkBox.setSpacing(10);
linkBox.setAlignment(Pos.TOP_RIGHT);
BorderPane root = new BorderPane();
root.setTop(linkBox);
root.setCenter(webview);
Scene scene = new Scene(root);
stage.setScene(scene);
stage.setTitle("Using Hyperlink Controls");
stage.show();
}
public void loadPage(String url) {
webview.getEngine().load(url);
}
}