/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deltamike.scoa.repositories.financeiro.boleto;

import deltamike.scoa.model.financeiro.boleto.BoletoModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rodri
 */
public interface BoletoRepository extends JpaRepository<BoletoModel, Integer>{
    
}
