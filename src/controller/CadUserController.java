/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PacienteDao;
import dao.UserDao;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Paciente;
import model.User;
import petFX.AlterarSenha;
import petFX.CadPac;
import petFX.CadUser;
import petFX.MenuPrincipal;
import petFX.VisPac;
import petFX.Visuser;

/**
 *
 * @author Lucas Eduardo
 */
public class CadUserController implements Initializable{
    
    @FXML private Button btVisuUser;
    @FXML private Button btvoltar;
    @FXML private Button btedit;
    @FXML private Button btexcluir;
    @FXML private Button btlimpar;
    @FXML private Button btnovo;
    @FXML private Button btsalvar;
    @FXML private TextField tftipouser;
    @FXML private ImageView patavoltar;
    @FXML private TextField tfCpfCrmv;
    @FXML private TextField tfcep;
    @FXML private TextField tfcidade;
    @FXML private TextField tfemail;
    @FXML private TextField tfnome;
    @FXML private TextField tfnum;
    @FXML private TextField tfpesquisar;
    @FXML private TextField tfrua;
    @FXML private TextField tfsenha;
    @FXML private TextField tftel;
    @FXML private TextField tfuf;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("usuario inicializado!");
    }
    
    public void onActionVoltarMenu() {

        MenuPrincipal mp = new MenuPrincipal();
            
            try {
                mp.start(new Stage());
                CadUser.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
   
    public void CadastrarUser(){
         
        String cpfcrmv = tfCpfCrmv.getText();
        String nomeuser = tfnome.getText();
        String ruaU = tfrua.getText();
        String numeroU = tfnum.getText();
        String cepU = tfcep.getText();
        String cidadeU = tfcidade.getText();
        String UFU = tfuf.getText();
        String tipoUser = tftipouser.getText();
        String senha  = tfsenha.getText();
        String telU = tftel.getText();
        String emailU = tfemail.getText();
        
        User user = new User(cpfcrmv, nomeuser, ruaU, numeroU, cepU, cidadeU, UFU, tipoUser, senha, telU, emailU);
        UserDao u = new UserDao();       
         
            if(validaCrmv()){ 
                
                UpdateUser();
                
                
            }else{
                
                if (u.insertUser(user)){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("System Message");
                    alert.setHeaderText("USUARIO CADASTRADO COM SUCESSO");
                    alert.showAndWait(); 
                    
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("System Message");
                    alert.setHeaderText("USUARIO NÃO CADASTRADO");
                    alert.showAndWait();
                            
                }
            }
            
            
    }
    
    
public void UpdateUser(){
         
        String cpfcrmv = tfCpfCrmv.getText();
        String nomeuser = tfnome.getText();
        String ruaU = tfrua.getText();
        String numeroU = tfnum.getText();
        String cepU = tfcep.getText();
        String cidadeU = tfcidade.getText();
        String UFU = tfuf.getText();
        String tipoUser = tftipouser.getText();
        String senha  = tfsenha.getText();
        String telU = tftel.getText();
        String emailU = tfemail.getText();
        
        User user = new User(cpfcrmv, nomeuser, ruaU, numeroU, cepU, cidadeU, UFU, tipoUser, senha, telU, emailU);
        UserDao u = new UserDao();         
         
             
            if(u.updateUser(user)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("USUÁRIO ATUALIZADO COM SUCESSO");
                alert.showAndWait();            
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText("USUÁRIO NÃO ATUALIZADO");
                alert.showAndWait();
            }
        }

public void DeleteUser(){
         
        String cpfcrmv = tfCpfCrmv.getText();
        String nomeuser = tfnome.getText();
        String ruaU = tfrua.getText();
        String numeroU = tfnum.getText();
        String cepU = tfcep.getText();
        String cidadeU = tfcidade.getText();
        String UFU = tfuf.getText();
        String tipoUser = tftipouser.getText();
        String senha  = tfsenha.getText();
        String telU = tftel.getText();
        String emailU = tfemail.getText();
        
        User user = new User(cpfcrmv, nomeuser, ruaU, numeroU, cepU, cidadeU, UFU, tipoUser, senha, telU, emailU);
        UserDao u = new UserDao();          
         
         if(validaCrmv()){    
            if(u.deleteUser(user)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("USUÁRIO EXCLUÍDO COM SUCESSO");
                alert.showAndWait();
                LimparU();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText("USUÁRIO NÃO EXCLUÍDO");
                alert.showAndWait();
            }
         }else{
             
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("USUÁRIO NÃO CADASTRADO");
                alert.showAndWait();     
             
         }
        }

public boolean validaCrmv() {

        
        UserDao user = new UserDao();
        String coduser = user.codUser(tfCpfCrmv.getText());      
        

        if (coduser != null) {   
          
            return true;
            
        } else {
            return false;
        }
    
}

public void LimparU(){
    
    
    
    tftipouser.setText("");
    tfCpfCrmv.setText("");
    tfcep.setText("");
    tfcidade.setText("");
    tfemail.setText("");
    tfnome.setText("");
    tfnum.setText("");
    tfpesquisar.setText("");
    tfrua.setText("");
    tfsenha.setText("");
    tftel.setText("");
    tfuf.setText("");
    
    
}


        
     public void onActionVisUser() {

        Visuser us = new Visuser();
            
            try {
                us.start(new Stage());
                CadUser.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
     
     public void pesquisarUser() {
        

        
        UserDao userbusca = new UserDao();
        
        String cpfcrmv = tfpesquisar.getText();        
        
            User user = userbusca.pesquisar(cpfcrmv);
                
            if(user == null){
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("USUÁRIO NÃO LOCALIZADO");
                alert.showAndWait();   
                
            }else{
                
                tfCpfCrmv.setText(user.getCpfcrmv());
                tfnome.setText(user.getNomeuser());
                tfrua.setText(user.getRuaU());
                tfnum.setText(user.getNumeroU());
                tfcep.setText(user.getCepU());
                tfcidade.setText(user.getCidadeU());
                tfuf.setText(user.getUFU());
                tftipouser.setText(user.getTipoUser());
                tfsenha.setText(user.getSenha());
                tfemail.setText(user.getEmailU());
                tftel.setText(user.getTelU());
    
                
        }
     }
     
     public void alterarSenha(){
          
        AlterarSenha as = new AlterarSenha();
            
            try {
                as.start(new Stage());
                CadUser.getStage().close();                
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
         
         
     
    
}
