/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.academico.curso;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import deltamike.scoa.model.academico.turma.TurmaModel;
import deltamike.scoa.model.usuario.AlunoModel;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    private List<DisciplinaModel> disciplinas;
    
    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<TurmaModel> turmas;
    
    @ManyToMany
    @JoinTable
    private List<AlunoModel> alunos;
    
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

    public List<AlunoModel> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoModel> alunos) {
        this.alunos = alunos;
    }

    public void addAluno(AlunoModel aluno){
        this.alunos.add(aluno);
        aluno.getCursos().add(this);
    }
    
    public void removeAluno(AlunoModel aluno){
        this.alunos.remove(aluno);
        aluno.getCursos().remove(this);
    }
}
