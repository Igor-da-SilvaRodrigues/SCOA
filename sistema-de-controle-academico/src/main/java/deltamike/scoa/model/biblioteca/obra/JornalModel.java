
package deltamike.scoa.model.biblioteca.obra;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "jornal")
public class JornalModel extends ObraModel{
    
    @Column
    private String manchete;
    @Column
    private int quantidadePaginas;

    public JornalModel(String manchete, int quantidadePaginas, String titulo, int anoPublicacao, String idioma, String palavrasChave) {
        super(titulo, anoPublicacao, idioma, palavrasChave);
        this.manchete = manchete;
        this.quantidadePaginas = quantidadePaginas;
    }

    public String getManchete() {
        return manchete;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setManchete(String manchete) {
        this.manchete = manchete;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }
    
    
}
