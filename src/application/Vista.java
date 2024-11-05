package application;

import javafx.scene.control.TextArea;
import java.io.Serializable;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vista implements Serializable {

	private TextArea campoMensaje = new TextArea();
	private Button btnEnviar = new Button("Enviar");
	private ScrollPane s = new ScrollPane();
	private VBox fondo = new VBox();
	
	public void start(Stage primaryStage) {

		s.setContent(fondo);
		s.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		campoMensaje.setMaxHeight(100);
		campoMensaje.setMaxWidth(100);
		
		HBox contenedorMensaje = new HBox();
		contenedorMensaje.getChildren().add(campoMensaje);
		contenedorMensaje.getChildren().add(btnEnviar);

		VBox contenedor = new VBox();
		contenedor.getChildren().add(s);
		contenedor.getChildren().add(contenedorMensaje);
		
		Scene scene = new Scene(contenedor, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

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

	/*
	 boton.setOnAction(e -> {
		 if(this.getId == 1){
		 	vista1 = this;
		 	vista2 = controlador.getVista2;
		 	crearEtiqueta(mensaje, id, vista1, vista2)
		 } else {
		 	vista1 = controlador.getVista1;
		 	vista2 = this
		 	crearEtiqueta(mensaje, id, vista1, vista2)
		 }
	 });
	 
	 public void crearEtiqueta(){
	 
	 }
	 
	 */
	
}
