package org.example.controller;


import org.example.model.Venda;
import org.example.service.VendaService;

import javax.swing.*;
import java.sql.Date;
import java.util.List;

public class VendaController {
    private VendaService vendaService;

    public void adicionarVenda(double valor, Date data){
        try {
            if (data.toLocalDate().isAfter(java.time.LocalDate.now())){
                JOptionPane.showMessageDialog(null, "A data da venda não pode estar no futuro!");
                return;
            }
            Venda venda =  new Venda(valor, data);
            vendaService.adicionarVenda(venda);
            JOptionPane.showMessageDialog(null,"Venda adicionada com sucesso!");
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao adicionar venda: " +  e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
        }

    }


}
