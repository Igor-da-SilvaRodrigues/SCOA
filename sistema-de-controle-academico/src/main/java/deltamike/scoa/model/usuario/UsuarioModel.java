package deltamike.scoa.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Table(name = UsuarioModel.TABLE_NAME)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO")
public class UsuarioModel implements Serializable{

    public interface CreateUser {
    }

    public interface UpdateUser {
    }

    public static final String TABLE_NAME = "user";

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email", length = 100, unique = true)
    private String id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 60, nullable = false)
    private String password;
    
    //@Id
    //@Column(name = "email", length = 100, nullable = false, unique = true)
    //private String email;

    @Column(name = "cpf", length = 60, nullable = false, unique = true)
    private String cpf;

    @Column(name = "telefone", length = 9, nullable = false)
    private int telefone;//string?
    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<EmprestimoModel> emprestimos;

    public UsuarioModel() {
    }

    public UsuarioModel(String id, String username, String password, String cpf, int telefone) {
        this.id = id;
        this.username = username;
        this.password = password;
        //this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public UsuarioModel(String username, String password, String cpf, int telefone) {
        this.username = username;
        this.password = password;
        //this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getEmail() {
//        return this.email;
//    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public List<EmprestimoModel> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<EmprestimoModel> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    public void addEmprestimo(EmprestimoModel em){
        this.emprestimos.add(em);
        em.setUser(this);
    }
    
    public void removeEmprestimo(EmprestimoModel em){
        this.emprestimos.remove(em);
        em.setUser(null);
    }
    
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this)
//            return true;
//        if (obj == null)
//            return false;
//        if (!(obj instanceof UsuarioModel))
//            return false;
//        UsuarioModel other = (UsuarioModel) obj;
//        if (this.id == null)
//            if (other.id != null)
//                return false;
//            else if (!this.id.equals(other.id))
//                return false;
//        return Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username)
//                && Objects.equals(this.password, other.password);
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
//        return result;
//    }

}
