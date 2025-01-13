/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.bem.BemInservivelModel;
import deltamike.scoa.model.almoxarifado.bem.BemServivelModel;
import deltamike.scoa.repositories.almoxarifado.bem.BemInservivelRepository;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class BemInservivelService {
    BemInservivelRepository bemInservivelRepository;

    public BemInservivelService(BemInservivelRepository bemInservivelRepository) {
        this.bemInservivelRepository = bemInservivelRepository;
    }
    
    @Transactional
    public BemInservivelModel save(BemInservivelModel bemInservivelModel){
        return this.bemInservivelRepository.saveAndFlush(bemInservivelModel);
    }
    
    @Transactional
    public void delete(BemInservivelModel bemInservivelModel){
        this.bemInservivelRepository.delete(bemInservivelModel);
    }
    
    public void deleteById(String id){
        Optional<BemInservivelModel> bemOptional = this.getById(id);
        
        if (bemOptional.isPresent()){
            this.delete(bemOptional.get());
        }
    }
    
    public List<BemInservivelModel> getAll(){
        return this.bemInservivelRepository.findAll();
    }
    
    public Optional<BemInservivelModel> getById(String id){
        return this.bemInservivelRepository.findById(id);
    }
}
