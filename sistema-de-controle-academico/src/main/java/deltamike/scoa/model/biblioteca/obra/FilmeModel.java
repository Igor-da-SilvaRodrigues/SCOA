
package deltamike.scoa.model.biblioteca.obra;

import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import java.time.Duration;
import java.util.List;
import javax.persistence.Column;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
@DiscriminatorValue(value = "filme")
public class FilmeModel extends ObraModel{
    
    @Column
    private String diretores;
    @Column(length = 127)
    private String distribuidor;
    @Column(length = 127)
    private String genero;
    @Column(length = 1023)
    private String sinopse;
    @Column
    private Duration duracao;

    public FilmeModel(String diretores, String distribuidor, String genero, String sinopse, Duration duracao, String titulo, int anoPublicacao, String idioma, String palavrasChave, List<EmprestimoModel> emprestimos) {
        super(titulo, anoPublicacao, idioma, palavrasChave, emprestimos);
        this.diretores = diretores;
        this.distribuidor = distribuidor;
        this.genero = genero;
        this.sinopse = sinopse;
        this.duracao = duracao;
    }

    public FilmeModel() {
    }

    
    
    
    public String getDiretores() {
        return diretores;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public String getGenero() {
        return genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDiretores(String diretores) {
        this.diretores = diretores;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }
    
    
}
