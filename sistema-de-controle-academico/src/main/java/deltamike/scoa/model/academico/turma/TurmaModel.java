/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.academico.turma;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.academico.curso.CursoModel;
import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import deltamike.scoa.model.academico.sala.SalaModel;
import deltamike.scoa.model.academico.turma_disciplina.TurmaDisciplinaModel;
import deltamike.scoa.model.usuario.AlunoModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


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
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<AlunoModel> alunos;
    
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "turma")
    private List<TurmaDisciplinaModel> turmaDisciplinas;

    public TurmaModel(LocalTime horario, String nome, CursoModel curso, SalaModel sala, List<AlunoModel> alunos) {
        this.horario = horario;
        this.nome = nome;
        this.curso = curso;
        this.sala = sala;
        this.alunos = alunos;
    }

    public TurmaModel() {
    }

    public void setTurmaDisciplinas(List<TurmaDisciplinaModel> turmaDisciplinas) {
        this.turmaDisciplinas = turmaDisciplinas;
    }
    
    public List<TurmaDisciplinaModel> getTurmaDisciplinas() {
        return turmaDisciplinas;
    }
    
    public void addTurmaDisciplina(TurmaDisciplinaModel turmaDisciplinaModel){
        this.turmaDisciplinas.add(turmaDisciplinaModel);
        turmaDisciplinaModel.setTurma(this);
    }
    
    public void removeTurmaDisciplina(TurmaDisciplinaModel turmaDisciplinaModel){
        this.turmaDisciplinas.remove(turmaDisciplinaModel);
        turmaDisciplinaModel.setTurma(null);
        
//        DisciplinaModel disciplina = turmaDisciplinaModel.getDisciplina();
//        if (disciplina != null){
//            disciplina.removeTurmaDisciplina(turmaDisciplinaModel);
//        }
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
    
    public void addAluno(AlunoModel aluno){
        this.alunos.add(aluno);
        aluno.getTurmas().add(this);
    }
    
    public void removeAluno(AlunoModel aluno){
        this.alunos.remove(aluno);
        aluno.getTurmas().remove(this);
    }
    
    @JsonIgnore
    public List<DisciplinaModel> getDisciplinas(){
        if(this.turmaDisciplinas == null){return null;}
        
        ArrayList<DisciplinaModel> disciplinas = new ArrayList<>();
        
        for(TurmaDisciplinaModel turmaDisciplinaModel : this.turmaDisciplinas){
            
            disciplinas.add(turmaDisciplinaModel.getDisciplina());
            
        }
        return disciplinas;
    }
    
}
