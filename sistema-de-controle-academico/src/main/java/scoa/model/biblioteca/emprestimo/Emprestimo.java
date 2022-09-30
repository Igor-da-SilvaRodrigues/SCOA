
package scoa.model.biblioteca.emprestimo;

import scoa.model.biblioteca.obra.Obra;
import java.time.LocalDate;
import java.util.ArrayList;

public class Emprestimo {
    private ArrayList<Obra> obras;
    //private Usuario cliente;
    private LocalDate prazo;

    public Emprestimo(ArrayList<Obra> obras, LocalDate prazo) {
        this.obras = obras;
        this.prazo = prazo;
    }

    public ArrayList<Obra> getObras() {
        return obras;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    
}
