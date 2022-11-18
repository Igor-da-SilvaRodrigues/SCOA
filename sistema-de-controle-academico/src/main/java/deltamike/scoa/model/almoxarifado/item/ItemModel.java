/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.almoxarifado.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "item")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO")
public class ItemModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(length = 127)
    private String nome;    
    
    @Column(nullable = false)
    private Integer estoque;
    
    @Column(nullable = false)
    private Integer estoque_min;
    
    @Column(nullable = false)
    private Integer estoque_max;
    
    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<RelatorioModel> relatorios;

    public ItemModel(String nome, Integer estoque, Integer estoque_min, Integer estoque_max, List<RelatorioModel> relatorios) {
        this.nome = nome;
        this.estoque = estoque;
        this.estoque_min = estoque_min;
        this.estoque_max = estoque_max;
        this.relatorios = relatorios;
    }

    public ItemModel(String nome, Integer estoque, Integer estoque_min, Integer estoque_max) {
        this.nome = nome;
        this.estoque = estoque;
        this.estoque_min = estoque_min;
        this.estoque_max = estoque_max;
    }
    
    public ItemModel() {
    }

    
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
//    public Integer getId() {
//        return nome;
//    }

    public String getNome() {
        return nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public Integer getEstoque_min() {
        return estoque_min;
    }

    public Integer getEstoque_max() {
        return estoque_max;
    }

//    public void setId(Integer nome) {
//        this.nome = nome;
//    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public void setEstoque_min(Integer estoque_min) {
        this.estoque_min = estoque_min;
    }

    public void setEstoque_max(Integer estoque_max) {
        this.estoque_max = estoque_max;
    }

    public void setRelatorios(List<RelatorioModel> relatorios) {
        this.relatorios = relatorios;
    }

    public List<RelatorioModel> getRelatorios() {
        return relatorios;
    }
    
    public void addRelatorio(RelatorioModel relatorio){
        this.relatorios.add(relatorio);
        relatorio.setItem(this);
    }
    
    public void removeRelatorio(RelatorioModel relatorio){
        this.relatorios.remove(relatorio);
        relatorio.setItem(null);
    }
    
}
