
package deltamike.scoa.model.biblioteca.obra;

import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "jornal")
@DiscriminatorValue(value = "jornal")
public class JornalModel extends ObraModel{
    
    @Column
    private String manchete;
    @Column
    private Integer quantidadePaginas;

    public JornalModel(String manchete, Integer quantidadePaginas, String titulo, Integer anoPublicacao, String idioma, String palavrasChave, List<EmprestimoModel> emprestimos) {
        super(titulo, anoPublicacao, idioma, palavrasChave, emprestimos);
        this.manchete = manchete;
        this.quantidadePaginas = quantidadePaginas;
    }

    public JornalModel() {
    }

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
