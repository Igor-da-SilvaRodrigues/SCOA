
package scoa.model.almoxarifado.produto;

public class Produto {
    private int estoqueMax;
    private int estoqueMin;
    private String referencia;
    private String localizacao;
    private String codBarras;
    private String nome;
    private String tipo;

    protected Produto(int estoqueMax, int estoqueMin, String referencia, String localizacao, String codBarras, String nome, String tipo) {
        this.estoqueMax = estoqueMax;
        this.estoqueMin = estoqueMin;
        this.referencia = referencia;
        this.localizacao = localizacao;
        this.codBarras = codBarras;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Produto() {
    }
    

    public String getCodBarras() {
        return codBarras;
    }

    public int getEstoqueMax() {
        return estoqueMax;
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
    
    
}
