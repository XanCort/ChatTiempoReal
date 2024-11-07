package application;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Controlador {

	Vista vista1 ;
	Vista vista2 ;
	
	public Controlador() {
		this.vista1=vista1;
		this.vista2=vista2;
	}
	
	public void crearEtiqueta(String s, String id) {
		
		vista1.crearEtiqueta(s, id);
		vista2.crearEtiqueta(s, id);
		
	}
	
}
