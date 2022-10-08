/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.biblioteca.emprestimo;

import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import deltamike.scoa.repositories.biblioteca.emprestimo.EmprestimoRepository;
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
public class EmprestimoService {
    EmprestimoRepository emprestimoRepository;
    ObraService obraService;
    public EmprestimoService(EmprestimoRepository emprestimoRepository, ObraService obraService) {
        this.emprestimoRepository = emprestimoRepository;
        this.obraService = obraService;
    }
    
    @Transactional
    public EmprestimoModel save(EmprestimoModel emprestimoModel){
        return this.emprestimoRepository.saveAndFlush(emprestimoModel);
    }
    
    @Transactional
    public void delete(EmprestimoModel emprestimoModel){
        this.emprestimoRepository.delete(emprestimoModel);
    }
    
    public List<EmprestimoModel> getAll(){
        return this.emprestimoRepository.findAll();
    }
    
    public Optional<EmprestimoModel> getById(Integer id){
        return this.emprestimoRepository.findById(id);
    }

    public ObraService getObraService() {
        return obraService;
    }
    
}
