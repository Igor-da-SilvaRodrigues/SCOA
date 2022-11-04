/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.usuario;

import deltamike.scoa.dtos.usuario.FuncionarioDTO;
import deltamike.scoa.dtos.usuario.UsuarioDTO;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import deltamike.scoa.model.usuario.FuncionarioModel;
import deltamike.scoa.model.usuario.UsuarioModel;
import deltamike.scoa.services.usuario.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {
    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @PostMapping
    public ResponseEntity<UsuarioModel> saveUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        UsuarioModel usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuarioModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.save(usuarioModel));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuarioById(@PathVariable Integer id){
        Optional<UsuarioModel> usuarioOptional = this.usuarioService.getById(id);
        
        if (usuarioOptional.isPresent()){
            this.usuarioService.delete(usuarioOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.get());        
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
    }
    
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        Optional<UsuarioModel> usuarioOptional = this.usuarioService.getById(id);
        
        if (usuarioOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<Object> getByEmail(@PathVariable String email){
        Optional<UsuarioModel> usuarioOptional = this.usuarioService.getByEmail(email);
        
        if (usuarioOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
    }

}
