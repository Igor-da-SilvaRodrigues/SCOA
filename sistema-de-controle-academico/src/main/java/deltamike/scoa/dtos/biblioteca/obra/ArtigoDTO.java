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
public class ArtigoDTO extends ObraDTO{

    @Length(max = 127)
    private String autor;
    
    @Length(max = 127)
    private String editora;

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    
}
