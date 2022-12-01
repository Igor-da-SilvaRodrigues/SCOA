/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.usuario;

import deltamike.scoa.model.usuario.ProfessorModel;
import deltamike.scoa.repositories.usuario.ProfessorRepository;
import deltamike.scoa.services.ScoaService;

/**
 *
 * @author rodri
 */
public class ProfessorService extends ScoaService<ProfessorModel, Integer, ProfessorRepository>{
    final UsuarioService usuarioService;

    public ProfessorService(UsuarioService usuarioService, ProfessorRepository repository) {
        super(repository);
        this.usuarioService = usuarioService;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }
    
}
