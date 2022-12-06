/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.academico.disciplina;

import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import deltamike.scoa.repositories.academico.disciplina.DisciplinaRepository;
import deltamike.scoa.services.ScoaService;
import deltamike.scoa.services.academico.curso.CursoService;
import deltamike.scoa.services.academico.turma_disciplina.TurmaDisciplinaService;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class DisciplinaService extends ScoaService<DisciplinaModel, Integer, DisciplinaRepository>{
    CursoService cursoService;
    TurmaDisciplinaService turmaDisciplinaService;

    public DisciplinaService(CursoService cursoService, TurmaDisciplinaService turmaDisciplinaService, DisciplinaRepository repository) {
        super(repository);
        this.cursoService = cursoService;
        this.turmaDisciplinaService = turmaDisciplinaService;
    }
    
    
    public CursoService getCursoService() {
        return cursoService;
    }

    public TurmaDisciplinaService getTurmaDisciplinaService() {
        return turmaDisciplinaService;
    }
    
    
    
}
