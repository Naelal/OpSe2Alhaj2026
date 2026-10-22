package main;


import gui.GetraenkeControl;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new GetraenkeControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
