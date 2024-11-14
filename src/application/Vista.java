package application;

import javafx.scene.control.TextArea;
import java.io.Serializable;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Vista implements Serializable {

	private TextArea campoMensaje = new TextArea();
	private Button btnEnviar = new Button("Enviar mensaje");
	private ScrollPane s = new ScrollPane();
	private VBox fondo = new VBox();
	private Controlador c = new Controlador();
	public String id;
	private Label escribiendo;
	public Thread hilo;


	public void start(Stage primaryStage) {
		
	
		escribiendo = new Label("");

		fondo.getChildren().addAll();
		
		
		fondo.setId(id+"a");
		s.setMinHeight(300);
		fondo.setMinWidth(200);
		s.setMinWidth(200);
		s.setContent(fondo);
		s.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		
		campoMensaje.setMaxHeight(100);
		campoMensaje.setMaxWidth(100);
		
		HBox root = new HBox();
		
		GridPane grid = new GridPane();
		
		grid.add(s, 0, 0, 10,1);
		grid.add(campoMensaje, 0, 2);
		grid.add(btnEnviar, 0, 3);
		
		
		grid.add(escribiendo, 0, 1);

		btnEnviar.setOnAction(e -> {
			c.crearEtiqueta(getCampoMensaje().getText(),this.id);
		
		});
		
		campoMensaje.setOnKeyPressed(e->{
				c.escribiendo(this.id);
		});
		

		Scene scene = new Scene(grid, 400, 400);
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

	public void setCampoMensaje(TextArea campoMensaje) {
		this.campoMensaje = campoMensaje;
	}

	public Button getBtnEnviar() {
		return btnEnviar;
	}

	public void setBtnEnviar(Button btnEnviar) {
		this.btnEnviar = btnEnviar;
	}

	public ScrollPane getS() {
		return s;
	}

	public void setS(ScrollPane s) {
		this.s = s;
	}

	public VBox getFondo() {
		return fondo;
	}

	public void setFondo(VBox fondo) {
		this.fondo = fondo;
	}

	
	public void empezarEscribir() {
		if(hilo==null || !hilo.isAlive()) {
			hilo = new Thread(new Runnable() {
			    @Override
			    public void run() {
			        try {
			        	
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

	
	
	
	
	public void crearEtiqueta (Mensaje m) {
		
		Label etiqueta = new Label(m.getTexto());
		etiqueta.setId(m.getId());
		etiqueta.setWrapText(true);
		etiqueta.setTextAlignment(TextAlignment.RIGHT);
		etiqueta.setMaxWidth(150);
		//etiqueta.setPadding(new Insets(0,0,0,100));
		fondo.getChildren().add(etiqueta);		
	}
	
	
}
