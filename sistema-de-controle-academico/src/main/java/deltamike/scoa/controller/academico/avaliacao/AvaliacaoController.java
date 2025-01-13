/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.academico.avaliacao;

import deltamike.scoa.dtos.academico.avaliacao.AvaliacaoDTO;
import deltamike.scoa.model.academico.avaliacao.AvaliacaoModel;
import deltamike.scoa.model.academico.turma_disciplina.TurmaDisciplinaModel;
import deltamike.scoa.model.usuario.AlunoModel;
import deltamike.scoa.services.academico.avaliacao.AvaliacaoService;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
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
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/academico/avaliacao")
public class AvaliacaoController {
    final AvaliacaoService AvaliacaoService;

    public AvaliacaoController(AvaliacaoService AvaliacaoService) {
        this.AvaliacaoService = AvaliacaoService;
    }
    
    
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AvaliacaoDTO avaliacaoDTO){
        AvaliacaoModel avaliacaoModel = new AvaliacaoModel();
        BeanUtils.copyProperties(avaliacaoDTO, avaliacaoModel);
        
        AvaliacaoModel retorno = this.AvaliacaoService.save(avaliacaoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    } 
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id){
        Optional<AvaliacaoModel> avaliacaoOptional = this.AvaliacaoService.getById(id);
        
        if(avaliacaoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avaliacao não encontrada");
        }
        
        AvaliacaoModel avaliacaoModel = avaliacaoOptional.get();
        //como o objeto avaliacao representa o lado N da relação, ele armazena a relação em si,
        //logo não há necessidade de remover a relação antes de apagar a avaliação,
        //pois apagando a avaliação, apaga-se tambêm a relação.
        //avaliacaoModel.removeAluno();
        //avaliacaoModel.removeTurmaDisciplina();
        
        this.AvaliacaoService.delete(avaliacaoModel);
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoModel);
    }
    
    @PutMapping("/{idAvaliacao}/turmadisciplina/{idTurmaDisciplina}")
    public ResponseEntity<Object> adicionarAvaliacaoEmTurmaDisciplina(@PathVariable Integer idAvaliacao, @PathVariable Integer idTurmaDisciplina){
        Optional<AvaliacaoModel> avaliacaoOptional = this.AvaliacaoService.getById(idAvaliacao);
        Optional<TurmaDisciplinaModel> turmaDisciplinaOptional = this.AvaliacaoService.getTurmaDisciplinaService().getById(idTurmaDisciplina);
        
        if(avaliacaoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avaliacao não encontrada");
        }
        
        if(turmaDisciplinaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma_Disciplina não encontrada");
        }
        
        AvaliacaoModel avaliacaoModel = avaliacaoOptional.get();
        TurmaDisciplinaModel turmaDisciplinaModel = turmaDisciplinaOptional.get();
        
        avaliacaoModel.setTurmaDisciplina(turmaDisciplinaModel);
        
        AvaliacaoModel retorno = this.AvaliacaoService.save(avaliacaoModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @DeleteMapping("/{idAvaliacao}/turmadisciplina/")
    public ResponseEntity<Object> removerAvaliacaoDeTurmaDisciplina(@PathVariable Integer idAvaliacao){
        Optional<AvaliacaoModel> avaliacaoOptional = this.AvaliacaoService.getById(idAvaliacao);
        
        if(avaliacaoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avaliacao não encontrada");
        }
                
        AvaliacaoModel avaliacaoModel = avaliacaoOptional.get();
        
        avaliacaoModel.setTurmaDisciplina(null);
        
        AvaliacaoModel retorno = this.AvaliacaoService.save(avaliacaoModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @PutMapping("/{idAvaliacao}/aluno/{idAluno}")
    public ResponseEntity<Object> adicionarAlunoEmAvaliacao(@PathVariable Integer idAvaliacao, @PathVariable Integer idAluno){
        Optional<AvaliacaoModel> avaliacaoOptional = this.AvaliacaoService.getById(idAvaliacao);
        Optional<AlunoModel> alunoOptional = this.AvaliacaoService.getAlunoService().getById(idAluno);
        
        if(avaliacaoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("avaliação não encontrada");
        }
        
        if(alunoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("aluno não encontrado");
        }
        
        AvaliacaoModel avaliacaoModel = avaliacaoOptional.get();
        AlunoModel alunoModel = alunoOptional.get();
        
        avaliacaoModel.setAluno(alunoModel);
        
        AvaliacaoModel retorno = this.AvaliacaoService.save(avaliacaoModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @DeleteMapping("/{idAvaliacao}/aluno")
    public ResponseEntity<Object> removerAlunoDeAvaliacao(@PathVariable Integer idAvaliacao){
        Optional<AvaliacaoModel> avaliacaoOptional = this.AvaliacaoService.getById(idAvaliacao);
        
        if(avaliacaoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("avaliação não encontrada");
        }
        
        AvaliacaoModel avaliacaoModel = avaliacaoOptional.get();
        
        avaliacaoModel.setAluno(null);
        
        AvaliacaoModel retorno = this.AvaliacaoService.save(avaliacaoModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        Optional<AvaliacaoModel> avaliacaoOptional = this.AvaliacaoService.getById(id);
        
        if(avaliacaoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avaliacao não encontrada");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoOptional.get());
    }
    
    @GetMapping
    public ResponseEntity<List<AvaliacaoModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.AvaliacaoService.getAll());
    }
}
    

