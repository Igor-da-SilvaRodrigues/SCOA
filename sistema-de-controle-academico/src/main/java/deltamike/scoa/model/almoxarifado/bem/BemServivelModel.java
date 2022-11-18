package deltamike.scoa.model.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bem_servivel")
//@DiscriminatorValue(value = "bem_servivel")
public class BemServivelModel implements Serializable {

    @Id
    @Column(name="nome", length = 127)
    private String nome;
    
    @OneToOne
    private BemModel bem;

    @Column(length = 127)
    private String tombo;
    @Column(length = 127)
    private String setor;
    @Column
    private Integer quantidade;

    public BemServivelModel(String tombo, String setor, Integer quantidade) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public BemModel getBem() {
        return bem;
    }

    public void setBem(BemModel bem) {
        this.bem = bem;
    }
    
    public void removeBem(){
        this.bem = null;
    }

}
