
package deltamike.scoa.model.biblioteca.obra;

import deltamike.scoa.model.biblioteca.emprestimo.EmprestimoModel;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "manual")
public class ManualModel extends ObraModel{

    public ManualModel(String titulo, Integer anoPublicacao, String idioma, String palavrasChave, List<EmprestimoModel> emprestimos) {
        super(titulo, anoPublicacao, idioma, palavrasChave, emprestimos);
    }

    //Manual Tecnico

    public ManualModel() {
    }
    
}
