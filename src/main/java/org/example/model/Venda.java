package org.example.model;

import java.util.Date;

public class Venda {
    private int id;
    private double valor;
    private Date dataDaVenda;

    public Venda(double valor, Date dataDaVenda) {
        this.valor = valor;
        this.dataDaVenda = dataDaVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
