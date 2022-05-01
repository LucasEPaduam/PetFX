/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VacinaDao;
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
import model.Vacina;
import petFX.CadMed;
import petFX.VisVacina;

/**
 *
 * @author Lucas Eduardo
 */
public class VisVacinaController implements Initializable{
    
    @FXML private TableView<Vacina> TabelaCadVacina;
    @FXML private Button btvoltarMed;
    @FXML private TableColumn<Vacina, String> columCodigo;
    @FXML private TableColumn<Vacina, String> columNome;
    @FXML private TableColumn<Vacina, String> columPreco;
    
    
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Visualizar Vacina inicializado!");
        iniciarTabelaV();
    }
    
    
    public void iniciarTabelaV(){
        
        columCodigo.setCellValueFactory(new PropertyValueFactory("codigoV"));
        columNome.setCellValueFactory(new PropertyValueFactory("nomeV"));
        columPreco.setCellValueFactory(new PropertyValueFactory("precoV"));
        
        TabelaCadVacina.setItems(atualizaTabelaV());
    }
    
    public ObservableList<Vacina>atualizaTabelaV(){
        
        VacinaDao vd = new VacinaDao();
        return FXCollections.observableArrayList(vd.getListVacina());
               
    }
    
    public void onActionVoltarMedicamento() {

        CadMed cm = new CadMed();
            
            try {
                cm.start(new Stage());
                VisVacina.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(VisVacinaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
}
