package application;

import javafx.scene.control.TextArea;
import java.io.Serializable;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
	private Vista vistaGemela;
	
	
	


	public void start(Stage primaryStage) {

	

		Label etiqueta = new Label("Hola qiue tal");
		Label etiqueta1 = new Label("Hola que tal");
		Label etiqueta2 = new Label("Hola que tal");
		Label etiqueta3 = new Label("Hola que tal");
		Label etiqueta4 = new Label("Hola que tal");
		Label etiqueta5 = new Label("Hola que tal");
		Label etiqueta6 = new Label("Hola que tal");
		Label etiqueta7 = new Label("Hola que tal");
		Label etiqueta8 = new Label("Hola que tal");
		Label etiqueta9 = new Label("Hola que tal");
		Label etiqueta10 = new Label("Hola que tal");
		Label etiqueta11 = new Label("Hola que tal");
		Label etiqueta12 = new Label("Hola que tal");

		fondo.getChildren().addAll(etiqueta, etiqueta1, etiqueta2, etiqueta3, etiqueta4, etiqueta5, etiqueta6,
				etiqueta7, etiqueta8, etiqueta9, etiqueta10, etiqueta11, etiqueta12);

		s.setContent(fondo);
		s.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		
		campoMensaje.setMaxHeight(100);
		campoMensaje.setMaxWidth(100);
		
		HBox root = new HBox();
		
		GridPane grid = new GridPane();
		
		grid.add(s, 0, 0, 10,1);
		grid.add(campoMensaje, 0, 1);
		grid.add(btnEnviar, 0, 2);
		

		btnEnviar.setOnAction(e -> {
			
	
//			crearEtiqueta(vista1.getCampoMensaje().getText(),"uno");
			
		});
		//root.getChildren().add(s);
		//root.getChildren().add(campoMensaje);
		//root.getChildren().add(btnEnviar);

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

	public Vista getVistaGemela() {
		return vistaGemela;
	}

	public void setVistaGemela(Vista vistaGemela) {
		this.vistaGemela = vistaGemela;
	}
	
	
	
	public void crearEtiqueta (String id, Vista vista1, Vista vista2) {
		
		
		
		
		/*
		Label etiqueta = new Label(vista1.getCampoMensaje().getText());
		Label etiqueta2 = new Label(vista1.getCampoMensaje().getText());
		etiqueta.setId(id);
		etiqueta2.setId(id);
		vista1.getFondo().getChildren().add(etiqueta);
		vista2.getFondo().getChildren().add(etiqueta2);
		
		vista1.getCampoMensaje().clear();
		vista2.getCampoMensaje().clear();
		*/
		
	}
	
	
}
