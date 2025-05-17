package org.example.persistence.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class Venda {
    private long id;
    private BigDecimal valor;
    private LocalDate dataDaVenda;

    @Override
    public String toString() {
        if (dataDaVenda.getDayOfMonth()<10 && dataDaVenda.getMonthValue()<10 ){
            return "Valor: R$ " + valor +
                    " \nData da venda: 0" + dataDaVenda.getDayOfMonth()+"/0"+dataDaVenda.getMonthValue()+"/"+dataDaVenda.getYear();
        }
        if (dataDaVenda.getDayOfMonth()<10 ){
            return "Valor: R$ " + valor +
                    " \nData da venda: 0" + dataDaVenda.getDayOfMonth()+"/"+dataDaVenda.getMonthValue()+"/"+dataDaVenda.getYear();
        }
        if (dataDaVenda.getMonthValue()<10){
            return "Valor: R$ " + valor +
                    " \nData da venda: " + dataDaVenda.getDayOfMonth()+"/0"+dataDaVenda.getMonthValue()+"/"+dataDaVenda.getYear();
        }
        return "Valor: R$ " + valor +
                " \nData da venda: " + dataDaVenda.getDayOfMonth()+"/"+dataDaVenda.getMonthValue()+"/"+dataDaVenda.getYear();
    }
}
