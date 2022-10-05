
package deltamike.scoa.model.biblioteca.obra;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "revista")
public class RevistaModel extends ObraModel{
    private String editora;

    public RevistaModel(String editora, String titulo, int anoPublicacao, String idioma, String palavrasChave) {
        super(titulo, anoPublicacao, idioma, palavrasChave);
        this.editora = editora;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    
    
}
