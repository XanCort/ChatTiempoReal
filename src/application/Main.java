package application;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Controlador controlador = new Controlador();
			
			Vista vista1 = new Vista();
			Vista vista2 = new Vista();
			
			controlador.vista1 = vista1;
			controlador.vista2 = vista2;
			
			vista1.setC(controlador);
			vista1.setId("uno");
			
			vista1.start(new Stage());
			
			vista2.setC(controlador);
			vista2.setId("dos");
			vista2.start(new Stage());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
