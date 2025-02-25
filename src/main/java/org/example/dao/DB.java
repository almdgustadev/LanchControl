package org.example.dao;

import org.example.controller.Conexao;

import java.sql.Connection;

public class DB {
    private static Connection connection = null;

    public static void main(String[] args) {
        try {
            connection = Conexao.getInstance().iniciarConexao();
            System.out.println("Banco criado com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
