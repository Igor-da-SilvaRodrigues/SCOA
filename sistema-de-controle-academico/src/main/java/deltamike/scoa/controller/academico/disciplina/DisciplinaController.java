/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.academico.disciplina;

import deltamike.scoa.dtos.academico.disciplina.DisciplinaDTO;
import deltamike.scoa.model.academico.curso.CursoModel;
import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import deltamike.scoa.model.academico.turma.TurmaModel;
import deltamike.scoa.services.academico.disciplina.DisciplinaService;
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
@RequestMapping("/academico/disciplina")
public class DisciplinaController {
    final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }
    
    @PostMapping
    public ResponseEntity<Object> saveDisciplina(@RequestBody @Valid DisciplinaDTO disciplinaDTO){
        DisciplinaModel disciplinaModel = new DisciplinaModel();
        BeanUtils.copyProperties(disciplinaDTO, disciplinaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.disciplinaService.save(disciplinaModel));
    }
    
    @PutMapping("/{idDisciplina}/curso/{idCurso}")
    public ResponseEntity<Object> colocarDisciplinaEmCurso(@PathVariable Integer idDisciplina, @PathVariable Integer idCurso){
        Optional<DisciplinaModel> disciplinaOptional = this.disciplinaService.getById(idDisciplina);
        Optional<CursoModel> cursoOptional = this.disciplinaService.getCursoService().getById(idCurso);
        
        if(disciplinaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("disciplina não encontrada");
        }
        
        if(cursoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("curso não encontrado");
        }
        
        DisciplinaModel disciplinaModel = disciplinaOptional.get();
        CursoModel cursoModel  = cursoOptional.get();
        
        disciplinaModel.setCurso(cursoModel);
        
        DisciplinaModel retorno = this.disciplinaService.save(disciplinaModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @DeleteMapping("/{idDisciplina}/curso")
    public ResponseEntity<Object> removerDisciplinaDeCurso(@PathVariable Integer idDisciplina){
        Optional<DisciplinaModel> disciplinaOptional = this.disciplinaService.getById(idDisciplina);
        
        if(disciplinaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("disciplina não encontrada");
        }
        
        DisciplinaModel disciplinaModel = disciplinaOptional.get();
        
        disciplinaModel.setCurso(null);
        
        DisciplinaModel retorno = this.disciplinaService.save(disciplinaModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    /*
    Por algum motivo a chamada deste metodo não está causando erro na relação 
    disciplina-turma, mesmo que a relação não esteja sendo removida manualmente.
    O controller da turma limpa a relação como o esperado,
    mas ele nunca é acionado nesta função.
    
    Talvez o spring reconheça a relação N-pra-N e faz a limpeza automaticamente,
    seria muito conveniente, mas eu duvido muito, já que em outras relações
    a limpeza manual é obrigatoria...
    
    O mesmo está acontecendo com o método deleteById de AlunoController.
    
    Vou comentar o codigo de limpeza da relação; caso esse método venha a causar
    erros no futuro (como eu acho que vai) basta descomentar pra limpar
    manualmente.
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id){
        Optional<DisciplinaModel> disciplinaOptional = this.disciplinaService.getById(id);
        
        if(disciplinaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("disciplina não encontrada");
        }
        
        DisciplinaModel disciplinaModel = disciplinaOptional.get();
//      //removendo relação disciplina-turma
//        List<TurmaModel> turmas = disciplinaModel.getTurmas();
//        for(int i = 0; i < turmas.size(); i = i + 1){
//            TurmaModel turma;
//            try {
//                turma = turmas.get(i);
//            } catch (IndexOutOfBoundsException e) {
//                break;
//            }
//            
//            disciplinaModel.removeTurma(turma);
//        }
        
        this.disciplinaService.delete(disciplinaModel);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaModel);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        Optional<DisciplinaModel> optional = this.disciplinaService.getById(id);
        
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("disciplina não encontrada");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(optional.get());
    }
    
    @GetMapping
    public ResponseEntity<List<DisciplinaModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.disciplinaService.getAll());
    }
}
