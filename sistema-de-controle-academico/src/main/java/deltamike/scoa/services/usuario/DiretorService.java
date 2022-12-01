/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.usuario;

import deltamike.scoa.model.usuario.DiretorModel;
import deltamike.scoa.repositories.usuario.DiretorRepository;
import deltamike.scoa.services.ScoaService;

/**
 *
 * @author rodri
 */
public class DiretorService extends ScoaService<DiretorModel, Integer, DiretorRepository>{
    final UsuarioService usuarioService;

    public DiretorService(UsuarioService usuarioService, DiretorRepository repository) {
        super(repository);
        this.usuarioService = usuarioService;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }
    
    
}
