/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.academico.curso;

import deltamike.scoa.dtos.academico.curso.CursoDTO;
import deltamike.scoa.model.academico.curso.CursoModel;
import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import deltamike.scoa.services.academico.curso.CursoService;
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
@RequestMapping("/academico/curso")
public class CursoController {
    final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    
    @PostMapping
    public ResponseEntity<Object> saveCurso(@RequestBody @Valid CursoDTO cursoDTO){
        CursoModel cursoModel = new CursoModel();
        BeanUtils.copyProperties(cursoDTO, cursoModel);
        
        return ResponseEntity.status(HttpStatus.OK).body(this.cursoService.save(cursoModel));
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id){
        Optional<CursoModel> cursoOptional = this.cursoService.getById(id);
        
        if(cursoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
        }
        
        CursoModel cursoModel = cursoOptional.get();
        List<DisciplinaModel> disciplinas = cursoModel.getDisciplinas();
        //removendo relação disciplina-curso
        for(int i = 0; i<disciplinas.size(); i = i + 1){
            DisciplinaModel disciplina;
            
            try {
                disciplina = disciplinas.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            
            cursoModel.removeDisciplina(disciplina);
        }
        this.cursoService.delete(cursoModel);
        return ResponseEntity.status(HttpStatus.OK).body(cursoModel);
    }
    
    @GetMapping
    public ResponseEntity<List<CursoModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.cursoService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        Optional<CursoModel> cursoOptional = this.cursoService.getById(id);
        
        if(cursoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(cursoOptional.get());
    }
}
