/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.almoxarifado.bem;

import deltamike.scoa.dtos.almoxarifado.bem.BemDTO;
import deltamike.scoa.dtos.almoxarifado.bem.BemInservivelDTO;
import deltamike.scoa.dtos.almoxarifado.bem.BemServivelDTO;
import deltamike.scoa.model.almoxarifado.bem.BemInservivelModel;
import deltamike.scoa.model.almoxarifado.bem.BemModel;
import deltamike.scoa.model.almoxarifado.bem.BemServivelModel;
import deltamike.scoa.services.almoxarifado.bem.BemService;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/almoxarifado/item/bem")
public class BemController {
    final BemService bemService;

    public BemController(BemService bemService) {
        this.bemService = bemService;
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
    @PostMapping
    public ResponseEntity<Object> saveBem(@RequestBody @Valid BemDTO bemDTO){        
        //comentado porque parece não ser necessário, o spring não insere dados duplicados, e atualiza oq for necessario ao tentar inserir com um id ja existente
        //if(this.itemService.existsById(bemDTO.getNome())){
        //    return ResponseEntity.status(HttpStatus.CONFLICT).body("O bem em questão já existe");
        //}
        
        BemModel bemModel = new BemModel();
        BeanUtils.copyProperties(bemDTO, bemModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bemService.save(bemModel));        
    }
    
    /**
     * <p>
     * Salva o registro de bens serviveis no banco de dados.
     * Um registro de mesmo nome deve estar cadastrado como bem, antes dessa função ser chamada
     * @param bemDTO
     * @return O bem servivel cadastrado
     */
    @PostMapping("/servivel")
    public ResponseEntity<Object> saveBemServivel(@RequestBody @Valid BemServivelDTO bemDTO){
        BemServivelModel bemServivelModel = new BemServivelModel();
        BeanUtils.copyProperties(bemDTO, bemServivelModel);
        
        if (!(this.bemService.existsById( bemServivelModel.getNome() ))){
            //se não existe nenhum bem com o id do bem que compõe o bem servivel fornecido
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe um bem com esse nome cadastrado ainda");
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bemService.getBemServivelService().save(bemServivelModel));
    }
    
    /**
     * <p>
     * Salva o registro de bens inserviveis no banco de dados.
     * Um registro de mesmo nome deve estar cadastrado como bem, antes dessa função ser chamada
     * @param bemDTO
     * @return O bem inservivel cadastrado
     */
    @PostMapping("/inservivel")
    public ResponseEntity<Object> saveBemInservivel(@RequestBody @Valid BemInservivelDTO bemDTO){
        BemInservivelModel bemInservivelModel = new BemInservivelModel();
        BeanUtils.copyProperties(bemDTO, bemInservivelModel);
        
        if (!(this.bemService.existsById( bemInservivelModel.getNome() ))){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe um bem com esse nome cadastrado ainda");
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bemService.getBemInservivelService().save(bemInservivelModel));
    }
    
    /**
     * Relaciona um bem a uma entrada na tabela de bens serviveis
     * @param idServivel
     * @param idBem
     * @return 
     */
    @PutMapping("/servivel/{idServivel}/bem/{idBem}")
    public ResponseEntity<Object> adicionarBemEmBemServivel(@PathVariable String idServivel, @PathVariable String idBem){
        Optional<BemServivelModel> servivelOptional = this.bemService.getBemServivelService().getById(idServivel);
        Optional<BemModel> bemOptional = this.bemService.getById(idBem);
        
        if (servivelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem Servivel não encontrado, com nome: " + idServivel);
        }
        
        if (bemOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem não encontrado");
        }
        
        BemServivelModel bemServivelModel = servivelOptional.get();
        BemModel bemModel = bemOptional.get();
        
        bemServivelModel.setBem(bemModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.bemService.getBemServivelService().save(bemServivelModel));
    }
    
    /**
     * Relaciona um bem a uma entrada na tabela de bens inserviveis
     * @param idInservivel
     * @param idBem
     * @return 
     */
    @PutMapping("/inservivel/{idInservivel}/bem/{idBem}")
    public ResponseEntity<Object> adicionarBemEmBemInservivel(@PathVariable String idInservivel, @PathVariable String idBem){
        Optional<BemInservivelModel> inservivelOptional = this.bemService.getBemInservivelService().getById(idInservivel);
        Optional<BemModel> bemOptional = this.bemService.getById(idBem);
        
        if (inservivelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem Inservivel não encontrado");
        }
        
        if (bemOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem não encontrado");
        }
        
        BemInservivelModel bemInservivelModel = inservivelOptional.get();
        BemModel bemModel = bemOptional.get();
        
        bemInservivelModel.setBem(bemModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.bemService.getBemInservivelService().save(bemInservivelModel));
    }
    /**
     * <p>Retorna todos os bens</p>
     */
    @GetMapping
    public ResponseEntity<List<BemModel>> getAll(){
        return this.bemService.getAll();
    }
    
}
