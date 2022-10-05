
package deltamike.scoa.model.biblioteca.obra;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "manual")
public class ManualModel extends ObraModel{

    public ManualModel(String titulo, int anoPublicacao, String idioma, String palavrasChave) {
        super(titulo, anoPublicacao, idioma, palavrasChave);
    }
    //Manual Tecnico
    
    
    
}
