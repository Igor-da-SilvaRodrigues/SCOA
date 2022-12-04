/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.almoxarifado.relatorio;

import deltamike.scoa.dtos.almoxarifado.relatorio.RelatorioEntradaDTO;
import deltamike.scoa.dtos.almoxarifado.relatorio.RelatorioSaidaDTO;
import deltamike.scoa.model.almoxarifado.item.ItemModel;
import deltamike.scoa.model.almoxarifado.produto.ProdutoModel;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioEntradaModel;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioSaidaModel;
import deltamike.scoa.model.usuario.FuncionarioModel;
import deltamike.scoa.services.almoxarifado.relatorio.RelatorioService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
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
@RequestMapping("/almoxarifado/relatorio")
public class RelatorioController {
    final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }
    
    @PostMapping("/entrada")
    public ResponseEntity<Object> saveRelatorioEntrada(@RequestBody @Valid RelatorioEntradaDTO relatorioEntradaDTO){
        RelatorioEntradaModel relatorioEntradaModel = new RelatorioEntradaModel();
        BeanUtils.copyProperties(relatorioEntradaDTO, relatorioEntradaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.relatorioService.save(relatorioEntradaModel));
    }
    
    @PostMapping("/saida")
    public ResponseEntity<Object> saveRelatorioSaida(@RequestBody @Valid RelatorioSaidaDTO relatorioSaidaDTO){
        RelatorioSaidaModel relatorioSaidaModel = new RelatorioSaidaModel();
        BeanUtils.copyProperties(relatorioSaidaDTO, relatorioSaidaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.relatorioService.save(relatorioSaidaModel));
    }
    
    /**
     * Relaciona um relatorio a um item do almoxarifado
     * @param idRelatorio
     * @param idItem
     * @return 
     */
    @PutMapping("/{idRelatorio}/produto/{idItem}")
    public ResponseEntity<Object> adicionarItemEmRelatorio(@PathVariable Integer idRelatorio, @PathVariable String idItem){
        Optional<RelatorioModel> relatorioOptional = this.relatorioService.getById(idRelatorio);
        Optional<ItemModel> itemOptional = this.relatorioService.getItemService().getById(idItem);
        
        if (relatorioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Relatorio não encontrado");
        }
        if (itemOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não encontrado");
        }
        
        
        RelatorioModel relatorioModel = relatorioOptional.get();
        ItemModel itemModel = itemOptional.get();
        
        relatorioModel.setItem(itemModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioService.save(relatorioModel));
        
    }
    
    @DeleteMapping("/{idRelatorio}/produto")
    public ResponseEntity<Object> removerItemDeRelatorio(@PathVariable Integer idRelatorio){
        Optional<RelatorioModel> relatorioOptional = this.relatorioService.getById(idRelatorio);
        
        if (relatorioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Relatorio não encontrado");
        }
        
        
        RelatorioModel relatorioModel = relatorioOptional.get();
        
        relatorioModel.setItem(null);
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioService.save(relatorioModel));
    }
    
    /**
     * Relaciona um relatorio a um funcionario (idealmente aquele que emitiu o relatorio)
     * @param idRelatorio
     * @param idFuncionario
     * @return 
     */
    @PutMapping("/{idRelatorio}/funcionario/{idFuncionario}")
    public ResponseEntity<Object> adicionarFuncionarioEmRelatorio(@PathVariable Integer idRelatorio, @PathVariable Integer idFuncionario){
        Optional<RelatorioModel> relatorioOptional = this.relatorioService.getById(idRelatorio);
        Optional<FuncionarioModel> funcionarioOptional = this.relatorioService.getFuncionarioService().getById(idFuncionario);
        
        if (relatorioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Relatorio não encontrado");
        }
        if (funcionarioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado");
        }
        
        RelatorioModel relatorioModel = relatorioOptional.get();
        FuncionarioModel funcionarioModel = funcionarioOptional.get();
        
        relatorioModel.setFuncionario(funcionarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioService.save(relatorioModel));
    }
    
    @DeleteMapping("/{idRelatorio}/funcionario")
    public ResponseEntity<Object> removerFuncionarioDeRelatorio(@PathVariable Integer idRelatorio){
        Optional<RelatorioModel> relatorioOptional = this.relatorioService.getById(idRelatorio);
        
        if (relatorioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Relatorio não encontrado");
        }
        
        RelatorioModel relatorioModel = relatorioOptional.get();
        
        relatorioModel.setFuncionario(null);
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioService.save(relatorioModel));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRelatorioById(@PathVariable Integer id){
        Optional<RelatorioModel> relatorioOptional = this.relatorioService.getById(id);
        
        if(relatorioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Relatorio não encontrado");
        }
        
        RelatorioModel relatorio = relatorioOptional.get();
        this.relatorioService.delete(relatorio);
        return ResponseEntity.status(HttpStatus.OK).body(relatorio);
        
    }
    
    
    @GetMapping
    public ResponseEntity<List<RelatorioModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.relatorioService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmprestimoById(@PathVariable Integer id){
        Optional<RelatorioModel> relatorioModel = this.relatorioService.getById(id);
        
        if (relatorioModel.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(relatorioModel.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emprestimo não encontrado");
    }
    
}
