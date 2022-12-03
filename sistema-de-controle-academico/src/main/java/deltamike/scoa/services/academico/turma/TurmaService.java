/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.academico.turma;

import deltamike.scoa.model.academico.turma.TurmaModel;
import deltamike.scoa.repositories.academico.turma.TurmaRepository;
import deltamike.scoa.services.ScoaService;
import deltamike.scoa.services.academico.curso.CursoService;
import deltamike.scoa.services.academico.disciplina.DisciplinaService;
import deltamike.scoa.services.academico.sala.SalaService;
import deltamike.scoa.services.usuario.AlunoService;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class TurmaService extends ScoaService<TurmaModel, Integer, TurmaRepository>{
    final DisciplinaService disciplinaService;
    final AlunoService alunoService;
    final SalaService salaService;
    final CursoService cursoService;

    public TurmaService(DisciplinaService disciplinaService, AlunoService alunoService, SalaService salaService, CursoService cursoService, TurmaRepository repository) {
        super(repository);
        this.disciplinaService = disciplinaService;
        this.alunoService = alunoService;
        this.salaService = salaService;
        this.cursoService = cursoService;
    }

    

    public DisciplinaService getDisciplinaService() {
        return disciplinaService;
    }

    public AlunoService getAlunoService() {
        return alunoService;
    }

    public SalaService getSalaService() {
        return salaService;
    }

    public CursoService getCursoService() {
        return cursoService;
    }
    
    
}
