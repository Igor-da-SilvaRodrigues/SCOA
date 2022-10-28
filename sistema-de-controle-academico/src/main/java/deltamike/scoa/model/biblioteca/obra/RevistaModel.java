
package deltamike.scoa.model.biblioteca.obra;

import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "revista")
@DiscriminatorValue(value = "revista")
public class RevistaModel extends ObraModel{
    private String editora;

    public RevistaModel(String editora, String titulo, int anoPublicacao, String idioma, String palavrasChave, List<EmprestimoModel> emprestimos) {
        super(titulo, anoPublicacao, idioma, palavrasChave, emprestimos);
        this.editora = editora;
    }

    public RevistaModel() {
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    
    
}
