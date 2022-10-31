/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.produto.ProdutoModel;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rodri
 */
public class ProdutoNaoConsumivelDTO {
    
    @NotBlank
    @Size(min = 1, max=127)
    private String nome;
    
    private ProdutoModel produtoModel;
    
    @NotNull
    private Integer quantidade;

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public ProdutoModel getProdutoModel() {
        return produtoModel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProdutoModel(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }
    
    
    
}
