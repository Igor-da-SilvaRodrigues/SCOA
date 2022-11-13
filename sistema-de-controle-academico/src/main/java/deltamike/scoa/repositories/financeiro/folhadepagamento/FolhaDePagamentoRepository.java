/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deltamike.scoa.repositories.financeiro.folhadepagamento;

import deltamike.scoa.model.financeiro.folhadepagamento.FolhaDePagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rodri
 */
public interface FolhaDePagamentoRepository extends JpaRepository<FolhaDePagamentoModel, Integer>{
    
}
