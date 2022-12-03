/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.usuario;

import deltamike.scoa.dtos.usuario.CoordenadorDTO;
import deltamike.scoa.model.usuario.CoordenadorModel;
import deltamike.scoa.model.usuario.UsuarioModel;
import deltamike.scoa.services.usuario.CoordenadorService;
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
@RequestMapping("/usuario/coordenador")
public class CoordenadorController {
    final CoordenadorService coordenadorService;

    public CoordenadorController(CoordenadorService coordenadorService) {
        this.coordenadorService = coordenadorService;
    }
    
    @PostMapping
    public ResponseEntity<CoordenadorModel> save(@RequestBody @Valid CoordenadorDTO coordenadorDTO){
        CoordenadorModel coordenadorModel = new CoordenadorModel();
        BeanUtils.copyProperties(coordenadorDTO, coordenadorModel);
        
        CoordenadorModel retorno = this.coordenadorService.save(coordenadorModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        Optional<CoordenadorModel> coordenadorOptional = this.coordenadorService.getById(id);
        
        if(coordenadorOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coordenador não encontrado");
        }
        
        CoordenadorModel coordenadorModel = coordenadorOptional.get();
        this.coordenadorService.delete(coordenadorModel);
        return ResponseEntity.status(HttpStatus.OK).body(coordenadorModel);
    }
    
    @PutMapping("/{idCoordenador}/usuario/{idUsuario}")
    public ResponseEntity<Object> colocarCoordenadorEmUsuario(@PathVariable Integer idCoordenador, @PathVariable String idUsuario){
        Optional<CoordenadorModel> coordenadorOptional = this.coordenadorService.getById(idCoordenador);
        Optional<UsuarioModel> usuarioOptional = this.coordenadorService.getUsuarioService().getById(idUsuario);
        
        if(coordenadorOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coordenador não encontrado");
        }
        
        if(usuarioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }
        
        CoordenadorModel coordenadorModel = coordenadorOptional.get();
        UsuarioModel usuarioModel = usuarioOptional.get();
        
        coordenadorModel.setUsuario(usuarioModel);
        
        CoordenadorModel retorno = this.coordenadorService.save(coordenadorModel);
        
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @DeleteMapping("/{idCoordenador}/usuario")
    public ResponseEntity<Object> removerCoordenadorDeUsuario(@PathVariable Integer idCoordenador){
        Optional<CoordenadorModel> coordenadorOptional = this.coordenadorService.getById(idCoordenador);
        
        if(coordenadorOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coordenador não encontrado");
        }
        
        
        CoordenadorModel coordenadorModel = coordenadorOptional.get();
        
        coordenadorModel.setUsuario(null);
        
        CoordenadorModel retorno = this.coordenadorService.save(coordenadorModel);
        
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    
    @GetMapping
    public ResponseEntity<List<CoordenadorModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.coordenadorService.getAll());
    }

    public ResponseEntity<Object> getById(Integer id) {
        Optional<CoordenadorModel> coordenadorOptional = this.coordenadorService.getById(id);
        
        if(coordenadorOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coordenador não encontrado");
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(coordenadorOptional.get());
    }
}
