/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.produto.ProdutoNaoConsumivelModel;
import deltamike.scoa.repositories.almoxarifado.produto.ProdutoNaoConsumivelRepository;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */

@Service
public class ProdutoNaoConsumivelService {
    ProdutoNaoConsumivelRepository produtoNaoConsumivelRepository;

    public ProdutoNaoConsumivelService(ProdutoNaoConsumivelRepository produtoNaoConsumivelRepository) {
        this.produtoNaoConsumivelRepository = produtoNaoConsumivelRepository;
    }
    
    @Transactional
    public ProdutoNaoConsumivelModel save(ProdutoNaoConsumivelModel produtoNaoConsumivelModel){
        return this.produtoNaoConsumivelRepository.save(produtoNaoConsumivelModel);
    }
    
    @Transactional
    public void delete(ProdutoNaoConsumivelModel produtoNaoConsumivelModel){
        this.produtoNaoConsumivelRepository.delete(produtoNaoConsumivelModel);
    }
    
    public void deleteById(String id){
        Optional<ProdutoNaoConsumivelModel> optional = this.getById(id);
        
        if(optional.isPresent()){
            this.delete(optional.get());
        }
        
    }
    
    public List<ProdutoNaoConsumivelModel> getAll(){
        return this.produtoNaoConsumivelRepository.findAll();
    }
    
    public Optional<ProdutoNaoConsumivelModel> getById(String id){
        return this.produtoNaoConsumivelRepository.findById(id);
    }
}
