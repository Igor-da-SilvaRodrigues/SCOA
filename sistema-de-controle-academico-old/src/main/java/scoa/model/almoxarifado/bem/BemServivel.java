
package scoa.model.almoxarifado.bem;

public class BemServivel extends Bem {
    private String tombo;
    private String setor;

    public BemServivel(String nome, String tombo, String setor) {
        super(nome, "Servivel");
        this.tombo = tombo;
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public String getTombo() {
        return tombo;
    }   
    
}
