package application;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Controlador {

	Vista vista1 = new Vista();
	Vista vista2 = new Vista();
	
	public void start(Stage stage) {
		
		Stage stage2 = new Stage();
		
		stage.setTitle("vista1");
		stage2.setTitle("vista2");
		
		vista1.start(stage);
		vista2.start(stage2);
		
		/*
		vista1.getCampoMensaje().setOnKeyPressed(e -> {
			if(e.isShiftDown() && e.getCode().equals(KeyCode.ENTER)) {
				vista1.getCampoMensaje().getText();

			} else if (e.getCode().equals(KeyCode.ENTER)) {
				crearEtiqueta(vista1.getCampoMensaje().getText());
			}
		});
		
		vista2.getCampoMensaje().setOnKeyPressed(e -> {
			if(e.getCode().equals(KeyCode.ENTER)) {
				crearEtiqueta(vista2.getCampoMensaje().getText());
			}
		});
		*/
		
		vista1.getBtnEnviar().setOnAction(e -> {
			crearEtiqueta(vista1.getCampoMensaje().getText());
		});
		
		vista2.getBtnEnviar().setOnAction(e -> {
			crearEtiqueta(vista2.getCampoMensaje().getText());
		});
		
	}
	
	public void crearEtiqueta (String mensaje) {
		
		Label etiqueta = new Label(mensaje);
		Label etiqueta2 = new Label(mensaje);
		vista1.getFondo().getChildren().add(etiqueta);
		vista2.getFondo().getChildren().add(etiqueta2);
		
	}
	
}
