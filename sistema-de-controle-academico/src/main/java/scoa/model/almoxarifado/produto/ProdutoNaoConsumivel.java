
package scoa.model.almoxarifado.produto;

public class ProdutoNaoConsumivel extends Produto{

    public ProdutoNaoConsumivel(int estoqueMax, int estoqueMin, String referencia, String localizacao, String codBarras, String nome) {
        super(estoqueMax, estoqueMin, referencia, localizacao, codBarras, nome, "NaoConsumivel");
    }
    
}
