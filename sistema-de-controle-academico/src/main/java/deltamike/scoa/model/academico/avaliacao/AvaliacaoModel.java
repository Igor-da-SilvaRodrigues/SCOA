/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.academico.avaliacao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import deltamike.scoa.model.academico.turma.TurmaModel;
import deltamike.scoa.model.academico.turma_disciplina.TurmaDisciplinaModel;
import deltamike.scoa.model.usuario.AlunoModel;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "avaliacao")
public class AvaliacaoModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    private AlunoModel aluno;
    
    @ManyToOne
    private TurmaDisciplinaModel turmaDisciplina;
    
    private Float nota;
    
    private LocalDate data;

    public AvaliacaoModel(AlunoModel aluno, TurmaDisciplinaModel turmaDisciplinas) {
        this.aluno = aluno;
        this.turmaDisciplina = turmaDisciplinas;
    }

    public AvaliacaoModel() {
    }
    
    
    public Integer getId() {
        return id;
    }

    public AlunoModel getAluno() {
        return aluno;
    }
    
    public TurmaDisciplinaModel getTurmaDisciplina() {
        return turmaDisciplina;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }

    public void setTurmaDisciplina(TurmaDisciplinaModel turmaDisciplina) {
        this.turmaDisciplina = turmaDisciplina;
    }
    
    @JsonIgnore
    public DisciplinaModel getDisciplina(){
        if(this.turmaDisciplina == null){return null;}
        
        return this.turmaDisciplina.getDisciplina();
    }
    
    @JsonIgnore
    public TurmaModel getTurma(){
        if(this.turmaDisciplina == null){return null;}
        
        return this.turmaDisciplina.getTurma();
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public void removeAluno() {
        if(this.aluno == null){return;}
        this.aluno.removeAvaliacao(this);        
    }

    public void removeTurmaDisciplina() {
        if(this.turmaDisciplina == null){return;}
        
        this.turmaDisciplina.removeAvaliacao(this);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
}
