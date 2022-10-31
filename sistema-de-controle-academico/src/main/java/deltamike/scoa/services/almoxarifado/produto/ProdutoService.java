/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.bem.BemModel;
import deltamike.scoa.model.almoxarifado.produto.ProdutoModel;
import deltamike.scoa.repositories.almoxarifado.produto.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class ProdutoService {
    ProdutoRepository produtoRepository;
    ProdutoConsumivelService produtoConsumivelService;
    ProdutoNaoConsumivelService produtoNaoConsumivelService;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoConsumivelService produtoConsumivelService, ProdutoNaoConsumivelService produtoNaoConsumivelService) {
        this.produtoRepository = produtoRepository;
        this.produtoConsumivelService = produtoConsumivelService;
        this.produtoNaoConsumivelService = produtoNaoConsumivelService;
    }

    

    
    @Transactional
    public ProdutoModel save(ProdutoModel produtoModel){
        return this.produtoRepository.saveAndFlush(produtoModel);
    }
    
    @Transactional
    public void delete(ProdutoModel produtoModel){
        this.produtoRepository.delete(produtoModel);
    }
    
    public List<ProdutoModel> getAll(){
        return this.produtoRepository.findAll();
    }
    
    public Optional<ProdutoModel> getById(Integer id){
        return this.produtoRepository.findById(id);
    }

    public ProdutoConsumivelService getProdutoConsumivelService() {
        return produtoConsumivelService;
    }

    public ProdutoNaoConsumivelService getProdutoNaoConsumivelService() {
        return produtoNaoConsumivelService;
    }
    
    
}
