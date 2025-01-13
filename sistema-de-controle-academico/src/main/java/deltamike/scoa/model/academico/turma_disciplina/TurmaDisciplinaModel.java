/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.model.academico.turma_disciplina;

import com.fasterxml.jackson.annotation.JsonIgnore;
import deltamike.scoa.model.academico.avaliacao.AvaliacaoModel;
import deltamike.scoa.model.academico.disciplina.DisciplinaModel;
import deltamike.scoa.model.academico.turma.TurmaModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

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
    
    
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaModel turma;
    
    
    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private DisciplinaModel disciplina;
    
    @JsonIgnore
    @OneToMany(mappedBy = "turmaDisciplina")
    private List<AvaliacaoModel> avaliacoes;

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

    public List<AvaliacaoModel> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoModel> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    
    public void addAvaliacao(AvaliacaoModel avaliacao){
        this.avaliacoes.add(avaliacao);
        avaliacao.setTurmaDisciplina(this);
    }
    
    public void removeAvaliacao(AvaliacaoModel avaliacao){
        this.avaliacoes.remove(avaliacao);
        avaliacao.setTurmaDisciplina(null);
    }

    public void removeAllAvaliacao() {
    
        for(int i = 0; i < this.avaliacoes.size(); i = i + 1){
            AvaliacaoModel avaliacao;

            try {
                avaliacao = avaliacoes.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }

            this.removeAvaliacao(avaliacao);
        }
    
    }
}
