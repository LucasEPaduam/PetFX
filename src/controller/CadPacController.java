/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bdcon.BDFabricaCon;
import dao.LoginDao;
import dao.PacienteDao;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Paciente;
import petFX.CadPac;
import petFX.Main;
import petFX.MenuPrincipal;
import petFX.VisPac;
import petFX.iniciarConsulta;

/**
 *
 * @author Lucas Eduardo
 */
public class CadPacController implements Initializable{
    
    @FXML private Button btvoltarMenu, btok;
    @FXML private Button btedit;
    @FXML private Button btexclude;
    @FXML private Button btlimpar;
    @FXML private Button btnovo;
    @FXML private Button btsalvar;
    @FXML private Button btvisupac;
    @FXML private ImageView lupa;
    @FXML private ImageView patavolta;
    @FXML private RadioButton rbCachorro;
    @FXML private RadioButton rbGato;
    @FXML private RadioButton rbOut;
    @FXML private RadioButton rbPas;
    @FXML private TextField tfcepd;
    @FXML private TextField tfcidaded;
    @FXML private TextField tfcod;
    @FXML private TextField tfcpfdono;
    @FXML private TextField tfemaild;
    @FXML private TextField tfgenero;
    @FXML private TextField tfidade;
    @FXML private TextField tfnomedono;
    @FXML private TextField tfnomepac;
    @FXML private TextField tfnumd;
    @FXML private TextField tfpeso;
    @FXML private TextField tfpesquisapac;
    @FXML private TextField tfraca;
    @FXML private TextField tfruad;
    @FXML private TextField tfteld;
    @FXML private TextField tfufd;
    @FXML private ToggleGroup grupo;
    
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
    System.out.println("Pacientes inicializado!"); 
    
    }
    
     public void onActionVoltarMenu() {

        MenuPrincipal mp = new MenuPrincipal();
            
            try {
                mp.start(new Stage());
                CadPac.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
     
    public void Cadastrar(){
         
        String codigopet = tfcod.getText();
        String nomepet = tfnomepac.getText();
        String raca = tfraca.getText();
        String idade = tfidade.getText();
        String peso = tfpeso.getText();
        String sexo = tfgenero.getText();
        String cpfdono = tfcpfdono.getText();        
        String nomedono = tfnomedono.getText();
        String rua = tfruad.getText();
        String numero = tfnumd.getText();
        String cep = tfcepd.getText();
        String cidade = tfcidaded.getText();
        String UF = tfufd.getText();
        String email = tfemaild.getText();
        String telefone = tfteld.getText();
        
        Paciente paciente = new Paciente(codigopet,nomepet,raca,idade,peso,sexo,cpfdono,nomedono,rua,numero,cep,cidade,UF,email,telefone);
        PacienteDao pac = new PacienteDao();       
         
            if(validaCodPet()){ 
                
                UpdatePac();
                
                
            }else{
                
                if (pac.insertPac(paciente)){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("System Message");
                    alert.setHeaderText("PACIENTE CADASTRADO COM SUCESSO");
                    alert.showAndWait(); 
                    
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("System Message");
                    alert.setHeaderText("PACIENTE NÃO CADASTRADO");
                    alert.showAndWait();
                            
                }
            }
            
            
    }
    
    
public void UpdatePac(){
         
        String codigopet = tfcod.getText();
        String nomepet = tfnomepac.getText();
        String raca = tfraca.getText();
        String idade = tfidade.getText();
        String peso = tfpeso.getText();
        String sexo = tfgenero.getText();
        String cpfdono = tfcpfdono.getText();        
        String nomedono = tfnomedono.getText();
        String rua = tfruad.getText();
        String numero = tfnumd.getText();
        String cep = tfcepd.getText();
        String cidade = tfcidaded.getText();
        String UF = tfufd.getText();
        String email = tfemaild.getText();
        String telefone = tfteld.getText();
        
        Paciente paciente = new Paciente(codigopet,nomepet,raca,idade,peso,sexo,cpfdono,nomedono,rua,numero,cep,cidade,UF,email,telefone);
        PacienteDao pac = new PacienteDao();       
         
             
            if(pac.updatePac(paciente)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("PACIENTE ATUALIZADO COM SUCESSO");
                alert.showAndWait();            
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText("PACIENTE NÃO ATUALIZADO");
                alert.showAndWait();
            }
        }

public void DeletePac(){
         
        String codigopet = tfcod.getText();
        String nomepet = tfnomepac.getText();
        String raca = tfraca.getText();
        String idade = tfidade.getText();
        String peso = tfpeso.getText();
        String sexo = tfgenero.getText();
        String cpfdono = tfcpfdono.getText();        
        String nomedono = tfnomedono.getText();
        String rua = tfruad.getText();
        String numero = tfnumd.getText();
        String cep = tfcepd.getText();
        String cidade = tfcidaded.getText();
        String UF = tfufd.getText();
        String email = tfemaild.getText();
        String telefone = tfteld.getText();
        
        Paciente paciente = new Paciente(codigopet,nomepet,raca,idade,peso,sexo,cpfdono,nomedono,rua,numero,cep,cidade,UF,email,telefone);
        PacienteDao pac = new PacienteDao();       
         
         if(validaCodPet()){    
            if(pac.deletePac(paciente)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("PACIENTE EXCLUÍDO COM SUCESSO");
                alert.showAndWait();
                Limpar();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText("PACIENTE NÃO EXCLUÍDO");
                alert.showAndWait();
            }
         }else{
             
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("PACIENTE NÃO CADASTRADO");
                alert.showAndWait();     
             
         }
        }

public boolean validaCodPet() {

        
        PacienteDao pac = new PacienteDao();
        String codpet = pac.codPac(tfcod.getText());      
        

        if (codpet != null) {   
          
            return true;
            
        } else {
            return false;
        }
    
}

public void Limpar(){
   
    tfcod.setText("");
    tfnomepac.setText("");
    tfraca.setText("");
    tfidade.setText("");
    tfpeso.setText("");
    tfgenero.setText("");
    tfcpfdono.setText("");        
    tfnomedono.setText("");
    tfruad.setText("");
    tfnumd.setText("");
    tfcepd.setText("");
    tfcidaded.setText("");
    tfufd.setText("");
    tfemaild.setText("");
    tfteld.setText("");
    tfpesquisapac.setText("");
    
    
}

public void criarCodPet(){
    
     int min = 100;
     int max = 900;
        
        SecureRandom codigo = new SecureRandom();
        codigo.setSeed(new Date().getTime());
        int cod = codigo.nextInt((max - min) + 1) + min;
        
        if (rbCachorro.isSelected()){            
                     
            String codpet = "C" + cod;
            tfcod.setText(codpet);
            
        }else if (rbGato.isSelected()){
            
            String codpet = "G" + cod;
            tfcod.setText(codpet);
            
        }else if (rbPas.isSelected()){
            
            String codpet = "P" + cod;
            tfcod.setText(codpet);
        }
        
        else if (rbOut.isSelected()){
            
            String codpet = "O" + cod;
            tfcod.setText(codpet);
        }
}
        
     public void onActionVisPac() {

        VisPac vp = new VisPac();
            
            try {
                vp.start(new Stage());
                CadPac.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
     
    public void pesquisarPac() {
        

        
        PacienteDao pacbusca = new PacienteDao();
        
        String codpet = tfpesquisapac.getText();        
        
            Paciente pac = pacbusca.pesquisar(codpet);
                
            if(pac == null){
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("PACIENTE NÃO LOCALIZADO");
                alert.showAndWait();   
                
            }else{
                
                tfcod.setText(pac.getCodigopet());
                tfnomepac.setText(pac.getNomepet());
                tfraca.setText(pac.getRaca());
                tfidade.setText(pac.getIdade());
                tfpeso.setText(pac.getPeso());
                tfgenero.setText(pac.getSexo());
                tfcpfdono.setText(pac.getCpfdono());        
                tfnomedono.setText(pac.getNomedono());
                tfruad.setText(pac.getRua());
                tfnumd.setText(pac.getNumero());
                tfcepd.setText(pac.getCep());
                tfcidaded.setText(pac.getCidade());
                tfufd.setText(pac.getUF());
                tfemaild.setText(pac.getEmail());
                tfteld.setText(pac.getTelefone());
                
                if(codpet.startsWith("C")||codpet.startsWith("c")){
                    rbCachorro.setSelected(true);
                }else if (codpet.startsWith("G")||codpet.startsWith("g")){
                    rbGato.setSelected(true);
                }else if (codpet.startsWith("P")||codpet.startsWith("p")){
                    rbPas.setSelected(true);
                }else if (codpet.startsWith("O")||codpet.startsWith("o")){
                    rbOut.setSelected(true);
   
                }
                
                
        }
    
    }
   
}





     
    

