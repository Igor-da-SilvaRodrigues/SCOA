
package deltamike.scoa.model.almoxarifado.produto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO")
public class ProdutoModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private Integer estoqueMax;
    @Column(nullable = false)
    private Integer estoqueMin;
    @Column(nullable = false)
    private String referencia;
    @Column(nullable = false)
    private String localizacao;
    @Column(nullable = false)
    private String codBarras;
    @Column(nullable = false, length = 127)
    private String nome;
    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<RelatorioModel> relatorios;

    public ProdutoModel(Integer estoqueMax, Integer estoqueMin, String referencia, String localizacao, String codBarras, String nome, List<RelatorioModel> relatorios) {
        this.estoqueMax = estoqueMax;
        this.estoqueMin = estoqueMin;
        this.referencia = referencia;
        this.localizacao = localizacao;
        this.codBarras = codBarras;
        this.nome = nome;
        this.relatorios = relatorios;
    }

    public ProdutoModel() {
    }

    public List<RelatorioModel> getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(List<RelatorioModel> relatorios) {
        this.relatorios = relatorios;
    }
    
    

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public Integer getEstoqueMax() {
        return estoqueMax;
    }

    public Integer getEstoqueMin() {
        return estoqueMin;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEstoqueMax(Integer estoqueMax) {
        this.estoqueMax = estoqueMax;
    }

    public void setEstoqueMin(Integer estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
