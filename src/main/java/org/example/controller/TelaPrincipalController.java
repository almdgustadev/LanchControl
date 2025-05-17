package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaPrincipalController implements Initializable {

    private void abrirTela(String caminhoFXML,ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoFXML));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button button_buscar;

    @FXML
    private Button button_cadastrar;

    @FXML
    private Button button_exportar;

    @FXML
    private Button button_vendas;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void abrirTelaCadastro(ActionEvent event) {
        abrirTela("/view/telaCadastroVenda.fxml",event);
    }

    @FXML
    void abrirTelaVenda(ActionEvent event) {
        abrirTela("/view/telaMeses.fxml",event);
    }

    @FXML
    void abrirTelaDeBusca(ActionEvent event) {
        abrirTela("/view/telaBuscarPorData.fxml",event);
    }


}
