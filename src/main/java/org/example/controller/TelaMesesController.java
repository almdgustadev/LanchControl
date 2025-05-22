package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class TelaMesesController implements Initializable {

    private void abrirTela(String caminhoFXML,int mes, int ano,ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoFXML));
            Parent root = loader.load();

            TelaVendasDoMesController controller = loader.getController();

            controller.receberMesAno(mes,ano);

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
    private ComboBox<Integer> comboAno;


    @FXML
    void abrirJan(ActionEvent event) {
        int mes = 1;
        Integer anoSelecionado = comboAno.getValue();
        if (anoSelecionado != null) {
            abrirTela("/view/telaVendasDoMes.fxml", mes, anoSelecionado, event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione um ano antes de prosseguir");
            alert.showAndWait();        }
    }

    @FXML
    void abrirFev(ActionEvent event) {
        int mes = 2;
        Integer anoSelecionado = comboAno.getValue();
        if (anoSelecionado != null) {
            abrirTela("/view/telaVendasDoMes.fxml", mes, anoSelecionado, event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione um ano antes de prosseguir");
            alert.showAndWait();
        }
    }

    @FXML
    void abrirMar(ActionEvent event) {
        int mes = 3;
        Integer anoSelecionado = comboAno.getValue();
        if (anoSelecionado != null) {
            abrirTela("/view/telaVendasDoMes.fxml", mes, anoSelecionado, event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione um ano antes de prosseguir");
            alert.showAndWait();
        }
    }

    @FXML
    void abrirAbril(ActionEvent event) {
        int mes = 4;
        Integer anoSelecionado = comboAno.getValue();
        if (anoSelecionado != null) {
            abrirTela("/view/telaVendasDoMes.fxml", mes, anoSelecionado, event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione um ano antes de prosseguir");
            alert.showAndWait();
        }
    }

    @FXML
    void abrirMaio(ActionEvent event) {
        int mes = 5;
        Integer anoSelecionado = comboAno.getValue();
        if (anoSelecionado != null) {
            abrirTela("/view/telaVendasDoMes.fxml", mes, anoSelecionado, event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione um ano antes de prosseguir");
            alert.showAndWait();
        }
    }

    @FXML
    void abrirJun(ActionEvent event) {
        int mes = 6;
        Integer anoSelecionado = comboAno.getValue();
        if (anoSelecionado != null) {
            abrirTela("/view/telaVendasDoMes.fxml", mes, anoSelecionado, event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione um ano antes de prosseguir");
            alert.showAndWait();
        }
    }

    @FXML
    void abrirJul(ActionEvent event) {
        int mes = 7;
        Integer anoSelecionado = comboAno.getValue();
        if (anoSelecionado != null) {
            abrirTela("/view/telaVendasDoMes.fxml", mes, anoSelecionado, event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione um ano antes de prosseguir");
            alert.showAndWait();
        }
    }

        @FXML
    void abrirAgo(ActionEvent event) {
            int mes = 8;
            Integer anoSelecionado = comboAno.getValue();
            if (anoSelecionado != null) {
                abrirTela("/view/telaVendasDoMes.fxml", mes, anoSelecionado, event);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText("Selecione um ano antes de prosseguir");
                alert.showAndWait();
            }
    }

    @FXML
    void abrirSet(ActionEvent event) {
        int mes = 9;
        Integer anoSelecionado = comboAno.getValue();
        if (anoSelecionado != null) {
            abrirTela("/view/telaVendasDoMes.fxml", mes, anoSelecionado, event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione um ano antes de prosseguir");
            alert.showAndWait();
        }
    }

    @FXML
    void abrirOut(ActionEvent event) {
        int mes = 10;
        Integer anoSelecionado = comboAno.getValue();
        if (anoSelecionado != null) {
            abrirTela("/view/telaVendasDoMes.fxml", mes, anoSelecionado, event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione um ano antes de prosseguir");
            alert.showAndWait();
        }
    }

    @FXML
    void abrirNov(ActionEvent event) {
        int mes = 11;
        Integer anoSelecionado = comboAno.getValue();
        if (anoSelecionado != null) {
            abrirTela("/view/telaVendasDoMes.fxml", mes, anoSelecionado, event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione um ano antes de prosseguir");
            alert.showAndWait();
        }
    }

    @FXML
    void abrirDez(ActionEvent event) {
        int mes = 12;
        Integer anoSelecionado = comboAno.getValue();
        if (anoSelecionado != null) {
            abrirTela("/view/telaVendasDoMes.fxml", mes, anoSelecionado, event);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro");
            alert.setHeaderText("Selecione um ano antes de prosseguir");
            alert.showAndWait();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Integer> anos = FXCollections.observableArrayList();
        int anoAtual = LocalDate.now().getYear();
        for(int ano = 2000 ; ano <= anoAtual ; ano++){
            anos.add(ano);
        }
        comboAno.setItems(anos);

    }
}
