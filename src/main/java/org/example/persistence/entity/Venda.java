package org.example.persistence.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class Venda {
    private long id;
    private BigDecimal valor;
    private LocalDate dataDaVenda;


}

