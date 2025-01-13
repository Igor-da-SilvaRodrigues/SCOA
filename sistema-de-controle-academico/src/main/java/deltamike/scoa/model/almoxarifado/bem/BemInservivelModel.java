
package deltamike.scoa.model.almoxarifado.bem;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
/*
Bens Inservíveis são todos os bens desativados, danificados
ou obsoletos, podendo ser considerados como recuperáveis ou irrecuperáveis.
*/
/**
 * <p>
 * Bens Inservíveis são todos os bens desativados, danificados
 * ou obsoletos, podendo ser considerados como recuperáveis ou irrecuperáveis.
 * </p>
 * @author rodri
 */
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

    public void removeBem(){
        this.bem = null;
    }
    
}
