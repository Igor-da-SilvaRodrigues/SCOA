/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.bem.BemModel;
import deltamike.scoa.model.almoxarifado.bem.BemServivelModel;
import deltamike.scoa.repositories.almoxarifado.bem.BemRepository;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class BemService {
    BemRepository bemRepository;
    BemServivelService bemServivelService;
    BemInservivelService bemInservivelService;

    public BemService(BemRepository bemRepository, BemServivelService bemServivelService, BemInservivelService bemInservivelService) {
        this.bemRepository = bemRepository;
        this.bemServivelService = bemServivelService;
        this.bemInservivelService = bemInservivelService;
    }
    
    @Transactional
    public BemModel save(BemModel bemModel){
        return this.bemRepository.saveAndFlush(bemModel);
    }
    
    @Transactional
    public void delete(BemModel bemModel){
        this.bemRepository.delete(bemModel);
    }
    
    public boolean existsById(String id){
        return this.bemRepository.existsById(id);
    }
    
    public List<BemModel> getAll(){
        return this.bemRepository.findAll();
    }
    
    public Optional<BemModel> getById(String id){
        return this.bemRepository.findById(id);
    }

    public BemServivelService getBemServivelService() {
        return bemServivelService;
    }

    public BemInservivelService getBemInservivelService() {
        return bemInservivelService;
    }

    public void setBemServivelService(BemServivelService bemServivelService) {
        this.bemServivelService = bemServivelService;
    }

    public void setBemInservivelService(BemInservivelService bemInservivelService) {
        this.bemInservivelService = bemInservivelService;
    }
    
    
}
