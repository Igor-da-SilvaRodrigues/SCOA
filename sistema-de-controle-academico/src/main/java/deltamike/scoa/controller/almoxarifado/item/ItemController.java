/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.controller.almoxarifado.item;

import deltamike.scoa.model.almoxarifado.item.ItemModel;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import deltamike.scoa.services.almoxarifado.item.ItemService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rodri
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/almoxarifado/item")
public class ItemController {
    final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    
    
    @GetMapping
    public ResponseEntity<List<ItemModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.itemService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getItemById(@PathVariable String id){
        Optional<ItemModel> itemOptional = this.itemService.getById(id);
        
        if (itemOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(itemOptional.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bem não encontrado");
    }
    
    /**
     * <p>
     * Chamar esse método causa a exclusão dos registros do item.
     * </p>
     * <p>
     * As relações de bem com bem servível e inservível, e de produto com 
     * produto inservível também serão excluídas.
     * </p>
     *
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItemById(@PathVariable String id){
        Optional<ItemModel> alvo = this.itemService.getById(id);
        
        if (alvo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não encontrado");
        
        }
        
        ItemModel item = alvo.get();
        List<RelatorioModel> relatorios = item.getRelatorios();
        //remover as relações do item com os relatorios
        for (int i = 0; i < relatorios.size(); i = i + 1){
            RelatorioModel relatorio;
            
            try {
                relatorio = relatorios.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            
            item.removeRelatorio(relatorio);
        }

        this.itemService.delete(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
    
}
