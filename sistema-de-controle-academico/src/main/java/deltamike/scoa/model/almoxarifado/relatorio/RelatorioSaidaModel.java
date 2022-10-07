
package deltamike.scoa.model.almoxarifado.relatorio;

import deltamike.scoa.model.almoxarifado.produto.ProdutoModel;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "saida")
public class RelatorioSaidaModel extends RelatorioModel{

    public RelatorioSaidaModel(LocalDateTime data, Integer quantidade, ProdutoModel produto) {
        super(data, quantidade, produto);
    }

    public RelatorioSaidaModel() {
    }
    
}
