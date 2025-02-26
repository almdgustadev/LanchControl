package org.example.dao;

import org.example.controller.Conexao;
import org.example.model.Venda;
import org.example.exception.PersistenciaException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    private static String ADICIONAR_VENDA = "INSERT INTO VENDAS"
            + "(ID, VALOR, DATADAVENDA) "
            + " VALUES (NULL, ?, ?)";

    private static String LISTAR_VENDAS = "SELECT * FROM VENDAS WHERE 1=1";

    private static String ALTERAR_VENDA = "UPDATE VENDAS SET"
            + "VALOR = ? "
            + "WHERE ID = ?";

    public VendaDAO(){}

    public void adicionarVenda(Venda venda){
        Connection connection = Conexao.getInstance().iniciarConexao();

        String query = ADICIONAR_VENDA;
        try {
            preparedStatement = connection.prepareStatement(query);

            int i = 1;
            preparedStatement.setDouble(i++,venda.getValor());
            preparedStatement.setDate(i++, venda.getDataDaVenda());

            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            throw new PersistenciaException("Erro ao adicionar venda no banco de dados: " + e.getMessage(),e);
        }finally {
            encerrarConexao();
        }
    }

    public List<Venda> listarVendas(){
        Connection connection = Conexao.getInstance().iniciarConexao();
        List<Venda> vendas = new ArrayList<>();

        String query = LISTAR_VENDAS;
        try {
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                vendas.add( new Venda(resultSet.getInt("ID"),
                        resultSet.getDouble("VALOR"),
                        resultSet.getDate("DATADAVENDA")));
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Erro ao listar vendas: " + e.getMessage(), e);
        }finally {
            encerrarConexao();
        }
        return vendas;
    }

    public void alterarVenda(int id, Venda venda){
        Connection connection = Conexao.getInstance().iniciarConexao();

        String query = ALTERAR_VENDA;
        try {
            preparedStatement = connection.prepareStatement(query);

            int i = 1;
            preparedStatement.setDouble(i++,venda.getValor());
            preparedStatement.setDate(i++, venda.getDataDaVenda());
            preparedStatement.setInt(i++,id);

            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            throw new PersistenciaException("Erro ao alterar venda: " +e.getMessage(), e);
        }finally {
            encerrarConexao();
        }
    }


    private void encerrarConexao() {
            try {
                if (resultSet!=null){
                    resultSet.close();
                }
                if (preparedStatement!=null){
                    preparedStatement.close();
                }
                Conexao.getInstance().encerrarConexao();
            } catch (SQLException e) {
                throw new PersistenciaException(e.getMessage());
            }

    }


}
