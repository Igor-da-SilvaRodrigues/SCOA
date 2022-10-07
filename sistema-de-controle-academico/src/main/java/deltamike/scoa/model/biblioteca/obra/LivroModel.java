
package deltamike.scoa.model.biblioteca.obra;

import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "livro")
public class LivroModel extends ObraModel{
    @Column(length = 127)
    private String autor;
    @Column
    private int quantidadePaginas;
    @Column(length = 1023)
    private String sinopse;
    @Column(length = 127)
    private String ISBN;
    @Column(length = 127)
    private String editora;    

    public LivroModel(String autor, int quantidadePaginas, String sinopse, String ISBN, String editora, String titulo, int anoPublicacao, String idioma, String palavrasChave, List<EmprestimoModel> emprestimos) {
        super(titulo, anoPublicacao, idioma, palavrasChave, emprestimos);
        this.autor = autor;
        this.quantidadePaginas = quantidadePaginas;
        this.sinopse = sinopse;
        this.ISBN = ISBN;
        this.editora = editora;
    }

    public LivroModel() {
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidadePaginas() {
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

    public void setQuantidadePaginas(int quantidadePaginas) {
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
