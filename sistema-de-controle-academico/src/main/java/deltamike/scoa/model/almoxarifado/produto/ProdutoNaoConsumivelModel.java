
package deltamike.scoa.model.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <p>Produtos não consumiveis são aqueles que saem do estoque mas obrigatoriamente
 * devem voltar para o estoque em um determinado momento, por exemplo:</p>
 * <ul>
 * <li>ferramentas</li>
 * </ul>
 * @author rodri
 */
@Entity
@Table(name = "produto_nao_consumivel")
//@DiscriminatorValue(value = "produto_nao_consumivel")
public class ProdutoNaoConsumivelModel implements Serializable{
    
    @Id
    @Column(name = "nome", length = 127)
    private String nome;
    
    @Column
    private Integer quantidade;
    
    @OneToOne
    private ProdutoModel produtoModel;


    public ProdutoNaoConsumivelModel(String nome, Integer quantidade) {
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProdutoModel getProdutoModel() {
        return produtoModel;
    }

    public void setProdutoModel(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }
    
}
