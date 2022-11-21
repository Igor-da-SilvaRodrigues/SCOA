/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.usuario;

import deltamike.scoa.model.usuario.UsuarioModel;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import deltamike.scoa.repositories.usuario.UsuarioRepository;
import deltamike.scoa.services.biblioteca.emprestimo.EmprestimoService;

/**
 *
 * @author rodri
 */
@Service
public class UsuarioService {
    UsuarioRepository userRepository;


    public UsuarioService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    

    
    @Transactional
    public UsuarioModel save(UsuarioModel u){
        return this.userRepository.saveAndFlush(u);
    }
    
    @Transactional
    public void delete(UsuarioModel u){
        this.userRepository.delete(u);
    }
    
    public void deleteById(String id){
        Optional<UsuarioModel> userOptional = this.getById(id);
        
        if (userOptional.isPresent()){
            this.delete(userOptional.get());
        }
    }
    
    public boolean existsById(String id){
        return this.userRepository.existsById(id);
    }
    
//    public boolean existsByEmail(String email){
//        return this.userRepository.existsByEmail(email);
//    }
    
    public List<UsuarioModel> getAll(){
        return this.userRepository.findAll();
    }
    
    public Optional<UsuarioModel> getById(String id){
        return this.userRepository.findById(id);
    }
    
//    public Optional<UsuarioModel> getByEmail(String email){
//        return this.userRepository.findByEmail(email);
//    }
    
    
}
