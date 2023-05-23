package com.dim.FX.Menu;

import java.io.File;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class AudioTactica {
	public AudioTactica(Stage escenario) {
		// Crear una nueva ventana modal
		Stage escenariomodal = new Stage();
		escenariomodal.initModality(Modality.APPLICATION_MODAL);
		escenariomodal.initOwner(escenario);
		escenariomodal.setTitle("Ventana Modal");
		String audioFilePath = "recursos/besson2.mp3";
		Media media = new Media(new File(audioFilePath).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		Button playButton = new Button("Play");
		playButton.setOnAction(event -> {
			// Verificar el estado actual del reproductor
			if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
				mediaPlayer.stop();
				mediaPlayer.play();
			} else {
				mediaPlayer.play();
			}
		});
		Button stopBtn = new Button("Stop");
		stopBtn.setOnAction(e -> mediaPlayer.stop());
		Button pauseBtn = new Button("Pause");
		pauseBtn.setOnAction(e -> mediaPlayer.pause());
		Button salir = new Button("Exit");
		salir.setOnAction(e -> {
			mediaPlayer.stop();
			escenariomodal.close();
		});
		String imagenFile = "recursos/besson2.jpg";
		Image image31 = new Image(new File(imagenFile).toURI().toString());
		ImageView imageView31 = new ImageView(image31);

		HBox controlBox = new HBox(5, playButton, pauseBtn, stopBtn, salir);
		BorderPane root = new BorderPane();
		Label tit = new Label("COMINT. Conversaciones entre buques");
		root.setTop(tit);
		root.setCenter(imageView31);
		root.setBottom(controlBox);
		escenariomodal.setScene(new Scene(root));
		escenariomodal.show();

	}
}