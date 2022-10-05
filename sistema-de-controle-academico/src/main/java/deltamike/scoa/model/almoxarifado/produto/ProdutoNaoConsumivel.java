
package deltamike.scoa.model.almoxarifado.produto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "nao_consumivel")
public class ProdutoNaoConsumivel extends ProdutoModel{

    public ProdutoNaoConsumivel(Integer estoqueMax, Integer estoqueMin, String referencia, String localizacao, String codBarras, String nome) {
        super(estoqueMax, estoqueMin, referencia, localizacao, codBarras, nome);
    }

    public ProdutoNaoConsumivel() {
    }
    
}
