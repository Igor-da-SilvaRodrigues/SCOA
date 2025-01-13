
package deltamike.scoa.model.biblioteca.obra;

import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "artigo")
@DiscriminatorValue(value = "artigo")
public class ArtigoModel extends ObraModel{
    @Column(length = 127)
    private String autor;
    @Column(length = 127)
    private String editora;

    public ArtigoModel(String autor, String editora, String titulo, int anoPublicacao, String idioma, String palavrasChave, List<EmprestimoModel> emprestimos) {
        super(titulo, anoPublicacao, idioma, palavrasChave, emprestimos);
        this.autor = autor;
        this.editora = editora;
    }

    public ArtigoModel() {
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
