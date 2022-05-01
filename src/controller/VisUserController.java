/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PacienteDao;
import dao.UserDao;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Paciente;
import model.User;
import petFX.CadPac;
import petFX.CadUser;
import petFX.VisPac;
import petFX.Visuser;

/**
 *
 * @author Lucas Eduardo
 */
public class VisUserController implements Initializable{
    
    @FXML private TableView<User> TabelaU;
    @FXML private Button btvoltarU;
    @FXML private TableColumn<User, String> columC;
    @FXML private TableColumn<User, String> columFun;
    @FXML private TableColumn<User, String> columNome;
    
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Visualizar Usuários inicializado!");
        iniciarTabelaU();
    }
    
    
    public void iniciarTabelaU(){
        
        columC.setCellValueFactory(new PropertyValueFactory("cpfcrmv"));
        columNome.setCellValueFactory(new PropertyValueFactory("nomeuser"));
        columFun.setCellValueFactory(new PropertyValueFactory("tipoUser"));
        TabelaU.setItems(atualizaTabelaU());
    }
    
    public ObservableList<User>atualizaTabelaU(){
        
        UserDao us = new UserDao();
        return FXCollections.observableArrayList(us.getListU());
               
    }
    
    public void onActionVoltarU() {

        CadUser cu = new CadUser();
            
            try {
                cu.start(new Stage());
                Visuser.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
}
