
package scoa.model.biblioteca.obra;

import java.util.ArrayList;

public class Livro extends Obra {
    private String autor;
    private int quantidadePaginas;
    private String sinopse;
    private String ISBN;
    private String editora;

    public Livro(String titulo, int anoPublicacao, String idioma, ArrayList<String> palavrasChave, String autor, int quantidadePaginas, String sinopse, String ISBN, String editora) {
        super(titulo, anoPublicacao, idioma, palavrasChave, "Livro");
        this.autor = autor;
        this.quantidadePaginas = quantidadePaginas;
        this.sinopse = sinopse;
        this.ISBN = ISBN;
        this.editora = editora;
    }

    public Livro() {}
    
    @Override
    public String toString(){
        return (super.toString() + 
                "Autor: " + this.autor + "\n" + 
                "Quantidade de Paginas: " + this.quantidadePaginas + "\n" +
                "Sinopse: " + this.sinopse + "\n" +
                "ISBN: " + this.ISBN + "\n" +
                "Editora: " + this.editora + "\n");
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getEditora() {
        return editora;
    }
    
    
}
