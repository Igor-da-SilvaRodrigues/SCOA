/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.usuario;

import deltamike.scoa.model.usuario.FuncionarioModel;
import deltamike.scoa.repositories.usuario.FuncionarioRepository;
import deltamike.scoa.services.ScoaService;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
 @Service
public class FuncionarioService extends ScoaService<FuncionarioModel, Integer, FuncionarioRepository>{
    final UsuarioService usuarioService;

    public FuncionarioService(UsuarioService usuarioService, FuncionarioRepository repository) {
        super(repository);
        this.usuarioService = usuarioService;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }
    
    
    
}
