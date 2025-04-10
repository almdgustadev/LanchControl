package org.example;




import org.example.persistence.VendaDao;
import org.example.persistence.entity.Venda;
import org.flywaydb.core.Flyway;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Main {

    private final static VendaDao vendaDao =  new VendaDao();

    public static void main(String[] args) {
      /* var flyway = Flyway.configure()
               .dataSource("jdbc:postgresql://localhost:5432/LanchControl", "postgres","1234567")
               .load();
        flyway.migrate();*/


      /*var venda = new Venda();
      venda.setValor(new BigDecimal("300"));
      venda.setDataDaVenda(LocalDate.parse("2025-02-21"));
      vendaDao.adicionarVenda(venda);
      System.out.println(venda);*/

       //vendaDao.listarVendas().forEach(System.out::println);

       //System.out.println(vendaDao.findByData(LocalDate.parse("2025-02-21")));

        /*var venda = new Venda();
        venda.setValor(new BigDecimal("1500"));
        venda.setDataDaVenda(LocalDate.parse("2025-02-21"));
        vendaDao.alterarVenda(venda);*/

        vendaDao.deletarVenda(1);
    }



}