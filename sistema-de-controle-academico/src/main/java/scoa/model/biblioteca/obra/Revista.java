
package scoa.model.biblioteca.obra;

import java.util.ArrayList;

 class Revista extends Obra{
    private String editora;

    public Revista( String titulo, int anoPublicacao, String idioma, ArrayList<String> palavrasChave, String editora) {
        super(titulo, anoPublicacao, idioma, palavrasChave, "Revista");
        this.editora = editora;
    }
    
}
