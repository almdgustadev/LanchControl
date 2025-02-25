package org.example.controller;

import java.sql.Connection; //representa a conexão com o BD
import java.sql.DriverManager;// gerencia a conexão  JDBC
import java.sql.SQLException;// trata erros de SQL

public class Conexao {
    private static Conexao instancia;
    private static String DRIVER = "org.sqlite.JDBC";
    private static String DB = "jdbc:sqlite:src/main/resources/bdvendas.db";
    private static Connection conexao;

    private Conexao() {}

    public static Conexao getInstance(){
        if(instancia == null){
            instancia = new Conexao();
        }
            return instancia;
    }

    public Connection iniciarConexao(){
        try {
           if (conexao == null || conexao.isClosed()){
               Class.forName(DRIVER);
               conexao = DriverManager.getConnection(DB);
               conexao.setAutoCommit(false);
           }
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
