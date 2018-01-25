/**
 * 
 */
package com.test.testApp;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * @author Yuvraj
 *
 */
public class SliderController implements Initializable {

	@FXML AnchorPane rootPane;
	@FXML VBox vBox;
	
	@FXML VBox firstSubVBox;	
	@FXML VBox firstSubMenuList;
	@FXML Button firstMenu;
	
	@FXML VBox secondSubVBox;	
	@FXML VBox secondSubMenuList;
	@FXML Button secondMenu;

	@FXML VBox thirdSubVBox;	
	@FXML VBox thirdSubMenuList;
	@FXML Button thirdMenu;
	
	@FXML VBox fourthSubVBox;	
	@FXML VBox fourthSubMenuList;
	@FXML Button fourthMenu;
	
	@FXML VBox fifthSubVBox;	
	@FXML VBox fifthSubMenuList;
	@FXML Button fifthMenu;
	Map<VBox,VBox> map = new HashMap<VBox,VBox>();
	
	public void initialize(URL location, ResourceBundle resources) {
		
		addMenusToMap();
		setComponentsSize();
		
		
		firstMenu.setOnAction(new EventHandler<ActionEvent>() {
	         public void handle(ActionEvent event) {
	        	 toolsSlider(firstSubVBox,firstSubMenuList);
	        	 removeOtherMenus(firstSubVBox);	        	
	         }
			
	     });
		
		secondMenu.setOnAction(new EventHandler<ActionEvent>() {
	         public void handle(ActionEvent event) {
	        	 toolsSlider(secondSubVBox,secondSubMenuList);
	        	 removeOtherMenus(secondSubVBox);
	         }
	     });
		
		thirdMenu.setOnAction(new EventHandler<ActionEvent>() {
	         public void handle(ActionEvent event) {
	        	 toolsSlider(thirdSubVBox,thirdSubMenuList);
	        	 removeOtherMenus(thirdSubVBox);
	         }
	     });
		
		fourthMenu.setOnAction(new EventHandler<ActionEvent>() {
	         public void handle(ActionEvent event) {
	        	 toolsSlider(fourthSubVBox,fourthSubMenuList);
	        	 removeOtherMenus(fourthSubVBox);
	         }
	     });
		
		fifthMenu.setOnAction(new EventHandler<ActionEvent>() {
	         public void handle(ActionEvent event) {
	        	 toolsSlider(fifthSubVBox,fifthSubMenuList);
	        	 removeOtherMenus(fifthSubVBox);
	         }
	     });	
	}
	
	/**
	 * Set stage size as per screen resolution 
	 */
	private void setComponentsSize() {
		vBox.prefHeightProperty().bind(App.stage.heightProperty());
		vBox.setPrefWidth(200);
	}
/**
 * Add Menus to map 
 */
	public void addMenusToMap() {
		addMenusToMapImpl();
	}

	private void addMenusToMapImpl() {
		
		map.put(firstSubVBox,firstSubMenuList);
		map.put(secondSubVBox, secondSubMenuList);
		map.put(thirdSubVBox,thirdSubMenuList);
		map.put(fourthSubVBox, fourthSubMenuList);
		map.put(fifthSubVBox, fifthSubMenuList);

		/**
		 * Remove the components from VBox on load of stage
		 */
		for (Map.Entry<VBox,VBox> entry : map.entrySet()) {
			entry.getKey().getChildren().remove(entry.getValue());
		}		
	}
/**
 * Menu slider
 * @param menu
 * @param subMenu
 */
	public void toolsSlider(VBox menu,VBox subMenu){
		toolsSliderImpl(menu,subMenu);
	}

	private void toolsSliderImpl(VBox menu,VBox subMenu) {
		   if(menu.getChildren().contains(subMenu)){
	    	   final FadeTransition transition = new FadeTransition(Duration.millis(500), menu);
       	    transition.setFromValue(0.5);
       	    transition.setToValue(1);
       	    transition.setInterpolator(Interpolator.EASE_IN);
       	 menu.getChildren().remove(subMenu);
       	    transition.play();
	       }else{
	    	   final FadeTransition transition = new FadeTransition(Duration.millis(500), menu);
       	    transition.setFromValue(0.5);
       	    transition.setToValue(1);
       	    transition.setInterpolator(Interpolator.EASE_IN);
       	 menu.getChildren().add(subMenu);
       	    transition.play();
	       }
	}
/**
 * Remove other menus
 * @param menu
 */
	public void removeOtherMenus(VBox menu){
		removeOtherMenusImpl(menu);
	}
	private void removeOtherMenusImpl(VBox menu) {
		for (Map.Entry<VBox,VBox> entry : map.entrySet()) {
			if(!entry.getKey().equals(menu))
				entry.getKey().getChildren().remove(entry.getValue());
		}	
	}

}
