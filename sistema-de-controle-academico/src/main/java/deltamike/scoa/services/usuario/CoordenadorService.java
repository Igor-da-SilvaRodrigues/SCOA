/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.usuario;

import deltamike.scoa.model.usuario.CoordenadorModel;
import deltamike.scoa.repositories.usuario.CoordenadorRepository;
import deltamike.scoa.services.ScoaService;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class CoordenadorService extends ScoaService<CoordenadorModel, Integer, CoordenadorRepository>{
    final UsuarioService usuarioService;

    public CoordenadorService(UsuarioService usuarioService, CoordenadorRepository repository) {
        super(repository);
        this.usuarioService = usuarioService;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }
    
    
}
