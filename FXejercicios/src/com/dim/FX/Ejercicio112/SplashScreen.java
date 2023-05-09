package com.dim.FX.Ejercicio112;

//splash
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SplashScreen extends Application {
    private static final int SPLASH_WIDTH = 200;
    private static final int SPLASH_HEIGHT = 400;
    private static final String SPLASH_IMAGE = "https://via.placeholder.com/500x400.png?text=Splash+Image";
    private static final String APP_TITLE = "My Application";

    @Override
    public void start(final Stage primaryStage) {
        // Create the splash screen layout
        final ImageView splashImageView = new ImageView(new Image(SPLASH_IMAGE));
        final Label loadingLabel = new Label("Loading...");
        final VBox splashLayout = new VBox();
        splashLayout.getChildren().addAll(splashImageView, loadingLabel);

        // Create the splash screen stage
        final Scene splashScene = new Scene(splashLayout, SPLASH_WIDTH, SPLASH_HEIGHT);
        final Stage splashStage = new Stage(StageStyle.UNDECORATED);
        splashStage.setScene(splashScene);
        splashStage.show();

        // Load the main application
        Platform.runLater(() -> {
            final BorderPane root = new BorderPane();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle(APP_TITLE);
            primaryStage.show();

            // Close the splash screen stage
            splashStage.close();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}