/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.biblioteca.emprestimo;

import deltamike.scoa.dtos.biblioteca.emprestimo.EmprestimoDTO;
import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import deltamike.scoa.model.biblioteca.obra.ObraModel;
import deltamike.scoa.model.usuario.UsuarioModel;
import deltamike.scoa.services.biblioteca.emprestimo.EmprestimoService;
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
@RequestMapping("/biblioteca/emprestimo")
public class EmprestimoController {
    final EmprestimoService emprestimoService;
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }
    
    @PostMapping
    public ResponseEntity<Object> saveEmprestimo(@RequestBody @Valid EmprestimoDTO emprestimoDTO){
        EmprestimoModel emprestimoModel = new EmprestimoModel();
        BeanUtils.copyProperties(emprestimoDTO, emprestimoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.emprestimoService.save(emprestimoModel));
    }
    
    /**
     * Relaciona um emprestimo a uma obra
     * @param idEmprestimo
     * @param idObra
     * @return 
     */
    @PutMapping("/{idEmprestimo}/obra/{idObra}")
    public ResponseEntity<Object> adicionarObraEmEmprestimo(@PathVariable Integer idEmprestimo, @PathVariable Integer idObra){
        Optional<EmprestimoModel> emprestimoOptional = this.emprestimoService.getById(idEmprestimo);
        Optional<ObraModel> obraOptional = this.emprestimoService.getObraService().getById(idObra);
        
        if (emprestimoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emprestimo não encontrado");
        }
        
        if (obraOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Obra não encontrada");
        }
               
        EmprestimoModel emprestimoModel = emprestimoOptional.get();
        ObraModel obraModel = obraOptional.get();

        List<ObraModel> obras = emprestimoModel.getObras();
        if(!obras.contains(obraModel)){
            obras.add(obraModel);
        }
        
        emprestimoModel.setObras(obras);
        return ResponseEntity.status(HttpStatus.OK).body(this.emprestimoService.save(emprestimoModel));
    }
    
    @DeleteMapping("/{idEmprestimo}/obra/{idObra}")
    public ResponseEntity<Object> removerObraDeEmprestimo(@PathVariable Integer idEmprestimo, @PathVariable Integer idObra){
        Optional<EmprestimoModel> emprestimoOptional = this.emprestimoService.getById(idEmprestimo);
        Optional<ObraModel> obraOptional = this.emprestimoService.getObraService().getById(idObra);
        
        if (emprestimoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emprestimo não encontrado");
        }
        
        if (obraOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Obra não encontrada");
        }
        
        EmprestimoModel emprestimoModel = emprestimoOptional.get();
        ObraModel obraModel = obraOptional.get();

        emprestimoModel.removeObra(obraModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.emprestimoService.save(emprestimoModel));
    }
    
    @PutMapping("/{idEmprestimo}/usuario/{idUsuario}")
    public ResponseEntity<Object> adicionarUsuarioEmEmprestimo(@PathVariable Integer idEmprestimo, @PathVariable String idUsuario){
        Optional<EmprestimoModel> emprestimoOptional = this.emprestimoService.getById(idEmprestimo);
        Optional<UsuarioModel> usuarioOptional = this.emprestimoService.getUsuarioService().getById(idUsuario);
        
        if (emprestimoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emprestimo não encontrado");
        }
        
        if (usuarioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }
        
        EmprestimoModel emprestimoModel = emprestimoOptional.get();
        UsuarioModel usuarioModel = usuarioOptional.get();
        
        emprestimoModel.setUser(usuarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(this.emprestimoService.save(emprestimoModel));
    }
    
    @DeleteMapping("/{idEmprestimo}/usuario")
    public ResponseEntity<Object> removerUsuarioDeEmprestimo(@PathVariable Integer idEmprestimo){
        Optional<EmprestimoModel> emprestimoOptional = this.emprestimoService.getById(idEmprestimo);
        
        if (emprestimoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emprestimo não encontrado");
        }
        
        EmprestimoModel emprestimoModel = emprestimoOptional.get();
        
        emprestimoModel.setUser(null);
        return ResponseEntity.status(HttpStatus.OK).body(this.emprestimoService.save(emprestimoModel));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id){
        Optional<EmprestimoModel> emprestimoOptional = this.emprestimoService.getById(id);
        
        if(emprestimoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emprestimo não encontrado");
        }
                
        EmprestimoModel emprestimoModel = emprestimoOptional.get();
        List<ObraModel> obras = emprestimoModel.getObras();
        
        for (int i = 0; i < obras.size(); i = i + 1){
            ObraModel obra;
            try {
                obra = obras.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            
            emprestimoModel.removeObra(obra);
        }
        
        this.emprestimoService.delete(emprestimoModel);
        return ResponseEntity.status(HttpStatus.OK).body(emprestimoModel);
    }
    
    
    @GetMapping
    public ResponseEntity<List<EmprestimoModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.emprestimoService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmprestimoById(@PathVariable Integer id){
        Optional<EmprestimoModel> emprestimoOptional = this.emprestimoService.getById(id);
        
        if (emprestimoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(emprestimoOptional.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emprestimo não encontrado");
    }
}
