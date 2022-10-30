/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.bem.BemModel;
import deltamike.scoa.model.almoxarifado.bem.BemServivelModel;
import deltamike.scoa.repositories.almoxarifado.bem.BemServivelRepository;
import java.util.List;
import java.util.Optional;
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
    
    @Transactional
    public void delete(BemServivelModel bemServivelModel){
        this.bemServivelRepository.delete(bemServivelModel);
    }
    
    public void deleteById(String id){
        Optional<BemServivelModel> bemOptional = this.getById(id);
        
        if (bemOptional.isPresent()){
            this.delete(bemOptional.get());
        }
    }
    
    public List<BemServivelModel> getAll(){
        return this.bemServivelRepository.findAll();
    }    
    
    public Optional<BemServivelModel> getById(String id){
        return this.bemServivelRepository.findById(id);
    }
    
}
