/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Lucas Eduardo
 */
public class MenuPrincipal extends Application {
    private static Stage stage;
    
    
    
     public static void main(String[] args) {
        launch(args);
    }
    
     @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("../view/MenuPrincipal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Menu Principal");
        stage.show();
        setStage(stage);
        
        
    }
    
    
    public static Stage getStage(){        
        return stage;
    }
    
    public static void setStage(Stage stage){
        
        MenuPrincipal.stage = stage;
    }
    
    
}
