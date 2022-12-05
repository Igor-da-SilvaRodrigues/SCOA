/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.usuario;

import deltamike.scoa.dtos.usuario.AlunoDTO;
import deltamike.scoa.model.academico.curso.CursoModel;
import deltamike.scoa.model.financeiro.mensalidade.MensalidadeModel;
import deltamike.scoa.model.usuario.AlunoModel;
import deltamike.scoa.model.usuario.UsuarioModel;
import deltamike.scoa.services.usuario.AlunoService;
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
        
        //if (this.alunoService.getUsuarioService().existsById(alunoModel.getId())){
        //    UsuarioModel user = this.alunoService.getUsuarioService().getById(alunoModel.getId()).get();
        //    BeanUtils.copyProperties(user, alunoModel);
        //    this.alunoService.getUsuarioService().delete(user);
        //}
        
        AlunoModel retorno = this.alunoService.save(alunoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }
    
    @PutMapping("/{idAluno}/usuario/{idUsuario}")
    public ResponseEntity<Object> colocarAlunoEmUsuario(@PathVariable Integer idAluno, @PathVariable String idUsuario){
        Optional<AlunoModel> alunoOptional = this.alunoService.getById(idAluno);
        Optional<UsuarioModel> usuarioOptional = this.alunoService.getUsuarioService().getById(idUsuario);
        
        if(alunoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        
        if(usuarioOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }
        
        AlunoModel alunoModel = alunoOptional.get();
        UsuarioModel usuarioModel = usuarioOptional.get();
        
        alunoModel.setUsuario(usuarioModel);
        
        return ResponseEntity.status(HttpStatus.OK).body(this.alunoService.save(alunoModel));
    }
    
    @DeleteMapping("/{idAluno}/usuario")
    public ResponseEntity<Object> removerAlunoDeUsuario(@PathVariable Integer idAluno){
        Optional<AlunoModel> alunoOptional = this.alunoService.getById(idAluno);
        
        if(alunoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        
        AlunoModel alunoModel = alunoOptional.get();
        
        alunoModel.setUsuario(null);
        
        return ResponseEntity.status(HttpStatus.OK).body(this.alunoService.save(alunoModel));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        Optional<AlunoModel> alunoOptional = this.alunoService.getById(id);
        
        if( alunoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        
        AlunoModel alunoModel = alunoOptional.get();
        List<MensalidadeModel> mensalidades = alunoModel.getMensalidades();
        //removendo relação de aluno com mensalidades
        for (int i = 0; i < mensalidades.size(); i = i + 1){
            MensalidadeModel mensalidade;
            try {
                mensalidade = mensalidades.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            
            alunoModel.removeMensalidade(mensalidade);
        }
        
        //removendo relação curso-aluno
        List<CursoModel> cursos = alunoModel.getCursos();
        for( int i = 0; i < cursos.size(); i = i + 1){
            CursoModel curso;
            try {
                curso = cursos.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            
            alunoModel.removeCurso(curso);
        }
        
        this.alunoService.delete(alunoModel);
        return ResponseEntity.status(HttpStatus.OK).body(alunoModel);
    }
    
   @GetMapping
   public ResponseEntity<List<AlunoModel>> getAll(){
       return ResponseEntity.status(HttpStatus.OK).body(this.alunoService.getAll());
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Object> getById(@PathVariable Integer id){
       Optional<AlunoModel> aluno = this.alunoService.getById(id);
       
       if(aluno.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("aluno não encontrado");
       }
       
       return ResponseEntity.status(HttpStatus.OK).body(aluno.get());
   }
}
