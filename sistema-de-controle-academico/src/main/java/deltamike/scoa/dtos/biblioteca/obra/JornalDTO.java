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
public class JornalDTO extends ObraDTO{
    @Length(max = 255)
    private String manchete;
    
    private Integer quantidadePaginas;

    public String getManchete() {
        return manchete;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setManchete(String manchete) {
        this.manchete = manchete;
    }

    public void setQuantidadePaginas(Integer quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }
    
    
}
