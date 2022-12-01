/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.usuario;

import deltamike.scoa.model.usuario.AlunoModel;
import deltamike.scoa.repositories.usuario.AlunoRepository;
import deltamike.scoa.services.ScoaService;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class AlunoService extends ScoaService<AlunoModel, Integer, AlunoRepository>{
    final UsuarioService usuarioService;

    public AlunoService(UsuarioService usuarioService, AlunoRepository repository) {
        super(repository);
        this.usuarioService = usuarioService;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }
 
    
}
