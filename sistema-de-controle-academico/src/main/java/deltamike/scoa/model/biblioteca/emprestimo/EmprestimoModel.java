
package deltamike.scoa.model.biblioteca.emprestimo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import deltamike.scoa.model.biblioteca.obra.ObraModel;
import deltamike.scoa.model.usuario.UsuarioModel;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "emprestimo")
public class EmprestimoModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToMany
    @JoinTable(
            name = "emprestimo_obra",
            joinColumns = @JoinColumn(name = "emprestimo_id"),
            inverseJoinColumns = @JoinColumn(name = "obra_id")
    )
    private List<ObraModel> obras;
    
    @ManyToOne
    private UsuarioModel user;
    
    //prazos devem ser enviados para api obedecendo o seguinte formato:
    //ano-mez-dia
    //ex: "2023-12-01"
    @Column(nullable = false)
    private LocalDate prazo;

    public EmprestimoModel(List<ObraModel> obras, LocalDate prazo) {
        this.obras = obras;
        this.prazo = prazo;
    }

    public EmprestimoModel() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public List<ObraModel> getObras() {
        return obras;
    }

    public void setObras(List<ObraModel> obras) {
        this.obras = obras;
    }

    public UsuarioModel getUser() {
        return user;
    }

    public void setUser(UsuarioModel user) {
        this.user = user;
    }
    
    
    
    
    @Override
    public String toString(){
        
        return 
                "\n id: " + this.id + "\n" +
                "obras: " + this.obras + "\n";
    }
}
