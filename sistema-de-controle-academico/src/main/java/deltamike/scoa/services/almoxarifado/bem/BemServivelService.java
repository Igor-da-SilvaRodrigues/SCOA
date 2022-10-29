/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.bem.BemModel;
import deltamike.scoa.model.almoxarifado.bem.BemServivelModel;
import deltamike.scoa.repositories.almoxarifado.bem.BemServivelRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class BemServivelService {
    BemServivelRepository bemServivelRepository;

    public BemServivelService(BemServivelRepository bemServivelRepository) {
        this.bemServivelRepository = bemServivelRepository;
    }
    
    @Transactional
    public BemServivelModel save(BemServivelModel bemServivelModel){
        return this.bemServivelRepository.saveAndFlush(bemServivelModel);
    }
    
    
}
