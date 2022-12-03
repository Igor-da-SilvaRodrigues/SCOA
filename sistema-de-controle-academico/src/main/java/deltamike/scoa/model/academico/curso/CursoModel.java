/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.academico.curso;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
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
@Table(name = "curso")
public class CursoModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(nullable = false)
    private String nome;
    
    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    List<DisciplinaModel> disciplinas;
    
    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    List<TurmaModel> turmas;

    public CursoModel(String nome) {
        this.nome = nome;
    }

    public CursoModel() {
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<DisciplinaModel> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<DisciplinaModel> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void removeDisciplina(DisciplinaModel disciplina){
        this.disciplinas.remove(disciplina);
        disciplina.setCurso(null);
    }

    public List<TurmaModel> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<TurmaModel> turmas) {
        this.turmas = turmas;
    }
    
    public void removeTurma(TurmaModel turma){
        this.turmas.remove(turma);
        turma.setCurso(null);
    }
}
