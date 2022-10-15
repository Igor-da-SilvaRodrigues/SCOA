/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.biblioteca;

import deltamike.scoa.services.biblioteca.emprestimo.EmprestimoService;
import deltamike.scoa.services.biblioteca.obra.ObraService;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */

@Service
public class BibliotecaService {
    EmprestimoService emprestimoService;
    ObraService obraService;

    public BibliotecaService(EmprestimoService emprestimoService, ObraService obraService) {
        this.emprestimoService = emprestimoService;
        this.obraService = obraService;
    }

    public EmprestimoService getEmprestimoService() {
        return emprestimoService;
    }

    public ObraService getObraService() {
        return obraService;
    }

    public void setEmprestimoService(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    public void setObraService(ObraService obraService) {
        this.obraService = obraService;
    }
    
    
}
