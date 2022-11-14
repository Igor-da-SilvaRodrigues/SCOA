/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.financeiro.boleto;

import deltamike.scoa.model.financeiro.boleto.BoletoModel;
import deltamike.scoa.repositories.financeiro.boleto.BoletoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class BoletoService {
    final BoletoRepository boletoRepository;

    public BoletoService(BoletoRepository boletoRepository) {
        this.boletoRepository = boletoRepository;
    }
    
    @Transactional
    public BoletoModel save(BoletoModel boleto){
        return this.boletoRepository.save(boleto);
    }

    @Transactional
    public void delete(BoletoModel boleto){
        this.boletoRepository.delete(boleto);
    }
    
    public Optional<BoletoModel> getById(Integer id){
        return this.boletoRepository.findById(id);
    }
    
    public List<BoletoModel> getAll(){
        return this.boletoRepository.findAll();
    }
}
