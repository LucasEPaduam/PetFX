/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import petFX.Agendamento;
import petFX.CadPac;
import petFX.MenuPrincipal;

/**
 *
 * @author Lucas Eduardo
 */
public class AgendamentoController implements Initializable {
    
    @FXML private Button btAgendamentos;
    @FXML private Button btvoltar;
    @FXML private Button btAgendar;
    @FXML private Button btExcluir;
    @FXML private Button btLimpar;
    @FXML private Button btVisuPac;
    @FXML private Button btVisuVet;
    @FXML private ImageView pataVoltaMenu;
    @FXML private TextField tfCodPet;
    @FXML private TextField tfCodVet;
    @FXML private TextField tfData;
    @FXML private TextField tfHora;  
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Agendamento inicializado!");
    }
    
    public void onActionVoltarMenu() {

        MenuPrincipal mp = new MenuPrincipal();
            
            try {
                mp.start(new Stage());
                Agendamento.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
}
