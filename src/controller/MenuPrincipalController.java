/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import petFX.AgendamentoTela;
import petFX.CadExames;
import petFX.CadMed;
import petFX.CadPac;
import petFX.CadUser;
import petFX.Main;
import petFX.MenuPrincipal;
import petFX.Relatorios;
import petFX.iniciarConsulta;


/**
 *
 * @author Lucas Eduardo
 */
public class MenuPrincipalController implements Initializable{
    
    @FXML private Button btAgendamento;
    @FXML private Button btConsultas;
    @FXML private Button btExame;
    @FXML private Button btMed;
    @FXML private Button btRelatorios;
    @FXML private Button btUsuario;
    @FXML private Button bt_Paciente;
    @FXML private Button btVoltar;
    @FXML private ImageView pataVoltaLogin;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Menu Principal inicializado!");
        
              
    }
    

    public void VoltarLogin() {

        Main main = new Main();
            
            try {
                main.start(new Stage());
                MenuPrincipal.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
    public void onActionUsuario() {

        CadUser user = new CadUser();
            
            try {
                user.start(new Stage());
                MenuPrincipal.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
    public void onActionPaciente() {

        CadPac pac = new CadPac();
            
            try {
                pac.start(new Stage());
                MenuPrincipal.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
    public void onActionExame() {

        CadExames exame = new CadExames();
            
            try {
                exame.start(new Stage());
                MenuPrincipal.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
    public void onActionMed() {

        CadMed med = new CadMed();
            
            try {
                med.start(new Stage());
                MenuPrincipal.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
    public void onActionAgendamento() {

        AgendamentoTela ag = new AgendamentoTela();
            
            try {
                ag.start(new Stage());
                MenuPrincipal.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
    
    
    public void onActionConsulta() {

        iniciarConsulta ic = new iniciarConsulta();
            
            try {
                ic.start(new Stage());
                MenuPrincipal.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
    public void onActionRelatorio() {

        Relatorios rel = new Relatorios();
            
            try {
                rel.start(new Stage());
                MenuPrincipal.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    
    
    
    

