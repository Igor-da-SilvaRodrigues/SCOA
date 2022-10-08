/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.repositories.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.bem.BemModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rodri
 */
public interface BemRepository extends JpaRepository<BemModel, Integer>{
    
}
