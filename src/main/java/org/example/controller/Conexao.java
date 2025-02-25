package org.example.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Conexao instancia;
    private static String DRIVER = "org.sqlite.JDBC";
    private static String DB = "jdbc:sqlite:resources/bdvendas.db";
    private static Connection conexao;
    public Conexao() {}

    private static Conexao getInstance(){
        if(instancia == null){
            instancia = new Conexao();
        }
            return instancia;
    }

    public Connection iniciarConexao(){
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(DB);
            conexao.setAutoCommit(false);
        } catch (SQLException  | ClassNotFoundException e) {
            System.out.println("ERRO AO CONECTAR COM BANCOS DE DADOS"+e.getMessage());
        }
        return conexao;
    }

    public void encerrarConexao(){
        try {
            if (conexao!= null && !conexao.isClosed()){
                conexao.close();
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO ENCERRAR CONEXÃO" + e.getMessage());
        }finally {
            conexao = null;
        }
    }
}
