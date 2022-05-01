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
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import petFX.Consulta;
import petFX.MenuPrincipal;
import petFX.iniciarConsulta;

/**
 *
 * @author Lucas Eduardo
 */
public class ConsultaController implements Initializable{
    
    @FXML private Button btIniciarConsulta, btvoltar;
    @FXML private TableView<?> tvIniciar;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Iniciar Consulta inicializado!");
    }
    
    public void onActionVoltarIC() {

        iniciarConsulta ic = new iniciarConsulta();
            
            try {
                ic.start(new Stage());
                Consulta.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
}
