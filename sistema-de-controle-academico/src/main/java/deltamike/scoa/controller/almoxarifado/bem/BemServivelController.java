/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.bem.BemServivelModel;
import deltamike.scoa.services.almoxarifado.bem.BemServivelService;
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
@RequestMapping("/almoxarifado/item/bem/servivel")
public class BemServivelController {
    final BemServivelService bemServivelService;

    public BemServivelController(BemServivelService bemServivelService) {
        this.bemServivelService = bemServivelService;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        Optional<BemServivelModel> bemOptional = this.bemServivelService.getById(id);
        
        if(bemOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem servivel não encontrado");
        }

        this.bemServivelService.delete(bemOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(bemOptional.get());
    }
    
    @GetMapping
    public ResponseEntity<List<BemServivelModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.bemServivelService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id){
        Optional<BemServivelModel> bemOptional = this.bemServivelService.getById(id);
        
        if(bemOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem servivel não encontrado");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(bemOptional.get());
    }
}
