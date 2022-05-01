/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ExameDao;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Exame;
import petFX.CadExames;
import petFX.MenuPrincipal;
import petFX.VisExame;


/**
 *
 * @author Lucas Eduardo
 */
public class CadExameController implements Initializable {
    
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button btvoltar;
    @FXML private Button btPesquisar;
    @FXML private Button btExcluir;
    @FXML private Button btLimpar;    
    @FXML private Button btSalvar;
    @FXML private Button btVisuExame;
    @FXML private TextField tfcodigo;
    @FXML private TextField tfnome;
    @FXML private TextField tfpesquisar;
    @FXML private TextField tfpreco;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Cad Exame inicializado!");
    }
    
    
    public void onActionVoltarMenu() {

        MenuPrincipal mp = new MenuPrincipal();
            
            try {
                mp.start(new Stage());
                CadExames.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
    public void Cadastrar(){
         
        String codigo = tfcodigo.getText();
        String nome = tfnome.getText();
        String preco = tfpreco.getText();
        
        
        Exame exame = new Exame(codigo,nome,preco);
        ExameDao ex = new ExameDao();       
         
            if(validaCodExame()){ 
                
                updateExame();
                
                
            }else{
                
                if (ex.insertExame(exame)){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("System Message");
                    alert.setHeaderText("EXAME CADASTRADO COM SUCESSO");
                    alert.showAndWait(); 
                    
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("System Message");
                    alert.setHeaderText("EXAME NÃO CADASTRADO");
                    alert.showAndWait();
                            
                }
            }
            
            
    }
    
    
    public void updateExame(){
         
        String codigo = tfcodigo.getText();
        String nome = tfnome.getText();
        String preco = tfpreco.getText();
        
        
        Exame exame = new Exame(codigo,nome,preco);
        ExameDao ex = new ExameDao();         
         
             
            if(ex.updateExame(exame)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("EXAME ATUALIZADO COM SUCESSO");
                alert.showAndWait();            
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText("EXAME NÃO ATUALIZADO");
                alert.showAndWait();
            }
        }

    public void deleteExame(){
         
        String codigo = tfcodigo.getText();
        String nome = tfnome.getText();
        String preco = tfpreco.getText();
        
        
        Exame exame = new Exame(codigo,nome,preco);
        ExameDao ex = new ExameDao();             
         
         if(validaCodExame()){    
            if(ex.deleteExame(exame)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("EXAME EXCLUÍDO COM SUCESSO");
                alert.showAndWait();
                limpar();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText("EXAME NÃO EXCLUÍDO");
                alert.showAndWait();
            }
         }else{
             
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("EXAME NÃO CADASTRADO");
                alert.showAndWait();     
             
         }
        }

    public boolean validaCodExame() {

        
        ExameDao ex = new ExameDao();
        String codExame = ex.codExame(tfcodigo.getText());      
        

        if (codExame != null) {   
          
            return true;
            
        } else {
            return false;
        }
    
}

    public void limpar(){
   
        tfcodigo.setText("");
        tfnome.setText("");
        tfpreco.setText("");
        tfpesquisar.setText("");
    
    
}

public void criarCodExame(){
    
     int min = 100;
     int max = 900;
        
        SecureRandom codigo = new SecureRandom();
        codigo.setSeed(new Date().getTime());
        int cod = codigo.nextInt((max - min) + 1) + min;
        
            String codExame = "E" + cod;
            tfcodigo.setText(codExame);
        
}
        
    public void onActionVisExame() {

        VisExame ve = new VisExame();
            
            try {
                ve.start(new Stage());
                CadExames.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
     
    public void pesquisarExame() {
        
        
        ExameDao exameBusca = new ExameDao();
        
        String codExame = tfpesquisar.getText();       
        Exame exame = exameBusca.pesquisar(codExame);
                
            if(exame == null){
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("EXAME NÃO LOCALIZADO");
                alert.showAndWait();   
                
            }else{
                
                tfcodigo.setText(exame.getCodigoE());
                tfnome.setText(exame.getNomeE());
                tfpreco.setText(exame.getPrecoE());
                
   
                }
                
    
    }
    
    
    
}
