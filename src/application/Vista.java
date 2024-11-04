package application;

import java.io.Serializable;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Vista implements Serializable{
	public int id=0;
	public void start(Stage primaryStage) {
		id++;
		System.out.println(id);
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid,500,500);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		primaryStage.setTitle("Barra de menú");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	
	
}
