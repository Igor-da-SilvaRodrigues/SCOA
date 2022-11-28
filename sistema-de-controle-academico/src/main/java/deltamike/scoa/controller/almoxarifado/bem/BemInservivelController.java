/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.bem.BemInservivelModel;
import deltamike.scoa.services.almoxarifado.bem.BemInservivelService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rodri
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/almoxarifado/item/bem/inservivel")
public class BemInservivelController {
    final BemInservivelService bemInservivelService;

    public BemInservivelController(BemInservivelService bemInservivelService) {
        this.bemInservivelService = bemInservivelService;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        Optional<BemInservivelModel> bemOptional = this.bemInservivelService.getById(id);
        
        if(bemOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bem inservivel não encontrado.");
        }
        
        this.bemInservivelService.delete(bemOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(bemOptional.get());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id){
        Optional<BemInservivelModel> bemOptional = this.bemInservivelService.getById(id);
        
        if(bemOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bem inservivel não encontrado.");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(bemOptional.get());
    }
    
    @GetMapping
    public ResponseEntity<List<BemInservivelModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.bemInservivelService.getAll());
    }
}
