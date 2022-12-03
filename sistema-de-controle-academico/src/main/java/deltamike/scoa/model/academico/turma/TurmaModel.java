/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.academico.turma;

import deltamike.scoa.model.academico.curso.CursoModel;
import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import deltamike.scoa.model.academico.sala.SalaModel;
import deltamike.scoa.model.usuario.AlunoModel;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "turma")
public class TurmaModel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    private LocalTime horario;
    
    @Column(nullable = false)
    private String nome;
    
    @ManyToOne
    private CursoModel curso;
    
    @ManyToOne
    private SalaModel sala;
    
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<AlunoModel> alunos;
    
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private List<DisciplinaModel> disciplinas;

    public TurmaModel(LocalTime horario, String nome, CursoModel curso, SalaModel sala, List<AlunoModel> alunos, List<DisciplinaModel> disciplinas) {
        this.horario = horario;
        this.nome = nome;
        this.curso = curso;
        this.sala = sala;
        this.alunos = alunos;
        this.disciplinas = disciplinas;
    }

    public TurmaModel() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }

    public void setSala(SalaModel sala) {
        this.sala = sala;
    }

    public void setAlunos(List<AlunoModel> alunos) {
        this.alunos = alunos;
    }

    public void setDisciplinas(List<DisciplinaModel> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public String getNome() {
        return nome;
    }

    public CursoModel getCurso() {
        return curso;
    }

    public SalaModel getSala() {
        return sala;
    }

    public List<AlunoModel> getAlunos() {
        return alunos;
    }

    public List<DisciplinaModel> getDisciplinas() {
        return disciplinas;
    }
    
    public void addAluno(AlunoModel aluno){
        this.alunos.add(aluno);
        aluno.getTurmas().add(this);
    }
    
    public void removeAluno(AlunoModel aluno){
        this.alunos.remove(aluno);
        aluno.getTurmas().remove(this);
    }
    
    public void addDisciplina(DisciplinaModel disciplina){
        this.disciplinas.add(disciplina);
        disciplina.getTurmas().add(this);
    }
    
    public void removeDisciplina(DisciplinaModel disciplina) {
        this.disciplinas.remove(disciplina);
        disciplina.getTurmas().remove(this);
    }
    
    
}
