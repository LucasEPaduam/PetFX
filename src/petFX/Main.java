/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petFX;


import java.awt.image.BufferedImage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import static petFX.MenuPrincipal.setStage;

/**
 *
 * @author Lucas Eduardo
 */
public class Main extends Application{
    private static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tela de Login");
        stage.show();
        setStage(stage);
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static Stage getStage(){        
        return stage;
    }
    
    public static void setStage(Stage stage){
        
        Main.stage = stage;
    }

   

    
}
