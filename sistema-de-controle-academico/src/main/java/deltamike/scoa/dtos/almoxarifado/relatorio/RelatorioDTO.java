/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.almoxarifado.relatorio;

import deltamike.scoa.model.almoxarifado.produto.ProdutoModel;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author rodri
 */
public class RelatorioDTO {
    
    @NotNull
    private LocalDateTime data;
    @NotNull
    private Integer quantidade;

    private ProdutoModel produto;

    public LocalDateTime getData() {
        return data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }
    
    
}
