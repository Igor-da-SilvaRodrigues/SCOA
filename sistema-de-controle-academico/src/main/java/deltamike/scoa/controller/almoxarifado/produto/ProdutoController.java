/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.almoxarifado.produto;

import deltamike.scoa.dtos.almoxarifado.produto.ProdutoConsumivelDTO;
import deltamike.scoa.dtos.almoxarifado.produto.ProdutoNaoConsumivelDTO;
import deltamike.scoa.model.almoxarifado.produto.ProdutoConsumivelModel;
import deltamike.scoa.model.almoxarifado.produto.ProdutoModel;
import deltamike.scoa.model.almoxarifado.produto.ProdutoNaoConsumivelModel;
import deltamike.scoa.services.almoxarifado.produto.ProdutoService;
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
@RequestMapping("/almoxarifado/produto")
public class ProdutoController {
    
    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    
    @PostMapping("/consumivel")
    public ResponseEntity<Object> saveProdutoConsumivel(@RequestBody @Valid ProdutoConsumivelDTO produtoConsumivelDTO){
        ProdutoConsumivelModel produtoConsumivelModel = new ProdutoConsumivelModel();
        BeanUtils.copyProperties(produtoConsumivelDTO, produtoConsumivelModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.produtoService.save(produtoConsumivelModel));
    }
    @PostMapping("/nao_consumivel")
    public ResponseEntity<Object> saveProdutoNaoConsumivel(@RequestBody @Valid ProdutoNaoConsumivelDTO produtoNaoConsumivelDTO){
        ProdutoNaoConsumivelModel produtoNaoConsumivelModel = new ProdutoNaoConsumivelModel();
        BeanUtils.copyProperties(produtoNaoConsumivelDTO, produtoNaoConsumivelModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.produtoService.save(produtoNaoConsumivelModel));
    }
    
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProdutoById(@PathVariable Integer id){
        Optional<ProdutoModel> produtoOptional = this.produtoService.getById(id);
        
        if (produtoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(produtoOptional.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
    }
    
}
