
package deltamike.scoa.dtos.biblioteca.emprestimo;

import deltamike.scoa.model.biblioteca.obra.ObraModel;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotNull;


public class EmprestimoDTO {
   
    
    private List<ObraModel> obras;
    //private Usuario cliente; // n vou mecher com usuario ainda
    @NotNull
    private LocalDate prazo;

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
    
    
}
