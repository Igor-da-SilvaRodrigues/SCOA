
package deltamike.scoa.model.almoxarifado.relatorio;

import deltamike.scoa.model.almoxarifado.item.ItemModel;
import deltamike.scoa.model.usuario.FuncionarioModel;
import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "relatorio")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO")
public class RelatorioModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private LocalDateTime data;
    
    @Column(nullable = false)
    private Integer quantidade;
    
    @ManyToOne
    private ItemModel item;
    
    @ManyToOne
    private FuncionarioModel funcionario;

    public RelatorioModel(LocalDateTime data, Integer quantidade, ItemModel item, FuncionarioModel funcionario) {
        this.data = data;
        this.quantidade = quantidade;
        this.item = item;
        this.funcionario = funcionario;
    }

    public RelatorioModel(LocalDateTime data, Integer quantidade, ItemModel item) {
        this.data = data;
        this.quantidade = quantidade;
        this.item = item;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }

    public ItemModel getItem() {
        return item;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }
    
    public void removeItem(){
        this.item = null;
    }
    
    public void removeFuncionario(){
        this.funcionario = null;
    }
    
}
