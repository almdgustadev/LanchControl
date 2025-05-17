package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.example.exception.PersistenciaException;
import org.example.persistence.VendaDao;
import org.example.persistence.entity.Venda;
import org.example.service.VendaService;

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

            vendaService.salvarVenda(venda);
            if (vendaService.salvarVenda(venda)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Venda salva com sucesso!");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(vendaService.getMessage());
                alert.show();
            }

        } catch (NumberFormatException e) {
            Alert alert =  new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Valor inválido! Digite um número válido.");
            alert.show();
        }


    }

}
