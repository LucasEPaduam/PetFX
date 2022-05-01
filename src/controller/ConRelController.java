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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import petFX.CadPac;
import petFX.MenuPrincipal;
import petFX.Relatorios;

/**
 *
 * @author Lucas Eduardo
 */
public class ConRelController implements Initializable{
    
    @FXML private Button btvoltar;
    @FXML private Button btImprimir;
    @FXML private Button btPesquisar;
    @FXML private ComboBox<?> cbData;
    @FXML private ComboBox<?> cbPET;
    @FXML private ComboBox<?> cbVET;
    @FXML private RadioButton rbData;
    @FXML private RadioButton rbPet;
    @FXML private RadioButton rbVet;
    @FXML private TableView<?> tvrelatorios;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Relatorios inicializado!");
    }
    
    public void onActionVoltarMenu() {

        MenuPrincipal mp = new MenuPrincipal();
            
            try {
                mp.start(new Stage());
                Relatorios.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
}
