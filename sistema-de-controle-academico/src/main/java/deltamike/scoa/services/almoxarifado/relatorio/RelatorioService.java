/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.almoxarifado.relatorio;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import deltamike.scoa.repositories.almoxarifado.relatorio.RelatorioRepository;
import deltamike.scoa.services.almoxarifado.produto.ProdutoService;
import deltamike.scoa.services.biblioteca.obra.ObraService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class RelatorioService {
    RelatorioRepository relatorioRepository;
    ProdutoService produtoService;

    public RelatorioService(RelatorioRepository relatorioRepository, ProdutoService produtoService) {
        this.relatorioRepository = relatorioRepository;
        this.produtoService = produtoService;
    }

    @Transactional
    public RelatorioModel save(RelatorioModel relatorioModel){
        return this.relatorioRepository.saveAndFlush(relatorioModel);
    }
    
    @Transactional
    public void delete(RelatorioModel relatorioModel){
        this.relatorioRepository.delete(relatorioModel);
    }
    
    public List<RelatorioModel> getAll(){
        return this.relatorioRepository.findAll();
    }
    
    public Optional<RelatorioModel> getById(Integer id){
        return this.relatorioRepository.findById(id);
    }

    public ProdutoService getProdutoService() {
        return produtoService;
    }
    
    
}
