package application.carballeira.controller;

import application.carballeira.view.Vista;

public class Controlador {

	private Vista vista1;
	private Vista vista2;
	
	public Controlador() {
		this.vista1 = vista1;
		this.vista2 = vista2;
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

	public void crearEtiqueta(String s, String id) {
		
		vista1.crearEtiqueta(s, id);
		vista2.crearEtiqueta(s, id);
		
	}
	
	public void escribiendo(String id) {
		if(vista1.getId().equals(id)) {
			vista2.empezarEscribir();
		}else if (vista2.getId().equals(id)) {
			vista1.empezarEscribir();
			
		}
	}
	
}
