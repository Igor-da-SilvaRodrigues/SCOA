/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.academico.disciplina;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.academico.curso.CursoModel;
import deltamike.scoa.model.academico.turma.TurmaModel;
import deltamike.scoa.model.academico.turma_disciplina.TurmaDisciplinaModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

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
    
    @ManyToOne(fetch = FetchType.EAGER)
    private CursoModel curso;
    
    @JsonIgnore
    @OneToMany(mappedBy = "disciplina")
    private List<TurmaDisciplinaModel> turmaDisciplinas;

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

    public void setTurmaDisciplinas(List<TurmaDisciplinaModel> turmaDisciplinas) {
        this.turmaDisciplinas = turmaDisciplinas;
    }

    public List<TurmaDisciplinaModel> getTurmaDisciplinas() {
        return turmaDisciplinas;
    }
    
    public void addTurmaDisciplina(TurmaDisciplinaModel turmaDisciplinaModel){
        this.turmaDisciplinas.add(turmaDisciplinaModel);
        turmaDisciplinaModel.setDisciplina(this);
    }
    
    public void removeTurmaDisciplina(TurmaDisciplinaModel turmaDisciplinaModel){
        this.turmaDisciplinas.remove(turmaDisciplinaModel);
        turmaDisciplinaModel.setDisciplina(null);
    }
}
