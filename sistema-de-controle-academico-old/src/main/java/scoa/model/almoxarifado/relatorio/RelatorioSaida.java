
package scoa.model.almoxarifado.relatorio;

import java.time.LocalDateTime;
import scoa.model.almoxarifado.produto.Produto;


public class RelatorioSaida extends Relatorio{
   
    public RelatorioSaida(int a, LocalDateTime data, int quantidade, Produto produto) {
        super(data, quantidade, produto, "Saida");     
    }
   
}
