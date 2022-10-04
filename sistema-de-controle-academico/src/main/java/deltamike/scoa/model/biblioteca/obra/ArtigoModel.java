
package deltamike.scoa.model.biblioteca.obra;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "artigo")
public class ArtigoModel extends ObraModel{
    @Column(length = 127)
    private String autor;
    @Column(length = 127)
    private String editora;

    public ArtigoModel(String titulo, int anoPublicacao, String idioma, String palavrasChave, String autor, String editora) {
        super(titulo, anoPublicacao, idioma, palavrasChave);
        this.autor = autor;
        this.editora = editora;
    }

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
