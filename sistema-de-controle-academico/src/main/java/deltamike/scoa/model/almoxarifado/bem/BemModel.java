
package deltamike.scoa.model.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.item.ItemModel;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bem")
public class BemModel extends ItemModel{

    public BemModel(String nome, Integer estoque, Integer estoque_min, Integer estoque_max, List<RelatorioModel> relatorios) {
        super(nome, estoque, estoque_min, estoque_max, relatorios);
    }

    public BemModel(String nome, Integer estoque, Integer estoque_min, Integer estoque_max) {
        super(nome, estoque, estoque_min, estoque_max);
    }
    
    public BemModel() {
    } 
    
}
