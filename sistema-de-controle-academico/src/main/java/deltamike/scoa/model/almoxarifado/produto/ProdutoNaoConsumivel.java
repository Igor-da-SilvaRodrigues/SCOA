
package deltamike.scoa.model.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "nao_consumivel")
public class ProdutoNaoConsumivel extends ProdutoModel{

    public ProdutoNaoConsumivel(Integer estoqueMax, Integer estoqueMin, String referencia, String localizacao, String codBarras, String nome, List<RelatorioModel> relatorios) {
        super(estoqueMax, estoqueMin, referencia, localizacao, codBarras, nome, relatorios);
    }

    public ProdutoNaoConsumivel() {
    }
    
}
