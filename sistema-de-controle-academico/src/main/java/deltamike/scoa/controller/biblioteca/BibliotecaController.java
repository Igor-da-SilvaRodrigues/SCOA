/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.biblioteca;

import deltamike.scoa.model.biblioteca.obra.ObraModel;
import deltamike.scoa.services.biblioteca.BibliotecaService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rodri
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/biblioteca")
public class BibliotecaController {
    final BibliotecaService bibliotecaService;

    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }
    
    @GetMapping
    public String bilbioteca(Model model){
        model.addAttribute("obras",getAllObras());
        return "biblioteca_index";
    }
    
    public List<ObraModel> getAllObras(){
        return this.bibliotecaService.getObraService().getAll();
    }
    
}
