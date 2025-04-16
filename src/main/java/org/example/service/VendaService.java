package org.example.service;

import org.example.persistence.VendaDao;
import org.example.persistence.entity.Venda;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VendaService {
    private final VendaDao vendaDao;


    public VendaService(VendaDao vendaDao){
        this.vendaDao = vendaDao;
    }

    public void salvarVenda(Venda venda){
        if (venda.getValor().compareTo(new BigDecimal("0")) < 0){
            System.out.println("O valor da venda tem que ser maior que zero!");
            return;
        }
        if (venda.getDataDaVenda().getDayOfMonth() > LocalDate.now().getDayOfMonth() || venda.getDataDaVenda().getMonthValue() > LocalDate.now().getMonthValue() ||
                venda.getDataDaVenda().getYear() > LocalDate.now().getYear()){
            System.out.println("A data da venda tem que ser menor/igual a atual!");
            return;
        }
        vendaDao.adicionarVenda(venda);
    }


}
