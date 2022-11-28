/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.produto.ProdutoConsumivelModel;
import deltamike.scoa.services.almoxarifado.produto.ProdutoConsumivelService;
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
@RequestMapping("/almoxarifado/item/produto/consumivel")
public class ProdutoConsumivelController {
    final ProdutoConsumivelService produtoConsumivelService;

    public ProdutoConsumivelController(ProdutoConsumivelService produtoConsumivelService) {
        this.produtoConsumivelService = produtoConsumivelService;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        Optional<ProdutoConsumivelModel> produtoConsumivelOptional = this.produtoConsumivelService.getById(id);
        
        if(produtoConsumivelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto consumivel não encontrado");
        }
        
        this.produtoConsumivelService.delete(produtoConsumivelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(produtoConsumivelOptional.get());
    }
    
    @GetMapping
    public ResponseEntity<List<ProdutoConsumivelModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoConsumivelService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id){
        Optional<ProdutoConsumivelModel> produtoConsumivelOptional = this.produtoConsumivelService.getById(id);
        
        if(produtoConsumivelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto consumivel não encontrado");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(produtoConsumivelOptional.get());
    }
    
}
