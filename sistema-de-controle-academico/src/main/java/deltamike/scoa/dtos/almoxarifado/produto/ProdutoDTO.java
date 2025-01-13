/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.almoxarifado.produto;

import deltamike.scoa.dtos.almoxarifado.item.ItemDTO;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author rodri
 */
public class ProdutoDTO extends ItemDTO{
    
    @Length(max = 255)
    @NotNull
    private String referencia;
    
    @Length(max = 255)
    @NotNull
    private String localizacao;
    
    @Length(max = 255)
    @NotNull
    private String codBarras;

    public String getReferencia() {
        return referencia;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getCodBarras() {
        return codBarras;
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

}
