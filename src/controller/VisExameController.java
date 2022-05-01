/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ExameDao;
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
import model.Exame;
import petFX.CadExames;
import petFX.VisExame;

/**
 *
 * @author Lucas Eduardo
 */
public class VisExameController implements Initializable{
    
    @FXML private TableView<Exame> TabelaCadExame;
    @FXML private Button btvoltarExame;
    @FXML private TableColumn<Exame, String> columCodigo;
    @FXML private TableColumn<Exame, String> columNome;
    @FXML private TableColumn<Exame, String> columPreco;
    
    
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Visualizar Exames inicializado!");
        iniciarTabela();
    }
    
    
    public void iniciarTabela(){
        
        columCodigo.setCellValueFactory(new PropertyValueFactory("codigoE"));
        columNome.setCellValueFactory(new PropertyValueFactory("nomeE"));
        columPreco.setCellValueFactory(new PropertyValueFactory("precoE"));
        
        TabelaCadExame.setItems(atualizaTabela());
    }
    
    public ObservableList<Exame>atualizaTabela(){
        
        ExameDao ed = new ExameDao();
        return FXCollections.observableArrayList(ed.getList());
               
    }
    
    public void onActionVoltarExame() {

        CadExames ce = new CadExames();
            
            try {
                ce.start(new Stage());
                VisExame.getStage().close();
            }catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
}
