/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.academico.avaliacao;

import deltamike.scoa.model.academico.avaliacao.AvaliacaoModel;
import deltamike.scoa.model.academico.turma_disciplina.TurmaDisciplinaModel;
import deltamike.scoa.repositories.academico.avaliacao.AvaliacaoRepository;
import deltamike.scoa.services.ScoaService;
import deltamike.scoa.services.academico.turma_disciplina.TurmaDisciplinaService;
import deltamike.scoa.services.usuario.AlunoService;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class AvaliacaoService extends ScoaService<AvaliacaoModel, Integer, AvaliacaoRepository> {
    final TurmaDisciplinaService turmaDisciplinaService;
    final AlunoService alunoService;

    public AvaliacaoService(TurmaDisciplinaService turmaDisciplinaService, AlunoService alunoService, AvaliacaoRepository repository) {
        super(repository);
        this.turmaDisciplinaService = turmaDisciplinaService;
        this.alunoService = alunoService;
    }

    public AlunoService getAlunoService() {
        return alunoService;
    }
    
    public TurmaDisciplinaService getTurmaDisciplinaService() {
        return turmaDisciplinaService;
    }
    
}
