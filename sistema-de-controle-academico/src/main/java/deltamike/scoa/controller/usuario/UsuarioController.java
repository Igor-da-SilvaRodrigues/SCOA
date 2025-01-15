/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.usuario;

import deltamike.scoa.dtos.usuario.UsuarioGetDto;
import deltamike.scoa.dtos.usuario.UsuarioPostDto;
import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import deltamike.scoa.model.usuario.UsuarioModel;
import deltamike.scoa.services.usuario.UsuarioService;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<UsuarioGetDto> saveUsuario(@RequestBody @Valid UsuarioPostDto usuarioDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                UsuarioGetDto.fromUsuario(
                        this.usuarioService.save(usuarioDTO.toUsuario())
                )
        );
    }
    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuarioById(@PathVariable String id){
        Optional<UsuarioModel> usuarioOptional = this.usuarioService.getById(id);
        
        if (usuarioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");              
        }

        UsuarioModel usuario = usuarioOptional.get();
        List<EmprestimoModel> emprestimos = usuario.getEmprestimos();
        //Remover as relações do usuario com emprestimo
        emprestimos.forEach(usuario::removeEmprestimo);
        
        this.usuarioService.delete(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuario); 
    }
    
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id){
        Optional<UsuarioModel> usuarioOptional = this.usuarioService.getById(id);
        
        if (usuarioOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<Object> getByEmail(@PathVariable String email){
        Optional<UsuarioModel> usuarioOptional = this.usuarioService.getById(email);
        
        if (usuarioOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
    }

}
