/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petFX;

import controller.ConsultaController;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Agendamento;

/**
 *
 * @author Lucas Eduardo
 */
public class ConsultaTela extends Application {

    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage, Agendamento agendamento) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Consulta.fxml"));
        loader.setController(new ConsultaController(agendamento));
        Parent root = loader.load();
        stage.setTitle("Consulta");
        stage.setScene(new Scene(root));
        stage.show();
        setStage(stage);

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {

        ConsultaTela.stage = stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
