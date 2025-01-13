
package deltamike.scoa.model.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * <p>Produto consumivel é aquele destinado a ser gasto na sua própria utilização,
* são aqueles que saem do estoque e não voltam mais como pro exemplo:</p>
* <ul>
* <li>papel</li>
* <li>tinta para a impressora</li>
* <li>caneta</li>
* <li>etc</li>
* </ul>
 * @author rodri
 */
@Entity
@Table(name = "produto_consumivel")
//@DiscriminatorValue(value = "produto_consumivel")
public class ProdutoConsumivelModel implements Serializable{
        
    @Id
    @Column(name = "nome", length = 127)
    private String nome;
    
    @Column
    private Integer quantidade;
    
    @OneToOne
    private ProdutoModel produtoModel;
    
    public ProdutoConsumivelModel(String nome, Integer quantidade) {
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public ProdutoModel getProdutoModel() {
        return produtoModel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProdutoModel(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }
    
}
