/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.academico.disciplina;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.academico.curso.CursoModel;
import deltamike.scoa.model.academico.turma.TurmaModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "disciplina")
public class DisciplinaModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private String nome;
    
    @ManyToOne
    private CursoModel curso;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "disciplinas")
    List<TurmaModel> turmas;

    public DisciplinaModel() {
    }

    public DisciplinaModel(String nome, CursoModel curso) {
        this.nome = nome;
        this.curso = curso;
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

    public CursoModel getCurso() {
        return curso;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }

    public List<TurmaModel> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<TurmaModel> turmas) {
        this.turmas = turmas;
    }
    
    public void addTurma(TurmaModel turma){
        this.turmas.add(turma);
        turma.getDisciplinas().add(this);
    }
    
    public void removeTurma(TurmaModel turma){
        this.turmas.remove(turma);
        turma.getDisciplinas().remove(this);
    }
}
