package deltamike.scoa.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = UsuarioModel.TABLE_NAME)
@Inheritance(strategy = InheritanceType.JOINED)
public class UsuarioModel implements Serializable, UserDetails {

    public static final String TABLE_NAME = "user";

    @Id
    @Column(name = "email", length = 100, unique = true)
    private String id;

    @Column(name = "username", length = 100, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "cpf", length = 60, nullable = false, unique = true)
    private String cpf;

    @Column(name = "telefone", length = 9, nullable = false)
    private String telefone;//string?
    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<EmprestimoModel> emprestimos;
    
    public UsuarioModel() {
    }

    public UsuarioModel(String id, String username, String password, String cpf, String telefone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public UsuarioModel(String username, String password, String cpf, String telefone) {
        this.username = username;
        this.password = password;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    
    

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUserNickname() {
        return this.username;
    }
    public void setUserNickname(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
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


    @Override
    public String getUsername() {
        return getId(); //bacalhau. O id não deveria ser o que o usuário digita para logar. Mas infelizmente foi assim que eu decidi fazer no passado.
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UsuarioModel))
            return false;
        UsuarioModel other = (UsuarioModel) obj;
        if (this.id == null)
            if (other.id != null)
                return false;
            else if (!this.id.equals(other.id))
                return false;
        return Objects.equals(this.id, other.id) && Objects.equals(this.username, other.username)
                && Objects.equals(this.password, other.password);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    
    @Override
    public String toString(){
        return this.id;
    }

}
