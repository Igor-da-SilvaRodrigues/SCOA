package deltamike.scoa.model.almoxarifado.bem;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



/**
 * <p>São os bens patrimoniais</p>
 * <p>Um bem que serve para alguma coisa é um bem servível.</p>
 * <p>Os bens móveis ou imóveis que integram o acervo patrimonial,
 * que são de uso indispensável à prestação do serviço, são bens servíveis.</p>
 * <br>Exemplo:
 * <ul>
 * <li>sofás</li>
 * <li>unidades de ar condicionado</li>
 * <li>geladeiras</li>
 * <li>computadores</li>
 * <li>etc.</li>
 * </ul>
 * 
 * @author rodri
 */
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
