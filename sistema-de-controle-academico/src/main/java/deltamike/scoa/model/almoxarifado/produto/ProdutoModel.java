
package deltamike.scoa.model.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.item.ItemModel;
import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class ProdutoModel extends ItemModel{
    
    @Column(nullable = false)
    private String referencia;
    @Column(nullable = false)
    private String localizacao;
    @Column(nullable = false)
    private String codBarras;

    public ProdutoModel(String referencia, String localizacao, String codBarras, String nome, Integer estoque, Integer estoque_min, Integer estoque_max) {
        super(nome, estoque, estoque_min, estoque_max);
        this.referencia = referencia;
        this.localizacao = localizacao;
        this.codBarras = codBarras;
    }

    public ProdutoModel(String referencia, String localizacao, String codBarras, String nome, Integer estoque, Integer estoque_min, Integer estoque_max, List<RelatorioModel> relatorios) {
        super(nome, estoque, estoque_min, estoque_max, relatorios);
        this.referencia = referencia;
        this.localizacao = localizacao;
        this.codBarras = codBarras;
    }
    

    public ProdutoModel() {
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

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }
}
