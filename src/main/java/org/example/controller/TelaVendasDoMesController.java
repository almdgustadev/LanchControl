package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.persistence.VendaDao;
import org.example.persistence.entity.Venda;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TelaVendasDoMesController implements Initializable {
    //AQUI VAI VIR A FUNCAO DE EDITR A VENDAR E DELETAR

    private int mesSelecionado;
    private int anoSelecionado;
    @FXML
    private Button button_voltar;

    @FXML
    private TableColumn<Venda, String> colunaData;

    @FXML
    private TableColumn<Venda, BigDecimal> colunaValor;

    @FXML
    private Label labelTitulo;

    @FXML
    private TableView<Venda> tabelaVendas;

    public void receberMesAno(int mes, int ano) {
        this.mesSelecionado = mes;
        this.anoSelecionado = ano;

        labelTitulo.setText("Vendas de " + nomeMes(mesSelecionado) + " de " + anoSelecionado);

        carregarDadosTabela();
    }

    private String nomeMes(int mes) {
        String[] meses = {
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };
        if (mes >= 1 && mes <= 12) {
            return meses[mes - 1];
        }
        return "";
    }

    @FXML
    void voltarTela(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/telaMeses.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colunaData.setCellValueFactory(new PropertyValueFactory<>("dataDaVenda"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

    }

    private void carregarDadosTabela() {
        VendaDao vendaDao = new VendaDao();
        List<Venda> listaVendas = vendaDao.listarPorMesEAno(mesSelecionado,anoSelecionado);

        ObservableList<Venda> vendasObservable = FXCollections.observableArrayList(listaVendas);

        tabelaVendas.setItems(vendasObservable);
    }
}
