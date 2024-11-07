package application;

import javafx.scene.control.TextArea;
import java.io.Serializable;
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
import javafx.stage.Stage;

public class Vista implements Serializable {

	private TextArea campoMensaje = new TextArea();
	private Button btnEnviar = new Button("Enviar mensaje");
	private ScrollPane s = new ScrollPane();
	private VBox fondo = new VBox();
	private Controlador c = new Controlador();
	private String id;
	
	public void start(Stage primaryStage) {

		fondo.setId("fondo" + id);
		campoMensaje.setPromptText("Escribe tu mensaje...");
		
		s.setContent(fondo);
		s.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		s.setFitToWidth(true);

        // Asegurar que el ScrollPane se desplace siempre hacia abajo
		fondo.heightProperty().addListener((observable, oldValue, newValue) ->
            
			actualizarScroll()
        	
        );
		
		
		HBox contenedorMensaje = new HBox();
		contenedorMensaje.getChildren().add(campoMensaje);
		contenedorMensaje.getChildren().add(btnEnviar);
		
		Image archivoIcon = new Image(getClass().getResourceAsStream("/aplication/images/fotoMenu.png"));
        ImageView archivoIconView = new ImageView(archivoIcon);
        archivoIconView.setFitWidth(20); // Ajustar el tama�o del �cono
        archivoIconView.setFitHeight(20); 
        
        Label nombre = new Label("Usuario " + id);
        Label campoEscribiendo = new Label("");
		
		
		VBox textoCabecera = new VBox();
		textoCabecera.getChildren().add(nombre);
		textoCabecera.getChildren().add(campoEscribiendo);
		
		HBox cabecera = new HBox();
		cabecera.getChildren().add(archivoIconView);
		cabecera.getChildren().add(textoCabecera);
		
		HBox root = new HBox();
		
		GridPane grid = new GridPane();
		
		grid.add(cabecera, 0, 0);
		grid.add(s, 0, 1);
		grid.add(contenedorMensaje, 0, 2);		

		btnEnviar.setOnAction(e -> {
			
			c.crearEtiqueta(campoMensaje.getText(), this.getId());
			campoMensaje.clear();
		
		});
		
		campoMensaje.addEventFilter(javafx.scene.input.KeyEvent.KEY_PRESSED, event -> {
            // Shift + Enter para hacer un salto de l�nea
            if (event.isShiftDown() && event.getCode() == javafx.scene.input.KeyCode.ENTER) {
            	campoMensaje.appendText("\n");
            	event.consume(); // Evita que se procese el Enter como env�o
            }
            // Enter sin Shift para enviar el mensaje
            else if (event.getCode() == javafx.scene.input.KeyCode.ENTER) {
                 // Llama a la funci�n de env�o
            	c.crearEtiqueta(campoMensaje.getText(), this.getId());
    			campoMensaje.clear(); // Limpia el TextArea despu�s de enviar
                event.consume(); // Evita el salto de l�nea
            }
        });
		
		Scene scene = new Scene(grid, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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

	public void crearEtiqueta (String texto, String id) {
		
		Label etiqueta = new Label(texto);
		etiqueta.setWrapText(true);
		etiqueta.setId(id);
		HBox hbox = new HBox();
		hbox.getChildren().add(etiqueta);
		
		hbox.setId("contenedor" + id);
		hbox.setMargin(etiqueta, new javafx.geometry.Insets(5, 5, 5, 5));
		fondo.getChildren().add(hbox);
		
	}
	
	private void actualizarScroll () {
		if(fondo.getChildren().size() >  5) {
			s.setVvalue(1.0);
		}
	}
	
}
