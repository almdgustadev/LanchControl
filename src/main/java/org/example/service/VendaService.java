package org.example.service;

import lombok.Getter;
import org.example.persistence.VendaDao;
import org.example.persistence.entity.Venda;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VendaService {
    private final VendaDao vendaDao;

    @Getter
    private String message;


    public VendaService(VendaDao vendaDao){
        this.vendaDao = vendaDao;
    }

    public boolean salvarVenda(Venda venda){
        if (venda.getValor().compareTo(new BigDecimal("0")) < 0){
            message ="O valor da venda tem que ser maior que zero!" ;
            System.out.println(message);
            return false;
        }
        if (venda.getDataDaVenda().isAfter(LocalDate.now())){
            message ="A data da venda tem que ser menor/igual a atual!";
            System.out.println(message);
            return false;
        }
        try {
            vendaDao.adicionarVenda(venda);
            return true;
        } catch (Exception e) {
            if (e.getMessage().contains("vendas_data_da_venda_key")) {
                message = "Já existe uma venda cadastrada para essa data.";
            } else {
                message = "Erro ao salvar venda: " + e.getMessage();
            }
            e.printStackTrace();
            return false;
        }
    }


}
