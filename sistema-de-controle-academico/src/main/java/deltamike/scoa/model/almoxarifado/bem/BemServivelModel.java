
package deltamike.scoa.model.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bem_servivel")
@DiscriminatorValue(value = "bem_servivel")
public class BemServivelModel extends BemModel{
    @Column(length = 127)
    private String tombo;
    @Column(length = 127)
    private String setor;
    @Column
    private Integer quantidade;

    public BemServivelModel(String tombo, String setor, Integer quantidade, String nome, Integer estoque, Integer estoque_min, Integer estoque_max, List<RelatorioModel> relatorios) {
        super(nome, estoque, estoque_min, estoque_max, relatorios);
        this.tombo = tombo;
        this.setor = setor;
        this.quantidade = quantidade;
    }

    

    public BemServivelModel() {
    }

    public String getTombo() {
        return tombo;
    }

    public String getSetor() {
        return setor;
    }

    public void setTombo(String tombo) {
        this.tombo = tombo;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
