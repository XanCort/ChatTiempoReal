package application;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Controlador {

	
	ArrayList<Mensaje> mensajes;
	
	Vista vista1 ;
	Vista vista2 ;
	
	public Controlador() {
		this.vista1=vista1;
		this.vista2=vista2;
		this.mensajes = new ArrayList<>();
	}
	
	
	
	public void crearEtiqueta(String s, String id) {
		try {
			Mensaje mensajeNuevo = new Mensaje(s, id);
			mensajes.add(mensajeNuevo);
			if(mensajes.get((mensajes.size()-1)).isEmpty()) {
				mensajes.remove(mensajes.size()-1);
				throw(new Exception("No se pueden mandar mensajes vacios"));
			};
			vista1.crearEtiqueta(mensajeNuevo);
			vista2.crearEtiqueta(mensajeNuevo);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void escribiendo(String id) {
		if(vista1.id.equals(id)) {
			vista2.empezarEscribir();
		}else if (vista2.id.equals(id)) {
			vista1.empezarEscribir();
			
		}
	}
	
	
}
