
package deltamike.scoa.model.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "produto_consumivel")
@DiscriminatorValue(value = "produto_consumivel")
public class ProdutoConsumivelModel extends ProdutoModel{
    
    @Column
    private Integer quantidade;

    public ProdutoConsumivelModel(Integer quantidade, String referencia, String localizacao, String codBarras, String nome, Integer estoque, Integer estoque_min, Integer estoque_max, List<RelatorioModel> relatorios) {
        super(referencia, localizacao, codBarras, nome, estoque, estoque_min, estoque_max, relatorios);
        this.quantidade = quantidade;
    }
    
    public ProdutoConsumivelModel() {
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
