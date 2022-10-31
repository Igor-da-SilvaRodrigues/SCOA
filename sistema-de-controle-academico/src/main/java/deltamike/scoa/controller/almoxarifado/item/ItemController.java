/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.almoxarifado.item;

import deltamike.scoa.dtos.almoxarifado.bem.BemDTO;
import deltamike.scoa.dtos.almoxarifado.bem.BemInservivelDTO;
import deltamike.scoa.dtos.almoxarifado.bem.BemServivelDTO;
import deltamike.scoa.dtos.almoxarifado.produto.ProdutoConsumivelDTO;
import deltamike.scoa.dtos.almoxarifado.produto.ProdutoDTO;
import deltamike.scoa.dtos.almoxarifado.produto.ProdutoNaoConsumivelDTO;
import deltamike.scoa.model.almoxarifado.bem.BemModel;
import deltamike.scoa.model.almoxarifado.bem.BemInservivelModel;
import deltamike.scoa.model.almoxarifado.bem.BemServivelModel;
import deltamike.scoa.model.almoxarifado.item.ItemModel;
import deltamike.scoa.model.almoxarifado.produto.ProdutoConsumivelModel;
import deltamike.scoa.model.almoxarifado.produto.ProdutoModel;
import deltamike.scoa.model.almoxarifado.produto.ProdutoNaoConsumivelModel;
import deltamike.scoa.services.almoxarifado.item.ItemService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import jdk.jshell.spi.ExecutionControl;
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
@RequestMapping("/almoxarifado/item")
public class ItemController {
    final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    
    @PostMapping("/bem")
    public ResponseEntity<Object> saveBem(@RequestBody @Valid BemDTO bemDTO){        
        
        //comentado porque parece não ser necessário, o spring não insere dados duplicados, e atualiza oq for necessario ao tentar inserir com um id ja existente
        //if(this.itemService.existsById(bemDTO.getNome())){
        //    return ResponseEntity.status(HttpStatus.CONFLICT).body("O bem em questão já existe");
        //}
        
        BemModel bemModel = new BemModel();
        BeanUtils.copyProperties(bemDTO, bemModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.save(bemModel));        
    }
    
    @PostMapping("/bem/servivel")
    public ResponseEntity<Object> saveBemServivel(@RequestBody @Valid BemServivelDTO bemDTO){
        BemServivelModel bemServivelModel = new BemServivelModel();
        BeanUtils.copyProperties(bemDTO, bemServivelModel);
        
        if (!(this.itemService.existsById( bemServivelModel.getNome() ))){
            //se não existe nenhum bem com o id do bem que compõe o bem servivel fornecido
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe um bem com esse nome cadastrado ainda");
            
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.getBemService().getBemServivelService().save(bemServivelModel));

    }
    
    @PostMapping("/bem/inservivel")
    public ResponseEntity<Object> saveBemNaoServivel(@RequestBody @Valid BemInservivelDTO bemDTO){
        BemInservivelModel bemInservivelModel = new BemInservivelModel();
        BeanUtils.copyProperties(bemDTO, bemInservivelModel);
        
        if (!(this.itemService.existsById(bemInservivelModel.getNome()))){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe um bem com esse nome cadastrado ainda");
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.getBemService().getBemInservivelService().save(bemInservivelModel));
    }
    
    //-------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------
    
    @PostMapping("/produto")
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDTO produtoDTO){
        ProdutoModel produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDTO,produtoModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.save(produtoModel));        
    }
    
    @PostMapping("/produto/consumivel")
    public ResponseEntity<Object> saveProdutoConsumivel(@RequestBody @Valid ProdutoConsumivelDTO produtoConsumivelDTO){
        ProdutoConsumivelModel produtoConsumivelModel = new ProdutoConsumivelModel();
        BeanUtils.copyProperties(produtoConsumivelDTO, produtoConsumivelModel);
        
        if (!(this.itemService.existsById(produtoConsumivelModel.getNome()))){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe um produto com esse nome cadastrado ainda");
        }
        
        if(!(this.itemService.getById(produtoConsumivelModel.getNome()).get() instanceof ProdutoModel)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O item em questão não é um produto, e portanto não pode ser consumivel");
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.getProdutoService().getProdutoConsumivelService().save(produtoConsumivelModel));

        
        //return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.save(produtoConsumivelModel));
    }
    @PostMapping("/produto/naoconsumivel")
    public ResponseEntity<Object> saveProdutoNaoConsumivel(@RequestBody @Valid ProdutoNaoConsumivelDTO produtoNaoConsumivelDTO){
        ProdutoNaoConsumivelModel produtoNaoConsumivelModel = new ProdutoNaoConsumivelModel();
        BeanUtils.copyProperties(produtoNaoConsumivelDTO, produtoNaoConsumivelModel);
        
        if (!(this.itemService.existsById( produtoNaoConsumivelModel.getNome() ))){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe um produto com esse nome cadastrado ainda");
        }
        
        if (!(this.itemService.getById( produtoNaoConsumivelModel.getNome() ).get() instanceof ProdutoModel)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O item em questão não é um produto, e portanto não pode ser nao consumivel");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.getProdutoService().getProdutoNaoConsumivelService().save(produtoNaoConsumivelModel));

    }
    
    @GetMapping
    public ResponseEntity<List<ItemModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.itemService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getItemById(@PathVariable String id){
        Optional<ItemModel> itemOptional = this.itemService.getById(id);
        
        if (itemOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(itemOptional.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem não encontrado");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItemById(@PathVariable String id){
        Optional<ItemModel> alvo = this.itemService.getById(id);
        
        if (alvo.isPresent()){
            this.itemService.getBemService().getBemServivelService().deleteById(alvo.get().getNome());
            this.itemService.getBemService().getBemInservivelService().deleteById(alvo.get().getNome());
            this.itemService.delete(alvo.get());
            return ResponseEntity.status(HttpStatus.OK).body(alvo.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não encontrado");
    }
    
}
