package deltamike.scoa.dtos.usuario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import java.util.List;

public class UserDTO {

   @NotBlank
   @Size(min = 2, max = 100)
   private String username;

   @JsonProperty(access = Access.WRITE_ONLY)
   @NotBlank
   @Size(min = 8, max = 60)
   private String password; 

   @NotBlank
   @Size(max = 100)
   private String email;

   @NotBlank
   @Size(max = 11)
   private String cpf;

   @NotBlank
   @Size(max = 9)
   private String telefone;
   
   private List<EmprestimoModel> emprestimos;


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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return this.telefone;
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
    
    
    
}
