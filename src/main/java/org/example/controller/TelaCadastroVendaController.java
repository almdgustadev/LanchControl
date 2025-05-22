package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.example.persistence.VendaDao;
import org.example.persistence.entity.Venda;
import org.example.service.VendaService;

import java.io.IOException;
import java.math.BigDecimal;

public class TelaCadastroVendaController {
    VendaDao vendaDao = new VendaDao();
    VendaService vendaService =  new VendaService(vendaDao);
    @FXML
    private Button button_salvar;

    @FXML
    private DatePicker campoData;

    @FXML
    private TextField campoValor;

    @FXML
    private void validarNumeros(KeyEvent event) {
        TextField source = (TextField) event.getSource();
        String texto = source.getText();

        if (!event.getCharacter().matches("[0-9.,]")) {
            event.consume();
        }
    }

    @FXML
    void salvarVenda(ActionEvent event) {
        try {
            Venda venda = new Venda();
            venda.setDataDaVenda(campoData.getValue());
            String valorEmTexto = campoValor.getText().replace(",", ".").trim();
            BigDecimal valor = new BigDecimal(valorEmTexto);
            venda.setValor(valor);

            boolean tentativaDeCadastro = vendaService.salvarVenda(venda);
            if (tentativaDeCadastro) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Venda salva com sucesso!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(vendaService.getMessage());
                alert.showAndWait();
            }

        } catch (NumberFormatException e) {
            Alert alert =  new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Valor inválido! Digite um número válido.");
            alert.showAndWait();
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
}
