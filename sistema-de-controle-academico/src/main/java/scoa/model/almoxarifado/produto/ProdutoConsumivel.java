
package scoa.model.almoxarifado.produto;

public class ProdutoConsumivel extends Produto{

    public ProdutoConsumivel(int estoqueMax, int estoqueMin, String referencia, String localizacao, String codBarras, String nome) {
       super(estoqueMax, estoqueMin, referencia, localizacao, codBarras, nome, "Consumivel");
    }
    
}
