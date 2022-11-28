/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.produto.ProdutoNaoConsumivelModel;
import deltamike.scoa.services.almoxarifado.produto.ProdutoNaoConsumivelService;
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
@RequestMapping("/almoxarifado/item/produto/naoconsumivel")
public class ProdutoNaoConsumivelController {
    final ProdutoNaoConsumivelService produtoNaoConsumivelService;

    public ProdutoNaoConsumivelController(ProdutoNaoConsumivelService service) {
        this.produtoNaoConsumivelService = service;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        Optional<ProdutoNaoConsumivelModel> produtoOptional;
        produtoOptional = this.produtoNaoConsumivelService.getById(id);
        
        if(produtoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    "Produto não-consumivel não encontrado"
            );
        }
        
        ProdutoNaoConsumivelModel produto = produtoOptional.get();
        
        this.produtoNaoConsumivelService.delete(produto);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id){
        Optional<ProdutoNaoConsumivelModel> produtoOptional;
        produtoOptional = this.produtoNaoConsumivelService.getById(id);
        
        if(produtoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    "Produto não-consumivel não encontrado"
            );
            
        }
        
        ProdutoNaoConsumivelModel produto = produtoOptional.get();
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }
    
    @GetMapping
    public ResponseEntity<List<ProdutoNaoConsumivelModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(
                this.produtoNaoConsumivelService.getAll()
        );
    }
    
}
