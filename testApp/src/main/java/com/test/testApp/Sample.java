package com.test.testApp;

import org.controlsfx.tools.Borders;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Sample extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane=new Pane();
		
		Button btn=new Button("Hello");
		
		Node wrapBtn=Borders.wrap(btn)
				.lineBorder()
				.title("Line")
				.color(Color.GREEN)
				.thickness(1)
				.build()
				.etchedBorder()
				.title("Welcome")
				.build()
				.emptyBorder()
				.padding(20)
				.build()
				.build();
		pane.getChildren().add(wrapBtn);
		
		Scene scene=new Scene(pane,500,500);
		stage.setScene(scene);
		stage.show();
		
	}
	public static void main(String args[]){
		launch(args);
	}

}
