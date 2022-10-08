/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.biblioteca.obra;

import deltamike.scoa.dtos.biblioteca.obra.ArtigoDTO;
import deltamike.scoa.model.biblioteca.obra.ArtigoModel;
import deltamike.scoa.model.biblioteca.obra.ObraModel;
import deltamike.scoa.services.biblioteca.obra.ObraService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/biblioteca/obra")
public class ObraController {
    final ObraService obraService;

    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }
    
    @PostMapping("/artigo")
    public ResponseEntity<Object> saveArtigo(@RequestBody @Valid ArtigoDTO artigoDTO){
        ArtigoModel artigo = new ArtigoModel();
        BeanUtils.copyProperties(artigoDTO, artigo);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.obraService.save(artigo));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getObraById(@PathVariable Integer id){
        Optional<ObraModel> obraOptional = this.obraService.getById(id);
        if (obraOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(obraOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Obra não encontrada");
    }
    
    @GetMapping
    public ResponseEntity<List<ObraModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.obraService.getAll());
    }
}
