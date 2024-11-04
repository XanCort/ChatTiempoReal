package application;

import javafx.stage.Stage;

public class Controlador {

	public void start(Stage stage) {
		Stage stage2 = new Stage();
		Vista vista1 = new Vista();
		vista1.start(stage);
		Vista vista2 = new Vista();
		vista2.start(stage2);
	}
	
	
}
