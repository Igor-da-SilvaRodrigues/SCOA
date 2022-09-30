
package scoa.model.biblioteca.obra;

import java.util.ArrayList;


public class Jornal extends Obra{
    private String manchete;
    private int quantidadePaginas;

    public Jornal(String titulo, int anoPublicacao, String idioma, ArrayList<String> palavrasChave, String manchete, int quantidadePaginas) {
        super(titulo, anoPublicacao, idioma, palavrasChave, "Jornal");
        this.manchete = manchete;
        this.quantidadePaginas = quantidadePaginas;
    }
    
}
