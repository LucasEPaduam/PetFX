/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AgendamentoDao;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Agendamento;
import petFX.ConsultaTela;
import petFX.MenuPrincipal;
import petFX.iniciarConsulta;

/**
 *
 * @author Lucas Eduardo
 */
public class IniciarConController implements Initializable {

    @FXML
    private Button btIniciarConsulta, btvoltar;
    @FXML
    private TableView<Agendamento> tvIniciarConsulta;
    @FXML
    private TableColumn<Agendamento, String> columCRMV;
    @FXML
    private TableColumn<Agendamento, String> columCodPet;
    @FXML
    private TableColumn<Agendamento, String> columDia;
    @FXML
    private TableColumn<Agendamento, String> columHorario;
    @FXML
    private TableColumn<Agendamento, String> columNomePet;
    @FXML
    private TableColumn<Agendamento, String> columNomeVet;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Iniciar Consulta inicializado!");
        iniciarTabelaAgendamentoDia();
    }

    public void iniciarTabelaAgendamentoDia() {

        columDia.setCellValueFactory(new PropertyValueFactory("dataCon"));
        columHorario.setCellValueFactory(new PropertyValueFactory("horaCon"));
        columCodPet.setCellValueFactory(new PropertyValueFactory("codigopet"));
        columNomePet.setCellValueFactory(new PropertyValueFactory("nomepet"));
        columNomeVet.setCellValueFactory(new PropertyValueFactory("nomeUser"));
        columCRMV.setCellValueFactory(new PropertyValueFactory("cpfcrmv"));
        tvIniciarConsulta.setItems(atualizaTabelaAgendamentosDia());
    }

    public ObservableList<Agendamento> atualizaTabelaAgendamentosDia() {

        AgendamentoDao ad = new AgendamentoDao();
        return FXCollections.observableArrayList(ad.getListAgendamentosDia());

    }

    public void onActionIniciarConsulta() {

        int i = tvIniciarConsulta.getSelectionModel().getSelectedIndex();
        Agendamento agendamento = tvIniciarConsulta.getItems().get(i);

        ConsultaTela c = new ConsultaTela();

        try {
            c.start(new Stage(), agendamento);
            iniciarConsulta.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void onActionVoltarMenu() {

        MenuPrincipal mp = new MenuPrincipal();

        try {
            mp.start(new Stage());
            iniciarConsulta.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
