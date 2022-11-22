/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.usuario;

import deltamike.scoa.model.usuario.AlunoModel;
import deltamike.scoa.repositories.usuario.AlunoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class AlunoService {
    final AlunoRepository alunoRepository;
    final UsuarioService usuarioService;

    public AlunoService(AlunoRepository alunoRepository, UsuarioService usuarioService) {
        this.alunoRepository = alunoRepository;
        this.usuarioService = usuarioService;
    }
    
    
    
    @Transactional
    public AlunoModel save(AlunoModel u){        
        return this.alunoRepository.saveAndFlush(u);
    }
    
    @Transactional
    public void delete(AlunoModel u){
        this.alunoRepository.delete(u);
    }
    
    public void deleteById(Integer id){
        Optional<AlunoModel> userOptional = this.getById(id);
        
        if (userOptional.isPresent()){
            this.delete(userOptional.get());
        }
    }
    
    public boolean existsById(Integer id){
        return this.alunoRepository.existsById(id);
    }
    
    public List<AlunoModel> getAll(){
        return this.alunoRepository.findAll();
    }
    
    public Optional<AlunoModel> getById(Integer id){
        return this.alunoRepository.findById(id);
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }
 
    
}
