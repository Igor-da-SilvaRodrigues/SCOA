/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.biblioteca.obra;

import jakarta.persistence.Column;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author rodri
 */
public class LivroDTO extends ObraDTO{
    @Length(max = 127)
    private String autor;
    
    private Integer quantidadePaginas;
    
    @Length(max = 1023)
    private String sinopse;
    
    @Length(max = 127)
    private String ISBN;
    
    @Length(max = 127)
    private String editora;

    public String getAutor() {
        return autor;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getEditora() {
        return editora;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setQuantidadePaginas(Integer quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    
}
