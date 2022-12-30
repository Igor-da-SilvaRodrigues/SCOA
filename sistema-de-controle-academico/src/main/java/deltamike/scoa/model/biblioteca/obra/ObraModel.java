
package deltamike.scoa.model.biblioteca.obra;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "obra")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO")
public class ObraModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private Integer anoPublicacao;
    @Column(nullable = false)
    private String idioma;
    @Column(nullable = false, length = 511)
    private String palavrasChave;
    @JsonIgnore //evita recursão infinita quando pegar atraves da api
    @ManyToMany(mappedBy = "obras", fetch = FetchType.EAGER)
    private List<EmprestimoModel> emprestimos;
    @Column(insertable = false, updatable = false)
    private String TIPO;

    public ObraModel(String titulo, Integer anoPublicacao, String idioma, String palavrasChave, List<EmprestimoModel> emprestimos) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.idioma = idioma;
        this.palavrasChave = palavrasChave;
        this.emprestimos = emprestimos;
    }

    public ObraModel(String titulo, Integer anoPublicacao, String idioma, String palavrasChave, List<EmprestimoModel> emprestimos, String TIPO) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.idioma = idioma;
        this.palavrasChave = palavrasChave;
        this.emprestimos = emprestimos;
        this.TIPO = TIPO;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }
    
    
    
    public ObraModel() {
    }

    public List<EmprestimoModel> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<EmprestimoModel> emprestimos) {
        this.emprestimos = emprestimos;
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

    public Integer getAnoPublicacao() {
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

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public void addEmprestimo(EmprestimoModel em){
        this.emprestimos.add(em);
        em.getObras().add(this);
    }    
    
    public void removeEmprestimo(EmprestimoModel em){
        this.emprestimos.remove(em);
        em.getObras().remove(this);
            
    }
    
    @Override
    public String toString() {
        return this.titulo;
    }
    
    
    
}
