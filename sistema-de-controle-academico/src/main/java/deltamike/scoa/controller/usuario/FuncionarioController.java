/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.usuario;

import deltamike.scoa.dtos.usuario.FuncionarioDTO;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import deltamike.scoa.model.financeiro.folhadepagamento.FolhaDePagamentoModel;
import deltamike.scoa.model.usuario.FuncionarioModel;
import deltamike.scoa.model.usuario.UsuarioModel;
import deltamike.scoa.services.usuario.FuncionarioService;
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
@RequestMapping("/usuario/funcionario")
public class FuncionarioController {
    final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }
    
    @PostMapping()
    public ResponseEntity<FuncionarioModel> saveFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO){
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        BeanUtils.copyProperties(funcionarioDTO, funcionarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.funcionarioService.save(funcionarioModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable @Valid Integer id){
        Optional<FuncionarioModel> funcionarioOptional = this.funcionarioService.getById(id);
        
        if(funcionarioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado");
        }
        
        FuncionarioModel funcionarioModel = funcionarioOptional.get();
        List<RelatorioModel> relatorios = funcionarioModel.getRelatorios();
        //removendo relação relatorio-funcionario
        for (int i = 0; i < relatorios.size(); i = i + 1){
            RelatorioModel relatorio;
            try {
                relatorio = relatorios.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            
            funcionarioModel.removeRelatorio(relatorio);
        }
        
        //removendo relação pagamento-funcionario
        List<FolhaDePagamentoModel> pagamentos = funcionarioModel.getPagamentos();
        for(int i = 0; i < pagamentos.size(); i = i + 1){
            FolhaDePagamentoModel pagamento;
            try {
                pagamento = pagamentos.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            
            funcionarioModel.removePagamento(pagamento);
        }
        
        this.funcionarioService.delete(funcionarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioModel);
   }
    
   @GetMapping
   public ResponseEntity<List<FuncionarioModel>> getAll(){
       return ResponseEntity.status(HttpStatus.OK).body(this.funcionarioService.getAll());
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Object> getById(@PathVariable Integer id){
       Optional<FuncionarioModel> funcionario = this.funcionarioService.getById(id);
       
       if(funcionario.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado");
       }
       
       return ResponseEntity.status(HttpStatus.OK).body(funcionario.get());
   }
    
}
