/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.academico.sala;

import deltamike.scoa.model.academico.sala.SalaModel;
import deltamike.scoa.repositories.academico.sala.SalaRepository;
import deltamike.scoa.services.ScoaService;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class SalaService extends ScoaService<SalaModel, Integer, SalaRepository>{

    public SalaService(SalaRepository repository) {
        super(repository);
    }
    
}
