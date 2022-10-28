
package deltamike.scoa.model.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "produto_nao_consumivel")
@DiscriminatorValue(value = "produto_nao_consumivel")
public class ProdutoNaoConsumivelModel extends ProdutoModel{
    
    @Column
    private Integer quantidade;

    public ProdutoNaoConsumivelModel(Integer quantidade, String referencia, String localizacao, String codBarras, String nome, Integer estoque, Integer estoque_min, Integer estoque_max, List<RelatorioModel> relatorios) {
        super(referencia, localizacao, codBarras, nome, estoque, estoque_min, estoque_max, relatorios);
        this.quantidade = quantidade;
    }
    
    public ProdutoNaoConsumivelModel() {
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
}
