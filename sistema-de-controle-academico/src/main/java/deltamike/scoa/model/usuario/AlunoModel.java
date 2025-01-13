/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.academico.avaliacao.AvaliacaoModel;
import deltamike.scoa.model.academico.curso.CursoModel;
import deltamike.scoa.model.academico.turma.TurmaModel;
import deltamike.scoa.model.financeiro.mensalidade.MensalidadeModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author rodri
 */
@Entity
@Table(name = "aluno")
public class AlunoModel extends UsuarioModel{


    @Column(length = 60)
    private String matricula;
    private Integer ano_letivo;
    private Integer carga_horaria;
    @Column(length = 60)
    private String situacao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<MensalidadeModel> mensalidades;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "alunos")
    private List<TurmaModel> turmas;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "alunos", fetch = FetchType.EAGER)
    private List<CursoModel> cursos;
    
    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<AvaliacaoModel> avaliacoes;

    public AlunoModel(String matricula, Integer ano_letivo, Integer carga_horaria, String situacao){
        this.matricula = matricula;
        this.ano_letivo=ano_letivo;
        this.carga_horaria = carga_horaria;
        this.situacao = situacao;
    }

    public AlunoModel(String matricula, Integer ano_letivo, Integer carga_horaria, String situacao, List<MensalidadeModel> mensalidades) {
        this.matricula = matricula;
        this.ano_letivo = ano_letivo;
        this.carga_horaria = carga_horaria;
        this.situacao = situacao;
        this.mensalidades = mensalidades;
    }

    
    public AlunoModel(){
    }
    
    public String getMatricula(){return this.matricula;}
    public Integer getAno_letivo(){return this.ano_letivo;}
    public Integer getCarga_horaria(){return this.carga_horaria;}
    public String getSituacao(){return this.situacao;}

    public void setMatricula(String matricula){this.matricula = matricula;}
    public void setAno_letivo(Integer ano_letivo){this.ano_letivo=ano_letivo;}
    public void setCarga_horaria(Integer carga_horaria){this.carga_horaria = carga_horaria;}
    public void setSituacao(String situacao){this.situacao = situacao;}

    public List<MensalidadeModel> getMensalidades() {
        return mensalidades;
    }

    public void setMensalidades(List<MensalidadeModel> mensalidades) {
        this.mensalidades = mensalidades;
    }
    
    public void addMensalidade(MensalidadeModel mensalidade){
        this.mensalidades.add(mensalidade);
        mensalidade.setAluno(this);
    }
    
    public void removeMensalidade(MensalidadeModel mensalidade){
        this.mensalidades.remove(mensalidade);
        mensalidade.setAluno(null);
    }


    public List<TurmaModel> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<TurmaModel> turmas) {
        this.turmas = turmas;
    }
    
    public void addTurma(TurmaModel turma){
        this.turmas.add(turma);
        turma.getAlunos().add(this);
    }
    
    public void removeTurma(TurmaModel turma){
        this.turmas.remove(turma);
        turma.getAlunos().remove(this);
    }

    public List<CursoModel> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoModel> cursos) {
        this.cursos = cursos;
    }
    
    public void addCurso(CursoModel curso){
        this.cursos.add(curso);
        curso.getAlunos().add(this);
    }
    
    public void removeCurso(CursoModel curso){
        this.cursos.remove(curso);
        curso.getAlunos().remove(this);
    }

    public List<AvaliacaoModel> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoModel> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    
    public void addAvaliacao(AvaliacaoModel avaliacao){
        this.avaliacoes.add(avaliacao);
        avaliacao.setAluno(this);
    }
    
    public void removeAvaliacao(AvaliacaoModel avaliacao){
        this.avaliacoes.remove(avaliacao);
        avaliacao.setAluno(null);
    }
}
