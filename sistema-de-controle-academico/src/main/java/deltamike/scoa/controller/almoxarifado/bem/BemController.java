/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.almoxarifado.bem;

import deltamike.scoa.dtos.almoxarifado.bem.BemNaoServivelDTO;
import deltamike.scoa.dtos.almoxarifado.bem.BemServivelDTO;
import deltamike.scoa.model.almoxarifado.bem.BemModel;
import deltamike.scoa.model.almoxarifado.bem.BemNaoServivelModel;
import deltamike.scoa.model.almoxarifado.bem.BemServivelModel;
import deltamike.scoa.services.almoxarifado.bem.BemService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/almoxarifado/bem")
public class BemController {
    final BemService bemService;

    public BemController(BemService bemService) {
        this.bemService = bemService;
    }
    
    @PostMapping("/servivel")
    public ResponseEntity<Object> saveBemServivel(@RequestBody @Valid BemServivelDTO bemDTO){
        BemServivelModel bemServivelModel = new BemServivelModel();
        BeanUtils.copyProperties(bemDTO, bemServivelModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bemService.save(bemServivelModel));
    }
    
    @PostMapping("/nao_servivel")
    public ResponseEntity<Object> saveBemNaoServivel(@RequestBody @Valid BemNaoServivelDTO bemDTO){
        BemNaoServivelModel bemNaoServivelModel = new BemNaoServivelModel();
        BeanUtils.copyProperties(bemDTO, bemNaoServivelModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bemService.save(bemNaoServivelModel));
    }
    
    @GetMapping
    public ResponseEntity<List<BemModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.bemService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getBemById(@PathVariable Integer id){
        Optional<BemModel> bemOptional = this.bemService.getById(id);
        
        if (bemOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(bemOptional.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem não encontrado");
    }
}
