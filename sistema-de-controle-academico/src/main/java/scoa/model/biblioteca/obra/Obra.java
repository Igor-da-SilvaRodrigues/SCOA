package scoa.model.biblioteca.obra;

import java.util.ArrayList;

public class Obra {
    private String titulo;
    private int anoPublicacao;
    private String idioma;
    private ArrayList<String> palavrasChave;
    private String tipo;

    protected Obra(String titulo, int anoPublicacao, String idioma, ArrayList<String> palavrasChave, String tipo) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.idioma = idioma;
        this.palavrasChave = palavrasChave;
        this.tipo = tipo;
    }
    public Obra(){}

    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getIdioma() {
        return idioma;
    }

    public ArrayList<String> getPalavrasChave() {
        return palavrasChave;
    }

    public String getTipo() {
        return tipo;
    }
    
    @Override
    public String toString(){
        return ("Titulo: " + this.titulo + "\n" + 
                "Ano de publicacao: " + this.anoPublicacao + "\n" +
                "Idioma: " + this.idioma + "\n" +
                "Palavras-Chave: " + this.palavrasChave + "\n" + 
                "Tipo: "+ this.tipo + "\n"
                );
    }
}
