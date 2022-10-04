
package scoa.model.almoxarifado.relatorio;

import java.time.LocalDateTime;
import scoa.model.almoxarifado.produto.Produto;

public class RelatorioEntrada extends Relatorio{

    public RelatorioEntrada(LocalDateTime data, int quantidade, Produto produto) {
        super(data, quantidade, produto, "Entrada");
    }
    
}
