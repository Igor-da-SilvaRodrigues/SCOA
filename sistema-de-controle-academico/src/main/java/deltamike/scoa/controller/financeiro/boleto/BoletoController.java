/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.financeiro.boleto;

import deltamike.scoa.dtos.financeiro.boleto.BoletoDTO;
import deltamike.scoa.model.financeiro.boleto.BoletoModel;
import deltamike.scoa.model.financeiro.mensalidade.MensalidadeModel;
import deltamike.scoa.services.financeiro.boleto.BoletoService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.apache.catalina.connector.Response;
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
@RequestMapping("/financeiro/boleto")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BoletoController {
    final BoletoService boletoService;

    public BoletoController(BoletoService boletoService) {
        this.boletoService = boletoService;
    }
    
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid BoletoDTO boletoDTO){
        BoletoModel boletoModel = new BoletoModel();
        
        BeanUtils.copyProperties(boletoDTO, boletoModel);
        
        BoletoModel retorno = this.boletoService.save(boletoModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id){
        Optional<BoletoModel> boletoOptional = this.boletoService.getById(id);
        
        if(boletoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Boleto não encontrado");
        }
        
        BoletoModel boletoModel = boletoOptional.get();
        
        
        this.boletoService.delete(boletoModel);
        return ResponseEntity.status(HttpStatus.OK).body(boletoModel);
            
        
        
    }
    
    @PutMapping("{idBoleto}/mensalidade/{idMensalidade}")
    public ResponseEntity<Object> colocarMensalidadeEmBoleto(@PathVariable Integer idBoleto, @PathVariable Integer idMensalidade){
        Optional<BoletoModel> boletoOptional = this.boletoService.getById(idBoleto);
        Optional<MensalidadeModel> mensalidadeOptional = this.boletoService.getMensalidadeService().getById(idMensalidade);
        
        if (boletoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Boleto não encontrado");
        }
        
        if(mensalidadeOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mensalidade não encontrada");
        }
        
        BoletoModel boletoModel = boletoOptional.get();
        MensalidadeModel mensalidadeModel = mensalidadeOptional.get();
        
        boletoModel.setMensalidade(mensalidadeModel);
        
        BoletoModel retorno = this.boletoService.save(boletoModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @DeleteMapping("{idBoleto}/mensalidade")
    public ResponseEntity<Object> removerMensalidadeDeBoleto(@PathVariable Integer idBoleto){
        Optional<BoletoModel> boletoOptional = this.boletoService.getById(idBoleto);
        
        if (boletoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Boleto não encontrado");
        }
        
        BoletoModel boletoModel = boletoOptional.get();
        
        boletoModel.setMensalidade(null);
        
        BoletoModel retorno = this.boletoService.save(boletoModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        Optional<BoletoModel> boletoOptional = this.boletoService.getById(id);
        if (boletoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(boletoOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Boleto não encontrado");
    }
    
    @GetMapping
    public ResponseEntity<List<BoletoModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.boletoService.getAll());
    }
}
