/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AgendamentoDao;
import dao.PacienteDao;
import dao.RemedioDao;
import dao.UserDao;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Agendamento;
import model.Paciente;
import model.Remedio;
import petFX.AgendamentoTela;
import petFX.CadPac;
import petFX.MenuPrincipal;
import petFX.VisPac;

/**
 *
 * @author Lucas Eduardo
 */
public class AgendamentoController implements Initializable {

    @FXML
    private Button btAgendamentos, btvoltar, btAgendar, btExcluir, btLimpar;

    @FXML
    private TextField tfDia, tfMes, tfAno;
    @FXML
    private ComboBox<String> cbCodigoPet;

    @FXML
    private ComboBox<String> cbCodigoVet;

    @FXML
    private ComboBox<String> cbHorario;

    private final List<String> listaHorarios = new ArrayList<>();
    private ObservableList<String> obsList;
    private ObservableList<String> obsListPaciente;
    private ObservableList<String> obsListVeterinario;

    @FXML
    private TableView<Agendamento> tableAgendamentos;
    @FXML
    private TableColumn<Agendamento, String> tColDia;
    @FXML
    private TableColumn<Agendamento, String> tColHor;
    @FXML
    private TableColumn<Agendamento, String> tColCodPet;
    @FXML
    private TableColumn<Agendamento, String> tColNomePet;
    @FXML
    private TableColumn<Agendamento, String> tColCodVet;
    @FXML
    private TableColumn<Agendamento, String> tColNomeVet;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Agendamento inicializado!");
        preencherComboBoxHorario();
        preencherComboBoxCodPet();
        preencherComboBoxNomeVet();
        iniciarTabela();
    }

    public void iniciarTabela() {

        tColDia.setCellValueFactory(new PropertyValueFactory("dataCon"));
        tColHor.setCellValueFactory(new PropertyValueFactory("horaCon"));
        tColCodPet.setCellValueFactory(new PropertyValueFactory("codigopet"));
        tColNomePet.setCellValueFactory(new PropertyValueFactory("nomepet"));
        tColCodVet.setCellValueFactory(new PropertyValueFactory("cpfcrmv"));
        tColNomeVet.setCellValueFactory(new PropertyValueFactory("nomeUser"));
        tableAgendamentos.setItems(atualizaTabela());
    }

    public ObservableList<Agendamento> atualizaTabela() {

        AgendamentoDao ag = new AgendamentoDao();
        return FXCollections.observableArrayList(ag.getListAgendamentos());

    }

    public void onActionVoltarMenu() {

        MenuPrincipal mp = new MenuPrincipal();

        try {
            mp.start(new Stage());
            AgendamentoTela.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Agendar() {

        if (tfDia.getText().isEmpty() || tfMes.getText().isEmpty() || tfAno.getText().isEmpty()) {

            alerta("TODOS OS CAMPOS DEVEM ESTAR PREENCHIDOS", "", Alert.AlertType.INFORMATION);

        } else if (cbCodigoPet.getValue() == null || cbCodigoVet.getValue() == null || cbHorario.getValue() == null) {

            alerta("TODOS OS CAMPOS DEVEM ESTAR PREENCHIDOS", "", Alert.AlertType.INFORMATION);
        } else {

            Agendamento agendamento = getAgendamentoTextBox();
            AgendamentoDao agendamentoDao = new AgendamentoDao();

            if (agendamentoDao.insertAgendamento(agendamento)) {

                alerta("AGENDAMENTO REALIZADO COM SUCESSO", "", Alert.AlertType.CONFIRMATION);
                limparAg();
                iniciarTabela();

            } else {
                alerta("AGENDAMENTO NÃO REALIZADO", "", Alert.AlertType.ERROR);

            }
        }
    }

    private void preencherComboBoxCodPet() {

        PacienteDao pac = new PacienteDao();
        obsListPaciente = FXCollections.observableArrayList(pac.getListCodPet());
        cbCodigoPet.setItems(obsListPaciente);

    }

    private void preencherComboBoxNomeVet() {

        UserDao user = new UserDao();
        obsListVeterinario = FXCollections.observableArrayList(user.getListCodUser());
        cbCodigoVet.setItems(obsListVeterinario);

    }

    private void preencherComboBoxHorario() {

        int hora = 7;
        String horaMinuto;
        String minuto00 = "00";
        String minuto15 = "15";
        String minuto30 = "30";
        String minuto45 = "45";

        for (int i = 0; i < 9; i++) {

            hora = hora + 1;
            horaMinuto = hora + ":" + minuto00;
            listaHorarios.add(horaMinuto);
            horaMinuto = hora + ":" + minuto15;
            listaHorarios.add(horaMinuto);
            horaMinuto = hora + ":" + minuto30;
            listaHorarios.add(horaMinuto);
            horaMinuto = hora + ":" + minuto45;
            listaHorarios.add(horaMinuto);
        }
        obsList = FXCollections.observableArrayList(listaHorarios);
        cbHorario.setItems(obsList);
    }

    public Agendamento getAgendamentoTextBox() {

        String codPet = cbCodigoPet.getValue();
        String vet = cbCodigoVet.getValue();
        String horario = cbHorario.getValue();

        String dia = tfDia.getText();
        String mes = tfMes.getText();
        String ano = "2022";

        if (dia.length() == 1) {
            dia = "0" + dia;
        }
        if (mes.length() == 1) {
            mes = "0" + mes;
        }
        String data = ano + "-" + mes + "-" + dia;

        PacienteDao pac = new PacienteDao();
        UserDao user = new UserDao();

        String nomePet = pac.pesquisarNomePet(codPet);
        String codVet = user.pesquisarCodVet(vet);

        Agendamento agendar = new Agendamento(data, horario, codPet, nomePet, codVet, vet);

        return agendar;
    }

    public Alert alerta(String header, String content, Alert.AlertType tipo) {

        Alert alert = new Alert(tipo);
        alert.setTitle("System Message");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
        return alert;
    }

    public void limparAg() {

        cbCodigoPet.setValue("");
        cbCodigoVet.setValue("");
        cbHorario.setValue("");
        tfDia.setText("");
        tfMes.setText("");
        tfAno.setText("");

    }

    public void deleteAgendamento() {

        int i = tableAgendamentos.getSelectionModel().getSelectedIndex();

        Agendamento agendamento = tableAgendamentos.getItems().get(i);
        AgendamentoDao agendamentoDao = new AgendamentoDao();

        if (agendamentoDao.deleteAgendamento(agendamento)) {
            alerta("AGENDAMENTO EXCLUÍDO COM SUCESSO", "", Alert.AlertType.CONFIRMATION);
            limparAg();
            iniciarTabela();
        } else {
            alerta("AGENDAMENTO NÃO EXCLUÍDO", "", Alert.AlertType.ERROR);
        }

    }
}
