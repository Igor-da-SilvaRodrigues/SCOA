/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.almoxarifado.bem;

import deltamike.scoa.dtos.almoxarifado.item.ItemDTO;
import deltamike.scoa.model.almoxarifado.bem.BemServivelModel;

/**
 *
 * @author rodri
 */
public class BemDTO extends ItemDTO{

    private BemServivelModel bemServivel;

    public BemServivelModel getBemServivel() {
        return bemServivel;
    }

    public void setBemServivel(BemServivelModel bemServivel) {
        this.bemServivel = bemServivel;
    }
    
    
}
