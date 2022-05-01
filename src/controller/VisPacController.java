/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PacienteDao;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Paciente;
import petFX.CadMed;
import petFX.CadPac;
import petFX.MenuPrincipal;
import petFX.VisPac;

/**
 *
 * @author Lucas Eduardo
 */
public class VisPacController implements Initializable{
    
    @FXML private TableView<Paciente> Tabelapaccad;
    @FXML private Button btvoltarpac;
    @FXML private TableColumn<Paciente, String> columCod;
    @FXML private TableColumn<Paciente, String> columNome;
    @FXML private TableColumn<Paciente, String> columNomeD;
    @FXML private TableColumn<Paciente, String> columRaca;
    
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Visualizar pacientes inicializado!");
        iniciarTabela();
    }
    
    
    public void iniciarTabela(){
        
        columCod.setCellValueFactory(new PropertyValueFactory("codigopet"));
        columNome.setCellValueFactory(new PropertyValueFactory("nomepet"));
        columNomeD.setCellValueFactory(new PropertyValueFactory("nomedono"));
        columRaca.setCellValueFactory(new PropertyValueFactory("raca"));
        Tabelapaccad.setItems(atualizaTabela());
    }
    
    public ObservableList<Paciente>atualizaTabela(){
        
        PacienteDao pd = new PacienteDao();
        return FXCollections.observableArrayList(pd.getList());
               
    }
    
    public void onActionVoltarPac() {

        CadPac cp = new CadPac();
            
            try {
                cp.start(new Stage());
                VisPac.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
}
