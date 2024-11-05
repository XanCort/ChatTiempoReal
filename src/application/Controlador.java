package application;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Controlador {

	private Vista vista1 ;
	private Vista vista2 ;
	
	public Controlador() {
		this.vista1=vista1;
		this.vista2=vista2;
	}
	
//	public void start(Stage stage) {
//		
//		Stage stage2 = new Stage();
//		
//		stage.setTitle("vista1");
//		stage2.setTitle("vista2");
//		
//		vista1.start(stage,this);
//		vista2.start(stage2,this);
//		
//		vista1.getCampoMensaje().setOnKeyPressed(e -> {
//			if(e.isShiftDown() && e.getCode().equals(KeyCode.ENTER)) {
//				vista1.getCampoMensaje().getText();
//
//			} else if (e.getCode().equals(KeyCode.ENTER)) {
//				//crearEtiqueta(vista1.getCampoMensaje().getText(),1);
//			}
//		});
//		
//		vista2.getCampoMensaje().setOnKeyPressed(e -> {
//			if(e.getCode().equals(KeyCode.ENTER)) {
//				//crearEtiqueta(vista2.getCampoMensaje().getText(),2);
//			}
//		});
//		
//		vista1.getBtnEnviar().setOnAction(e -> {
//			crearEtiqueta(vista1.getCampoMensaje().getText(),"uno");
//			
//		});
//		
//		vista2.getBtnEnviar().setOnAction(e -> {
//			crearEtiqueta(vista2.getCampoMensaje().getText(),"dos");
//		});
//		
//	}
//	
//	public void crearEtiqueta (String mensaje, String id) {
//		
//		Label etiqueta = new Label(mensaje);
//		Label etiqueta2 = new Label(mensaje);
//		etiqueta.setId(id);
//		etiqueta2.setId(id);
//		vista1.getFondo().getChildren().add(etiqueta);
//		vista2.getFondo().getChildren().add(etiqueta2);
//		
//		vista1.getCampoMensaje().clear();
//		vista2.getCampoMensaje().clear();
//		
//		
//	}
	
	
	public void crearEtiqueta() {
		this.vista1.crearEtiqueta( null, vista1, vista2);
		this.vista2.crearEtiqueta( null, vista1, vista2);
	}
	
}
