/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginDao;
import dao.UserDao;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import petFX.AlterarSenha;
import petFX.CadUser;
import petFX.Main;
import petFX.MenuPrincipal;

/**
 *
 * @author Lucas Eduardo
 */
public class AlterarSenhaController implements Initializable{
    
    @FXML private Button btsalvar;
    @FXML private TextField tfUserID;
    @FXML private TextField tfSenhaAtual;
    @FXML private TextField tfsenhaNew;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Alterar Senha inicializado!");
    }
    
    
    public void salvarNovaSenha(){
        
        
        LoginDao dao = new LoginDao();
        String userName = dao.login(tfUserID.getText(), tfSenhaAtual.getText());      
       
            
        if (userName != null) {
            
            UserDao userSenha = new UserDao();
            if(userSenha.alteraSenhaUser(tfUserID.getText(), tfsenhaNew.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText("SENHA ALTERADA COM SUCESSO");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText("ERRO AO ALTERAR A SENHA");
                alert.setContentText("Problemas de conexão com o banco de dados!");
                alert.showAndWait();            
                 }
            
           CadUser user = new CadUser();
            
            try {
                user.start(new Stage());
                AlterarSenha.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("System Message");
            alert.setHeaderText("ERRO DE VERIFICAÇÃO");
            alert.setContentText("Usuário e/ou senha inválido(s)!");
            alert.showAndWait();
        }
        
        
        
    }
    
    
}
