package application.carballeira.view;

import application.carballeira.controller.Controlador;

import javafx.scene.control.TextArea;
import java.io.Serializable;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Vista implements Serializable {

	private TextArea campoMensaje = new TextArea();
	private Button btnEnviar = new Button("Enviar");
	private ScrollPane s = new ScrollPane();
	private VBox fondo = new VBox();
	private Controlador c = new Controlador();
	private String id;
	public Thread hilo;
	Label campoEscribiendo = new Label("");
	
	Text text1 = new Text(".");
    Text text2 = new Text(".");
    Text text3 = new Text(".");
    
 // Combinar los textos en un TextFlow
    TextFlow textFlow = new TextFlow(text1, text2, text3);
    
	Label etiquetaEscribiendo = new Label();
	HBox cajaMensaje = new HBox();
	
	public void start(Stage primaryStage) {

		Image imagen = new Image(getClass().getResourceAsStream("/application/carballeira/images/ic_usuario_"+id+".png"));
		ImageView imagenView = new ImageView(imagen);
		imagenView.setFitWidth(35);
		imagenView.setFitHeight(35);
		
     // Combinar los textos en un TextFlow
        etiquetaEscribiendo.setGraphic(textFlow);
        etiquetaEscribiendo.setId("etiquetaEscribiendo" + id);

		fondo.setId("fondo" + id);
		campoMensaje.setPromptText("Escribe tu mensaje...");

		s.setContent(fondo);
		s.setVbarPolicy(ScrollBarPolicy.NEVER);
		s.setFitToWidth(true);

		// Asegurar que el ScrollPane se desplace siempre hacia abajo
		fondo.heightProperty().addListener((observable, oldValue, newValue) ->

			actualizarScroll()

		);

		HBox contenedorMensaje = new HBox();
		contenedorMensaje.getChildren().add(campoMensaje);
		contenedorMensaje.getChildren().add(btnEnviar);

		Label nombre = new Label("Usuario " + id);

		VBox textoCabecera = new VBox();
		textoCabecera.getChildren().add(nombre);
		textoCabecera.getChildren().add(campoEscribiendo);

		HBox cabecera = new HBox();
		cabecera.getChildren().add(imagenView);
		cabecera.getChildren().add(textoCabecera);

		HBox root = new HBox();

		VBox contenedor = new VBox();
		
		contenedor.getChildren().addAll(cabecera, s, contenedorMensaje);

		btnEnviar.setOnAction(e -> {

			
			c.crearEtiqueta(campoMensaje.getText(), this.getId());
			campoMensaje.clear();
			
			
		});

		campoMensaje.setOnKeyPressed(e -> {
			c.escribiendo(this.id);
		});

		campoMensaje.addEventFilter(javafx.scene.input.KeyEvent.KEY_PRESSED, event -> {
			// Shift + Enter para hacer un salto de línea
			if (event.isShiftDown() && event.getCode() == javafx.scene.input.KeyCode.ENTER) {
				campoMensaje.appendText("\n");
				event.consume(); // Evita que se procese el Enter como envío
			}
			// Enter sin Shift para enviar el mensaje
			else if (event.getCode() == javafx.scene.input.KeyCode.ENTER) {
				// Llama a la función de envío
				c.crearEtiqueta(campoMensaje.getText(), this.getId());
				campoMensaje.clear(); // Limpia el TextArea después de enviar
				event.consume(); // Evita el salto de línea
			}
		});

		Scene scene = new Scene(contenedor, 400, 400);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("vista " + id);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public Controlador getC() {
		return c;
	}

	public void setC(Controlador c) {
		this.c = c;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void empezarEscribir() {
		
		if (hilo == null || !hilo.isAlive()) {
			
			etiquetaEscribiendo.setWrapText(true);
			//etiquetaEscribiendo.setId(id);
			
			cajaMensaje.getChildren().add(etiquetaEscribiendo);
			cajaMensaje.setId("contenedorEscribiendo");
			cajaMensaje.setMargin(etiquetaEscribiendo, new javafx.geometry.Insets(5, 5, 5, 5));
			fondo.getChildren().add(cajaMensaje);
			
			System.out.println("enta aqui");
			hilo = new Thread(new Runnable() {
				@Override
				public void run() {
					try {

						Platform.runLater(() -> {
							campoEscribiendo.setText("Escribiendo");
							text1.setId("puntoOscuro");
							text2.setId("puntoClaro");
							text3.setId("puntoClaro");
						});
						Thread.sleep(500);
						Platform.runLater(() -> campoEscribiendo.setText("Escribiendo."));
						Thread.sleep(500);
						Platform.runLater(() -> {
							campoEscribiendo.setText("Escribiendo..");
							text1.setId("puntoClaro");
							text2.setId("puntoOscuro");
							text3.setId("puntoClaro");
						});
						Thread.sleep(500);
						Platform.runLater(() -> campoEscribiendo.setText("Escribiendo..."));
						Thread.sleep(500);
						Platform.runLater(() -> {
							campoEscribiendo.setText("");
							text1.setId("puntoClaro");
							text2.setId("puntoClaro");
							text3.setId("puntoOscuro");
						});
						Thread.sleep(500);
						
						Platform.runLater(() -> cajaMensaje.getChildren().remove(etiquetaEscribiendo));
						Platform.runLater(() -> borrarEtiqueta(cajaMensaje));
						
					} catch (InterruptedException exception) {
						exception.printStackTrace();
					}
				}
			});
			
			hilo.start();
		}
	}
	
	
	public void borrarEtiqueta(HBox etiqueta) {
		fondo.getChildren().remove(etiqueta);
	}
	
	public void crearEtiqueta(String texto, String id) {

		Label etiqueta = new Label (texto);
		etiqueta.setText(texto);
		etiqueta.setWrapText(true);
		etiqueta.setId(id);
		HBox hbox = new HBox();
		hbox.getChildren().add(etiqueta);

		hbox.setId("contenedor" + id);
		hbox.setMargin(etiqueta, new javafx.geometry.Insets(5, 5, 5, 5));
		fondo.getChildren().add(hbox);

	}

	private void actualizarScroll() {
		if (fondo.getChildren().size() > 5) {
			s.setVvalue(1.0);
		}
	}

}