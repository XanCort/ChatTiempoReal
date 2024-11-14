package application;

public class Mensaje {

	private String texto;
	private String id;
	
	public Mensaje(String texto, String id) {
		super();
		this.texto = texto.trim();
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isEmpty(){
		
		if(this.texto.trim().isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
}
