/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.repositories.almoxarifado.item;

import deltamike.scoa.model.almoxarifado.item.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rodri
 */
public interface ItemRepository extends JpaRepository<ItemModel, Integer>{
    
}
