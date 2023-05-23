package com.dim.FX.Menu;
import java.io.File;
import java.io.File;
import java.net.URL;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
public class VideoMP4 {
public VideoMP4(Stage escenario) {
// Crear una nueva ventana modal
Stage escenariomodal = new Stage();
escenariomodal.initModality(Modality.APPLICATION_MODAL);
escenariomodal.initOwner(escenario);
escenariomodal.initStyle(StageStyle.UNDECORATED); // Ocultar los elementos de decoración de la ventana
escenariomodal.setTitle("Reproductor de video");
// Ruta del archivo de video
String videoFilePath ="recursos/Drone_Show.mp4";
// Crear el objeto Media con la ruta del archivo de video
Media media = new Media(new File(videoFilePath).toURI().toString());
//Create a Media Player
MediaPlayer player = new MediaPlayer(media);
//Automatically begin the playback
player.setAutoPlay(true);
//Create a 400X300 MediaView
MediaView mediaView = new MediaView(player);
mediaView.setFitWidth(400);
mediaView.setFitHeight(300);
//Create Play and Stop player control buttons and add action
//event handlers to them
Button playBtn = new Button("Play");
playBtn.setOnAction(e -> {
if (player.getStatus() == PLAYING) {
player.stop();
player.play();
} else {
player.play();
}
});
Button stopBtn = new Button("Stop");
stopBtn.setOnAction(e -> player.stop());
Button pauseBtn = new Button("Pause");
pauseBtn.setOnAction(e -> player.pause());
Button salir = new Button("Exit");
salir.setOnAction(e -> {player.stop(); escenariomodal.close();});
//Add an error handler
player.setOnError(() -> System.out.println(player.getError().getMessage()));
HBox controlBox = new HBox(5, playBtn, pauseBtn, stopBtn,salir);
BorderPane root = new BorderPane();
Label tit=new Label("Avista de vuelo de dron");
//Add the MediaView and player controls to the scene graph
root.setTop(tit);
root.setCenter(mediaView);
root.setBottom(controlBox);
Scene scene = new Scene(root);
escenariomodal.setScene(scene);
escenariomodal.setTitle("Playing Media");
escenariomodal.setTitle("Reproductor de video");
/*
// Acción para cerrar la ventana modal al hacer clic en el botón "Cerrar"
Button closeButton = (Button) modalContent.getChildren().get(1);
closeButton.setOnAction(e -> escenariomodal.close());
*/
// escenariomodal.setScene(new Scene(modalContent, 250, 150));
escenariomodal.showAndWait(); // Mostrar la ventana modal y esperar hasta que se cierre
}
}
