/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.produto.ProdutoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 *
 * @author rodri
 */
public class ProdutoConsumivelDTO{
    
    @NotBlank
    @Size(min = 1, max = 127)
    private String nome;
    
    private ProdutoModel produtoModel;
    
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
