/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.biblioteca.obra;

import deltamike.scoa.model.biblioteca.obra.ObraModel;
import deltamike.scoa.repositories.biblioteca.obra.ObraRepository;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class ObraService {
    final ObraRepository obraRepository;

    public ObraService(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }
    
    @Transactional
    public ObraModel save(ObraModel obraModel){
        return this.obraRepository.saveAndFlush(obraModel);
    }
    
    @Transactional
    public void delete(ObraModel obraModel){
        this.obraRepository.delete(obraModel);
    }
    
    public List<ObraModel> getAll(){
        return this.obraRepository.findAll();
    }
    
    public Optional<ObraModel> getById(Integer id){
        return this.obraRepository.findById(id);
    }
    
    public List<ObraModel> getByTitulo(String titulo){
        return this.obraRepository.findByTitulo(titulo);
    }    
    
}
