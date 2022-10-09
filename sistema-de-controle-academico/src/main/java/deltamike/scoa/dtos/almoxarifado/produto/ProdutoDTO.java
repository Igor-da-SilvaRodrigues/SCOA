/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.almoxarifado.produto;

import deltamike.scoa.model.almoxarifado.relatorio.RelatorioModel;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author rodri
 */
public class ProdutoDTO {

    @NotNull
    private Integer estoqueMax;
    
    @NotNull
    private Integer estoqueMin;
    
    @NotBlank
    @Length(max = 255)
    private String referencia;
    
    @NotBlank
    @Length(max = 255)
    private String localizacao;
    
    @NotBlank
    @Length(max = 255)
    private String codBarras;
    
    @NotBlank
    @Length(max = 127)
    private String nome;
    
    private List<RelatorioModel> relatorios;

    public Integer getEstoqueMax() {
        return estoqueMax;
    }

    public Integer getEstoqueMin() {
        return estoqueMin;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public String getNome() {
        return nome;
    }

    public List<RelatorioModel> getRelatorios() {
        return relatorios;
    }

    public void setEstoqueMax(Integer estoqueMax) {
        this.estoqueMax = estoqueMax;
    }

    public void setEstoqueMin(Integer estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRelatorios(List<RelatorioModel> relatorios) {
        this.relatorios = relatorios;
    }

    
}
