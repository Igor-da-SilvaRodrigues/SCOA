/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.academico.turma;

import deltamike.scoa.dtos.academico.turma.TurmaDTO;
import deltamike.scoa.model.academico.curso.CursoModel;
import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import deltamike.scoa.model.academico.sala.SalaModel;
import deltamike.scoa.model.academico.turma.TurmaModel;
import deltamike.scoa.model.academico.turma_disciplina.TurmaDisciplinaModel;
import deltamike.scoa.model.usuario.AlunoModel;
import deltamike.scoa.services.academico.turma.TurmaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rodri
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/academico/turma")
public class TurmaController {
    final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }
    
    @PostMapping
    public ResponseEntity<Object> saveTurma(@RequestBody @Valid TurmaDTO turmaDTO){
        TurmaModel turmaModel = new TurmaModel();
        BeanUtils.copyProperties(turmaDTO, turmaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.turmaService.save(turmaModel));
    }
    
    /**
     * Relaciona uma turma e uma disciplina, sempre cria uma entidade
     * TurmaDisciplina.
     * @param idTurma
     * @param idDisciplina
     * @return 
     */
    @PutMapping("/{idTurma}/disciplina/{idDisciplina}")
    public ResponseEntity<Object> colocarDisciplinaEmTurma(@PathVariable Integer idTurma, @PathVariable Integer idDisciplina){
        Optional<TurmaModel> turmaOptional = this.turmaService.getById(idTurma);
        Optional<DisciplinaModel> disciplinaOptional = this.turmaService.getDisciplinaService().getById(idDisciplina);
    
        if(turmaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
        }
        if(disciplinaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disciplina não encontrada");
        }
        
        TurmaModel turmaModel = turmaOptional.get();
        DisciplinaModel disciplinaModel = disciplinaOptional.get();
        
        TurmaDisciplinaModel turmaDisciplinaModel = new TurmaDisciplinaModel();
        
        turmaDisciplinaModel.setDisciplina(disciplinaModel);
        turmaDisciplinaModel.setTurma(turmaModel);
        //turmaModel.addTurmaDisciplina(turmaDisciplinaModel);
        //disciplinaModel.addTurmaDisciplina(turmaDisciplinaModel);
        TurmaDisciplinaModel retorno = this.turmaService.getTurmaDisciplinaService().save(turmaDisciplinaModel);
        
        //turmaModel.addDisciplina(disciplinaModel);
        //TurmaModel retorno = this.turmaService.save(turmaModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    /**
     * <p>
     * Metodo para remover uma TurmaDisciplina se apenas o id da turma e o id
     * da disciplina forem conhecidos.
     * </p>
     * <p>
     * Para remover uma TurmaDisciplina pelo id da TurmaDisciplina use 
     * {@link deltamike.scoa.controller.academico.turma_disciplina.TurmaDisciplinaController#deleteById(java.lang.Integer) TurmaDisciplinaController.deleteById}
     * </p>
     * 
     * @param idTurma
     * @param idDisciplina
     * @return 
     */
    @DeleteMapping("/{idTurma}/disciplina/{idDisciplina}")
    public ResponseEntity<Object> removerDisciplinaDeTurma(@PathVariable Integer idTurma, @PathVariable Integer idDisciplina){
        Optional<TurmaModel> turmaOptional = this.turmaService.getById(idTurma);
        Optional<DisciplinaModel> disciplinaOptional = this.turmaService.getDisciplinaService().getById(idDisciplina);
    
        if(turmaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
        }
        if(disciplinaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disciplina não encontrada");
        }
        
        TurmaModel turmaModel = turmaOptional.get();
        DisciplinaModel disciplinaModel = disciplinaOptional.get();
        
        List<TurmaDisciplinaModel> turmaDisciplinaList = turmaModel.getTurmaDisciplinas();
        DisciplinaModel retorno = null;
        for(int i = 0; i < turmaDisciplinaList.size(); i = i + 1){
            TurmaDisciplinaModel turmaDisciplina;
            
            try {
                turmaDisciplina = turmaDisciplinaList.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            
            if(turmaDisciplina.getDisciplina().equals(disciplinaModel)){
                
                //removendo relação turmadisciplina - avaliacao
                turmaDisciplina.removeAllAvaliacao();
                
                this.turmaService.getTurmaDisciplinaService().delete(turmaDisciplina);
                retorno = disciplinaModel;
            }
        }
        
        if(retorno == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A disciplina especificada não está relacionada com a turma especificada");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @PutMapping("/{idTurma}/aluno/{idAluno}")
    public ResponseEntity<Object> colocarAlunoEmTurma(@PathVariable Integer idTurma, @PathVariable Integer idAluno){
        Optional<TurmaModel> turmaOptional = this.turmaService.getById(idTurma);
        Optional<AlunoModel> alunoOptional = this.turmaService.getAlunoService().getById(idAluno);
    
        if(turmaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
        }
        if(alunoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        
        TurmaModel turmaModel = turmaOptional.get();
        AlunoModel alunoModel = alunoOptional.get();
        
        turmaModel.addAluno(alunoModel);
        
        TurmaModel retorno = this.turmaService.save(turmaModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @DeleteMapping("/{idTurma}/aluno/{idAluno}")
    public ResponseEntity<Object> removerAlunoDeTurma(@PathVariable Integer idTurma, @PathVariable Integer idAluno){
        Optional<TurmaModel> turmaOptional = this.turmaService.getById(idTurma);
        Optional<AlunoModel> alunoOptional = this.turmaService.getAlunoService().getById(idAluno);
    
        if(turmaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
        }
        if(alunoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        
        TurmaModel turmaModel = turmaOptional.get();
        AlunoModel alunoModel = alunoOptional.get();
        
        turmaModel.removeAluno( alunoModel);
        
        TurmaModel retorno = this.turmaService.save(turmaModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @PutMapping("/{idTurma}/sala/{idSala}")
    public ResponseEntity<Object> colocarSalaEmTurma(@PathVariable Integer idTurma, @PathVariable Integer idSala){
        Optional<TurmaModel> turmaOptional = this.turmaService.getById(idTurma);
        Optional<SalaModel> salaOptional = this.turmaService.getSalaService().getById(idSala);
        
        if(turmaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
        }
        if(salaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sala não encontrada");
        }
        
        TurmaModel turmaModel = turmaOptional.get();
        SalaModel salaModel = salaOptional.get();
        
        turmaModel.setSala(salaModel);
        
        TurmaModel retorno = this.turmaService.save(turmaModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @DeleteMapping("/{idTurma}/sala")
    public ResponseEntity<Object> removerSalaDeTurma(@PathVariable Integer idTurma, @PathVariable Integer idSala){
        Optional<TurmaModel> turmaOptional = this.turmaService.getById(idTurma);
        
        if(turmaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
        }
        
        TurmaModel turmaModel = turmaOptional.get();
        turmaModel.setSala(null);
        
        TurmaModel retorno = this.turmaService.save(turmaModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
            
    @PutMapping("/{idTurma}/curso/{idCurso}")
    public ResponseEntity<Object> colocarCursoEmTurma(@PathVariable Integer idTurma, @PathVariable Integer idCurso){
        Optional<TurmaModel> turmaOptional = this.turmaService.getById(idTurma);
        Optional<CursoModel> cursoOptional = this.turmaService.getCursoService().getById(idCurso);
        
        if(turmaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
        }
        if(cursoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
        }
        
        TurmaModel turmaModel = turmaOptional.get();
        CursoModel cursoModel = cursoOptional.get();
        
        turmaModel.setCurso(cursoModel);
        
        TurmaModel retorno = this.turmaService.save(turmaModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @DeleteMapping("/{idTurma}/curso")
    public ResponseEntity<Object> removerCursoDeTurma(@PathVariable Integer idTurma){
        Optional<TurmaModel> turmaOptional = this.turmaService.getById(idTurma);
        
        if(turmaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
        }
        
        TurmaModel turmaModel = turmaOptional.get();
        turmaModel.setCurso(null);
        
        TurmaModel retorno = this.turmaService.save(turmaModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTurma(@PathVariable Integer id){
        Optional<TurmaModel> turmaOptional = this.turmaService.getById(id);
        
        if(turmaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
        }
        
        TurmaModel turmaModel = turmaOptional.get();
        List<AlunoModel> alunos = turmaModel.getAlunos();
        //List<DisciplinaModel> disciplinas = turmaModel.getDisciplinas();
        //limpa a relação turma-aluno
        for(int i = 0; i < alunos.size(); i = i + 1){
            AlunoModel aluno;
            try {
                aluno = alunos.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            
            turmaModel.removeAluno(aluno);
        }
        
        //limpa a relação turma-disciplina
        List<TurmaDisciplinaModel> turmaDisciplinas = turmaModel.getTurmaDisciplinas();
        for(int i = 0; i < turmaDisciplinas.size(); i = i + 1){
            TurmaDisciplinaModel turmaDisciplinaModel;
            try {
                turmaDisciplinaModel = turmaDisciplinas.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            //limpa a relação turmadisciplina - avaliação
            turmaDisciplinaModel.removeAllAvaliacao();
            
            this.turmaService.getTurmaDisciplinaService().delete(turmaDisciplinaModel);
        }
        
        this.turmaService.delete(turmaModel);
        return ResponseEntity.status(HttpStatus.OK).body(turmaModel);
    }
    
    /**
     * Retorna todas as disciplinas relacionadas com a turma especificada.
     * @param id
     * @return 
     */
    @GetMapping("/{id}/disciplina")
    public ResponseEntity<Object> getAllDisciplinaEmTurma(@PathVariable Integer id){
        Optional<TurmaModel> turmaOptional = this.turmaService.getById(id);
        
        if(turmaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
        }
        
        TurmaModel turmaModel = turmaOptional.get();
        
        return ResponseEntity.status(HttpStatus.OK).body(turmaModel.getDisciplinas());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        Optional<TurmaModel> turmaOptional = this.turmaService.getById(id);
        
        if(turmaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada");
        }
        
        TurmaModel turma = turmaOptional.get();
        return ResponseEntity.status(HttpStatus.OK).body(turma);
    }
    
    @GetMapping
    public ResponseEntity<List<TurmaModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.turmaService.getAll());
    }
    
}
