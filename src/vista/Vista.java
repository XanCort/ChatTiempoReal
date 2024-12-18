package vista;

import javafx.scene.control.TextArea;
import java.io.Serializable;

import controlador.Controlador;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import modelo.Mensaje;

public class Vista implements Serializable {

	private TextArea campoMensaje = new TextArea();
	private Button btnEnviar = new Button("Enviar");
	private ScrollPane s = new ScrollPane();
	private VBox fondo = new VBox();
	private Controlador c = new Controlador();
	public String id;
	private Label escribiendo;
	public Thread hilo;


	public void start(Stage primaryStage) {
		
	
		escribiendo = new Label("");

		//Establece la imagen de usuario en funcion de la id de la ventana
		Image imagen = new Image(getClass().getResourceAsStream("images/ic_usuario_"+id+".png"));
		ImageView imagenView = new ImageView(imagen);
		
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
		
        
        Label nombre = new Label("Usuario " + id);
        Label campoEscribiendo = new Label("");
		
		
		VBox textoCabecera = new VBox();
		textoCabecera.getChildren().add(nombre);
		textoCabecera.getChildren().add(campoEscribiendo);
		
		HBox cabecera = new HBox();
		cabecera.getChildren().add(textoCabecera);
		
		HBox root = new HBox();
		
		GridPane grid = new GridPane();
		
		grid.add(imagenView, 0, 0);
		
		grid.add(cabecera, 1, 0);
		grid.add(s, 0, 1,2,1);
		grid.add(contenedorMensaje, 0, 2,2,1);	
		
		
		grid.add(escribiendo, 1, 0);

		//El boton enviar
		btnEnviar.setOnAction(e -> {
			c.crearEtiqueta(getCampoMensaje().getText(),this.id);
			c.cancelarEscribiendo(this.id);
		
		});
		
		campoMensaje.setOnKeyPressed(e->{
				c.escribiendo(this.id);
		});
		
		
		
		
		Scene scene = new Scene(grid, 300, 350);
		grid.setId("grid");
		scene.setFill(Color.rgb(255, 249, 238));
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		
		primaryStage.show();

	}

	public Controlador getC() {
		return c;
	}

	public void setC(Controlador c) {
		this.c = c;
	}

	public TextArea getCampoMensaje() {
		return campoMensaje;
	}


	//Se crea el hilo para mostrar el mensaje de "Escribiendo"
	public void empezarEscribir() {
		if(hilo==null || !hilo.isAlive()) {
			
			hilo = new Thread(new Runnable() {
			    @Override
			    public void run() {
			        try {
			        	escribiendo.setVisible(true);
			            Platform.runLater(() -> escribiendo.setText("Escribiendo"));
			            Thread.sleep(1000);
			            Platform.runLater(() -> escribiendo.setText("Escribiendo."));
			            Thread.sleep(1000);
			            Platform.runLater(() -> escribiendo.setText("Escribiendo.."));
			            Thread.sleep(1000);
			            Platform.runLater(() -> escribiendo.setText("Escribiendo..."));
			            Thread.sleep(1000);
			            Platform.runLater(() -> escribiendo.setText(""));
			        } catch (InterruptedException exception) {
			            exception.printStackTrace();
			        }
			    }
			});
			hilo.start();
		}
		}

	
	
	
	
	//Método para crear y añadir mensajes al "chat"
	public void crearEtiqueta (Mensaje m) {
		
		Label etiqueta = new Label(m.getTexto());
		etiqueta.setWrapText(true);
		etiqueta.setId(m.getId());
		HBox hbox = new HBox();
		hbox.getChildren().add(etiqueta);
		
		//Se establece la id para poder poner css distinto en funcion de quien haya mandado el mensaje
		hbox.setId("contenedor" + m.getId());
		hbox.setMargin(etiqueta, new javafx.geometry.Insets(5, 5, 5, 5));
		fondo.getChildren().add(hbox);	
	}
	
	private void actualizarScroll () {
		if(fondo.getChildren().size() >  5) {
			s.setVvalue(1.0);
		}
	}
	//Corta el mensaje de escribiendo en caso de que se envie el mensaje
	public void acabarHilo(){
		if(hilo!=null && hilo.isAlive()) {
			hilo.interrupt();
			escribiendo.setVisible(false);
		}
		
	}
	
	
	public void borrarEtiqueta(HBox contenedor) {
		fondo.getChildren().remove(contenedor);
	}
	
	
	
	
}
