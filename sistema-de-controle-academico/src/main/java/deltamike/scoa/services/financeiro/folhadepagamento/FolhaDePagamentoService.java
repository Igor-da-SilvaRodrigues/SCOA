/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.financeiro.folhadepagamento;

import deltamike.scoa.model.financeiro.folhadepagamento.FolhaDePagamentoModel;
import deltamike.scoa.repositories.financeiro.folhadepagamento.FolhaDePagamentoRepository;
import deltamike.scoa.services.usuario.FuncionarioService;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class FolhaDePagamentoService {
    final FolhaDePagamentoRepository folhaDePagamentoRepository;
    final FuncionarioService funcionarioService;

    public FolhaDePagamentoService(FolhaDePagamentoRepository folhaDePagamentoRepository, FuncionarioService funcionarioService) {
        this.folhaDePagamentoRepository = folhaDePagamentoRepository;
        this.funcionarioService = funcionarioService;
    }
    
    
    
    @Transactional
    public FolhaDePagamentoModel save(FolhaDePagamentoModel folha){
        return this.folhaDePagamentoRepository.saveAndFlush(folha);
    }
    
    @Transactional
    public void delete(FolhaDePagamentoModel folha){
        this.folhaDePagamentoRepository.delete(folha);
    }
    
    public void deleteById(Integer id){
        Optional<FolhaDePagamentoModel> optional = this.folhaDePagamentoRepository.findById(id);
        
        if(optional.isPresent()){
            this.delete(optional.get());
        }
        
    }
    
    public boolean existsById(Integer id){
        return this.folhaDePagamentoRepository.existsById(id);
    }
    
    public Optional<FolhaDePagamentoModel> getById(Integer id){
        return this.folhaDePagamentoRepository.findById(id);
    }
    
    public List<FolhaDePagamentoModel> getAll(){
        return this.folhaDePagamentoRepository.findAll();
    }

    public FuncionarioService getFuncionarioService() {
        return funcionarioService;
    }
    
}
