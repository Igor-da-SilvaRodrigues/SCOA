/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.academico.turno;

import deltamike.scoa.dtos.academico.turno.TurnoDTO;
import deltamike.scoa.model.academico.turno.TurnoModel;
import deltamike.scoa.services.academico.turno.TurnoService;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Estudo
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/academico/turno")
public class TurnoController {
    final TurnoService turnoService;
    
    public TurnoController(TurnoService turnoService){
        this.turnoService = turnoService;
    }
     public ResponseEntity<Object> saveTurno(@RequestBody @Valid TurnoDTO TurnoDTO){
        TurnoModel turnoModel = new TurnoModel();
        BeanUtils.copyProperties(TurnoDTO, turnoModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.turnoService.save(turnoModel));

     }
      @GetMapping
    public ResponseEntity<List<TurnoModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.turnoService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        Optional<TurnoModel> turnoOptional = this.turnoService.getById(id);
        
        if(turnoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turno não encontrado");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(turnoOptional.get());
    }
}