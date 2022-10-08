/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.bem.BemModel;
import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import deltamike.scoa.repositories.almoxarifado.bem.BemRepository;
import deltamike.scoa.services.biblioteca.obra.ObraService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class BemService {
    BemRepository bemRepository;

    public BemService(BemRepository bemRepository) {
        this.bemRepository = bemRepository;
    }
    
    @Transactional
    public BemModel save(BemModel bemModel){
        return this.bemRepository.saveAndFlush(bemModel);
    }
    
    @Transactional
    public void delete(BemModel bemModel){
        this.bemRepository.delete(bemModel);
    }
    
    public List<BemModel> getAll(){
        return this.bemRepository.findAll();
    }
    
    public Optional<BemModel> getById(Integer id){
        return this.bemRepository.findById(id);
    }
}
