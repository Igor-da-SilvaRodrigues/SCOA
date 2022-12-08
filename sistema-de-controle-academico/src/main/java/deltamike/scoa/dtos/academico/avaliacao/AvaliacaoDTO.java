/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.academico.avaliacao;

import deltamike.scoa.model.academico.turma_disciplina.TurmaDisciplinaModel;
import deltamike.scoa.model.usuario.AlunoModel;
import java.time.LocalDate;

/**
 *
 * @author rodri
 */
public class AvaliacaoDTO {
    
    private AlunoModel aluno;
    private TurmaDisciplinaModel turmaDisciplina;
    private Float nota;
    private LocalDate data;

    public AlunoModel getAluno() {
        return aluno;
    }

    public TurmaDisciplinaModel getTurmaDisciplina() {
        return turmaDisciplina;
    }

    public Float getNota() {
        return nota;
    }

    public LocalDate getData() {
        return data;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }

    public void setTurmaDisciplina(TurmaDisciplinaModel turmaDisciplina) {
        this.turmaDisciplina = turmaDisciplina;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    
}
