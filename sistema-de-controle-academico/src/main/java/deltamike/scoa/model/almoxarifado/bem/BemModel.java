
package deltamike.scoa.model.almoxarifado.bem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.almoxarifado.item.ItemModel;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bem")
@DiscriminatorValue(value = "bem")
public class BemModel extends ItemModel{
    
    @JsonIgnore
    @OneToOne(mappedBy = "bem", cascade = CascadeType.REMOVE)
    private BemServivelModel bemServivel;
    
    public BemModel(String nome, Integer estoque, Integer estoque_min, Integer estoque_max, List<RelatorioModel> relatorios) {
        super(nome, estoque, estoque_min, estoque_max, relatorios);
    }

    public BemModel(String nome, Integer estoque, Integer estoque_min, Integer estoque_max) {
        super(nome, estoque, estoque_min, estoque_max);
    }
    
    public BemModel(BemServivelModel bemServivel, String nome, Integer estoque, Integer estoque_min, Integer estoque_max, List<RelatorioModel> relatorios) {
        super(nome, estoque, estoque_min, estoque_max, relatorios);
        this.bemServivel = bemServivel;
    }

    public BemModel() {
    } 
    
    public BemServivelModel getBemServivel() {
        return bemServivel;
    }

    public void setBemServivel(BemServivelModel bemServivel) {
        this.bemServivel = bemServivel;
    }
    
    
}
