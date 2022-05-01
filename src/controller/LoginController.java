/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginDao;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import petFX.Main;
import petFX.MenuPrincipal;

/**
 *
 * @author Lucas Eduardo
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField tbLogin, tbSenha;
    @FXML
    private Button btEntrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Login Controller inicializado!");
    }

     @FXML
    public void loginOnAction() {

        
        LoginDao dao = new LoginDao();
        String userName= dao.login(tbLogin.getText(), tbSenha.getText());      
        

        if (userName != null) {   
          
            MenuPrincipal mp = new MenuPrincipal();
            
            try {
                mp.start(new Stage());
                Main.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("System Message");
            alert.setHeaderText("ERRO DE LOGIN");
            alert.setContentText("Usuário e/ou senha inválido(s)!");
            alert.showAndWait();
        }
    
}
}
