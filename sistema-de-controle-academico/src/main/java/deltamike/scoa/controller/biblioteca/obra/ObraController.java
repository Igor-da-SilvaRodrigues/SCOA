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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rodri
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/biblioteca/obra")
public class ObraController {
    final ObraService obraService;

    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }
    
    //Salva um artigo no banco de dados e redireciona para a pagina da biblioteca
    @PostMapping("/artigo")
    public String saveArtigo(@ModelAttribute @Valid ArtigoDTO artigoDTO){
        ArtigoModel artigo = new ArtigoModel();
        BeanUtils.copyProperties(artigoDTO, artigo);
        this.obraService.save(artigo);
        return  "redirect:/biblioteca";
    }
    
    //Serve a pagina de cadastro de artigos
    @GetMapping("/artigo")
    public String cadastro_artigo(Model model){
        model.addAttribute("artigodto", new ArtigoDTO());
        return "registrar_artigo";
    }
    
    @PostMapping("/filme")
    public ResponseEntity<Object> saveFilme(@RequestBody @Valid FilmeDTO filmeDTO){
        FilmeModel filme = new FilmeModel();
        BeanUtils.copyProperties(filmeDTO, filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.obraService.save(filme));
    }
    
    @PostMapping("/jornal")
    public ResponseEntity<Object> saveJornal(@RequestBody @Valid JornalDTO jornalDTO){
        JornalModel jornal = new JornalModel();
        BeanUtils.copyProperties(jornalDTO, jornal);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.obraService.save(jornal));
    }
    
    @PostMapping("/livro")
    public ResponseEntity<Object> saveLivro(@RequestBody @Valid LivroDTO livroDTO){
        LivroModel livro = new LivroModel();
        BeanUtils.copyProperties(livroDTO, livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.obraService.save(livro));
    }
    
    @PostMapping("/manual")
    public ResponseEntity<Object> saveManual(@RequestBody @Valid ManualDTO manualDTO){
        ManualModel manual = new ManualModel();
        BeanUtils.copyProperties(manualDTO, manual);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.obraService.save(manual));
    }
    
    @PostMapping("/revista")
    public ResponseEntity<Object> saveRevista(@RequestBody @Valid RevistaDTO revistaDTO){
        RevistaModel revista = new RevistaModel();
        BeanUtils.copyProperties(revistaDTO, revista);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.obraService.save(revista));
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
