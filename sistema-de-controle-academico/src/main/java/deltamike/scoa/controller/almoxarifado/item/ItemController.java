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
    
    /**
     * <p>
     * Salva o registro de um bem no banco de dados, que armazenará o inventario total do item, incluindo 
     * bens serviveis e inserviveis.<br> Após a inserção, é recomendado que se crie um cadastro deste item nas 
     * tabelas de bens serviveis e inserviveis, para que seja possivel armazenar qual parcela deste item é servivel.
     * </p>
     * <p>
     * Não há relação automática entre bem e bem servivel (ou inservivel), e portanto, este método não garante que 
     * a soma dos valores serviveis e inserviveis sejam iguais ao valor cadastrado por esse método como inventario. 
     * <br> Logo, esse método deve ser usado para cadastrar um item e atualizar seu inventário toda vez que 
     * <ul>
     * <li>Um relatorio de entrada ou saída for emitido</li>
     * <li>O valor cadastrado nas tabelas de bens serviveis ou inserviveis for atualizado</li>
     * </ul>
     * @param bemDTO
     * @return O bem inserido
     */
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
    
    /**
     * <p>
     * Salva o registro de bens serviveis no banco de dados.
     * Um registro de mesmo nome deve estar cadastrado como bem, antes dessa função ser chamada
     * @param bemDTO
     * @return O bem servivel cadastrado
     */
    @PostMapping("/bem/servivel")
    public ResponseEntity<Object> saveBemServivel(@RequestBody @Valid BemServivelDTO bemDTO){
        BemServivelModel bemServivelModel = new BemServivelModel();
        BeanUtils.copyProperties(bemDTO, bemServivelModel);
        
        if (!(this.itemService.existsById( bemServivelModel.getNome() ))){
            //se não existe nenhum bem com o id do bem que compõe o bem servivel fornecido
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe um bem com esse nome cadastrado ainda");
        }
        
        if(!(this.itemService.getById(bemServivelModel.getNome()).get() instanceof BemModel)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O item em questão não é um bem, e portanto não pode ser servivel");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.getBemService().getBemServivelService().save(bemServivelModel));

    }
    
    /**
     * <p>
     * Salva o registro de bens inserviveis no banco de dados.
     * Um registro de mesmo nome deve estar cadastrado como bem, antes dessa função ser chamada
     * @param bemDTO
     * @return O bem inservivel cadastrado
     */
    @PostMapping("/bem/inservivel")
    public ResponseEntity<Object> saveBemInservivel(@RequestBody @Valid BemInservivelDTO bemDTO){
        BemInservivelModel bemInservivelModel = new BemInservivelModel();
        BeanUtils.copyProperties(bemDTO, bemInservivelModel);
        
        if (!(this.itemService.existsById(bemInservivelModel.getNome()))){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe um bem com esse nome cadastrado ainda");
        }
        
        if(!(this.itemService.getById(bemInservivelModel.getNome()).get() instanceof BemModel)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("O item em questão não é um bem, e portanto não pode ser inservivel");
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.itemService.getBemService().getBemInservivelService().save(bemInservivelModel));
    }
    
    //-------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------
    
    
    /**
     * <p>
     * Salva o registro de um bem no banco de dados, que armazenará o inventario total do item, incluindo 
     * bens serviveis e inserviveis.<br> Após a inserção, é recomendado que se crie um cadastro deste item nas 
     * tabelas de bens serviveis e inserviveis, para que seja possivel armazenar qual parcela deste item é servivel.
     * </p>
     * <p>
     * Não há relação automática entre bem e bem servivel (ou inservivel), e portanto, este método não garante que 
     * a soma dos valores serviveis e inserviveis sejam iguais ao valor cadastrado por esse método como inventario. 
     * <br> Logo, esse método deve ser usado para cadastrar um item e atualizar seu inventário toda vez que 
     * <ul>
     * <li>Um relatorio de entrada ou saída for emitido</li>
     * <li>O valor cadastrado nas tabelas de bens serviveis ou inserviveis for atualizado</li>
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
    
    @PutMapping("/bem/servivel/{idServivel}/bem/{idBem}")
    public ResponseEntity<Object> adicionarBemEmBemServivel(@PathVariable String idServivel, @PathVariable String idBem){
        Optional<BemServivelModel> servivelOptional = this.itemService.getBemService().getBemServivelService().getById(idServivel);
        Optional<BemModel> bemOptional = this.itemService.getBemService().getById(idBem);
        
        if (servivelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem Servivel não encontrado");
        }
        
        if (bemOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem não encontrado");
        }
        
        BemServivelModel bemServivelModel = servivelOptional.get();
        BemModel bemModel = bemOptional.get();
        
        bemServivelModel.setBem(bemModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.itemService.getBemService().getBemServivelService().save(bemServivelModel));
    }
        
    @PutMapping("/bem/inservivel/{idInservivel}/bem/{idBem}")
    public ResponseEntity<Object> adicionarBemEmBemInservivel(@PathVariable String idInservivel, @PathVariable String idBem){
        Optional<BemInservivelModel> inservivelOptional = this.itemService.getBemService().getBemInservivelService().getById(idInservivel);
        Optional<BemModel> bemOptional = this.itemService.getBemService().getById(idBem);
        
        if (inservivelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem Inservivel não encontrado");
        }
        
        if (bemOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem não encontrado");
        }
        
        BemInservivelModel bemInservivelModel = inservivelOptional.get();
        BemModel bemModel = bemOptional.get();
        
        bemInservivelModel.setBem(bemModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.itemService.getBemService().getBemInservivelService().)
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
