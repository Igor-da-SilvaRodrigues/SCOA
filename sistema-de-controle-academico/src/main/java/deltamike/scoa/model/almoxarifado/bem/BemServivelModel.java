
package deltamike.scoa.model.almoxarifado.bem;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "servivel")
public class BemServivelModel extends BemModel{
    @Column(length = 127)
    private String tombo;
    @Column(length = 127)
    private String setor;

    public BemServivelModel(String tombo, String setor, String nome) {
        super(nome);
        this.tombo = tombo;
        this.setor = setor;
    }

    public BemServivelModel() {
    }

    public String getTombo() {
        return tombo;
    }

    public String getSetor() {
        return setor;
    }

    public void setTombo(String tombo) {
        this.tombo = tombo;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    
}
