package org.example.persistence.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class Venda {
    private long id;
    private BigDecimal valor;
    private OffsetDateTime dataDaVenda;


}

