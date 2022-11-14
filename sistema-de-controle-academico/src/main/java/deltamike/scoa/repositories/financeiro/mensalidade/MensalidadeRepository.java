/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deltamike.scoa.repositories.financeiro.mensalidade;

import deltamike.scoa.model.financeiro.mensalidade.MensalidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rodri
 */
public interface MensalidadeRepository extends JpaRepository<MensalidadeModel, Integer>{
    
}
