package com.dim.FX.Menu;

import javafx.application.Platform;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXApp extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage escenario) {
		escenario.setTitle("Menú demostrativo con JavaFX");
		Menu menu0 = new Menu("Ficheros");
		MenuItem menuItem01 = new MenuItem("Menú solapas");
		menuItem01.setOnAction(actionEvent -> new TabTest(escenario));

		MenuItem menuItem02 = new MenuItem("Editor HTML");
		menuItem02.setOnAction(actionEvent -> new HTMLEditorTest(escenario));

		MenuItem menuItem03 = new MenuItem("Selección de un fichero");
		menuItem03.setOnAction(actionEvent -> new FileChooserTest(escenario));

		MenuItem menuItem05 = new MenuItem("genérico");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		menuItem05.setOnAction(actionEvent -> new Generico(escenario));

		MenuItem salir = new MenuItem("Salir");
		salir.setOnAction(actionEvent -> Platform.exit());

		menu0.getItems().add(menuItem01);
		menu0.getItems().add(menuItem02);
		menu0.getItems().add(menuItem03);

		menu0.getItems().add(menuItem05);
		menu0.getItems().add(separator);
		menu0.getItems().add(salir);

		Menu menu1 = new Menu("Multimedia");
		MenuItem menuItem11 = new MenuItem("Audio");
		MenuItem menuItem12 = new MenuItem("Video");

		menuItem11.setOnAction(actionEvent -> new AudioTactica(escenario));
		menuItem12.setOnAction(actionEvent -> new VideoMP4(escenario));

		menu1.getItems().add(menuItem11);
		menu1.getItems().add(menuItem12);

		Menu menu2 = new Menu("Efectos");
		MenuItem menuItem21 = new MenuItem("Arrastrar y soltar");
		menuItem21.setOnAction(actionEvent -> new CustomDataTransfer(escenario));

		MenuItem menuItem22 = new MenuItem("Efecto Fading");
		menuItem22.setOnAction(actionEvent -> new FadingTest(escenario));

		MenuItem menuItem23 = new MenuItem("Deslizador selector");
		menuItem23.setOnAction(actionEvent -> new SliderTest(escenario));

		MenuItem menuItem24 = new MenuItem("Selector de color");
		menuItem24.setOnAction(actionEvent -> new ColorPickerTest(escenario));

		menu2.getItems().add(menuItem21);
		menu2.getItems().add(menuItem22);
		menu2.getItems().add(menuItem23);
		menu2.getItems().add(menuItem24);

		SeparatorMenuItem separator2 = new SeparatorMenuItem();
		menu2.getItems().add(separator2);
		Menu menu3 = new Menu("Tablas");
		MenuItem menuItem31 = new MenuItem("Listado");
		Image image31 = new Image(getClass().getResourceAsStream("images/icons8-dataencryption-16.png"));
		ImageView imageView31 = new ImageView(image31);
		menuItem31.setGraphic(imageView31);
		menuItem31.setOnAction(actionEvent -> new TableViewListado(escenario));
		menu3.getItems().add(menuItem31);

		MenuItem menuItem32 = new MenuItem("Edición de fechas");
		Image image32 = new Image(getClass().getResourceAsStream("images/icons8-data-backup16.png"));
		ImageView imageView32 = new ImageView(image32);
		menuItem32.setGraphic(imageView32);
		menuItem32.setOnAction(actionEvent -> new CustomTableCellTest(escenario));
		menu3.getItems().add(menuItem32);

		MenuItem menuItem33 = new MenuItem("Añadir y borrar columnass");
		Image image33 = new Image(getClass().getResourceAsStream("images/icons8-data-backup16.png"));
		ImageView imageView33 = new ImageView(image33);
		menuItem33.setGraphic(imageView33);
		menuItem33.setOnAction(actionEvent -> new TableViewAddDeleteRows(escenario));
		menu3.getItems().add(menuItem33);

		Menu menu4 = new Menu("Gráficos de datos");
		MenuItem menuItem41 = new MenuItem("Pastel (sector)");
		Image image41 = new Image(getClass().getResourceAsStream("images/icons8-pie-chart16.png"));
		ImageView imageView41 = new ImageView(image41);
		menuItem41.setGraphic(imageView41);
		menuItem41.setOnAction(actionEvent -> new PieChartTest(escenario));
		menu4.getItems().add(menuItem41);

		MenuItem menuItem45 = new MenuItem("Gráfico de puntos");
		Image image45 = new Image(getClass().getResourceAsStream("images/icons8-scatterplot-16.png"));
		ImageView imageView45 = new ImageView(image45);
		menuItem45.setGraphic(imageView45);
		menuItem45.setOnAction(actionEvent -> new ScatterChartTest(escenario));
		menu4.getItems().add(menuItem45);

		MenuItem menuItem46 = new MenuItem("Gráfico de líneas");
		Image image46 = new Image(getClass().getResourceAsStream("images/icons8-line-chart16.png"));
		ImageView imageView46 = new ImageView(image46);
		menuItem46.setGraphic(imageView46);
		menuItem46.setOnAction(actionEvent -> new LineChartTest(escenario));
		menu4.getItems().add(menuItem46);

		MenuItem menuItem47 = new MenuItem("Gráfico de burbujas");
		Image image47 = new Image(getClass().getResourceAsStream("images/icons8-blockchaintechnology-16.png"));
		ImageView imageView47 = new ImageView(image47);
		menuItem47.setGraphic(imageView47);
		menuItem47.setOnAction(actionEvent -> new BubbleChartTest(escenario));
		menu4.getItems().add(menuItem47);

		MenuItem menuItem48 = new MenuItem("Gráfico de áreas");
		Image image48 = new Image(getClass().getResourceAsStream("images/icons8-area-chart16.png"));
		ImageView imageView48 = new ImageView(image48);
		menuItem48.setGraphic(imageView48);
		menuItem48.setOnAction(actionEvent -> new AreaChartTest(escenario));
		menu4.getItems().add(menuItem48);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(menu0);
		menuBar.getMenus().add(menu1);
		menuBar.getMenus().add(menu2);
		menuBar.getMenus().add(menu3);
		menuBar.getMenus().add(menu4);
		// menuBar.getMenus().add(menu5);

		VBox vBox = new VBox(menuBar);
		Scene scene = new Scene(vBox, 960, 600);
		escenario.setScene(scene);
		escenario.show();
	}

}
