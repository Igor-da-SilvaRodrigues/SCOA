/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.almoxarifado.bem;

import deltamike.scoa.model.almoxarifado.bem.BemModel;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rodri
 */
public class BemInservivelDTO{
    
    @NotBlank
    private String nome;
    
    private BemModel bem;
    
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

    public BemModel getBem() {
        return bem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setBem(BemModel bem) {
        this.bem = bem;
    }
    
    
    
}
