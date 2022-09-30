
package scoa.model.biblioteca.obra;

import java.util.ArrayList;


public class ManualTecnico extends Obra{

    public ManualTecnico(String titulo, int anoPublicacao, String idioma, ArrayList<String> palavrasC) {
        super(titulo, anoPublicacao, idioma, palavrasC, "Manual");
    }
    
}
