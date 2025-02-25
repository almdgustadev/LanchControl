package org.example.model;

import java.sql.Date;

public class Venda {
    private Integer id;
    private double valor;
    private Date dataDaVenda;

    public Venda(Integer id, double valor, Date dataDaVenda) {
        this.id = id;
        this.valor = valor;
        this.dataDaVenda = dataDaVenda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(Date dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }
}
