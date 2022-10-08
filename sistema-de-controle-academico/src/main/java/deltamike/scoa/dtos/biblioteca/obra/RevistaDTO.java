/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.biblioteca.obra;

import org.hibernate.validator.constraints.Length;

/**
 *
 * @author rodri
 */
public class RevistaDTO extends ObraDTO{
    @Length(max = 255)
    private String editora; 

    public String getEditora() {
        return editora;
    }
    
    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    
}
