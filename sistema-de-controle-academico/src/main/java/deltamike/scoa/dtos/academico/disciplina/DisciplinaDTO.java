/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deltamike.scoa.dtos.academico.disciplina;

import deltamike.scoa.model.academico.curso.CursoModel;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author rodri
 */
public class DisciplinaDTO {
    @NotBlank
    private String nome;
    private CursoModel curso;

    public String getNome() {
        return nome;
    }

    public CursoModel getCurso() {
        return curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }
    
    
}
