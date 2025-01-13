/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.biblioteca.obra;

import deltamike.scoa.util.StringToDurationConverter;
import java.time.Duration;
import jakarta.persistence.Column;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author rodri
 */
public class FilmeDTO extends ObraDTO{
    @Length(max = 255)
    private String diretores;    
    @Length(max = 127)   
    private String distribuidor;
    @Length(max = 127)   
    private String genero;
    @Length(max = 1023)   
    private String sinopse;
      
    private String duracao;

    public String getDiretores() {
        return diretores;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public String getGenero() {
        return genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public Duration getDuracao() {
        return StringToDurationConverter.convert(this.duracao);
    }

    public void setDiretores(String diretores) {
        this.diretores = diretores;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
