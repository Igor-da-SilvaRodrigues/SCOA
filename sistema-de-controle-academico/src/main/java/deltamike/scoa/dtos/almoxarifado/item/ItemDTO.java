/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.almoxarifado.item;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rodri
 */
public class ItemDTO {
    @NotNull
    @Size(min = 1, max=127)
    private String nome;
    
    @NotNull
    private Integer estoque;
    
    @NotNull
    private Integer estoque_min;
    
    @NotNull
    private Integer estoque_max;
    
    private List<RelatorioModel> relatorios;

    public String getNome() {
        return nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public Integer getEstoque_min() {
        return estoque_min;
    }

    public Integer getEstoque_max() {
        return estoque_max;
    }

    public List<RelatorioModel> getRelatorios() {
        return relatorios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public void setEstoque_min(Integer estoque_min) {
        this.estoque_min = estoque_min;
    }

    public void setEstoque_max(Integer estoque_max) {
        this.estoque_max = estoque_max;
    }

    public void setRelatorios(List<RelatorioModel> relatorios) {
        this.relatorios = relatorios;
    }
    
    
    
}
