/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.academico.turma_disciplina;

import deltamike.scoa.model.academico.turma_disciplina.TurmaDisciplinaModel;
import deltamike.scoa.services.academico.turma_disciplina.TurmaDisciplinaService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rodri
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TurmaDisciplinaController {
    final TurmaDisciplinaService TurmaDisciplinaService;

    public TurmaDisciplinaController(TurmaDisciplinaService TurmaDisciplinaService) {
        this.TurmaDisciplinaService = TurmaDisciplinaService;
    }
    
    
    @GetMapping("/academico/turma/disciplina")
    public ResponseEntity<List<TurmaDisciplinaModel>> getAllTurmaDisciplina(){
        return ResponseEntity.status(HttpStatus.OK).body(this.TurmaDisciplinaService.getAll());
    }
    
    /**
     * <p>
     * Remove a entidade associativa TurmaDisciplina pelo Id
     * </p>
     * @param idTurmaDisciplina
     * @return 
     */
    @DeleteMapping("/academico/turma/disciplina/{idTurmaDisciplina}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer idTurmaDisciplina){
        Optional<TurmaDisciplinaModel> turmaOptional = this.TurmaDisciplinaService.getById(idTurmaDisciplina);
        
        if(turmaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A turma_disciplina não foi encontrada");
        }
        
        TurmaDisciplinaModel turmaDisciplinaModel = turmaOptional.get();
        
        turmaDisciplinaModel.removeAllAvaliacao();
        
        this.TurmaDisciplinaService.delete(turmaDisciplinaModel);
        
        return ResponseEntity.status(HttpStatus.OK).body(turmaDisciplinaModel);
    }
}
