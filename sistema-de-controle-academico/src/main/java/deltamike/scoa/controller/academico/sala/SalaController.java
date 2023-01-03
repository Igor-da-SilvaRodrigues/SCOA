/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.academico.sala;

import deltamike.scoa.dtos.academico.sala.SalaDTO;
import deltamike.scoa.model.academico.sala.SalaModel;
import deltamike.scoa.model.academico.turma.TurmaModel;
import deltamike.scoa.services.academico.sala.SalaService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rodri
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/academico/sala")
public class SalaController {
    final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }
    
    @PostMapping
    public ResponseEntity<Object> saveSala(@RequestBody @Valid SalaDTO salaDTO){
        SalaModel salaModel  = new SalaModel();
        BeanUtils.copyProperties(salaDTO, salaModel);
        SalaModel retorno = this.salaService.save(salaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id){
        Optional<SalaModel> salaOptional = this.salaService.getById(id);
        
        if(salaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sala não encontrada");
        }
        
        SalaModel salaModel = salaOptional.get();
        
        //limpa relação sala-turma
        List<TurmaModel> turmas = salaModel.getTurmas();
        for (int i = 0; i < turmas.size(); i = i + 1){
            TurmaModel turma;
            try {
                turma = turmas.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            salaModel.removeTurma(turma);
        }
        
        
        this.salaService.delete(salaModel);
        return ResponseEntity.status(HttpStatus.OK).body(salaModel);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        Optional<SalaModel> salaOptional = this.salaService.getById(id);
        
        if(salaOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(salaOptional.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sala não encontrada");
    }
    
    @GetMapping
    public ResponseEntity<List<SalaModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.salaService.getAll());
    }
}
