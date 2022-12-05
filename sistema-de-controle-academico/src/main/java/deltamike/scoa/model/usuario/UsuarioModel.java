package deltamike.scoa.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Table(name = UsuarioModel.TABLE_NAME)
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

    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private FuncionarioModel funcionario;
    
    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private AlunoModel aluno;
    
    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private CoordenadorModel coordenador;
    
    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private DiretorModel diretor;
    
    @JsonIgnore
    @OneToOne(mappedBy = "usuario")
    private ProfessorModel professor;
    
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

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }
    
    public FuncionarioModel getFuncionario() {
        return funcionario;
    }
    
    public void removeFuncionario(){
        if (this.funcionario != null){
            this.funcionario.setUsuario(null);
        }
        this.funcionario = null;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }
    
    public AlunoModel getAluno() {
        return aluno;
    }
    
    public void removeAluno(){
        if (this.aluno != null){
            this.aluno.setUsuario(null);
        }
        this.aluno = null;
    }

    public void setCoordenador(CoordenadorModel coordenador) {
        this.coordenador = coordenador;
    }
    
    public void removeCoordenador(){
        if (this.coordenador != null){
            this.coordenador.setUsuario(null);
        }
        this.coordenador = null;
    }

    public DiretorModel getDiretor() {
        return diretor;
    }

    public void setDiretor(DiretorModel diretor) {
        this.diretor = diretor;
    }
    
    public void removeDiretor(){
        if (this.diretor != null){
            this.diretor.setUsuario(null);
        }
        this.coordenador = null;
    }

    public ProfessorModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) {
        this.professor = professor;
    }
    
    public void removeProfessor(){
        if (this.professor != null){
            this.professor.setUsuario(null);
        }
        this.professor = null;
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

    public CoordenadorModel getCoordenador() {
        return coordenador;
    }


}
