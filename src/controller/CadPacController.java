/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PacienteDao;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Paciente;
import petFX.CadPac;
import petFX.MenuPrincipal;
import petFX.VisPac;

/**
 *
 * @author Lucas Eduardo
 */
public class CadPacController implements Initializable {

    @FXML
    private Button btvoltarMenu, btok, btedit, btexclude, btlimpar, btnovo, btsalvar, btvisupac;
    @FXML
    private ImageView lupa, patavolta;
    @FXML
    private RadioButton rbCachorro, rbGato, rbOut, rbPas;
    @FXML
    private TextField tfcepd, tfcidaded, tfcod, tfcpfdono, tfemaild, tfgenero, tfidade, tfnomedono;
    @FXML
    private TextField tfnomepac, tfnumd, tfpeso, tfpesquisapac, tfraca, tfruad, tfteld, tfufd;
    @FXML
    private ToggleGroup grupo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Pacientes inicializado!");

    }

    public void Cadastrar() {

        Paciente paciente = getTextBox();
        PacienteDao pac = new PacienteDao();

        if (validaCodPet()) {

            atualizarPac(paciente);

        } else {

            if (pac.insertPac(paciente)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("PACIENTE CADASTRADO COM SUCESSO");
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText("PACIENTE NÃO CADASTRADO");
                alert.showAndWait();

            }
        }

    }

    public void atualizarPac(Paciente paciente) {

        PacienteDao pac = new PacienteDao();
        if (pac.updatePac(paciente)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("System Message");
            alert.setHeaderText("PACIENTE ATUALIZADO COM SUCESSO");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("System Message");
            alert.setHeaderText("PACIENTE NÃO ATUALIZADO");
            alert.showAndWait();
        }
    }

    public void deletePac() {

        Paciente paciente = getTextBox();
        PacienteDao pac = new PacienteDao();

        if (validaCodPet()) {
            if (pac.deletePac(paciente)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("System Message");
                alert.setHeaderText("PACIENTE EXCLUÍDO COM SUCESSO");
                alert.showAndWait();
                Limpar();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("System Message");
                alert.setHeaderText("PACIENTE NÃO EXCLUÍDO");
                alert.showAndWait();
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("System Message");
            alert.setHeaderText("PACIENTE NÃO CADASTRADO");
            alert.showAndWait();

        }
    }

    public void pesquisarPac() {

        String codpet = tfpesquisapac.getText();
        PacienteDao pac = new PacienteDao();

        Paciente paciente = pac.pesquisar(codpet);

        if (pac == null) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("System Message");
            alert.setHeaderText("PACIENTE NÃO LOCALIZADO");
            alert.showAndWait();

        } else {

            tfcod.setText(paciente.getCodigopet());
            tfnomepac.setText(paciente.getNomepet());
            tfraca.setText(paciente.getRaca());
            tfidade.setText(paciente.getIdade());
            tfpeso.setText(paciente.getPeso());
            tfgenero.setText(paciente.getSexo());
            tfcpfdono.setText(paciente.getCpfdono());
            tfnomedono.setText(paciente.getNomedono());
            tfruad.setText(paciente.getRua());
            tfnumd.setText(paciente.getNumero());
            tfcepd.setText(paciente.getCep());
            tfcidaded.setText(paciente.getCidade());
            tfufd.setText(paciente.getUF());
            tfemaild.setText(paciente.getEmail());
            tfteld.setText(paciente.getTelefone());

            if (codpet.startsWith("C") || codpet.startsWith("c")) {
                rbCachorro.setSelected(true);
            } else if (codpet.startsWith("G") || codpet.startsWith("g")) {
                rbGato.setSelected(true);
            } else if (codpet.startsWith("P") || codpet.startsWith("p")) {
                rbPas.setSelected(true);
            } else if (codpet.startsWith("O") || codpet.startsWith("o")) {
                rbOut.setSelected(true);

            }

        }

    }

    public void Limpar() {

        tfcod.setText("");
        tfnomepac.setText("");
        tfraca.setText("");
        tfidade.setText("");
        tfpeso.setText("");
        tfgenero.setText("");
        tfcpfdono.setText("");
        tfnomedono.setText("");
        tfruad.setText("");
        tfnumd.setText("");
        tfcepd.setText("");
        tfcidaded.setText("");
        tfufd.setText("");
        tfemaild.setText("");
        tfteld.setText("");
        tfpesquisapac.setText("");

    }

    private boolean validaCodPet() {

        PacienteDao pac = new PacienteDao();

        String codpet = pac.codPac(tfcod.getText());

        return codpet != null;

    }

    public void criarCodPet() {

        int min = 100;
        int max = 900;

        SecureRandom codigo = new SecureRandom();
        codigo.setSeed(new Date().getTime());
        int cod = codigo.nextInt((max - min) + 1) + min;

        if (rbCachorro.isSelected()) {

            String codpet = "C" + cod;
            tfcod.setText(codpet);

        } else if (rbGato.isSelected()) {

            String codpet = "G" + cod;
            tfcod.setText(codpet);

        } else if (rbPas.isSelected()) {

            String codpet = "P" + cod;
            tfcod.setText(codpet);
        } else if (rbOut.isSelected()) {

            String codpet = "O" + cod;
            tfcod.setText(codpet);
        }
    }

    public Paciente getTextBox() {

        String codigopet = tfcod.getText();
        String nomepet = tfnomepac.getText();
        String raca = tfraca.getText();
        String idade = tfidade.getText();
        String peso = tfpeso.getText();
        String sexo = tfgenero.getText();
        String cpfdono = tfcpfdono.getText();
        String nomedono = tfnomedono.getText();
        String rua = tfruad.getText();
        String numero = tfnumd.getText();
        String cep = tfcepd.getText();
        String cidade = tfcidaded.getText();
        String UF = tfufd.getText();
        String email = tfemaild.getText();
        String telefone = tfteld.getText();

        Paciente paciente = new Paciente(codigopet, nomepet, raca, idade, peso, sexo, cpfdono, nomedono, rua, numero, cep, cidade, UF, email, telefone);

        return paciente;
    }

    public void onActionVoltarMenu() {

        MenuPrincipal mp = new MenuPrincipal();

        try {
            mp.start(new Stage());
            CadPac.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void onActionVisPac() {

        VisPac vp = new VisPac();

        try {
            vp.start(new Stage());
            CadPac.getStage().close();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
