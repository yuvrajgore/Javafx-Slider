package com.test.testApp;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author Yuvraj
 *
 */
public class App extends Application
{
	static Stage stage;
    public static void main( String[] args )
    {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = null;
		
		try {
			stage=primaryStage;
			root = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		Scene scene=new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
		
		stage.setScene(scene);
		stage.setTitle("JavaFx Sliding MenuBar");
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        //set Stage boundaries to visible bounds of the main screen
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
		stage.show();
	}
}
