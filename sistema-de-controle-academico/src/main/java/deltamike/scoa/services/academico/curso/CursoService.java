/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.academico.curso;

import deltamike.scoa.model.academico.curso.CursoModel;
import deltamike.scoa.repositories.academico.curso.CursoRepository;
import deltamike.scoa.services.ScoaService;
import deltamike.scoa.services.usuario.AlunoService;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class CursoService extends ScoaService<CursoModel, Integer, CursoRepository>{
    final AlunoService alunoService;

    public CursoService(AlunoService alunoService, CursoRepository repository) {
        super(repository);
        this.alunoService = alunoService;
    }

    public AlunoService getAlunoService() {
        return alunoService;
    }
    
    
}
