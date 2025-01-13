/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.academico.turma;

import deltamike.scoa.model.academico.curso.CursoModel;
import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import deltamike.scoa.model.academico.sala.SalaModel;
import deltamike.scoa.model.usuario.AlunoModel;
import java.time.LocalTime;
import java.util.List;
import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author rodri
 */
public class TurmaDTO {
    
    @NotBlank
    private String horario;
    @NotBlank
    private String nome;
    
    private CursoModel curso;
    
    private SalaModel sala;
    
    private List<AlunoModel> alunos;
    
    private List<DisciplinaModel> disciplinas;

    public void setHorario(String horario) {
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

    public LocalTime getHorario() {
        return LocalTime.parse(this.horario);
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
    
    

}
