/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.services.almoxarifado.item;

import deltamike.scoa.model.almoxarifado.item.ItemModel;
import deltamike.scoa.repositories.almoxarifado.item.ItemRepository;
import deltamike.scoa.services.almoxarifado.bem.BemService;
import deltamike.scoa.services.almoxarifado.produto.ProdutoService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodri
 */
@Service
public class ItemService {
    ItemRepository itemRepository;
    BemService bemService;
    ProdutoService produtoService;

    public ItemService(ItemRepository itemRepository, BemService bemService, ProdutoService produtoService) {
        this.itemRepository = itemRepository;
        this.bemService = bemService;
        this.produtoService = produtoService;
    }
    
    @Transactional
    public ItemModel save(ItemModel itemModel){
        return this.itemRepository.saveAndFlush(itemModel);
    }
    
    @Transactional
    public void delete(ItemModel itemModel){
        this.itemRepository.delete(itemModel);
    }
    
    public boolean existsById(String id){
        return this.itemRepository.existsById(id);
    }
    
    public List<ItemModel> getAll(){
        return this.itemRepository.findAll();
    }
    
    public Optional<ItemModel> getById(String id){
        return this.itemRepository.findById(id);
    }

    public BemService getBemService() {
        return bemService;
    }

    public ProdutoService getProdutoService() {
        return produtoService;
    }
    
}
