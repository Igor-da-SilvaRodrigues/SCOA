/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.academico.sala;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.academico.turma.TurmaModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "sala")
public class SalaModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private String nome;
    
    @JsonIgnore
    @OneToMany(mappedBy = "sala")
    private List<TurmaModel> turmas;

    public SalaModel(String nome) {
        this.nome = nome;
    }

    public SalaModel() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TurmaModel> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<TurmaModel> turmas) {
        this.turmas = turmas;
    }
    
    public void addTurma(TurmaModel t){
        this.turmas.add(t);
        t.setSala(this);
    }
            
    public void removeTurma(TurmaModel t){
      this.turmas.remove(t);
      t.setSala(null);
    }
}
