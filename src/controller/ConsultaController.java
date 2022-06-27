/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AgendamentoDao;
import dao.ConsultaDao;
import dao.ExameDao;
import dao.PacienteDao;
import dao.RemedioDao;
import dao.VacinaDao;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Agendamento;
import model.Consulta;
import model.Paciente;
import petFX.ConsultaTela;
import petFX.MenuPrincipal;
import petFX.iniciarConsulta;

/**
 *
 * @author Lucas Eduardo
 */
public class ConsultaController implements Initializable {

    private Agendamento agendamento;
    private final List<String> listaV = new ArrayList<>();
    private final List<String> listaR = new ArrayList<>();
    private final List<String> listaE = new ArrayList<>();
    private ObservableList<String> obsListVacina;
    private ObservableList<String> obsListRemedio;
    private ObservableList<String> obsListExame;
    private String remedio1 = "", remedio2 = "", remedio3 = "";
    private String vacina1 = "", vacina2 = "", vacina3 = "";
    private String exame1 = "", exame2 = "", exame3 = "";
    private String obs, idade, peso, codigopet, nomepet, raca, datacon, horacon, cpf, user;

    public ConsultaController(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    PacienteDao paciente = new PacienteDao();
    Paciente pac;

    @FXML
    private Button btIniciarConsulta, btvoltar;
    @FXML
    private Button btAdicionarE, btAdicionarR, btAdicionarV, btFinalizar, btRemover;

    @FXML
    private ListView<String> lvVacina;
    @FXML
    private ListView<String> lvRemedio;
    @FXML
    private ListView<String> lvExame;

    @FXML
    private TextField tfCodPet, tfIdade, tfNomePet, tfRaca, tfPeso;

    @FXML
    private ComboBox<String> cbExames;
    @FXML
    private ComboBox<String> cbRemedios;
    @FXML
    private ComboBox<String> cbVacinas;

    @FXML
    private TableView<String> tabelaMedicamentos;
    @FXML
    private TableColumn<String, String> colExame;
    @FXML
    private TableColumn<String, String> colRemedio;
    @FXML
    private TableColumn<String, String> colVacina;

    @FXML
    private TextArea tArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Iniciar Consulta inicializado!");
        pac = paciente.pesquisar(agendamento.getCodigopet());
        tfCodPet.setText(pac.getCodigopet());
        tfNomePet.setText(pac.getNomepet());
        tfRaca.setText(pac.getRaca());
        tfIdade.setText(pac.getIdade());
        preencherComboBoxCodVacina();
        preencherComboBoxCodRemedio();
        preencherComboBoxCodExame();
    }

    public void onActionVoltarIC() {

        iniciarConsulta ic = new iniciarConsulta();

        try {
            ic.start(new Stage());
            ConsultaTela.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void preencherComboBoxCodVacina() {

        VacinaDao vac = new VacinaDao();
        obsListVacina = FXCollections.observableArrayList(vac.getListNomeVacinas());
        cbVacinas.setItems(obsListVacina);

    }

    private void preencherComboBoxCodRemedio() {

        RemedioDao rem = new RemedioDao();
        obsListRemedio = FXCollections.observableArrayList(rem.getListNomeRemedios());
        cbRemedios.setItems(obsListRemedio);

    }

    private void preencherComboBoxCodExame() {

        ExameDao ex = new ExameDao();
        obsListExame = FXCollections.observableArrayList(ex.getListNomeExames());
        cbExames.setItems(obsListExame);

    }

    public void adicionarV() {

        listaV.add(cbVacinas.getValue());
        lvVacina.getItems().add(cbVacinas.getValue());
    }

    public void adicionarR() {
        listaR.add(cbRemedios.getValue());
        lvRemedio.getItems().add(cbRemedios.getValue());
    }

    public void adicionarE() {
        listaE.add(cbExames.getValue());
        lvExame.getItems().add(cbExames.getValue());
    }

    public void removerV() {

        listaV.remove(cbVacinas.getValue());
        lvVacina.getItems().remove(cbVacinas.getValue());
    }

    public void removerR() {
        listaR.remove(cbRemedios.getValue());
        lvRemedio.getItems().remove(cbRemedios.getValue());
    }

    public void removerE() {
        listaE.remove(cbExames.getValue());
        lvExame.getItems().remove(cbExames.getValue());
    }

    public void finalizarConsulta() {

        Consulta consulta = criarObjetoConsulta();
        ConsultaDao consultaDao = new ConsultaDao();

        if (consultaDao.insertConsulta(consulta)) {

            alerta("CONSULTA FINALIZADA COM SUCESSO", "", Alert.AlertType.CONFIRMATION);
            onActionVoltarMenu();

        } else {
            alerta("ERRO AO FINALIZAR CONSULTA", "", Alert.AlertType.ERROR);

        }

    }

    public Alert alerta(String header, String content, Alert.AlertType tipo) {

        Alert alert = new Alert(tipo);
        alert.setTitle("System Message");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
        return alert;
    }

    public Consulta criarObjetoConsulta() {

        if (!listaR.isEmpty()) {

            switch (listaR.size()) {
                case 1:
                    remedio1 = listaR.get(0);
                    break;
                case 2:
                    remedio1 = listaR.get(0);
                    remedio2 = listaR.get(1);
                    break;
                default:
                    remedio1 = listaR.get(0);
                    remedio2 = listaR.get(1);
                    remedio3 = listaR.get(2);
                    break;
            }

        }

        if (!listaV.isEmpty()) {

            switch (listaV.size()) {
                case 1:
                    vacina1 = listaV.get(0);
                    break;
                case 2:
                    vacina1 = listaV.get(0);
                    vacina2 = listaV.get(1);
                    break;
                default:
                    vacina1 = listaV.get(0);
                    vacina2 = listaV.get(1);
                    vacina3 = listaV.get(2);
                    break;
            }

        }

        if (!listaE.isEmpty()) {

            switch (listaE.size()) {
                case 1:
                    exame1 = listaE.get(0);
                    break;
                case 2:
                    exame1 = listaE.get(0);
                    exame2 = listaE.get(1);
                    break;
                default:
                    exame1 = listaE.get(0);
                    exame2 = listaE.get(1);
                    exame3 = listaE.get(2);
                    break;
            }

        }

        obs = tArea.getText();
        peso = tfPeso.getText();
        codigopet = tfCodPet.getText();
        nomepet = tfNomePet.getText();
        raca = tfRaca.getText();
        idade = tfIdade.getText();
        datacon = agendamento.getDataCon();
        horacon = agendamento.getHoraCon();
        cpf = agendamento.getCpfcrmv();
        user = agendamento.getNomeUser();

        Consulta con = new Consulta(datacon, horacon, codigopet, nomepet, cpf,
                user, peso, idade, obs, vacina1, vacina2, vacina3, remedio1,
                remedio2, remedio3, exame1, exame2, exame3);

        return con;
    }

    public void onActionVoltarMenu() {

        MenuPrincipal mp = new MenuPrincipal();

        try {
            mp.start(new Stage());
            ConsultaTela.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}