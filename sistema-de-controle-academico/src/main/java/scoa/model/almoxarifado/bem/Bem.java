
package scoa.model.almoxarifado.bem;

public class Bem {
    private String nome;
    private String tipo;

    protected Bem(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Bem() {
    }
    

    public String getTipo() {
        return tipo;
    }
    
    public String getNome() {
        return nome;
    }
    
}
