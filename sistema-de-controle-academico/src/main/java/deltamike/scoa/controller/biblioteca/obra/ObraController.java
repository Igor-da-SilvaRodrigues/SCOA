/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.biblioteca.obra;

import deltamike.scoa.dtos.biblioteca.obra.ArtigoDTO;
import deltamike.scoa.dtos.biblioteca.obra.FilmeDTO;
import deltamike.scoa.dtos.biblioteca.obra.JornalDTO;
import deltamike.scoa.dtos.biblioteca.obra.LivroDTO;
import deltamike.scoa.dtos.biblioteca.obra.ManualDTO;
import deltamike.scoa.dtos.biblioteca.obra.RevistaDTO;
import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import deltamike.scoa.model.biblioteca.obra.ArtigoModel;
import deltamike.scoa.model.biblioteca.obra.FilmeModel;
import deltamike.scoa.model.biblioteca.obra.JornalModel;
import deltamike.scoa.model.biblioteca.obra.LivroModel;
import deltamike.scoa.model.biblioteca.obra.ManualModel;
import deltamike.scoa.model.biblioteca.obra.ObraModel;
import deltamike.scoa.model.biblioteca.obra.RevistaModel;
import deltamike.scoa.services.biblioteca.obra.ObraService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    
    //Salva um artigo no banco de dados
    @PostMapping("/artigo")
    public ResponseEntity<Object> saveArtigo(@RequestBody @Valid ArtigoDTO artigoDTO){
        ArtigoModel artigo = new ArtigoModel();
        BeanUtils.copyProperties(artigoDTO, artigo);
        
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.obraService.save(artigo));
    }
    
    
    //Salva um filme no banco de dados
    @PostMapping("/filme")
    public ResponseEntity<Object> saveFilme(@RequestBody @Valid FilmeDTO filmeDTO){
        FilmeModel filme = new FilmeModel();
        BeanUtils.copyProperties(filmeDTO, filme);
        
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(this.obraService.save(filme));
    }
    
    
    @PostMapping("/jornal")
    public ResponseEntity<Object> saveJornal(@RequestBody @Valid JornalDTO jornalDTO){
        JornalModel jornal = new JornalModel();
        BeanUtils.copyProperties(jornalDTO, jornal);
        
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(this.obraService.save(jornal));
    }
    
    @PostMapping("/livro")
    public ResponseEntity<Object> saveLivro(@RequestBody @Valid LivroDTO livroDTO){
        LivroModel livro = new LivroModel();
        BeanUtils.copyProperties(livroDTO, livro);
        
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(this.obraService.save(livro));
    }
    
    @PostMapping("/manual")
    public ResponseEntity<Object> saveManual(@RequestBody @Valid ManualDTO manualDTO){
        ManualModel manual = new ManualModel();
        BeanUtils.copyProperties(manualDTO, manual);
        
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(this.obraService.save(manual));
    }
    
    @PostMapping("/revista")
    public ResponseEntity<Object> saveRevista(@RequestBody @Valid RevistaDTO revistaDTO){
        RevistaModel revista = new RevistaModel();
        BeanUtils.copyProperties(revistaDTO, revista);
        
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(this.obraService.save(revista));
    }
    
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> deleteObraById(@PathVariable Integer id){
        System.out.println("O ID QUE EU ESTOU TENTADO DELETAR É: " + id);
        
        Optional<ObraModel> alvo = this.obraService.getById(id);
        
        if (alvo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A obra em questão não existe na base de dados");    
        }
        
        ObraModel obra = alvo.get();
            
        List<EmprestimoModel> emprestimos = obra.getEmprestimos();
        //Remover as relações da Obra com emprestimo
        //para cada emprestimo em obra.getEmprestimos();
        for (int i = 0; i < emprestimos.size(); i += 1){
            EmprestimoModel emprestimo;
            try{
                emprestimo = emprestimos.get(i);
            }catch(IndexOutOfBoundsException e){
                System.out.println("[ObraController] - IndexOutOfBoundsException - deleteObraById");
                break;
            }

            obra.removeEmprestimo(emprestimo);

        }

        this.obraService.delete(obra);
        return ResponseEntity.status(HttpStatus.OK).body(obra);
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
    
    public ResponseEntity<List<ObraModel>> getByTitulo(String titulo){
        
        return ResponseEntity.status(HttpStatus.OK).body(this.obraService.getByTitulo(titulo));
        
    }
}
