/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.academico.turma_disciplina;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import deltamike.scoa.model.academico.turma.TurmaModel;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "turma_disciplina")
public class TurmaDisciplinaModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaModel turma;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private DisciplinaModel disciplina;

    public TurmaDisciplinaModel(TurmaModel turma, DisciplinaModel disciplina) {
        this.turma = turma;
        this.disciplina = disciplina;
    }

    public TurmaDisciplinaModel() {
    }

    public Integer getId() {
        return id;
    }

    public TurmaModel getTurma() {
        return turma;
    }

    public DisciplinaModel getDisciplina() {
        return disciplina;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTurma(TurmaModel turma) {
        this.turma = turma;
    }

    public void setDisciplina(DisciplinaModel disciplina) {
        this.disciplina = disciplina;
    }
    
    
}
