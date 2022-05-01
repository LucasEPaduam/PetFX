/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petFX;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lucas Eduardo
 */
public class Relatorios extends Application{
    
    private static Stage stage;
    
    
    
     public static void main(String[] args) {
        launch(args);
    }
    
     @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("../view/Relatorios.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Relatórios de Consultas Realizadas");
        stage.show();
        setStage(stage);
        
    }
    
    
    public static Stage getStage(){        
        return stage;
    }
    
    public static void setStage(Stage stage){
        
        Relatorios.stage = stage;
    }
    
}
