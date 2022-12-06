/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.academico.turma_disciplina;

import deltamike.scoa.model.academico.turma_disciplina.TurmaDisciplinaModel;
import deltamike.scoa.repositories.academico.turma_disciplina.TurmaDisciplinaRepository;
import deltamike.scoa.services.ScoaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class TurmaDisciplinaService extends ScoaService<TurmaDisciplinaModel, Integer, TurmaDisciplinaRepository>{

    public TurmaDisciplinaService(TurmaDisciplinaRepository repository) {
        super(repository);
    }
    
}
