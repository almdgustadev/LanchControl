package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import org.example.persistence.VendaDao;
import org.example.persistence.entity.Venda;
import org.example.service.VendaService;

import java.io.IOException;

public class TelaBuscarPorDataController {
    VendaDao vendaDao = new VendaDao();
    VendaService vendaService =  new VendaService(vendaDao);

    @FXML
    private Button button_buscarVenda;

    @FXML
    private DatePicker dataBuscaPicker;


    @FXML
    private void buscarVenda(){
        try {
            Venda venda = new Venda();
            venda = vendaDao.findByData(dataBuscaPicker.getValue());
            Alert alert =  new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Venda");
            alert.setHeaderText("Venda encontrada!");
            alert.setContentText(String.valueOf(venda));
            alert.show();
        } catch (Exception e) {
            Alert alert =  new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Venda");
            alert.setHeaderText("Venda não encontrada!");
            alert.show();
            throw new RuntimeException(e);
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
