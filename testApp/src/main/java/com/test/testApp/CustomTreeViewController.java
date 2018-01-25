package com.test.testApp;

import java.net.InetAddress;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomTreeViewController extends Application {

	TreeView<HBox> treeView;
	
	@Override
	public void start(Stage stage) throws Exception {
	
		String hostName="This PC";
		try {
			hostName=InetAddress.getLocalHost().getHostName();
		} catch (Exception e) {
			System.out.println("Error..");
		}
		Label systemName=new Label(hostName);
		ImageView systemIcon=new ImageView(new Image("/images/computer.png"));
		systemIcon.setFitHeight(40);
		systemIcon.setFitWidth(40);
		HBox systemHBox=new HBox();
		systemHBox.setPrefHeight(50);
		systemHBox.setPrefWidth(50);
		systemHBox.getChildren().addAll(systemIcon,systemName);
		
		
	
		
		TreeItem<HBox> systemRoot=new TreeItem<HBox>(systemHBox);
		systemRoot.setExpanded(true);
		Label labelChild=new Label(hostName);
		ImageView iconChild=new ImageView(new Image("/images/folder.png"));
		iconChild.setFitHeight(30);
		iconChild.setFitWidth(30);
		HBox hboxChild=new HBox();
		hboxChild.setPrefHeight(40);
		hboxChild.setPrefWidth(40);
		hboxChild.getChildren().addAll(iconChild,labelChild);
		TreeItem<HBox> systemRootChild=new TreeItem<HBox>(hboxChild);
		
		for (int i = 0; i < 5; i++) {
			Label label=new Label(hostName);
			ImageView icon=new ImageView(new Image("/images/folder.png"));
			icon.setFitHeight(30);
			icon.setFitWidth(30);
			HBox hbox=new HBox();
			hbox.setPrefHeight(40);
			hbox.setPrefWidth(40);
			hbox.getChildren().addAll(icon,label);
			TreeItem<HBox> children=new TreeItem<HBox>(hbox);
			systemRootChild.getChildren().add(children);
		}
		systemRoot.getChildren().add(systemRootChild);
		treeView=new TreeView<HBox>(systemRoot);
		BorderPane rootBorderPane=new BorderPane();
		rootBorderPane.setLeft(treeView);
		
		
		/**
		 * Action event for treeview
		 */
		EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
		    handleMouseClicked(event);
		};

		treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle); 
		
		Scene scene =new Scene(rootBorderPane,500,500);
		stage.setScene(scene);
		stage.show();
	}
	private void handleMouseClicked(MouseEvent event) {
		 Node node = event.getPickResult().getIntersectedNode();
		 // Accept clicks only on node cells, and not on empty spaces of the TreeView
		    if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
		        String name = (String) ((TreeItem)treeView.getSelectionModel().getSelectedItem()).getValue();
		        System.out.println("Node click: " + name);
		    }
	}
	public static void main(String args[]){
		launch(args);
	}

}
