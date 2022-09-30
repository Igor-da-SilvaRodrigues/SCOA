
package scoa.model.biblioteca.obra;

import java.time.Duration;
import java.util.ArrayList;


public class Filme extends Obra{
    private ArrayList<String> diretores;
    private String distribuidor;
    private String genero;
    private String sinopse;
    private Duration duracao;

    public Filme( String titulo, int anoPublicacao, String idioma, ArrayList<String> palavrasChave, ArrayList<String> diretores, String distribuidor, String genero, String sinopse, Duration duracao) {
        super(titulo, anoPublicacao, idioma, palavrasChave, "Filme");
        this.diretores = diretores;
        this.distribuidor = distribuidor;
        this.genero = genero;
        this.sinopse = sinopse;
        this.duracao = duracao;
    }
    
}
