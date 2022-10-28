
package deltamike.scoa.model.almoxarifado.relatorio;

import deltamike.scoa.model.almoxarifado.item.ItemModel;
import deltamike.scoa.model.almoxarifado.produto.ProdutoModel;
import deltamike.scoa.model.usuario.FuncionarioModel;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "relatorio_entrada")
@DiscriminatorValue(value = "entrada")
public class RelatorioEntradaModel extends RelatorioModel{

    public RelatorioEntradaModel(LocalDateTime data, Integer quantidade, ItemModel item, FuncionarioModel funcionario) {
        super(data, quantidade, item, funcionario);
    }

    public RelatorioEntradaModel(LocalDateTime data, Integer quantidade, ItemModel item) {
        super(data, quantidade, item);
    }
    
    public RelatorioEntradaModel() {
    }
    
}
