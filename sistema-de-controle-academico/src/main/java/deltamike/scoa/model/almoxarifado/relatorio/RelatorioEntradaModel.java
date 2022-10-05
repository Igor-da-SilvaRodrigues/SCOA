
package deltamike.scoa.model.almoxarifado.relatorio;

import deltamike.scoa.model.almoxarifado.produto.ProdutoModel;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "entrada")
public class RelatorioEntradaModel extends RelatorioModel{

    public RelatorioEntradaModel(LocalDateTime data, Integer quantidade, List<ProdutoModel> produto) {
        super(data, quantidade, produto);
    }

    public RelatorioEntradaModel() {
    }
    
    
    
}
