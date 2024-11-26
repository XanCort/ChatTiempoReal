package application;
	
import controlador.Controlador;
import javafx.application.Application;
import javafx.stage.Stage;
import vista.Vista;

//Clase para establecer las ids y las relaciones entre controlador y vistas y lanzar el programa
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Controlador controlador = new Controlador();
			
			Vista vista1 = new Vista();
			Vista vista2 = new Vista();
			vista1.id ="uno";
			vista2.id="dos";
			controlador.setVista1(vista1);
			controlador.setVista2(vista2);
			
			
			vista1.setC(controlador);
			vista1.start(new Stage());
			vista2.setC(controlador);
			vista2.start(new Stage());

			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
