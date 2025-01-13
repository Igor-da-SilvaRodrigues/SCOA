/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.usuario;

import deltamike.scoa.model.usuario.UsuarioModel;
import org.springframework.stereotype.Service;
import deltamike.scoa.repositories.usuario.UsuarioRepository;
import deltamike.scoa.services.ScoaService;

/**
 *
 * @author rodri
 */
@Service
public class UsuarioService extends ScoaService<UsuarioModel, String, UsuarioRepository>{

    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }
        
//    public boolean existsByEmail(String email){
//        return this.userRepository.existsByEmail(email);
//    }
    
//    public Optional<UsuarioModel> getByEmail(String email){
//        return this.userRepository.findByEmail(email);
//    }
    
    
}
