
package deltamike.scoa.model.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bem_nao_servivel")
//@DiscriminatorValue(value = "bem_nao_servivel")
public class BemInservivelModel implements Serializable{
    
    @Id
    @Column(name="nome", length = 127)
    private String nome;
    
    @OneToOne
    private BemModel bem;
    
    @Column
    private Integer quantidade;

    public BemInservivelModel(String nome, BemModel bem, Integer quantidade) {
        this.nome = nome;
        this.bem = bem;
        this.quantidade = quantidade;
    }

    public BemInservivelModel(BemModel bem, Integer quantidade) {
        this.bem = bem;
        this.quantidade = quantidade;
    }

    public BemInservivelModel(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public BemInservivelModel() {
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public BemModel getBem() {
        return bem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setBem(BemModel bem) {
        this.bem = bem;
    }

    
    
}
