package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			ScrollPane s = new ScrollPane();  
	        	VBox fondo = new VBox();
	        
	        	Label etiqueta = new Label("Hola qiue tal");
	        	etiqueta.setId("tipo1");
	       		etiqueta.getId();
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
	        
	        	fondo.getChildren().addAll(etiqueta, etiqueta1, etiqueta2, etiqueta3, etiqueta4, etiqueta5, etiqueta6, etiqueta7, etiqueta8, etiqueta9, etiqueta10, etiqueta11, etiqueta12);
	        
        		s.setContent(fondo);
			
			BorderPane root = new BorderPane();
			prueba.getChildren().add(s);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Controlador controlador = new Controlador();
			controlador.start(primaryStage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
