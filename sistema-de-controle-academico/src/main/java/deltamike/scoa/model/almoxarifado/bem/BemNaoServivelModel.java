
package deltamike.scoa.model.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bem_nao_servivel")
@DiscriminatorValue(value = "bem_nao_servivel")
public class BemNaoServivelModel extends BemModel{
    
    @Column
    private Integer quantidade;

    public BemNaoServivelModel(Integer quantidade, String nome, Integer estoque, Integer estoque_min, Integer estoque_max, List<RelatorioModel> relatorios) {
        super(nome, estoque, estoque_min, estoque_max, relatorios);
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    
    public BemNaoServivelModel() {
    }
    
}
