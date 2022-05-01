/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.RemedioDao;
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
import model.Remedio;
import petFX.CadMed;
import petFX.VisRemedio;

/**
 *
 * @author Lucas Eduardo
 */
public class VisRemedioController implements Initializable{
    
    @FXML private TableView<Remedio> TabelaCadRemedio;
    @FXML private Button btvoltarMedicamentos;
    @FXML private TableColumn<Remedio, String> columCodigo;
    @FXML private TableColumn<Remedio, String> columNome;
    @FXML private TableColumn<Remedio, String> columPreco;
    
    
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Visualizar Remedios inicializado!");
        iniciarTabelaR();
    }
    
    
    public void iniciarTabelaR(){
        
        columCodigo.setCellValueFactory(new PropertyValueFactory("codigoR"));
        columNome.setCellValueFactory(new PropertyValueFactory("nomeR"));
        columPreco.setCellValueFactory(new PropertyValueFactory("precoR"));
        
        TabelaCadRemedio.setItems(atualizaTabelaR());
    }
    
    public ObservableList<Remedio>atualizaTabelaR(){
        
        RemedioDao rd = new RemedioDao();
        return FXCollections.observableArrayList(rd.getListRemedio());
               
    }
    
    public void onActionVoltarMed() {

        CadMed cm = new CadMed();
            
            try {
                cm.start(new Stage());
                VisRemedio.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
}
