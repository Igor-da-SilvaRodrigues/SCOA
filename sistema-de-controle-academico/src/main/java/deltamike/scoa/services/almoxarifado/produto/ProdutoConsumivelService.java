/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.produto.ProdutoConsumivelModel;
import deltamike.scoa.repositories.almoxarifado.produto.ProdutoConsumivelRepository;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class ProdutoConsumivelService {
    ProdutoConsumivelRepository produtoConsumivelRepository;

    public ProdutoConsumivelService(ProdutoConsumivelRepository produtoConsumivelRepository) {
        this.produtoConsumivelRepository = produtoConsumivelRepository;
    }
    
    @Transactional
    public ProdutoConsumivelModel save(ProdutoConsumivelModel produtoConsumivelModel){
        return this.produtoConsumivelRepository.save(produtoConsumivelModel);
    }
    
    @Transactional
    public void delete(ProdutoConsumivelModel produtoConsumivelModel){
        this.produtoConsumivelRepository.delete(produtoConsumivelModel);
    }
    
    public void deleteById(String id){
        Optional<ProdutoConsumivelModel> optional = this.getById(id);
        
        if(optional.isPresent()){
            this.delete(optional.get());
        }
    }
    
    public List<ProdutoConsumivelModel> getAll(){
        return this.produtoConsumivelRepository.findAll();
    }
    
    public Optional<ProdutoConsumivelModel> getById(String id){
        return this.produtoConsumivelRepository.findById(id);
    }
}
