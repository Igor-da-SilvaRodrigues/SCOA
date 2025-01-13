/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.almoxarifado.produto;

import deltamike.scoa.dtos.almoxarifado.produto.ProdutoConsumivelDTO;
import deltamike.scoa.dtos.almoxarifado.produto.ProdutoDTO;
import deltamike.scoa.dtos.almoxarifado.produto.ProdutoNaoConsumivelDTO;
import deltamike.scoa.model.almoxarifado.produto.ProdutoConsumivelModel;
import deltamike.scoa.model.almoxarifado.produto.ProdutoModel;
import deltamike.scoa.model.almoxarifado.produto.ProdutoNaoConsumivelModel;
import deltamike.scoa.services.almoxarifado.produto.ProdutoService;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rodri
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/almoxarifado/item/produto")
public class ProdutoController {
    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    
    /**
     * <p>
     * Salva o registro de um produto no banco de dados, que armazenará o inventario total do item, incluindo 
     * produtos consumíveis e não consumíveis.<br> Após a inserção, é recomendado que se crie um cadastro deste item nas 
     * tabelas de produtos consumíveis e não consumíveis, para que seja possível armazenar qual parcela deste item é servivel.
     * </p>
     * <p>
     * Não há relação automática entre produto e produto consumível (ou não-consumível), e portanto, este metodo não garante que 
     * a soma dos valores consumíveis e não-consumíveis sejam iguais ao valor cadastrado por esse método como inventario. 
     * <br> Logo, este deve ser usado para cadastrar um item e atualizar seu inventário toda vez que 
     * <ul>
     * <li>Um relatório de entrada ou saída for emitido</li>
     * <li>O valor cadastrado nas tabelas de produtos consumíveis ou não-consumíveis for atualizado</li>
     * </ul>
     * @param produtoDTO 
     * @return O produto inserido
     */
    @PostMapping()
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDTO produtoDTO){
        ProdutoModel produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDTO,produtoModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.produtoService.save(produtoModel));        
    }
    
    
    /**
     * <p>
     * Salva o registro de produtos consumiveis no banco de dados.
     * Um registro de mesmo nome deve estar cadastrado como produto, antes dessa função ser chamada
     * @param produtoConsumivelDTO 
     * @return O produto consumivel cadastrado
     */
    @PostMapping("/consumivel")
    public ResponseEntity<Object> saveProdutoConsumivel(@RequestBody @Valid ProdutoConsumivelDTO produtoConsumivelDTO){
        ProdutoConsumivelModel produtoConsumivelModel = new ProdutoConsumivelModel();
        BeanUtils.copyProperties(produtoConsumivelDTO, produtoConsumivelModel);
        
        
        /*comentando porque pode ser confuso, e parece o tipo de logica que deve
        ser implementada no front ou middleware.
        qualquer coisa é só descomentar...
        */
        //if (!(this.produtoService.existsById( produtoConsumivelModel.getNome() ))){
        //   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe um produto com esse nome cadastrado ainda");
        //}
        
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.produtoService.getProdutoConsumivelService().save(produtoConsumivelModel));

    }
    
    /**
     * <p>
     * Salva o registro de produtos não-consumiveis no banco de dados.
     * Um registro de mesmo nome deve estar cadastrado como produto, antes dessa função ser chamada
     * </p>
     * @param produtoNaoConsumivelDTO  
     * @return O produto não-consumivel cadastrado
     */
    @PostMapping("/naoconsumivel")
    public ResponseEntity<Object> saveProdutoNaoConsumivel(@RequestBody @Valid ProdutoNaoConsumivelDTO produtoNaoConsumivelDTO){
        ProdutoNaoConsumivelModel produtoNaoConsumivelModel = new ProdutoNaoConsumivelModel();
        BeanUtils.copyProperties(produtoNaoConsumivelDTO, produtoNaoConsumivelModel);
        
        
        /*comentando porque pode ser confuso, e parece o tipo de logica que deve
        ser implementada no front ou middleware.
        qualquer coisa é só descomentar...
        */
        //if(!(this.produtoService.existsById( produtoNaoConsumivelModel.getNome() ))){
        //    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe um produto com esse nome cadastrado ainda");
        //}
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.produtoService.getProdutoNaoConsumivelService().save(produtoNaoConsumivelModel));

    }
    
    /**
     * Relaciona um produto a uma entrada na tabela de produtos consumiveis
     * @param idConsumivel
     * @param idProduto
     * @return 
     */
    @PutMapping("/consumivel/{idConsumivel}/produto/{idProduto}")
    public ResponseEntity<Object> adicionarProdutoEmProdutoConsumivel(@PathVariable String idConsumivel, @PathVariable String idProduto){
        Optional<ProdutoConsumivelModel> consumivelOptional = this.produtoService.getProdutoConsumivelService().getById(idConsumivel);
        Optional<ProdutoModel> produtoOptional = this.produtoService.getById(idProduto);
        
        if (consumivelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto consumivel não encontrado");
        }
        
        if (produtoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encntrado");
        }
        
        ProdutoConsumivelModel produtoConsumivelModel = consumivelOptional.get();
        ProdutoModel produtoModel = produtoOptional.get();
        
        produtoConsumivelModel.setProdutoModel(produtoModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.getProdutoConsumivelService().save(produtoConsumivelModel));
    }
    
    @DeleteMapping("/consumivel/{idConsumivel}/produto")
    public ResponseEntity<Object> removerProdutoDeProdutoConsumivel(@PathVariable String idConsumivel){
        Optional<ProdutoConsumivelModel> consumivelOptional = this.produtoService.getProdutoConsumivelService().getById(idConsumivel);
        
        if (consumivelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto consumivel não encontrado");
        }
        
        ProdutoConsumivelModel produtoConsumivelModel = consumivelOptional.get();
        
        produtoConsumivelModel.setProdutoModel(null);
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.getProdutoConsumivelService().save(produtoConsumivelModel));
    }
    /**
     * Relaciona um produto a uma entrada na tabela de produtos não consumiveis;
     * @param idNaoConsumivel
     * @param idProduto
     * @return 
     */
    @PutMapping("/naoconsumivel/{idNaoConsumivel}/produto/{idProduto}")
    public ResponseEntity<Object> adicionarProdutoEmProdutoNaoConsumivel(@PathVariable String idNaoConsumivel, @PathVariable String idProduto){
        Optional<ProdutoNaoConsumivelModel> naoConsumivelOptional = this.produtoService.getProdutoNaoConsumivelService().getById(idNaoConsumivel);
        Optional<ProdutoModel> produtoOptional = this.produtoService.getById(idProduto);
        
        if (naoConsumivelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não consumivel não encontrado");
        }
        
        if (produtoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        
        ProdutoNaoConsumivelModel naoConsumivelModel = naoConsumivelOptional.get();
        ProdutoModel produtoModel = produtoOptional.get();
        
        naoConsumivelModel.setProdutoModel(produtoModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.getProdutoNaoConsumivelService().save(naoConsumivelModel));
    }
    
    @DeleteMapping("/naoconsumivel/{idNaoConsumivel}/produto")
    public ResponseEntity<Object> removerProdutoDeProdutoNaoConsumivel(@PathVariable String idNaoConsumivel){
        Optional<ProdutoNaoConsumivelModel> naoConsumivelOptional = this.produtoService.getProdutoNaoConsumivelService().getById(idNaoConsumivel);
        
        if (naoConsumivelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não consumivel não encontrado");
        }
        
        ProdutoNaoConsumivelModel naoConsumivelModel = naoConsumivelOptional.get();
        
        naoConsumivelModel.setProdutoModel(null);
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.getProdutoNaoConsumivelService().save(naoConsumivelModel));
    }
    
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id){
        Optional<ProdutoModel> produtoOptional = this.produtoService.getById(id);
        
        if(produtoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(produtoOptional.get());
    }
}
