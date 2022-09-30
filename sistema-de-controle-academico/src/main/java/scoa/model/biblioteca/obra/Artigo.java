
package scoa.model.biblioteca.obra;

import java.util.ArrayList;


public class Artigo extends Obra{
    private String autor;
    private String editora;

    public Artigo( String titulo, int anoPublicacao, String idioma, ArrayList<String> palavrasChave, String autor, String editora) {
        super(titulo, anoPublicacao, idioma, palavrasChave, "Artigo");
        this.autor = autor;
        this.editora = editora;
    }
    
}
