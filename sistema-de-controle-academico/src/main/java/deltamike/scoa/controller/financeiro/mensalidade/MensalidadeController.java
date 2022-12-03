/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.financeiro.mensalidade;

import deltamike.scoa.dtos.financeiro.mensalidade.MensalidadeDTO;
import deltamike.scoa.model.financeiro.mensalidade.MensalidadeModel;
import deltamike.scoa.model.usuario.AlunoModel;
import deltamike.scoa.services.financeiro.mensalidade.MensalidadeService;
import deltamike.scoa.model.financeiro.boleto.BoletoModel;
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
@RequestMapping("/financeiro/mensalidade")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MensalidadeController {
    final MensalidadeService mensalidadeService;

    public MensalidadeController(MensalidadeService mensalidadeService) {
        this.mensalidadeService = mensalidadeService;
    }
    
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid MensalidadeDTO mensalidadeDTO ){
        MensalidadeModel mensalidadeModel = new MensalidadeModel();
        BeanUtils.copyProperties(mensalidadeDTO, mensalidadeModel);
        
        MensalidadeModel retorno = this.mensalidadeService.save(mensalidadeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id){
        Optional<MensalidadeModel> mensalidadeOptional = this.mensalidadeService.getById(id);
        
        if (mensalidadeOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mensalidade não encontrada");
        }

        MensalidadeModel mensalidadeModel = mensalidadeOptional.get();
        List<BoletoModel> boletos = mensalidadeModel.getBoletos();
        
        
        for (int i = 0; i < boletos.size(); i = i + 1){
            BoletoModel boleto;
            try {
                boleto = boletos.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            mensalidadeModel.removeBoleto(boleto);
        }
        
        this.mensalidadeService.delete(mensalidadeOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(mensalidadeOptional.get());
        
    }


    @PutMapping("/{idMensalidade}/aluno/{idAluno}")
    public ResponseEntity<Object> colocarAlunoEmMensalidade(@PathVariable Integer idMensalidade, @PathVariable Integer idAluno){
        Optional<MensalidadeModel> mensalidadeOptional = this.mensalidadeService.getById(idMensalidade);
        Optional<AlunoModel> alunoOptional = this.mensalidadeService.getAlunoService().getById(idAluno);
        
        if(mensalidadeOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mensalidade não encontrada");
        }
        
        if(alunoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        
        MensalidadeModel mensalidadeModel = mensalidadeOptional.get();
        AlunoModel alunoModel = alunoOptional.get();
        
        mensalidadeModel.setAluno(alunoModel);
        MensalidadeModel retorno = this.mensalidadeService.save(mensalidadeModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @DeleteMapping("/{idMensalidade}/aluno")
    public ResponseEntity<Object> removerAlunoDeMensalidade(@PathVariable Integer idMensalidade){
        Optional<MensalidadeModel> mensalidadeOptional = this.mensalidadeService.getById(idMensalidade);
        
        if(mensalidadeOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mensalidade não encontrada");
        }
        
        MensalidadeModel mensalidadeModel = mensalidadeOptional.get();
        
        mensalidadeModel.setAluno(null);
        MensalidadeModel retorno = this.mensalidadeService.save(mensalidadeModel);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        Optional<MensalidadeModel> mensalidadeOptional = this.mensalidadeService.getById(id);
        
        if (mensalidadeOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(mensalidadeOptional.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mensalidade não encontrada");
    }
    
    @GetMapping
    public ResponseEntity<List<MensalidadeModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.mensalidadeService.getAll());
    }
}
