
package deltamike.scoa.dtos.biblioteca.emprestimo;

import deltamike.scoa.model.biblioteca.obra.ObraModel;
import deltamike.scoa.model.usuario.UsuarioModel;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotNull;


public class EmprestimoDTO {
   
    
    private List<ObraModel> obras;
    
    @NotNull
    private LocalDate prazo;
    
    private UsuarioModel user;

    public List<ObraModel> getObras() {
        return obras;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setObras(List<ObraModel> obras) {
        this.obras = obras;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public UsuarioModel getUser() {
        return user;
    }

    public void setUser(UsuarioModel user) {
        this.user = user;
    }
    
    
    
}
