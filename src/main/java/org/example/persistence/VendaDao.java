package org.example.persistence;

import org.example.persistence.entity.Venda;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendaDao {

    public void adicionarVenda(final Venda venda){
        var sql = "INSERT INTO vendas(valor, data_da_venda) VALUES (?, ?)";

        try( var connection = ConnectionUtil.getConnection();
             var statement = connection.prepareStatement(sql)){

            statement.setBigDecimal(1,venda.getValor());
            statement.setDate(2,java.sql.Date.valueOf(venda.getDataDaVenda()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarVenda(final Venda venda){
        var sql = "UPDATE vendas SET valor = ? WHERE data_da_venda = ?";

        try( var connection = ConnectionUtil.getConnection();
             var statement = connection.prepareStatement(sql)){

            statement.setBigDecimal(1,venda.getValor());
            statement.setDate(2,java.sql.Date.valueOf(venda.getDataDaVenda()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarVenda(final long id){
        var sql = "DELETE FROM vendas WHERE id = ?";

        try( var connection = ConnectionUtil.getConnection();
             var statement = connection.prepareStatement(sql)){

            statement.setLong(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Venda> listarVendas(){
        List<Venda> vendas = new ArrayList<>();
        var sql = "SELECT * FROM vendas ORDER BY data_da_venda";
        try( var connection = ConnectionUtil.getConnection();
             var statement = connection.prepareStatement(sql)){

            statement.executeQuery();
            var resultSet = statement.getResultSet();
            while(resultSet.next()){
                Venda venda = new Venda();
                venda.setValor(resultSet.getBigDecimal("valor"));
                venda.setDataDaVenda(resultSet.getDate("data_da_venda").toLocalDate());
                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vendas;
    }

    public Venda findByData(final LocalDate data){
        Venda venda = new Venda();
        var sql = ("SELECT * FROM vendas WHERE data_da_venda = ?");
        try( var connection = ConnectionUtil.getConnection();
             var statement = connection.prepareStatement(sql)){
            statement.setDate(1,java.sql.Date.valueOf(data));
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            if(resultSet.next()){
                venda.setValor(resultSet.getBigDecimal("valor"));
                venda.setDataDaVenda(resultSet.getDate("data_da_venda").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return venda;
    }
}
