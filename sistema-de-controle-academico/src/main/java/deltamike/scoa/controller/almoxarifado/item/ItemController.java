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
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
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
@RequestMapping("/almoxarifado/item")
public class ItemController {
    final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    
        
    //-------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------
    
    
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
    @PostMapping("/produto")
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDTO produtoDTO){
        ProdutoModel produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDTO,produtoModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.save(produtoModel));        
    }
    
    
    /**
     * <p>
     * Salva o registro de produtos consumiveis no banco de dados.
     * Um registro de mesmo nome deve estar cadastrado como produto, antes dessa função ser chamada
     * @param produtoConsumivelDTO 
     * @return O produto consumivel cadastrado
     */
    @PostMapping("/produto/consumivel")
    public ResponseEntity<Object> saveProdutoConsumivel(@RequestBody @Valid ProdutoConsumivelDTO produtoConsumivelDTO){
        ProdutoConsumivelModel produtoConsumivelModel = new ProdutoConsumivelModel();
        BeanUtils.copyProperties(produtoConsumivelDTO, produtoConsumivelModel);
        
        if (!(this.itemService.getProdutoService().existsById( produtoConsumivelModel.getNome() ))){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe um produto com esse nome cadastrado ainda");
        }
        
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.getProdutoService().getProdutoConsumivelService().save(produtoConsumivelModel));

    }
    
    /**
     * <p>
     * Salva o registro de produtos não-consumiveis no banco de dados.
     * Um registro de mesmo nome deve estar cadastrado como produto, antes dessa função ser chamada
     * </p>
     * @param produtoNaoConsumivelDTO  
     * @return O produto não-consumivel cadastrado
     */
    @PostMapping("/produto/naoconsumivel")
    public ResponseEntity<Object> saveProdutoNaoConsumivel(@RequestBody @Valid ProdutoNaoConsumivelDTO produtoNaoConsumivelDTO){
        ProdutoNaoConsumivelModel produtoNaoConsumivelModel = new ProdutoNaoConsumivelModel();
        BeanUtils.copyProperties(produtoNaoConsumivelDTO, produtoNaoConsumivelModel);
        
        if(!(this.itemService.getProdutoService().existsById( produtoNaoConsumivelModel.getNome() ))){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe um produto com esse nome cadastrado ainda");
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.getProdutoService().getProdutoNaoConsumivelService().save(produtoNaoConsumivelModel));

    }
    
    /**
     * Relaciona um produto a uma entrada na tabela de produtos consumiveis
     * @param idConsumivel
     * @param idProduto
     * @return 
     */
    @PutMapping("/produto/consumivel/{idConsumivel}/produto/{idProduto}")
    public ResponseEntity<Object> adicionarProdutoEmProdutoConsumivel(@PathVariable String idConsumivel, @PathVariable String idProduto){
        Optional<ProdutoConsumivelModel> consumivelOptional = this.itemService.getProdutoService().getProdutoConsumivelService().getById(idConsumivel);
        Optional<ProdutoModel> produtoOptional = this.itemService.getProdutoService().getById(idProduto);
        
        if (consumivelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto consumivel não encontrado");
        }
        
        if (produtoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encntrado");
        }
        
        ProdutoConsumivelModel produtoConsumivelModel = consumivelOptional.get();
        ProdutoModel produtoModel = produtoOptional.get();
        
        produtoConsumivelModel.setProdutoModel(produtoModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.itemService.getProdutoService().getProdutoConsumivelService().save(produtoConsumivelModel));
    }
    
    /**
     * Relaciona um produto a uma entrada na tabela de produtos não consumiveis;
     * @param idNaoConsumivel
     * @param idProduto
     * @return 
     */
    @PutMapping("/produto/naoconsumivel/{idNaoConsumivel}/produto/{idProduto}")
    public ResponseEntity<Object> adicionarProdutoEmProdutoNaoConsumivel(@PathVariable String idNaoConsumivel, @PathVariable String idProduto){
        Optional<ProdutoNaoConsumivelModel> naoConsumivelOptional = this.itemService.getProdutoService().getProdutoNaoConsumivelService().getById(idNaoConsumivel);
        Optional<ProdutoModel> produtoOptional = this.itemService.getProdutoService().getById(idProduto);
        
        if (naoConsumivelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não consumivel não encontrado");
        }
        
        if (produtoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        
        ProdutoNaoConsumivelModel naoConsumivelModel = naoConsumivelOptional.get();
        ProdutoModel produtoModel = produtoOptional.get();
        
        naoConsumivelModel.setProdutoModel(produtoModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.itemService.getProdutoService().getProdutoNaoConsumivelService().save(naoConsumivelModel));
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
    
    /**
     * <p>
     * Chamar esse método causa a exclusão dos registros do item.
     * </p>
     * <p>
     * As relações de bem com bem servível e inservível, e de produto com 
     * produto inservível também serão excluídas.
     * </p>
     *
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItemById(@PathVariable String id){
        Optional<ItemModel> alvo = this.itemService.getById(id);
        
        if (alvo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não encontrado");
        
        }
        
        ItemModel item = alvo.get();
        List<RelatorioModel> relatorios = item.getRelatorios();
        //remover as relações do item com os relatorios
        for (int i = 0; i < relatorios.size(); i = i + 1){
            RelatorioModel relatorio;
            
            try {
                relatorio = relatorios.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            
            item.removeRelatorio(relatorio);
        }
        
//        if(item instanceof BemModel){
//            this.itemService.getBemService().getBemServivelService().deleteById(item.getNome());
//            this.itemService.getBemService().getBemInservivelService().deleteById(item.getNome());
//        }
        
        if(item instanceof ProdutoModel){
            this.itemService.getProdutoService().getProdutoConsumivelService().deleteById(item.getNome());
            this.itemService.getProdutoService().getProdutoNaoConsumivelService().deleteById(item.getNome());
        }


        this.itemService.delete(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
}
