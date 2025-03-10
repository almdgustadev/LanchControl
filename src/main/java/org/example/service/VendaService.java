package org.example.service;

import org.example.dao.VendaDAO;
import org.example.model.Venda;
import java.sql.Date;
import java.util.List;

public class VendaService {
    private VendaDAO vendaDAO;

    public VendaService(VendaDAO vendaDAO) {
        this.vendaDAO = vendaDAO;
    }

    public void adicionarVenda(Venda venda){
        if(venda.getValor() <=0 ){
            throw new IllegalArgumentException("O valor da venda deve ser maior que 0!");
        }
        vendaDAO.adicionarVenda(venda);
    }

    public List<Venda> listarVendas(){
        return vendaDAO.listarVendas();
    }

    public double calcularFaturamentoMensal(int mes, int ano){
        List<Venda> vendas =  vendaDAO.listarVendas();
        return vendas.stream()
                .filter(v -> {
                    Date data = v.getDataDaVenda();
                    return (data.toLocalDate().getMonthValue() == mes) &&
                            (data.toLocalDate().getYear() == ano);
                })
                .mapToDouble(Venda::getValor)
                .sum();

    }

    public double calcularFaturamentoAnual(int ano){
        List<Venda> vendas =  vendaDAO.listarVendas();
        return vendas.stream()
                .filter(v -> v.getDataDaVenda().toLocalDate().getYear() == ano)
                .mapToDouble(Venda::getValor)
                .sum();

    }
}
