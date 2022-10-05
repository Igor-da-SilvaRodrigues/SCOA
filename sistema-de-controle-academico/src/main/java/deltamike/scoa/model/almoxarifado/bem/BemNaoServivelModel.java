
package deltamike.scoa.model.almoxarifado.bem;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "nao_servivel")
public class BemNaoServivelModel extends BemModel{

    public BemNaoServivelModel(String nome) {
        super(nome);
    }

    public BemNaoServivelModel() {
    }
    
}
