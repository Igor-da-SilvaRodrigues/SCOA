
package deltamike.scoa.model.biblioteca.obra;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.DiscriminatorColumn;

@Entity
@Table(name = "obra")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO")
public class ObraModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private int anoPublicacao;
    @Column(nullable = false)
    private String idioma;
    @Column(nullable = false, length = 511)
    private String palavrasChave;

    public ObraModel(String titulo, int anoPublicacao, String idioma, String palavrasChave) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.idioma = idioma;
        this.palavrasChave = palavrasChave;
    }

    public ObraModel() {
    }
    
    
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }
    
}
