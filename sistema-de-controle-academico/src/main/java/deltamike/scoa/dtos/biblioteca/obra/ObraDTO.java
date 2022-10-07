/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.biblioteca.obra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author rodri
 */
public class ObraDTO {
    @NotBlank
    @Length(max = 255)
    private String titulo;
    @NotNull
    private Integer anoPublicacao;
    @NotBlank
    @Length(max = 255)
    private String idioma;
    @NotBlank
    @Length(max = 511)
    private String palavrasChave;

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }
    
    

}
