/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.usuario;

import deltamike.scoa.dtos.usuario.AlunoDTO;
import deltamike.scoa.model.usuario.AlunoModel;
import deltamike.scoa.model.usuario.UsuarioModel;
import deltamike.scoa.services.usuario.AlunoService;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/usuario/aluno")
public class AlunoController {
    final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
    
    @PostMapping
    public ResponseEntity<AlunoModel> save(@RequestBody @Valid AlunoDTO alunoDTO){
        AlunoModel alunoModel = new AlunoModel();
        BeanUtils.copyProperties(alunoDTO, alunoModel);
        
        if (this.alunoService.getUsuarioService().existsById(alunoModel.getId())){
            UsuarioModel user = this.alunoService.getUsuarioService().getById(alunoModel.getId()).get();
            BeanUtils.copyProperties(user, alunoModel);
            this.alunoService.getUsuarioService().delete(user);
        }
        
        AlunoModel retorno = this.alunoService.save(alunoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }
}
