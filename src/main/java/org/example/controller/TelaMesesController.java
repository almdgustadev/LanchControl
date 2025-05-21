package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;


public class TelaMesesController  {

    private void abrirTela(String caminhoFXML, ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoFXML));
            Parent root = loader.load();

            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void voltarTela(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/telaPrincipal.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    private Button button_abr;

    @FXML
    private Button button_ago;

    @FXML
    private Button button_dez;

    @FXML
    private Button button_fev;

    @FXML
    private Button button_jan;

    @FXML
    private Button button_jul;

    @FXML
    private Button button_jun;

    @FXML
    private Button button_mai;

    @FXML
    private Button button_mar;

    @FXML
    private Button button_nov;

    @FXML
    private Button button_out;

    @FXML
    private Button button_set;

    @FXML
    private ComboBox<?> comboAno;

    @FXML
    void abrirJan(ActionEvent event) {
        abrirTela("/view/telaVendasDoMes.fxml",event);
    }

    @FXML
    void abrirFev(ActionEvent event) {
        abrirTela("/view/telaVendasDoMes.fxml",event);
    }

    @FXML
    void abrirMar(ActionEvent event) {
        abrirTela("/view/telaVendasDoMes.fxml",event);
    }

    @FXML
    void abrirAbril(ActionEvent event) {
        abrirTela("/view/telaVendasDoMes.fxml",event);
    }

    @FXML
    void abrirMaio(ActionEvent event) {
        abrirTela("/view/telaVendasDoMes.fxml",event);
    }

    @FXML
    void abrirJun(ActionEvent event) {
        abrirTela("/view/telaVendasDoMes.fxml",event);
    }

    @FXML
    void abrirJul(ActionEvent event) {
        abrirTela("/view/telaVendasDoMes.fxml",event);
    }

        @FXML
    void abrirAgo(ActionEvent event) {
            abrirTela("/view/telaVendasDoMes.fxml",event);
    }

    @FXML
    void abrirSet(ActionEvent event) {
        abrirTela("/view/telaVendasDoMes.fxml",event);
    }

    @FXML
    void abrirOut(ActionEvent event) {
        abrirTela("/view/telaVendasDoMes.fxml",event);
    }

    @FXML
    void abrirNov(ActionEvent event) {
        abrirTela("/view/telaVendasDoMes.fxml",event);
    }

    @FXML
    void abrirDez(ActionEvent event) {
        abrirTela("/view/telaVendasDoMes.fxml",event);
    }


}
