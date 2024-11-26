package controlador;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import modelo.Mensaje;
import vista.Vista;

public class Controlador {

	//Modelo
	private ArrayList<Mensaje> mensajes;
	
	//Vistas
	private Vista vista1 ;
	private Vista vista2 ;
	
	//Constructor del controlador
	public Controlador() {
		this.vista1=vista1;
		this.vista2=vista2;
		this.mensajes = new ArrayList<>();
	}
	
	public ArrayList<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(ArrayList<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Vista getVista1() {
		return vista1;
	}

	public void setVista1(Vista vista1) {
		this.vista1 = vista1;
	}

	public Vista getVista2() {
		return vista2;
	}

	public void setVista2(Vista vista2) {
		this.vista2 = vista2;
	}

	//Método que recibe el texto del mensaje que se ha enviado y la id de quien lo ha enviado para crear añadirlo en los chats de las dos ventanas
	public void crearEtiqueta(String s, String id) {
		try {
			Mensaje mensajeNuevo = new Mensaje(s, id);
			mensajes.add(mensajeNuevo);
			//Comprobacion de si el mensaje está vacío
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
	//Método para mostrar que el otro usuario está escribiendo un mensaje
	public void escribiendo(String id) {
		if(vista1.id.equals(id)) {
			vista2.empezarEscribir();
		}else if (vista2.id.equals(id)) {
			vista1.empezarEscribir();
			
		}
	}
	//Método para quitar el indicador de escribiendo en caso de que el otro usuario mande su mensaje
	public void cancelarEscribiendo(String id) {
		if(vista1.id.equals(id)) {
			vista2.acabarHilo();
		}else if (vista2.id.equals(id)) {
			vista1.acabarHilo();
			
		}
	}
	
	
}
