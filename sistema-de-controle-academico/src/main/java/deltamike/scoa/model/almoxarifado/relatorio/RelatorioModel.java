
package deltamike.scoa.model.almoxarifado.relatorio;

import deltamike.scoa.model.almoxarifado.produto.ProdutoModel;
import deltamike.scoa.model.usuario.FuncionarioModel;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "relatorio")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO")
public class RelatorioModel implements Serializable{
        
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private LocalDateTime data;
    @Column(nullable = false)
    private Integer quantidade;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produto;
    
    @ManyToOne
    private FuncionarioModel funcionario;

    public RelatorioModel(LocalDateTime data, Integer quantidade, ProdutoModel produto, FuncionarioModel funcionario) {
        this.data = data;
        this.quantidade = quantidade;
        this.produto = produto;
        this.funcionario = funcionario;
    }

    public RelatorioModel() {
    }
    

    public Integer getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }
    
}
