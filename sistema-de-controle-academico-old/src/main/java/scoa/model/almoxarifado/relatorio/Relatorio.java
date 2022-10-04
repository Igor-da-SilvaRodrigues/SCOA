
package scoa.model.almoxarifado.relatorio;

import java.time.LocalDateTime;
import scoa.model.almoxarifado.produto.Produto;

public class Relatorio {
    private LocalDateTime data;
    private int quantidade;
    private Produto produto;
    private String tipo;

    protected Relatorio(LocalDateTime data, int quantidade, Produto produto, String tipo) {
        this.data = data;
        this.quantidade = quantidade;
        this.produto = produto;
        this.tipo = tipo;
    }

    public Relatorio() {
    }
    
    public LocalDateTime getData() {
        return data;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getTipo() {
        return tipo;
    }
    
        
}
