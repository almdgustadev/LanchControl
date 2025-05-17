package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import org.example.persistence.VendaDao;
import org.example.persistence.entity.Venda;
import org.example.service.VendaService;

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


}
