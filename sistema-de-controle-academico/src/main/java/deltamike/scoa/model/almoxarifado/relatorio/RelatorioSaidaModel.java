
package deltamike.scoa.model.almoxarifado.relatorio;

import deltamike.scoa.model.almoxarifado.item.ItemModel;
import java.time.LocalDateTime;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "relatorio_saida")
@DiscriminatorValue(value = "saida")
public class RelatorioSaidaModel extends RelatorioModel{

    public RelatorioSaidaModel(LocalDateTime data, Integer quantidade, ItemModel item) {
        super(data, quantidade, item);
    }

    public RelatorioSaidaModel() {
    }
    
}
