/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.academico.turno;

import deltamike.scoa.model.academico.turno.TurnoModel;
import deltamike.scoa.repositories.academico.turno.TurnoRepositore;
import deltamike.scoa.services.ScoaService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Estudo
 */
@Service
public class TurnoService extends ScoaService<TurnoModel, Integer, TurnoRepositore>{
    
    public TurnoService(TurnoRepositore repository) {
        super(repository);
    }
    
}
