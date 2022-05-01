/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ExameDao;
import dao.RemedioDao;
import dao.VacinaDao;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Exame;
import model.Remedio;
import model.Vacina;
import petFX.CadExames;
import petFX.CadMed;
import petFX.CadPac;
import petFX.MenuPrincipal;
import petFX.VisExame;
import petFX.VisPac;
import petFX.VisRemedio;
import petFX.VisVacina;

/**
 *
 * @author Lucas Eduardo
 */
public class CadMedController implements Initializable{
    
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button btEdit;
    @FXML private Button btExcluir;
    @FXML private Button btLimpar;
    @FXML private Button btNovo;
    @FXML private Button btSalvar;
    @FXML private Button btVisuMed;
    @FXML private Button btpesquisarMedicamento;
    @FXML private Button btvoltar;
    @FXML private RadioButton rbRemedio;
    @FXML private RadioButton rbVacina;
    @FXML private TextField tfcodigo;
    @FXML private TextField tfnome;
    @FXML private TextField tfpesquisar;
    @FXML private TextField tfpreco;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Medicamentos inicializado!");
    }
    
    public void onActionVoltarMenu() {

        MenuPrincipal mp = new MenuPrincipal();
            
            try {
                mp.start(new Stage());
                CadMed.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
    
    public void Cadastrar(){
         
        String codigo = tfcodigo.getText();
        String nome = tfnome.getText();
        String preco = tfpreco.getText();
        
            
            Remedio remedio = new Remedio(codigo,nome,preco);
            RemedioDao med = new RemedioDao();       
         
            if(validaCodRemedio()){ 
                
                updateRemedio();
                
                
            }else{
                
                if (med.insertRemedio(remedio)){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("System Message");
                    alert.setHeaderText("REMÉDIO CADASTRADO COM SUCESSO");
                    alert.showAndWait(); 
                    
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("System Message");
                    alert.setHeaderText("REMÉDIO NÃO CADASTRADO");
                    alert.showAndWait();
                            
                }
            }
            
    }
    
    
    public void updateRemedio(){
         
        String codigo = tfcodigo.getText();
        String nome = tfnome.getText();
        String preco = tfpreco.getText();
        
        
        Remedio remedio = new Remedio(codigo,nome,preco);
        RemedioDao med = new RemedioDao();         
         
             
            if(med.updateRemedio(remedio)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("REMÉDIO ATUALIZADO COM SUCESSO");
                alert.showAndWait();            
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText("REMÉDIO NÃO ATUALIZADO");
                alert.showAndWait();
            }
        }

    public void deleteRemedio(){
         
        String codigo = tfcodigo.getText();
        String nome = tfnome.getText();
        String preco = tfpreco.getText();
        
        
        Remedio remedio = new Remedio(codigo,nome,preco);
        RemedioDao med = new RemedioDao();            
         
         if(validaCodRemedio()){    
            if(med.deleteRemedio(remedio)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("REMÉDIO EXCLUÍDO COM SUCESSO");
                alert.showAndWait();
                limpar();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText("REMÉDIO NÃO EXCLUÍDO");
                alert.showAndWait();
            }
         }else{
             
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("REMÉDIO NÃO CADASTRADO");
                alert.showAndWait();     
             
         }
        }

    public boolean validaCodRemedio() {

        
        RemedioDao med = new RemedioDao();
        String codRemedio = med.codRemedio(tfcodigo.getText());      
        

        if (codRemedio != null) {   
          
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

    public void criarCodRemedio(){  
           
        int min = 100;
        int max = 900;
        
        SecureRandom codigo = new SecureRandom();
        codigo.setSeed(new Date().getTime());
        int cod = codigo.nextInt((max - min) + 1) + min;
        
        String codRemedio = "R" + cod;
        tfcodigo.setText(codRemedio); 
        
}

    public void criarCodVacina(){
    
        int min = 100;
        int max = 900;
        
        SecureRandom codigo = new SecureRandom();
        codigo.setSeed(new Date().getTime());
        int cod = codigo.nextInt((max - min) + 1) + min;
        
        String codVacina = "V" + cod;
        tfcodigo.setText(codVacina);       
    
}
        
    public void onActionVisMedicamento() {
        
        if(!rbRemedio.isSelected() && !rbVacina.isSelected()){
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("System Message");
            alert.setHeaderText("SELECIONE O TIPO DE MEDICAMENTO");
            alert.showAndWait(); 
        }
        
        if(rbRemedio.isSelected()){
            
            VisRemedio vr = new VisRemedio();
            
            try {
                vr.start(new Stage());
                CadMed.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

         if(rbVacina.isSelected()){
             
             VisVacina vv = new VisVacina();
            
            try {
                vv.start(new Stage());
                CadMed.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(CadMedController.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         }
            
             

        }
     
    public void pesquisarMedicamento() {
        
       
        
        if(tfpesquisar.getText().startsWith("R")|| tfpesquisar.getText().startsWith("r")){
            
            RemedioDao medicamentoBusca = new RemedioDao();
        
            String codRemedio = tfpesquisar.getText();       
            Remedio remedio = medicamentoBusca.pesquisar(codRemedio);
                
            if(remedio == null){
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("REMÉDIO NÃO LOCALIZADO");
                alert.showAndWait();   
                
            }else{
                
                tfcodigo.setText(remedio.getCodigoR());
                tfnome.setText(remedio.getNomeR());
                tfpreco.setText(remedio.getPrecoR());
   
                } 
            
        } else if(tfpesquisar.getText().startsWith("V")|| tfpesquisar.getText().startsWith("v"))   {
            
            VacinaDao medicamentoBusca = new VacinaDao();
        
            String codVacina = tfpesquisar.getText();       
            Vacina vacina = medicamentoBusca.pesquisar(codVacina);
                
            if(vacina == null){
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("VACINA NÃO LOCALIZADA");
                alert.showAndWait();   
                
            }else{
                
                tfcodigo.setText(vacina.getCodigoV());
                tfnome.setText(vacina.getNomeV());
                tfpreco.setText(vacina.getPrecoV());
   
                } 
        }else{
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("System Message");
            alert.setHeaderText("MEDICAMENTO NÃO LOCALIZADO");
            alert.setContentText("Verifique se o código foi preenchido corretamente!");
            alert.showAndWait();
            
        }     
    
    }
    
    
    
    
    
}
